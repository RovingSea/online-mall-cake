import Mock from 'mockjs'

import banner from './banner.json'

Mock.mock('./mock/banner', { code: 200, data: banner })

console.log('mock')