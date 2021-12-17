import request from './request.js'
import mockRequest from './mockRequest.js'


// 请求首页轮播图
export const reqBannerList = () => mockRequest({ url: '/banner', method: 'get' })


