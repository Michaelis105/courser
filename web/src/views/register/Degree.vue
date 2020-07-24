<template>
  <v-container fluid>

    <div class="text">Tell us how you want to customize your class schedule.</div>

    <div class="text-h2">What is your focus for this semester?</div>
    <v-radio-group v-model="radiosFocus" :mandatory="false">
      <v-radio label="More General Education" value="radio-ge"></v-radio>
      <v-radio label="More In-Major" value="radio-major"></v-radio>
      <v-radio label="Balanced" value="radio-bal"></v-radio>
    </v-radio-group>

    <div class="text-h2">How many credits do you want to take this semester?</div>
    <v-radio-group v-model="radiosCredits" :mandatory="false">
      <v-radio label="Part-Time" value="radio-pt"></v-radio>
      <v-radio label="Full-Time Light (12-13)" value="radio-ftl"></v-radio>
      <v-radio label="Full-Time Regular (14-16)" value="radio-ftr"></v-radio>
      <v-radio label="Full-Time Heavy (17-19)" value="radio-fth"></v-radio>
    </v-radio-group>
    <!--
    <v-card-text>
      <v-range-slider v-model="creditHourRange" step="1" ticks="always" :max="19" thumb-label="always"></v-range-slider>
    </v-card-text>
    -->

    <div class="text-h2">What other circumstances do you want to consider?</div>
    <RuleDialog v-on:addedRule="addRule"/>
    <v-simple-table>
      <template v-slot:default>
        <thead>
          <tr>
            <th class="text-left">Rules</th>
            <th class="text-left">Actions</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in rulesText" :key="item">
            <td>{{ item }}</td>
            <v-icon small class="mr-2" @click="removeRule(item)">mdi-minus</v-icon>
          </tr>
        </tbody>
      </template>
    </v-simple-table>
    <v-divider></v-divider>
    <v-col cols="12" sm="4">
      <div>
        <v-btn color="primary" v-on:click="generateSchedule()">Generate My Schedule</v-btn>
      </div>
    </v-col>
    <v-snackbar v-model="snackbar" :timeout=2000>
      {{ snackbarText }}
    </v-snackbar>
  </v-container>
</template>


<script>
  import RuleDialog from '../../components/RuleDialog';

  export default {
    name: 'RegisterAutomatic',
    components: {
      RuleDialog
    },
    data () {
      return {
        daysSelected: [],
        creditHourRange: [0, 19],
        radiosFocus: 'radio-ge',
        radiosCredits: 'radio-ftr',
        rules: [],
        rulesText: [],
        snackbar: false,
        snackbarText: "",
      }
    },
    methods: {

      generateSchedule() {

        var translatedRules = []
        if (this.rules.length == 0) {
          this.snackbarText = "Please add at least one rule."
          this.snackbar = true
        } else {
          for (var i = 0; i < this.rules.length; i++) {
            var newSubjects = []
            this.rules[i].subject.forEach(s => newSubjects.push(s.abbr));

            var newDays = []
            this.rules[i].day.forEach(d => newDays.push(d.text));

            var newRule = {
              want: this.rules[i].want,
              subject: newSubjects,
              course: this.rules[i].course,
              day: newDays,
              timeRel: this.rules[i].timeRel,
              time: this.rules[i].time,
              beforeTime: this.rules[i].beforeTime,
              afterTime: this.rules[i].afterTime,
            }

            translatedRules.push(newRule)
          }

          switch (this.radiosCredits) {
              case "radio-ftl":
                this.creditHourRange[0] = 12;
                this.creditHourRange[1] = 13;
                break;
              case "radio-ftr":
                this.creditHourRange[0] = 14;
                this.creditHourRange[1] = 16;
                break;
              case "radio-fth":
                this.creditHourRange[0] = 17;
                this.creditHourRange[1] = 19;
                break;
              default:
                this.creditHourRange[0] = 0;
                this.creditHourRange[1] = 19;
          }

          var mnc = "&mnc=" + this.creditHourRange[0]
          var mxc = "&mxc=" + this.creditHourRange[1]

          this.url = "http://michaellouie.net/api/v1/schedule?did=1" + mnc + mxc
          fetch(this.url, {
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify(translatedRules)
          })
          .then(response => response.json())
          .then((data) => {

            for (var i = 0; i < data.classes.length; i++) {
              var curClass = data.classes[i]

              var time = ""
              for (var j = 0; j < curClass.classTimes.length; j++) {
                var classTime = curClass.classTimes[j]
                time += classTime.day + " " + classTime.startTime + " - " + classTime.endTime + "\n";
              }
              
              var avail = curClass.seatOccupied + " of " + curClass.seatCapacity;
              var wait = curClass.seatWaitlistOccupied + " of " + curClass.seatWaitlistCapacity;

              curClass.availability = avail;
              curClass.meeting = time;
              curClass.waitlist = wait;

              curClass.subject = curClass.attributes.subject;
              curClass.number = curClass.attributes.number;
              curClass.courseTitle = curClass.attributes.courseTitle;
              curClass.instructor = curClass.attributes.instructor;
              curClass.creditHours = curClass.attributes.creditHours;
            }

            this.$router.push({ name: 'Schedule', params: { 
              cartCourses: data.courses,
              cartClasses: data.classes 
            }})
          })
        }
      },

      addRule(rule) {
        var asText = "I ";
        asText += (rule.want == "w") ? "want" : "do not want ";
        if (rule.subject != null) {
          asText += " to take ";
          if (rule.subject == "any") {
            asText += " any subject "
          } else {
            rule.subject.forEach(s => asText += s.abbr + ", ");
          }
          
          asText += " for course number " + rule.course;
        }
        
        if (rule.day != null) {
          if (rule.day[0].value == "any") {
            asText += " on any day ";
          } else {
            asText += " on "
            rule.day.forEach(d => asText += d.text + ", ");
          }
        }
        
        if (rule.timeRel != null) {
          if (rule.timeRel == "any") {
            asText += " at any time ";
          } else if (rule.timeRel == "b" || rule.timeRel == "a") {
            if (rule.timeRel == "b") {
              asText += " before ";
            } else {
              asText += " after ";
            }
            asText += rule.time;
          } else if (rule.timeRel == "tr") {
            asText += " between " + rule.beforeTime + " and " + rule.afterTime; 
          }
        }

        this.rulesText.push(asText)
        this.rules.push(rule)
      },
      removeRule(rule) {
        var i = this.rulesText.indexOf(rule)
        this.rules.splice(i, 1)
        this.rulesText.splice(i, 1)
      }

    }
  }
</script>