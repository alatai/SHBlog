<template>
  <div class="wrapper">
    <div class="container">
      <div class="row">
        <div class="col-md-8 blog-main">
          <h3 class="pb-4 mb-4 font-italic border-bottom">Blog List</h3>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">
              <BaseItem />
            </li>
            <li class="list-group-item">
              <BaseItem />
            </li>
            <li class="list-group-item">
              <BaseItem />
            </li>
            <li class="list-group-item">
              <BaseItem />
            </li>
            <li class="list-group-item">
              <BaseItem />
            </li>
          </ul>
          <PageNav class="page-nav"/>
        </div>
        <BaseSideBar class="col-md-4 blog-sidebar" />
      </div>
    </div>
    <BaseFooter />
  </div>
</template>

<script>
import PageNav from '@/components/PageNav'

export default {
  components: {PageNav}
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
