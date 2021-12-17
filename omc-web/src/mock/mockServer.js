import Mock from 'mock'

import banner from './banner.json'

Mock.mock('./mock/banner', { code: 200, data: banner })