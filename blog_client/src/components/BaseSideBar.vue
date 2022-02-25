<template>
  <div class="sidebar">
    <!-- search -->
    <div class="p-4 blog-search">
      <h4>ブログ検索</h4>
      <div class="input-group mb-3">
        <input type="text" class="form-control"
               placeholder="検索" v-model="keyword"/>
        <div class="input-group-append">
          <button class="btn btn-outline-secondary" type="button"
                  v-on:click="searchByKeyword()">
            <font-awesome-icon icon="fa-solid fa-magnifying-glass"/>
          </button>
        </div>
      </div>
    </div>
    <!-- category -->
    <div class="p-4">
      <h4>カテゴリ</h4>
      <ul class="list-group list-group-flush">
        <li class="list-group-item">
          <a href="javascript:" v-on:click="searchByCid()">全部</a>
        </li>
        <li class="list-group-item" v-for="category in categories" :key="category.id">
          <a href="javascript:" v-on:click="searchByCid(category.id)">{{ category.name }}</a>
        </li>
      </ul>
    </div>
    <!-- contract -->
    <div class="p-4 blog-sns">
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
import {mapState, mapActions,} from 'vuex'

export default {
  data() {
    return {
      keyword: '',
    }
  },
  created() {
    this.fetchCategories()
  },
  methods: {
    searchByCid(cid) {
      if (!cid) {
        this.$store.dispatch('blog/fetchBlogs', {
          start: 0
        }).then(() => {
          this.back2Home()
        })
      } else {
        this.$store.dispatch('blog/fetchBlogsByCid', cid)
            .then(() => {
              this.back2Home()
            })
      }
    },
    searchByKeyword() {
      this.$store.dispatch('blog/fetchBlogByKeyword', this.keyword)
          .then(() => {
            this.back2Home()
          })
    },
    // 詳細ページからホームページへ移動する
    back2Home() {
      // URLを分析して判断する
      let isDetailPage = window.location.pathname
          .split('/').find(item => this.isNumber(item))

      if (isDetailPage) {
        this.$router.push({
          name: 'blog-list',
        })
      }
    },
    isNumber(value) {
      let reg = /^[0-9]+.?[0-9]*/

      return reg.test(value)
    },
    ...mapActions('category', ['fetchCategories'])
  },
  computed: {
    ...mapState({
      categories: state => state.category.categories
    })
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

.sidebar .blog-sns {
  margin-bottom: 52px;
}
</style>
