<template>
  <v-navigation-drawer v-model="drawer" :clipped="$vuetify.breakpoint.lgAndUp" app>
    <v-list dense>
      <template v-for="item in items">
        <v-row v-if="item.heading" :key="item.heading" align="center">
          <v-col cols="12">
            <v-divider v-if="item.divider" :key="item.divider">
            </v-divider>
            <v-subheader v-else-if="item.heading" :key="item.header">
              {{ item.heading }}
            </v-subheader>
          </v-col>
        </v-row>
        <v-list-group v-else-if="item.children" :key="item.text" v-model="item.model" :prepend-icon="item.model ? item.icon : item['icon-alt']"
        append-icon="">
        <template v-slot:activator>
          <v-list-item-content>
            <v-list-item-title>
              {{ item.text }}
            </v-list-item-title>
          </v-list-item-content>
        </template>
        <v-list-item v-for="(child, i) in item.children" :key="i" link>
          <v-list-item-action v-if="child.icon">
            <v-icon>{{ child.icon }}</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>
              {{ child.text }}
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list-group>
      <v-list-item v-else :key="item.text" v-on:click="navigate(item.to)" link>
        <v-list-item-action>
          <v-icon>{{ item.icon }}</v-icon>
        </v-list-item-action>
        <v-list-item-content>
          <v-list-item-title>
            {{ item.text }}
          </v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </template>
  </v-list>
</v-navigation-drawer>
</template>0.

<script>

  export default {
    name: 'NavigationDrawer',

    data: () => ({
      dialog: false,
      drawer: null,
      items: [
      { icon: 'mdi-home-circle', text: 'Home', to: '/home' },
      { icon: 'mdi-calendar-clock', text: 'My Schedule', to: '/schedule' },
      { heading: 'Register for Classes' },
      { icon: 'mdi-calendar-plus', text: 'Browse Course Catalog', to: '/register/catalog' },
      { icon: 'mdi-text-box-check-outline', text: 'Use Degree Requirements', to: '/register/degree' },

      { icon: 'mdi-text-box-check-outline', text: 'Temp', to: '/register/schedule' }
      //{ icon: 'mdi-checkbox-multiple-marked-circle', text: 'Registration Status', to: '/status' },
      
      //{ icon: 'mdi-chart-timeline', text: 'Plan Classes', to: '/plan' },
      //{ heading: 'div', divider: true },
      //{ heading: 'Transcripts' },
      //{ icon: 'mdi-file-document', text: 'Official', to: '/transcript/official' },
      //{ icon: 'mdi-file', text: 'Unofficial', to: '/transcript/official' }
      ],
    }),

    methods: {
      navigate(pathTo) {
        this.$router.push({ path: `${pathTo}`})
      }
    }
  }
</script>