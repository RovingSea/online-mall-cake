<template>
  <div class="goods-detail">
    <h2>商品详情</h2>
    <img :src="detail.image1" alt />
    <div class="desc">
      <h2>{{detail.name}}</h2>
      <span>分类: 儿童类</span>
      <p>{{detail.intro}}</p>
      <br />
      <span>￥ {{detail.price}}</span>
    </div>
    <div class="button" @click="goShopCart(2)">加入购物车</div>
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, toRefs } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { reqGoodsDetail } from '../../api/index.js'
export default defineComponent({
  setup() {
    const state = reactive({
      detail: {}
    })
    const route = useRoute()
    const router = useRouter()
    // 请求商品详情数据
    reqGoodsDetail({ id: route.params.id }).then(res => {
      console.log(res)
      state.detail = res.data.response
    })
    const goShopCart = id => {
      router.push({
        name: 'shopcart',
        params: {
          id
        }
      })
    }
    return {
      route,
      goShopCart,
      ...toRefs(state)
    }
  }
})
</script>

<style scoped lang="less">
.goods-detail {
  width: 1220px;
  margin: 40px auto;
  text-align: center;
  img {
    width: 400px;
  }
}
.button {
  height: 40px;
  width: 140px;
  line-height: 40px;
  margin: 40px auto;
  background-color: @fontColor;
  color: #fff;
  cursor: pointer;
}
</style>
