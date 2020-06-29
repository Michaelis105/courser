<template>
  <div class="text-right">
    <v-dialog v-model="dialog" width="50%">
      <v-card>
        <v-card-title class="headline blue" primary-title>
          Final Enrollment Confirmation
        </v-card-title>

        <v-card>
          
          <v-data-table :headers="classTableHeaders" :items-per-page="5" class="elevation-1">
            <template v-slot:top>
              You are about enroll in these courses:
            </template>
          </v-data-table>
        </v-card>

        <v-card>
          <v-data-table :headers="classTableHeaders" :items-per-page="5" class="elevation-1">
            <template v-slot:top>
              You are about unenroll from these courses:
            </template>
            <template v-slot:bot>
              You are about unenroll from these courses:
            </template>
          </v-data-table>
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
          <v-btn color="red lighten-2" text @click="dialog = false">No! I need to make changes</v-btn>
          <v-btn color="primary" text @click="dialog = false">Yes! Enroll me in these classes</v-btn>
        </v-card-actions>
      </v-card>
      <template v-slot:activator="{ on, attrs }">
        <v-btn color="primary" dark v-bind="attrs" v-on="on">Confirm Schedule</v-btn>
      </template>
    </v-dialog>
  </div>
</template>

<script>

  export default {
    name: 'ScheduleChangeConfirmation',

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

    methods: {
      navigate(pathTo) {
        this.$router.push({ path: `${pathTo}`})
      }
    }
  }
</script>