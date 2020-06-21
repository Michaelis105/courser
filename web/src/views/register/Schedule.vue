<template>
  <v-container fluid>
    <v-container>
      <v-form>
        <v-container>
          <v-row>
            <v-col cols="3">
              <v-card>
                <v-subheader>Added Course Cart</v-subheader>
                <v-data-table :headers="cart" :items-per-page="5" class="elevation-1"></v-data-table>
              </v-card>
              <v-row>
                <v-checkbox v-model="daysSelected" label="M" value="M"></v-checkbox>
                <v-checkbox v-model="daysSelected" label="T" value="T"></v-checkbox>
                <v-checkbox v-model="daysSelected" label="W" value="W"></v-checkbox>
                <v-checkbox v-model="daysSelected" label="R" value="R"></v-checkbox>
                <v-checkbox v-model="daysSelected" label="F" value="F"></v-checkbox>
              </v-row>
              <v-checkbox v-model="openOnly" label="Open Seats Only" value="open"></v-checkbox>

              <!--
              Starting/End Time
              Instructor
              -->

            </v-col>

            <v-col cols="9">
              <v-card>
                <v-subheader>Searched Classes</v-subheader>
                <v-data-table :headers="classTableHeaders" :items-per-page="5" class="elevation-1"></v-data-table>
              </v-card>
            </v-col>
            
          </v-row>

          <v-row>
            <v-col>
              <v-card>
                <v-subheader>Proposed Schedule</v-subheader>
                <v-data-table :headers="classTableHeaders" :items-per-page="5" class="elevation-1"></v-data-table>
              </v-card>
              <v-sheet height="400">
                <v-calendar ref="calendar" v-model="value" first-time="07:00" intervalMinutes="15" type="week"></v-calendar>
              </v-sheet>
            </v-col>
          </v-row>
        </v-container>
      </v-form>
    </v-container>
    <ScheduleChangeConfirmationDialog/> 
  </v-container>
</template>

<script>
  import ScheduleChangeConfirmationDialog from '../../components/ScheduleChangeConfirmationDialog';

  export default {
    name: 'RegisterSchedule',
    components: {
      ScheduleChangeConfirmationDialog
    },
    data: () => ({
      value: '',
      ready: false,
      hasSaved: false,
      isEditing: null,
      model: null,
      daysSelected: ['M', 'T', 'W', 'R', 'F'],
      openOnly: false,

      classTableHeaders: [
        { text: 'Class ID', value: 'courseId' },
        { text: 'Instructor', value: 'instructor' },
        { text: 'Availability', value: 'availability' },
        { text: 'Meeting Times', value: 'meeting' },
        { text: 'Waitlist', value: 'waitlist' },
        { text: 'Actions', value: 'actions' },
      ],
      classItems: [],

      cart: [
          { text: 'Subject', value: 'courseSubject' },
          { text: 'Course Number', value: 'courseNumber' },
      ],
      cartItems: [],
    }),
    computed: {
      cal () {
        return this.ready ? this.$refs.calendar : null
      },
    },
    mounted () {
      this.ready = true
    },
    methods: {
    },
  }
</script>

<style>
.v-calendar-daily_head-day-label {
    display: none;
}
</style>