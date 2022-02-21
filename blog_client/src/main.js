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

// set fontawesome component
library.add(faMagnifyingGlass, faGithub, faTwitter, faFacebook)
Vue.component('font-awesome-icon', FontAwesomeIcon)

// set bootstrap component
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

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount('#app')
