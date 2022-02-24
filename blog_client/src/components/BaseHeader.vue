<template>
  <div class="header">
    <div class="container">
      <nav class="row">
        <a href="#">
          <div class="col">SAI HOU's Blog</div>
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
  height: 230px;
  background-image: url(../assets/img/header.jpg);
}

.header a {
  color: #fff;
  font-size: 24px;
}

.header a:hover {
  text-decoration: none;
}

.header nav {
  padding-top: 10px;
}

.header .blog-page a {
  margin-left: 20px;
}
</style>
