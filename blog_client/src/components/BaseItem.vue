<template>
  <article>
    <router-link :to="{ name: 'blog-detail', params: { id: '1' } }">
      <h2 class="blog-title">Blog Title #id</h2>
    </router-link>
    <p class="blog-date">January 1, 2022 by SaiHou</p>
    <p>Blog summary</p>
  </article>
</template>

<script>
export default {}
</script>

<style scoped>
article a:hover {
  text-decoration: none;
}

article .blog-title {
  margin-bottom: 0.25rem;
  font-size: 2.5rem;
  color: #000;
}

article .blog-date {
  margin-bottom: 1.25rem;
  color: #999;
}
</style>
