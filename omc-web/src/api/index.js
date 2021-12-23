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

// 管理员身份认证
export const reqAuthentication = () => request({ url: '/common/isAdmin', method: 'get' })
// 查询所有热销商品
export const reqHotGoods = () => request({ url: '/common/goods/get/hot', method: 'get' })

// 查询所有新品
export const reqNewGoods = () => request({ url: '/common/goods/get/new', method: 'get' })

// 根据商品类型查询数据
export const reqGoodsByCategory = data => request({ url: 'common/goods/select/page/type', method: 'post', data })
