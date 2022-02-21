<template>
  <div class="sidebar">
    <!-- search -->
    <div class="p-4 blog-search">
      <h4>ブログ検索</h4>
      <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="検索"/>
        <div class="input-group-append">
          <button class="btn btn-outline-secondary" type="button" id="button-addon2">
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
          <a href="#">Java</a>
        </li>
        <li class="list-group-item">
          <a href="#">生活</a>
        </li>
        <li class="list-group-item">
          <a href="#">OS</a>
        </li>
        <li class="list-group-item">
          <a href="#">ネットワーク</a>
        </li>
      </ul>
    </div>
    <!-- contract -->
    <div class="p-4">
      <h4>SNS</h4>
      <ul class="list-unstyled">
        <li>
          <a target="_blank" href="https://github.com/alatai/SHBlog">
            <font-awesome-icon icon="fa-brands fa-github" /> GitHub
          </a>
        </li>
        <li>
          <a target="_blank" href="https://github.com/alatai/SHBlog">
            <font-awesome-icon icon="fa-brands fa-twitter" /> Twitter
          </a>
        </li>
        <li>
          <a target="_blank" href="https://github.com/alatai/SHBlog">
            <font-awesome-icon icon="fa-brands fa-facebook" /> Facebook
          </a>
        </li>
      </ul>
    </div>

  </div>
</template>

<script>
export default {
  name: 'BaseSideBar',
}
</script>

<style scoped>
.sidebar svg:active {
  color: #fff;
}

.list-unstyled {
  padding-left: 20px;
  list-style: none;
}

.blog-search h4 {
  margin-top: 52px;
}
</style>
