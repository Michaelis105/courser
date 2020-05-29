import Vue from 'vue'
import Router from 'vue-router';
import Home from './views/Home.vue'
import vuetify from './plugins/vuetify';


export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/',
            name: 'Home',
            component: Home
        },
        {
            path: '/profile',
            name: 'Profile',
            component: () => import('./views/Profile.vue')
        },
        {
            path: '/quick',
            name: 'Quick',
            component: () => import('./views/Quick.vue')
        },
        {
            path: '/settings',
            name: 'Settings',
            component: () => import('./views/Settings.vue')
        }
    ]
});

Vue.config.productionTip = false
Vue.use(Router)
new Vue({
  vuetify,
  render: h => h(Home)
}).$mount('#home')
