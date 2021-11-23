import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import Vue from 'vue'

createApp(App).mount('#app')

new Vue({
    router,
    render: h => h(App)
  }).$mount('#app')
  

//Vue.config.productionTip = false
