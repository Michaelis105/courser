<template>
  <v-container fluid>
    <div class="text-h2">How do you want your schedule generated?</div>
    <v-radio-group v-model="radios" :mandatory="false">
      <v-radio label="More General Education" value="radio-ge"></v-radio>
      <v-radio label="More In-Major" value="radio-major"></v-radio>
      <v-radio label="Balanced" value="radio-bal"></v-radio>
    </v-radio-group>
    <v-col cols="12" sm="4">
      <div class="my-2">
        <v-btn color="primary">Generate My Schedule</v-btn>
      </div>
    </v-col>
  </v-container>
</template>


<script>
export default {
  name: 'RegisterAutomatic',
  data () {
      return {
        radios: 'radio-ge',
      }
  }
}
</script>