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
      }
    },
    methods: {

      generateSchedule() {

        var translatedRules = []
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

        this.url = "http://localhost:8080/api/v1/schedule?did=1"
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
            console.log(data)
        })

        //this.$router.push({ name: 'Schedule', params: { cartCourses: this.cartItems } })
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