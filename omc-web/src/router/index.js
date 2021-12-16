import { createRouter, createWebHashHistory } from 'vue-router'

import routes from './route.js'
export default createRouter({
  history: createWebHashHistory(),
  routes
})