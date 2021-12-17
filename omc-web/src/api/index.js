import request from './request.js'
import mockRequest from './mockRequest.js'




export const reqBanners = () => mockRequest.get('/banner')



reqBanners().then(resolve => {
  console.log(resolve)
})