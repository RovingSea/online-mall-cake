import request from './request.js'
import mockRequest from './mockRequest.js'



// mock请求首页轮播图
export const reqBanners = () => mockRequest.get('/banner')
// 用户注册
export const reqRegister = data => request({ url: 'common/register', method: 'post', data })
// 用户登陆
export const reqLogin = data => request({
  url: "common/login", method: 'post', data, headers: {
    'Content-Type': 'multipart/form-data'
  }
})