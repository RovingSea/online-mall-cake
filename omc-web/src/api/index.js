import request from './request.js'
import mockRequest from './mockRequest.js'

// mock请求首页轮播图
export const reqBanners = () => mockRequest.get('/banner')
// 用户注册
export const reqRegister = data => request({ url: 'common/register', method: 'post', data })
// 用户登陆
export const reqLogin = data =>
	request({
		url: 'common/login',
		method: 'post',
		data,
		headers: {
			'Content-Type': 'multipart/form-data'
		}
	})
// 查询商品所有种类
export const reqGoodsCategory = () => request({ url: '/common/type/all', method: 'get' })

// 模糊查询商品
export const reqSearchGoods = data => request({ url: '/common/goods/fuzzy/get/page', method: 'post', data })

// 根据Id查看商品详情信息
export const reqGoodsDetail = data => request({ url: '/common/goods/get', method: 'post', data })
