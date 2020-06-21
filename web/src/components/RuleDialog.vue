<template>
  <div class="text-right">
    <v-dialog v-model="dialog" width="50%">
      <v-card>
        <v-card-title class="headline blue" primary-title>Add Rule</v-card-title>

        WHO WHAT WHEN WHERE
        <!-- 
        WHO: The professor
        What: Which class, course, subject,
        When: Day(s), time periods
        Where: Class location
        -->

        <v-card-text>
          You are about enroll in these courses:
        </v-card-text>

        <v-card>
          <v-subheader>Searched Classes</v-subheader>
          <v-data-table :headers="classTableHeaders" :items-per-page="5" class="elevation-1"></v-data-table>
        </v-card>

        <v-card-text>
          You are about unenroll from these courses:
        </v-card-text>

        <v-card>
          <v-subheader>Searched Classes</v-subheader>
          <v-data-table :headers="classTableHeaders" :items-per-page="5" class="elevation-1"></v-data-table>
        </v-card>

        <v-card-text>
          The resulting credit hours for this semester is: 
        </v-card-text>

        <v-card-text>
          Are you sure this is the schedule you want?
        </v-card-text>

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
      classTableHeaders: [

        { text: 'Course Number', value: 'courseNumber' },
        { text: 'Subject', value: 'courseSubject' },
        { text: 'Class ID', value: 'courseId' },
        { text: 'Title', value: 'courseTitle' },
        { text: 'Instructor', value: 'instructor' },
        { text: 'Meeting Times', value: 'meeting' },
        { text: 'Credit Hours', value: 'creditHours' },
      ],
      enrollClassses: [],
      unenrollClassses: []
    }),
  }
</script>