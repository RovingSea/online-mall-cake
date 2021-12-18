import request from './request.js'
import mockRequest from './mockRequest.js'



// mock请求首页轮播图
export const reqBanners = () => mockRequest.get('/banner')
// 用户注册
export const reqRegister = () => request({ url: '' })
// 用户登陆
export const reqLogin = () => request.get({})