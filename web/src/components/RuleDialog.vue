<template>
  <div class="text-right">
    <v-dialog v-model="dialog" width="50%">
      <v-card>
        <v-card-title class="headline blue" primary-title>Add Rule</v-card-title>
        <v-container>
          I <v-select v-model="want" :items="wants" label="want or not want" solo dense></v-select>
          to take <v-combobox v-model="subject" :items="subjects" item-text="text" label="subject" multiple chips dense></v-combobox>
          subjects
          with course <v-combobox v-model="course" :items="courses" item-text="text" label="course number" multiple chips dense></v-combobox>
          on day <v-combobox v-model="day" :items="days" item-text="text" label="day(s)" multiple chips dense></v-combobox>
          <v-select v-model="timeRel" :items="timeRels" label="before, after, or time range" solo dense></v-select>
          <v-select v-model="time" :items="times" label="time" solo dense></v-select>
        </v-container>
          

        <v-divider></v-divider>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="red lighten-2" text @click="dialog = false">Cancel</v-btn>
          <v-btn color="primary" text @click="dialog = false">Add Rule</v-btn>
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
        { text: 'want', value: 'w' },
        { text: 'do not want', value: 'dnw' },
      ],

      subject: [],
      subjects: [
        { text: 'any', value: 'any' },
        { text: 'CS', value: 'cs' },
        { text: 'ENG', value: 'en' },
        { text: 'PHY', value: 'phy' },
      ],

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

      timeRel: [],
      timeRels: [
        { text: 'any', value: 'any' },
        { text: 'before', value: 'b' },
        { text: 'after', value: 'af' },
        { text: 'time range', value: 'tr' },
      ],

      time: [],
      times: [
        { text: 'any', value: 'any' },
        { text: '12:00', value: '12' },
      ],
    }),
  }
</script>