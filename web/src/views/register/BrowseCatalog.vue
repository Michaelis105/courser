<template>
  <v-container fluid>
    <v-container>
      <v-form>
        <v-container>
          <v-row>
            <v-col cols="3">
              <v-card>
                <v-subheader>Current Search Filters</v-subheader>
                <v-autocomplete :items="subjects" item-text="name" label="Subjects"></v-autocomplete> <!-- :filter="customFilter" -->
                <v-autocomplete :items="levels" item-text="name" label="Course Level"></v-autocomplete>
                <v-autocomplete :disabled="!isEditing" :items="subjects" item-text="name" label="Course Number" hint="For example: 1234, 2350, 3870"></v-autocomplete>
                <v-divider></v-divider>
                <v-subheader>Credit Hour Range</v-subheader>
                <v-card-text>
                  <v-range-slider v-model="creditHourRange" step="1" ticks="always" :max="19" thumb-label="always"></v-range-slider>
                </v-card-text>
                <v-btn color="primary">Search</v-btn>
              </v-card>
            </v-col>

            <v-col cols="9">
              <v-card>
                <v-subheader>Searched Courses</v-subheader>
                <v-data-table :headers="courseTableHeaders" :items-per-page="5" class="elevation-1"></v-data-table>
              </v-card>

              <v-card>
                <v-subheader>Added Course Cart</v-subheader>
                <v-data-table :headers="cartTableHeaders" :items-per-page="5" class="elevation-1"></v-data-table>
              </v-card>

              <div>
                <v-btn color="primary" v-on:click="navigate('/register/schedule')">Add Courses</v-btn>
              </div>

            </v-col>

            <!--
              <template v-slot:item.actions="{ item }">
                <v-icon small class="mr-2" @click="editItem(item)">mdi-pencil</v-icon>
                <v-icon small @click="deleteItem(item)">mdi-delete</v-icon>
              </template>
            -->

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
        { name: 'Associate', abbr: 'AS', id: 1 },
        { name: 'Undergraduate', abbr: 'UG', id: 2 },
        { name: 'Graduate', abbr: 'GD', id: 3 },
        ],

        courseTableHeaders: [
          { text: 'Title', align: 'start', value: 'courseTitle' },
          { text: 'Course Number', value: 'courseNumber' },
          { text: 'Credit Hours', value: 'creditHours' },
          { text: 'Description', value: 'description' },
          { text: 'Actions', value: 'actions' },
        ],
        searchItems: [],

        cartTableHeaders: [
          { text: 'Subject', value: 'courseSubject' },
          { text: 'Course Number', value: 'courseNumber' },
          { text: 'Title', value: 'courseTitle' },
          { text: 'Actions', value: 'actions' },
        ],
        cartItems: [],
      }
    },

    methods: {
      navigate(pathTo) {
        this.$router.push({ path: `${pathTo}`})
      }
    }
}
</script>