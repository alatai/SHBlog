import axios from 'axios'

const apiClient = axios.create({
  baseURL: 'http://localhost:8088',
  withCredentials: false,
  headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json',
  },
})

export default {
  getBlogs(start) {
    return apiClient.get('/blogs', {
      params: {
        start: start,
      }
    })
  },
  getBlogsByCid(cid) {
    return apiClient.get('/categories/' + cid + '/blogs')
  },
  getBlogsByKeyword(keyword) {
    return apiClient.get('/blogs/keyword', {
      params: {
        keyword: keyword
      }
    })
  },
  getBlog(id) {
    return apiClient.get('/blogs/' + id)
  },
  getCategories() {
    return apiClient.get('/categories')
  },
}