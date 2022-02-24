<template>
  <div>
    <nav aria-label="Page navigation example"
         style="margin-top: 100px;" th:fragment="pagenav">
      <div class="container">
        <div class="page-nav">
          <ul class="pagination justify-content-center">
            <!-- previous page -->
            <li class="page-item" :class="{disabled: pageResult.first}">
              <a class="page-link" href="javascript:" aria-label="Previous"
                 @click="goPage(0)">
                <span aria-hidden="true">&laquo;</span>
              </a>
            </li>

            <!-- previous page -->
            <li class="page-item" :class="{disabled: !pageResult.hasPrevious}">
              <a class="page-link" href="javascript:" aria-label="Previous"
                 @click="goPage(pageResult.number - 1)">
                <span aria-hidden="true">‹</span>
              </a>
            </li>

            <!-- pages -->
            <li class="page-item" v-for="no in pageResult.displayNums" :key="no">
              <a class="page-link" href="javascript:"
                 @click="goPage(no - 1)">{{ no }}</a>
            </li>

            <!-- next page -->
            <li class="page-item" :class="{disabled: !pageResult.hasNext}">
              <a class="page-link" href="javascript:" aria-label="Next"
                 @click="goPage(pageResult.number + 1)">
                <span aria-hidden="true">›</span>
              </a>
            </li>

            <!-- last page -->
            <li class="page-item" :class="{disabled: pageResult.last}">
              <a class="page-link" href="javascript:" aria-label="Next"
                 @click="goPage(pageResult.totalPages - 1)">
                <span aria-hidden="true">&raquo;</span>
              </a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </div>
</template>

<script>
export default {
  props: {
    pageResult: Object,
  },
  methods: {
    goPage(num) {
      this.$store.dispatch('blog/fetchBlogs', {
        start: num,
      })
    },
  }
}
</script>

<style scoped></style>
