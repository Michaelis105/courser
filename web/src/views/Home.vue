<template>
  <v-app>
    <v-navigation-drawer v-model="drawer" :clipped="$vuetify.breakpoint.lgAndUp" app>
      <NavigationDrawer/>
    </v-navigation-drawer>

    <v-app-bar :clipped-left="$vuetify.breakpoint.lgAndUp" color="blue darken-3" dark app>
      <Header/>
    </v-app-bar>
    
    <v-content app>
      <Main/>
    </v-content>
    
    <v-footer color="blue darken-3" app>
      <Footer/>
    </v-footer>
  </v-app>
</template>

<script>
import Header from '../components/Header';
import NavigationDrawer from '../components/NavigationDrawer';
import Main from '../components/Main'
import Footer from '../components/Footer'

export default {
  name: 'Home',

  components: {
    Header,
    NavigationDrawer,
    Main,
    Footer
  }
}
</script>