import Back from '../views/Back/index.vue'
import Desk from '../views/Desk/index.vue'
const routes = [
  { path: '/', redirect: '/back' },
  {
    path: '/back', component: Back,
    children: [
      {
        path: 'goods',
        name: 'goods',
        component: () => import('../views/Goods/GoodsManage.vue'),
        redirect: { name: 'goodsshow' },
        children: [
          {
            path: 'addgoods',
            name: 'addgoods',
            component: () => import('../views/Goods/AddGoods.vue')
          },
          {
            path: 'goodsshow',
            name: 'goodsshow',
            component: () => import('../views/Goods/GoodsShow.vue')
          }
        ]
      },
      {
        path: 'customer',
        name: 'customer',
        component: () => import('../views/Back/CustomerManage.vue')
      },
      {
        path: 'order',
        name: 'order',
        component: () => import('../views/Back/OrderManage.vue')
      },
      {
        path: 'category',
        name: 'category',
        component: () => import('../views/Back/CategoryManage.vue')
      },
    ]
  },
  { path: '/desk', component: Desk },
]
export default routes