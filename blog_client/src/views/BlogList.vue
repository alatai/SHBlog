<template>
  <div class="wrapper">
    <div class="container">
      <div class="row">
        <div class="col-md-8 blog-main">
          <h3 class="pb-4 mb-4 font-italic border-bottom">Blog List</h3>
          <ul class="list-group list-group-flush">
            <li class="list-group-item" v-for="blog in blogs" :key="blog.id">
              <BaseItem :blog="blog" />
            </li>
          </ul>
          <PageNav class="page-nav"/>
        </div>
        <BaseSideBar class="col-md-4 blog-sidebar"/>
      </div>
    </div>
    <BaseFooter/>
  </div>
</template>

<script>
import PageNav from '@/components/PageNav'
import BlogService from '@/service/BlogService'

export default {
  components: {PageNav},
  data() {
    return {
      blogs: [],
    }
  },
  created() {
    this.loadData()
  },
  methods: {
    loadData() {
      BlogService.getBlogs()
          .then(response => {
            console.log(123)
            console.log(response.data)
            this.blogs = response.data
          })
          .catch(error => {
            console.log(error)
          })
    },
  },
}
</script>

<style scoped>
h3 {
  margin-top: 24px;
}

.page-nav {
  margin: 30px 0 50px 0;
}
</style>
