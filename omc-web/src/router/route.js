const routes = [
  { path: '/', redirect: '/back' },
  { path: '/back', component: () => import('../views/Back/index.vue') },
  { path: '/desk', component: () => import('../views/Desk/index.vue') },
]
export default routes