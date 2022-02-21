import Vue from 'vue'
import VueRouter from 'vue-router'
import BlogList from '@/views/BlogList.vue'
import BlogDetail from '@/views/BlogDetail.vue'
import AboutMe from '@/views/AboutMe.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/blogs',
    name: 'blog-list',
    component: BlogList,
  },
  {
    path: '/blogs/:id',
    name: 'blog-detail',
    component: BlogDetail,
    props: true,
  },
  {
    path: '/about',
    name: 'about-me',
    component: AboutMe,
  },
]

const router = new VueRouter({
  // Uses the browser's history.pushstate API to
  // change the URL without reloading the page
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
})

export default router
