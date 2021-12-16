import { createApp } from 'vue'
import App from './App.vue'
import '../public/css/base.css'
// 导入element-plus
import ElementPlus from 'element-plus'
import '../node_modules/element-plus/dist/index.css'
const app = createApp(App)
app.use(ElementPlus)
app.mount('#app')
