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
    meta: {
      title: 'Home',
    },
  },
  {
    path: '/blogs/:id',
    name: 'blog-detail',
    component: BlogDetail,
    props: true,
    meta: {
      title: 'Blog',
    },
  },
  {
    path: '/about',
    name: 'about-me',
    component: AboutMe,
    meta: {
      title: 'About',
    },
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
})

export default router
