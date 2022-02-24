<template>
  <div class="wrapper">
    <div class="container">
      <div class="row">
        <div class="col-md-8 blog-main">
          <h3 class="pb-4 mb-4 font-italic border-bottom">Blog List</h3>
          <ul class="list-group list-group-flush">
            <li class="list-group-item" v-for="blog in blogs" :key="blog.id">
              <BaseItem :blog="blog"/>
            </li>
          </ul>
          <PageNav class="page-nav" :pageResult="pageResult"/>
        </div>
        <BaseSideBar class="col-md-4 blog-sidebar"/>
      </div>
    </div>
    <BaseFooter/>
  </div>
</template>

<script>
import PageNav from '@/components/PageNav'
import {mapState,} from 'vuex'

export default {
  components: {
    PageNav,
  },
  created() {
    this.$store.dispatch('blog/fetchBlogs', {
      start: 0
    })
  },
  computed: {
    ...mapState({
      blogs: state => state.blog.blogs,
      pageResult: state => state.blog.pageResult,
    }),
  },
}
</script>

<style scoped>
h3 {
  margin-top: 56px;
}

.page-nav {
  margin: 30px 0 50px 0;
}
</style>
