<template>
  <v-app>
    
    <NavigationDrawer/>
    
    <Header/>

    <Main/>
    
    <Footer/>
    
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