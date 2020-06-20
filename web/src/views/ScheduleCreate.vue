<template>
  <v-container fluid>
    <v-card>
      <v-form>
        <v-container>
          <v-row>
            <v-col cols="6" sm="6" md="3">
              <span>Current Search Filters</span>
              <v-checkbox v-model="selecdaysSelectedted" label="Monday" value="M"></v-checkbox>
              <v-checkbox v-model="daysSelected" label="Tuesday" value="T"></v-checkbox>
              <v-checkbox v-model="daysSelected" label="Wednesday" value="W"></v-checkbox>
              <v-checkbox v-model="daysSelected" label="Thursday" value="R"></v-checkbox>
              <v-checkbox v-model="daysSelected" label="Friday" value="F"></v-checkbox>

              <v-text-field label="Subjects" hint="For example, flowers or used cars"></v-text-field>
            </v-col>
          </v-row>
        </v-container>
      </v-form>
    </v-card>
  </v-container>
</template>

<script>
  export default {
    name: 'ScheduleCreate',
    data () {
      return {
        hasSaved: false,
        isEditing: null,
        model: null,
        daysSelected: [],
      }
    },

/*
  methods: {
    customFilter (item, queryText, itemText) {
      const textOne = item.name.toLowerCase()
      const textTwo = item.abbr.toLowerCase()
      const searchText = queryText.toLowerCase()

      return textOne.indexOf(searchText) > -1 ||
        textTwo.indexOf(searchText) > -1
    },
    save () {
      this.isEditing = !this.isEditing
      this.hasSaved = true
    },
  },
  */
}
</script>