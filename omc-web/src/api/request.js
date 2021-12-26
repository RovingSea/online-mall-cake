import axios from 'axios'

import nprogress from 'nprogress'
import 'nprogress/nprogress.css'

const request = axios.create({
	baseURL: 'http://180.76.136.123:13400/omc/api/',
	timeout: 5000
})
import { getToken } from '../utils/token.js'
request.interceptors.request.use(config => {
	nprogress.start()
	// 请求拦截器
	config.headers['Content-type'] = 'application/json;charset=UTF-8'
	if (getToken()) {
		config.headers.authentication = getToken()
	}
	return config
})

request.interceptors.response.use(
	res => {
		nprogress.done()
		return res
	},
	err => {
		return new Promise.reject('fail' + err)
	}
)

export default request
