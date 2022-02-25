<template>
  <div class="blog-footer">
    <p>SAI HOU's Blog(Vue + Bootstrap) write by
      <a href="https://github.com/alatai/SHBlog" target="_blank">
        <font-awesome-icon icon="fa-brands fa-github"/>
        alatai
      </a>
    </p>
    <p>
      <a href="#">Back to top</a>
    </p>
  </div>
</template>

<script>
export default {}
</script>

<style scoped>
.blog-footer {
  padding: 2.5rem 0;
  color: #999;
  text-align: center;
  background-color: #f9f9f9;
  border-top: 0.05rem solid #e5e5e5;
}

.blog-footer a:hover {
  color: #0056b3;
  text-decoration: none;
}

.blog-footer p {
  margin-top: 0;
  margin-bottom: 1rem;
}

.blog-footer p:last-child {
  margin-bottom: 0;
}
</style>
