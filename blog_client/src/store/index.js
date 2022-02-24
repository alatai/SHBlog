import Vue from 'vue'
import Vuex from 'vuex'
import * as blog from '@/store/modules/blog.js'
import * as category from '@/store/modules/category.js'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    blog,
    category,
  },
})
