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
  getBlogs() {
    return apiClient.get('/blogs')
  },
  getBlog(id) {
    return apiClient.get('/blogs/' + id)
  },
  getCategories() {
    return apiClient.get('/categories')
  },
}