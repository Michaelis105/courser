<template>
    <v-app-bar :clipped-left="$vuetify.breakpoint.lgAndUp" app color="blue darken-3" dark>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title style="width: 300px" class="ml-0 pl-4">
        <span class="hidden-sm-and-down">Courser</span>
      </v-toolbar-title>
      <!--<v-text-field flat solo-inverted hide-details prepend-inner-icon="mdi-magnify" label="Search" class="hidden-sm-and-down"></v-text-field>-->
      <v-spacer></v-spacer>
      <!--
      <v-btn icon large1>
        <v-icon>mdi-bell</v-icon>
      </v-btn>
      <v-btn icon large>
        <v-icon>mdi-help-circle</v-icon>
      </v-btn>
      <v-btn icon large>
        <v-icon>mdi-information</v-icon>
      </v-btn>
      <v-btn icon large>
        <v-icon>mdi-account</v-icon>
      </v-btn>
    -->
    </v-app-bar>

</template>

<script>

export default {
  name: 'Header',
  data() {
    return {
      drawer: true
    }
  }
};
</script>
