<template>
  <v-container fluid>

    <div class="text">Tell us how you want to customize your course schedule.</div>

    <div class="text-h2">What is your focus for this semester?</div>
    <v-radio-group v-model="radios" :mandatory="false">
      <v-radio label="More General Education" value="radio-ge"></v-radio>
      <v-radio label="More In-Major" value="radio-major"></v-radio>
      <v-radio label="Balanced" value="radio-bal"></v-radio>
    </v-radio-group>

    <div class="text-h2">How many credits do you want to take this semester?</div>
    <v-card-text>
      <v-range-slider v-model="creditHourRange" step="1" ticks="always" :max="19" thumb-label="always"></v-range-slider>
    </v-card-text>

    <div class="text-h2">What other circumstances do you want to consider?</div>
    <RuleDialog/>
    <v-simple-table>
      <template v-slot:default>
        <thead>
          <tr>
            <th class="text-left">Rules</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in desserts" :key="item.name">
            <td>{{ item.name }}</td>
            <td>{{ item.calories }}</td>
          </tr>
        </tbody>
      </template>
    </v-simple-table>
    <v-divider></v-divider>
    <v-col cols="12" sm="4">
      <div>
        <v-btn color="primary" v-on:click="navigate('/register/schedule')">Generate My Schedule</v-btn>
      </div>
    </v-col>
  </v-container>
</template>


<script>
  import RuleDialog from '../../components/RuleDialog';

  export default {
    name: 'RegisterAutomatic',
    components: {
      RuleDialog
    },
    data () {
      return {
        daysSelected: [],
        creditHourRange: [0, 19],
        radios: 'radio-ge',
        rules: [],
      }
    },
    methods: {
      navigate(pathTo) {
        this.$router.push({ path: `${pathTo}`})
      }
    }
  }
</script>