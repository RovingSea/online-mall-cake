import { createRouter, createWebHashHistory } from 'vue-router'
import routes from './route.js'
const router = createRouter({
	history: createWebHashHistory(),
	routes
})

import { reqAuthentication } from '../api/index.js'
// 进入管理员界面进行鉴权校验

router.beforeEach(async (to, from, next) => {
	if (to.meta.isAuth == true) {
		console.log(to, '1')
		// try {
		// 	reqAuthentication().then(res => {
		// 		next()
		// 	})
		// } catch (e) {
		// 	next(false)
		// 	alert('非管理员无法进入')
		// }
		try {
			await reqAuthentication()
		} catch (error) {
			alert(error)
			next(false)
		}
	}
	next()
})
export default router
