<template>
  <v-app>
    <!--<SystemBar/>-->
    <NavigationDrawer/>
    
    <Header/>
    <Main/>
    
    <Footer/>
    
  </v-app>
</template>

<script>
import Header from '../components/Header';
import NavigationDrawer from '../components/NavigationDrawer';
import Main from '../components/Main';
import Footer from '../components/Footer';

//import SystemBar from '../components/SystemBar';

export default {
  name: 'Home',
  components: {
    Header,
    NavigationDrawer,
    Main,
    Footer
    //SystemBar
  }
}
</script>