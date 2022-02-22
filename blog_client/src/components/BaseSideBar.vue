<template>
  <div class="sidebar">
    <!-- search -->
    <div class="p-4 blog-search">
      <h4>ブログ検索</h4>
      <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="検索"/>
        <div class="input-group-append">
          <button class="btn btn-outline-secondary" type="button" v-on:click="test()">
            <font-awesome-icon icon="fa-solid fa-magnifying-glass"/>
          </button>
        </div>
      </div>
    </div>
    <!-- category -->
    <div class="p-4">
      <h4>カテゴリ</h4>
      <ul class="list-group list-group-flush">
        <li class="list-group-item" v-for="category in categories" :key="category.id">
          <a href="#">{{ category.name }}</a>
        </li>
      </ul>
    </div>
    <!-- contract -->
    <div class="p-4">
      <h4>SNS</h4>
      <ul class="list-unstyled">
        <li>
          <a target="_blank" href="https://github.com/alatai/SHBlog">
            <font-awesome-icon icon="fa-brands fa-github"/>
            GitHub
          </a>
        </li>
        <li>
          <a target="_blank" href="https://github.com/alatai/SHBlog">
            <font-awesome-icon icon="fa-brands fa-twitter"/>
            Twitter
          </a>
        </li>
        <li>
          <a target="_blank" href="https://github.com/alatai/SHBlog">
            <font-awesome-icon icon="fa-brands fa-facebook"/>
            Facebook
          </a>
        </li>
      </ul>
    </div>

  </div>
</template>

<script>
import BlogService from '@/service/BlogService'


export default {
  data () {
    return {
      categories: [],
    }
  },
  created () {
    this.load()
  },
  methods: {
    load () {
      BlogService.getCategories()
          .then(response => {
            console.log(123)
            console.log(response.data)
            this.categories = response.data
          })
          .catch(error => {
              console.log(error)
          })
    },
  },
}
</script>

<style scoped>
.sidebar a:hover {
  color: #0056b3;
  text-decoration: none;
}

.sidebar svg:active {
  color: #fff;
}

.sidebar .list-unstyled {
  padding-left: 20px;
  list-style: none;
}

.sidebar .blog-search h4 {
  margin-top: 52px;
}
</style>
