import { createRouter, createWebHashHistory } from 'vue-router'
import routes from './route.js'
const router = createRouter({
	history: createWebHashHistory(),
	routes
})

import { getToken } from '@/utils/token.js'
import { reqAuthentication } from '../api/index.js'
// 进入管理员界面进行鉴权校验

router.beforeEach(async (to, from, next) => {
	// if (to.meta.isAuth == true) {
	// 	console.log(to, '1')
	// 	// try {
	// 	// 	reqAuthentication().then(res => {
	// 	// 		next()
	// 	// 	})
	// 	// } catch (e) {
	// 	// 	next(false)
	// 	// 	alert('非管理员无法进入')
	// 	// }
	// 	try {
	// 		await reqAuthentication()
	// 	} catch (error) {
	// 		alert(error)
	// 		next(false)
	// 	}
	// }
	// 用户未登录校验
	if (to.meta.isAuth) {
		if (getToken()) {
			// 管理员省份确认
			if (to.path.indexOf('/back') === 0) {
				console.log('进入后台')
				let res = await reqAuthentication()
				console.log(res, 'token')
				if (res.data.code == 1) {
					next()
				} else {
					alert('非管理员无法进入')
					next({ name: 'desk' })
				}
			}
		} else {
			alert('当前未登录')
			next({ name: 'login' })
		}
	}
	next()
})
export default router
