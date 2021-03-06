import Vue from 'vue'
import VueRouter from 'vue-router'
import vuetify from './plugins/vuetify';
import Home from './views/Home.vue'

Vue.use(VueRouter)

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
    routes: [
        {
            path: '/register/catalog',
            name: 'BrowseCatalog',
            component: () => import('./views/register/BrowseCatalog.vue'),
            props: true
        },
        {
            path: '/register/degree',
            name: 'RegisterDegree',
            component: () => import('./views/register/Degree.vue'),
            props: true
        },
        {
            path: '/register/schedule',
            name: 'Schedule',
            component: () => import('./views/register/Schedule.vue'),
            props: true
        },
        {
            path: '/student/schedule',
            name: 'Schedule',
            component: () => import('./views/Schedule.vue'),
            props: true
        },
        /*
        {
            path: '/status',
            name: 'Status',
            component: () => import('./views/Status.vue')
        },
        {
            path: '/plan',
            name: 'Plan',
            component: () => import('./views/Plan.vue')
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
        */
    ]
});

Vue.config.productionTip = false
new Vue({
  vuetify,
  router,
  render: h => h(Home)
}).$mount('#home')
