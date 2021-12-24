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
		data
		// headers: {
		// 	'Content-Type': 'multipart/form-data'
		// }
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

// 更新个人信息
export const reqProfileInfo = () => request({ url: '/user/current', method: 'get' })

// 商品添加到购物车

export const reqAddToShopCart = data => request({ url: '/user/goods/add/shoppingCart', method: 'post', data })
// 查看个人购物车

export const reqProfileShopCart = () => request({ url: '/user/shoppingCart/mine', method: 'get' })

/* 管理员接口 */

// 添加商品
export const addGoods = data => request({ url: '/admin/goods/add', method: 'post', data })

// 查询所有商品数据
export const reqAllGoods = data => request({ url: '/common/goods/select/page', method: 'post', data })
// 条幅推荐
export const reqAllRecommend = data => request({ url: '/common/goods/get/recommend', method: 'get', data })
// 所有热销商品
export const reqHotRecommend = data => request({ url: '/common/goods/get/page/hot', method: 'post', data })
// 所有新品推荐
export const reqNewRecommend = data => request({ url: '/common/goods/get/page/new', method: 'post', data })
// 所有商品种类
export const reqAllGoodsCategory = () => request({ url: '/common/type/all', method: 'get' })
