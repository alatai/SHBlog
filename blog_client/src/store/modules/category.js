import BlogService from '@/services/BlogService.js'

export const namespaced = true

export const state = {
  categories: [],
  category: {},
}

export const mutations = {
  SET_CATEGORIES(state, categories) {
    state.categories = categories
  },
}

export const actions = {
  fetchCategories({commit}) {
    BlogService.getCategories()
        .then((response) => {
          commit('SET_CATEGORIES', response.data)
        })
        .catch((error) => {
          console.log(error)
        })
  }
}