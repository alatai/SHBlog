import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import upperFirst from 'lodash/upperFirst'
import camelCase from 'lodash/camelCase'
import {library} from '@fortawesome/fontawesome-svg-core'
import {faMagnifyingGlass} from '@fortawesome/free-solid-svg-icons'
import {faGithub, faTwitter, faFacebook} from '@fortawesome/free-brands-svg-icons'
import {FontAwesomeIcon} from '@fortawesome/vue-fontawesome'
import {BootstrapVue, IconsPlugin} from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import moment from 'moment/moment.js'

// fontawesome component
library.add(faMagnifyingGlass, faGithub, faTwitter, faFacebook)
Vue.component('font-awesome-icon', FontAwesomeIcon)

// bootstrap component
Vue.use(BootstrapVue)
Vue.use(IconsPlugin)

// ------ set global component automatically ------
const requireComponent = require.context(
    './components',
    false,
    /Base[A-Z]\w+\.(vue|js)$/
)

requireComponent.keys().forEach((fileName) => {
  const componentConfig = requireComponent(fileName)

  const componentName = upperFirst(
      camelCase(
          fileName
              .split('/')
              .pop()
              .replace(/\.\w+$/, '')
      )
  )

  Vue.component(
      componentName,
      componentConfig.default || componentConfig
  )
})
// ------ set global component automatically ------

// 日時フォーマット
Vue.filter('formatDateFilter', function (dateValue, formatString) {
  if (null == dateValue) {
    return ''
  }

  formatString = formatString || 'YYYY-MM-DD HH:mm:ss'

  return moment(dateValue).format(formatString)
})

// ページタイトル
router.beforeEach((to, form, next) => {
  if (to.meta.title) {
    document.title = to.meta.title
  }
  next()
})

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount('#app')
