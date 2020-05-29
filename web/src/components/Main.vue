<template>
  <v-container fluid>
    <v-system-bar>
      <SystemBar/>
    </v-system-bar>

    <v-progress-linear indeterminate/>

    <router-link to="/profile">Go to Foo</router-link>
    <router-link to="/settings">Go to Bar</router-link>

    <router-view></router-view>
  </v-container>
</template>

<script>

import SystemBar from '../components/SystemBar';

export default {
  name: 'Main',

  components: {
    SystemBar
  }
}
</script>