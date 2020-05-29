<template>
  <v-list dense>
    <template v-for="item in items">
      <v-row v-if="item.heading" :key="item.heading" align="center">
        <v-col cols="12">
          <v-divider v-if="item.divider" :key="index">
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
      <v-list-item v-else :key="item.text" link>
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
</template>

<script>

export default {
  name: 'NavigationDrawer',

  data: () => ({
    dialog: false,
    drawer: null,
    items: [
      { icon: 'mdi-home-circle', text: 'Home' },
      { icon: 'mdi-calendar-plus', text: 'Register for Classes' },
      { icon: 'mdi-checkbox-multiple-marked-circle', text: 'Registration Status' },
      { icon: 'mdi-calendar-clock', text: 'My Schedule' },
      { icon: 'mdi-chart-timeline', text: 'Plan Classes' },
      { heading: 'Transcripts', divider: true },
      { heading: 'Transcripts' },
      { icon: 'mdi-plus', text: 'Official' },
      { icon: 'mdi-plus', text: 'Unofficial' },
    ],
  }),
}
</script>