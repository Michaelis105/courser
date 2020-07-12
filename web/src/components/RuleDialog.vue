<template>
  <div class="text-right">
    <v-dialog v-model="dialog" width="50%">
      <v-card>
        <v-card-title class="headline blue" primary-title>Add Rule</v-card-title>
        <v-container>
          I <v-select v-model="want" :items="wants" label="want or not want" solo dense></v-select>
          to take subjects <v-combobox v-model="subject" :items="subjects" item-text="name" label="subject" multiple chips dense></v-combobox>
          
          with course 
          <v-text-field v-model="course" item-text="text" label="course number"></v-text-field>
          on day(s) <v-combobox v-model="day" :items="days" v-on:change="renderAdditionalOptions()" item-text="text" label="day(s)" multiple chips dense></v-combobox>

          <v-container v-show="showTimeRel">
            at times 
            <v-select v-model="timeRel" :items="timeRels" v-on:change="renderAdditionalOptions()" label="before, after, or time range" solo dense></v-select>
            <v-select v-show="showOneTime" v-model="time" :items="times" label="Time" solo dense></v-select>
            <v-select v-show="showTwoTime" v-model="beforeTime" :items="times" label="Before Time" solo dense></v-select>
            <v-select v-show="showTwoTime" v-model="afterTime" :items="times" label="After Time" solo dense></v-select>
          </v-container>
          
        </v-container>
          
        <v-divider></v-divider>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="red lighten-2" text @click="dialog = false">Cancel</v-btn>
          <v-btn color="primary" text @click="dialog = false; addRules()">Add Rule</v-btn>
        </v-card-actions>
      </v-card>
      <template v-slot:activator="{ on, attrs }">
        <v-btn color="primary" dark v-bind="attrs" v-on="on"><v-icon left dark>mdi-plus</v-icon>Add Rule</v-btn>
      </template>
    </v-dialog>
  </div>
</template>

<script>

  export default {
    name: 'RuleDialog',

    data: () => ({
      dialog: false,

      want: null,
      wants: [
        //{ text: 'want', value: 'w' },
        { text: 'do not want', value: 'dnw' },
      ],

      subject: [],
      subjects: [
        { name: 'any', abbr: 'any', id: 0 },
        { name: 'Chemistry', abbr: 'CHEM', id: 1 },
        { name: 'English', abbr: 'ENGL', id: 2 },
        { name: 'Engineering', abbr: 'ENGE', id: 3 },
        { name: 'Math', abbr: 'MATH', id: 4 },
        { name: 'Physics', abbr: 'PHYS', id: 5 },
        { name: 'Computer Science', abbr: 'CS', id: 6 },
        { name: 'Communications', abbr: 'COMM', id: 7 },
        { name: 'Statistics', abbr: 'STAT', id: 8 },
      ],

      times: [],

      course: [],
      courses: [
        { text: 'any', value: 'any' },
        { text: '1352', value: 'w' },
        { text: '2467', value: 'w' },
        { text: '3845', value: 'w' },
        { text: '4234', value: 'dnw' },
      ],

      day: [],
      days: [
        { text: 'any', value: 'any' },
        { text: 'Monday', value: 'm' },
        { text: 'Tuesday', value: 't' },
        { text: 'Wednesday', value: 'w' },
        { text: 'Thursday', value: 'r' },
        { text: 'Friday', value: 'f' },
        { text: 'Saturday', value: 'sa' },
        { text: 'Sunday', value: 'su' },
      ],

      timeRel: "any",
      timeRels: [
        { text: 'any', value: 'any' },
        { text: 'before', value: 'b' },
        { text: 'after', value: 'a' },
        { text: 'time range', value: 'tr' },
      ],

      showTimeRel: false,
      showTime: false,
      showOneTime: false,
      showTwoTime: false,

      time: null,
      beforeTime: null,
      afterTime: null,
      
    }),

    created: function() {
      for (var t = 600; t < 2200; t += 100) {
        for (var m = 0; m < 60; m += 15) {
          this.times.push({ text: (t+m).toString(), value: (t+m)})
        }
      }
    },

    methods: {
      renderAdditionalOptions() {
        this.showTimeRel = false;
        this.showTime = false;
        this.showOneTime = false;
        this.showTwoTime = false;
        for (var i = 0; i < this.day.length; i++) {
          if (this.day[i].value != "any") {
            this.showTimeRel = true;
            break;
          }
        }

        if (this.timeRel == "tr") {
            this.showTwoTime = true;
        } else if (this.timeRel != "any") {
          if (this.timeRel == "b" || this.timeRel == "a") {
            this.showOneTime = true;
          }
          this.showTime = true;
        }
      },
      addRules() {
        var rule = {
            want: this.want,
            subject: this.subject,
            course: this.course,
            day: this.day,
            timeRel: this.timeRel,
            time: this.time,
            beforeTime: this.beforeTime,
            afterTime: this.afterTime
        }
        this.$emit('addedRule', rule)
      }
    }
  }
</script>