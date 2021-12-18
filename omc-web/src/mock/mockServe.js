import Mock from 'mockjs'
import banner from './banner.json'

Mock.setup({
  timeout: '200-600'
})

Mock.mock('/mock/banner', 'get',
  () => banner
)