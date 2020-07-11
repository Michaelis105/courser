<template>
  <v-container fluid>
    <v-container>
      <v-form>
        <v-container>
          <v-row>
            <v-col cols="3">
              <v-card>
                <v-subheader>Current Search Filters</v-subheader>
                <v-combobox v-model="subjectSelect" :items="subjects" item-text="name" label="Subjects" multiple chips></v-combobox> <!-- :filter="customFilter" -->
                <v-text-field v-model="courseNumberSelect" item-text="name" label="Course Number" hint="For example: 1234, 2350, 3***"></v-text-field>
                <v-subheader>Credit Hour Range</v-subheader>
                <v-card-text>
                  <v-range-slider v-model="creditHourRange" step="1" ticks="always" :max="19" thumb-label="always"></v-range-slider>
                </v-card-text>
                <v-btn color="primary" @click="search()">Search</v-btn>
              </v-card>
            </v-col>

            <v-col cols="9">
              <v-card>
                <v-subheader>Searched Courses</v-subheader>
                <v-data-table :headers="courseTableHeaders" :items="searchItems" class="elevation-1">
                  <template v-slot:item.actions="{ item }">
                    <v-icon small class="mr-2" @click="addCourseToCart(item)">mdi-plus</v-icon>
                  </template>
                  <template v-slot:no-data>
                    No courses found - try your search again.
                  </template>
                </v-data-table>
              </v-card>

              <v-card>
                <v-subheader>Added Course Cart</v-subheader>
                <v-data-table :headers="cartTableHeaders" :items="cartItems" :items-per-page="5" class="elevation-1">
                  <template v-slot:item.actions="{ item }">
                    <v-icon small class="mr-2" @click="removeCourseFromCart(item)">mdi-minus</v-icon>
                  </template>
                  <template v-slot:no-data>
                    Empty cart - add some courses
                  </template>
                </v-data-table>
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
    <v-snackbar v-model="snackbar" :timeout=2000>
      Course already added!
    </v-snackbar>
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
        snackbar: false,
        subjectSelect: [],
        courseLevelsSelect: [],
        courseLevels: [],
        courseNumberSelect: 0,
        creditHourRange: [0, 19],
        subjects: [
          { name: 'Chemistry', abbr: 'CHEM', id: 1 },
          { name: 'English', abbr: 'ENGL', id: 2 },
          { name: 'Engineering', abbr: 'ENGE', id: 3 },
          { name: 'Math', abbr: 'MATH', id: 4 },
          { name: 'Physics', abbr: 'PHYS', id: 5 },
          { name: 'Computer Science', abbr: 'CS', id: 6 },
          { name: 'Communications', abbr: 'COMM', id: 7 },
          { name: 'Statistics', abbr: 'STAT', id: 8 },
        ],

        levels: [
          { name: 'Associate', abbr: 'AS', id: 1 },
          { name: 'Undergraduate', abbr: 'UG', id: 2 },
          { name: 'Graduate', abbr: 'GD', id: 3 },
        ],

        courseNumber: [],

        courseTableHeaders: [
          { text: 'Title', align: 'start', value: 'courseTitle' },
          { text: 'Subject', value: 'subject' },
          { text: 'Course Number', value: 'number' },
          { text: 'Credit Hours', value: 'creditCount' },
          { text: 'Description', value: 'description' },
          { text: 'Actions', value: 'actions' },
        ],
        searchItems: [],

        cartTableHeaders: [
          { text: 'Subject', value: 'subject' },
          { text: 'Course Number', value: 'number' },
          { text: 'Title', value: 'courseTitle' },
          { text: 'Actions', value: 'actions' },
        ],
        cartItems: [],
      }
    },

    methods: {
      navigate() {
        console.log(this.cartItems)
        this.$router.push({ name: 'Schedule', params: { cartCourses: this.cartItems } })
      },
      search() {
        this.searchItems = []
        this.url = "http://localhost:8080/api/v1/course"
        this.url += "?s=" + this.subjectSelect[0].abbr
        this.url += "&n=" + this.courseNumberSelect
        this.url += "&minc=" + this.creditHourRange[0]
        this.url += "&maxc=" + this.creditHourRange[1]
        //url += "&t=" + courseNumberSelect
        fetch(this.url, {
          method: "GET"
        })
        .then(response => response.json())
        .then((data) => {
          this.searchItems = data
        })
      },
      addCourseToCart(course) {
        var indexOfCourse = this.cartItems.indexOf(course)
        if (indexOfCourse == -1) {
          this.cartItems.push(course)
        } else {
          this.snackbar = true
        }
        
      },
      removeCourseFromCart(course) {
        this.cartItems.splice(this.cartItems.indexOf(course), 1)
      }
    }
}
</script>