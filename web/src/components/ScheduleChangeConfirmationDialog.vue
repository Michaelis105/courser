<template>
  <div class="text-right">
    <v-dialog v-model="dialog" width="50%">
      <v-card>
        <v-card-title class="headline blue" primary-title>
          Final Enrollment Confirmation
        </v-card-title>

        <v-card>
          <v-data-table :headers="classTableHeaders" :items="enrollClasses" :items-per-page="5" class="elevation-1">
            <template v-slot:item.actions="{ item }">
              <v-icon small class="mr-2" @click="removeClassFromCart(item)">mdi-plus</v-icon>
            </template>
            <template v-slot:top>
              You are about enroll in these courses:
            </template>
            <template v-slot:no-data>
              No classes added.
            </template>
          </v-data-table>
        </v-card>

        <v-card>
          <v-data-table :headers="classTableHeaders" :items="unenrollClasses" :items-per-page="5" class="elevation-1">
            <template v-slot:item.actions="{ item }">
              <v-icon small class="mr-2" @click="removeClassFromCart(item)">mdi-minus</v-icon>
            </template>
            <template v-slot:top>
              You are about unenroll from these courses:
            </template>
            <template v-slot:no-data>
              No classes removed.
            </template>
          </v-data-table>
        </v-card>

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
    props: {
      enrollClasses: {
        type: Array,
      },
      unenrollClasses: {
        type: Array,
      }
    },

    data () {
      return {
        dialog: false,
        classTableHeaders: [
          { text: 'Class ID', value: 'courseId' },
          { text: 'Subject', value: 'subject' },
          { text: 'Course Number', value: 'number' },
          { text: 'Title', value: 'courseTitle' },
          { text: 'Instructor', value: 'instructor' },
          { text: 'Meeting Times', value: 'meeting' },
          { text: 'Credit Hours', value: 'creditHours' },
        ],
      }
      
    },

    methods: {
      navigate(pathTo) {
        this.$router.push({ path: `${pathTo}`})
      }
    }
  }
</script>