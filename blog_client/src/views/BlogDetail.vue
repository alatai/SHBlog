<template>
  <div class="wrapper">
    <div class="container">
      <div class="row">
        <div class="col-md-8 blog-main">
          <div>
            <h3>{{ blog.title }}</h3>
            <p class="blog-date">{{ blog.createdDate | formatDateFilter }}</p>
            <div class="markdown-body" v-html="blog.htmlContent"></div>
          </div>
        </div>
        <BaseSideBar class="col-md-4 blog-sidebar"/>
      </div>
    </div>
    <BaseFooter/>
  </div>
</template>

<script>
import {mapState, mapActions,} from 'vuex'

export default {
  props: ['id'],
  created() {
    this.fetchBlog(this.id)
  },
  computed: {
    ...mapState({
      blog: state => state.blog.blog
    })
  },
  methods: {
    ...mapActions('blog', ['fetchBlog'])
  },
}
</script>

<style scoped>
@import 'github-markdown-css/github-markdown.css';

.markdown-body {
  box-sizing: border-box;
  min-width: 200px;
  max-width: 980px;
  margin: 0 auto;
  padding: 45px;
}

@media (max-width: 767px) {
  .markdown-body {
    padding: 15px;
  }
}

h3 {
  margin-top: 56px;
}

.blog-date {
  margin-bottom: 1.25rem;
  color: #999;
}
</style>
