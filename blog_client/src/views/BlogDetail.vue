<template>
  <div class="wrapper">
    <div class="container">
      <div class="row">
        <div class="col-md-8 blog-main">
          <div style="height: 800px">
            <!--            <h3>Blog Title</h3>-->
            <!--            <p class="blog-date">January 1, 2022 by SaiHou</p>-->
            <div class="markdown-body">
              <h1>Unicorns</h1>
              <p>All the things</p>
            </div>
          </div>
        </div>
        <BaseSideBar class="col-md-4 blog-sidebar"/>
      </div>
    </div>
    <BaseFooter/>
  </div>
</template>

<script>
export default {
  props: ['id'],
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
  margin-top: 24px;
}

.blog-date {
  margin-bottom: 1.25rem;
  color: #999;
}
</style>
