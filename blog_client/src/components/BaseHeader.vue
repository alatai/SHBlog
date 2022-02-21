<template>
  <div class="header">
    <div class="container">
      <nav class="row">
        <a href="#">
          <div class="col site-title">SAI HOU's Blog</div>
        </a>
        <div class="col d-flex justify-content-end blog-page">
          <router-link :to="{ name: 'blog-list' }">Home</router-link>
          <router-link :to="{ name: 'about-me' }">About</router-link>
        </div>
      </nav>
    </div>
  </div>
</template>

<script></script>

<style scoped>
.header {
  height: 200px;
  background-image: url(../assets/img/header.jpg);
}

.site-title {
  color: #fff;
  font-size: 24px;
}

nav {
  padding-top: 10px;
}

nav .blog-page a {
  margin-left: 20px;
  color: #fff;
  font-size: 24px;
  text-decoration: none;
}
</style>
