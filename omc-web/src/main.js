import { createApp } from 'vue'
import App from './App.vue'
import '../public/css/base.css'
// 导入element-plus
import ElementPlus from 'element-plus'
import '../node_modules/element-plus/dist/index.css'
import Pagination from "./components/Pagination.vue";


// 导入路由
import router from './router/index'

import './mock/mockServe.js'

const app = createApp(App)
app.use(ElementPlus)
app.component(Pagination.name, Pagination)
app.use(router)
app.mount('#app')
