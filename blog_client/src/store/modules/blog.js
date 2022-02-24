import BlogService from '@/services/BlogService.js'

export const namespaced = true

export const state = {
  pageResult: {},
  blogs: [],
  blog: {},
}

export const mutations = {
  SET_BLOGS(state, blogs) {
    state.blogs = blogs
  },
  SET_BLOG(state, blog) {
    state.blog = blog
  },
  SET_PAGE_RESULT(state, pageResult) {
    state.pageResult = pageResult
  },
}

export const actions = {
  fetchBlogs({commit}, {start}) {
    BlogService.getBlogs(start)
        .then((response) => {
          commit('SET_BLOGS', response.data.content)
          commit('SET_PAGE_RESULT', response.data)
        })
        .catch((error) => {
          console.log(error)
        })
  },
  fetchBlogsByCid({commit}, cid) {
    BlogService.getBlogsByCid(cid)
        .then((response) => {
          commit('SET_BLOGS', response.data.content)
          commit('SET_PAGE_RESULT', response.data)
        })
        .catch((error) => {
          console.log(error)
        })
  },
  fetchBlogByKeyword({commit}, keyword) {
    BlogService.getBlogsByKeyword(keyword)
        .then((response) => {
          commit('SET_BLOGS', response.data.content)
          commit('SET_PAGE_RESULT', response.data)
        })
        .catch((error) => {
          console.log(error)
        })
  },
  fetchBlog({commit, getters}, id) {
    let blog = getters.getBlogById(id)

    if (blog) {
      commit('SET_BLOG', blog)
    } else {
      BlogService.getBlog(id)
          .then((response) => {
            commit('SET_BLOG', response.data)
          })
          .catch((error) => {
            console.log(error)
          })
    }
  },
}

export const getters = {
  getBlogById: state => id => {
    return state.blogs.find(blog => blog.id === id)
  }
}