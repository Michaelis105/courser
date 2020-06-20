<template>
  <v-container fluid>
    <v-container>
      <v-form>
        <v-container>
          <v-row>
            <v-col cols="6" sm="6" md="3">
              <v-col cols="12" sm="4">
                <div class="my-2">
                  <v-btn color="primary">Generate My Schedule</v-btn>
                </div>
              </v-col>
              <v-subheader>Current Search Filters</v-subheader>
              <v-autocomplete :items="subjects" item-text="name" label="Subjects"></v-autocomplete> <!-- :filter="customFilter" -->
              <v-autocomplete :items="levels" item-text="name" label="Course Level"></v-autocomplete>
              <v-autocomplete :disabled="!isEditing" :items="subjects" item-text="name" label="Course Number" hint="For example: 1234, 2350, 3870"></v-autocomplete>
              <v-divider></v-divider>
              <v-subheader>Credit Hour Range</v-subheader>
              <v-card-text>
                <v-range-slider v-model="creditHourRange" step="1" ticks="always" :max="19" thumb-label="always"></v-range-slider>
              </v-card-text>
            </v-col>
          </v-row>
        </v-container>
      </v-form>
    </v-container>
  </v-container>
</template>

<script>
  export default {
    name: 'BrowseCatalog',
    data () {
      return {
        hasSaved: false,
        isEditing: null,
        model: null,
        creditHourRange: [0, 19],
        subjects: [
        { name: 'Music', abbr: 'FL', id: 1 },
        { name: 'Computer Science', abbr: 'GA', id: 2 },
        { name: 'English', abbr: 'NE', id: 3 },
        { name: 'Engineering', abbr: 'CA', id: 4 },
        { name: 'Physics', abbr: 'NY', id: 5 },
        ],
        levels: [
        { name: 'Associate', abbr: 'NE', id: 1 },
        { name: 'Undergraduate', abbr: 'FL', id: 2 },
        { name: 'Graduate', abbr: 'GA', id: 3 },
        ],
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