import { createApp } from 'vue'
import App from './App.vue'
import '../public/css/base.css'
// 导入element-plus
import ElementPlus from 'element-plus'
import '../node_modules/element-plus/dist/index.css'
import Pagination from './components/Pagination.vue'
import Alert from '@/components/Alert.vue'

import '@/mock/mockServe.js'

import { Lazyload } from 'vant'
// 导入路由
import router from './router/index'

// 懒加载
// import lazyPlugin from 'vue3-lazy'
// app.use(lazyPlugin, {
// 	loading: require('../src/assets/images/cakeloading.png'), // 图片加载时默认图片
// 	error: require('@/assets/images/error.png') // 图片加载失败时默认图片
// })

const app = createApp(App)
app.use(ElementPlus)
app.component(Pagination.name, Pagination)
app.component(Alert.name, Alert)
app.use(router)
app.use(Lazyload)
app.mount('#app')
