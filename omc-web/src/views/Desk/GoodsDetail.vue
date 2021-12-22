<template>
  <div class="goods-detail">
    <h2>商品详情</h2>
    <img src="../../assets/images/cakehot.png" alt="">
    <div class="desc">
      <h2>半熟知识</h2>
      <span>分类: 儿童类</span>
      <p>desc: Lorem ipsum dolor sit amet consectetur adipisicing elit. Minima, ipsam nihil eius aliquid soluta vel architecto. Rem corporis libero voluptates nostrum doloremque dolore veritatis quisquam in soluta et, sed maiores.</p>
      <br>
      <span>￥ 28</span>
    </div>
    <div class="button" @click="goShopCart(2)">
      加入购物车
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import { useRoute, useRouter } from "vue-router";
export default defineComponent({
  setup() {
    const route = useRoute();
    const router = useRouter();
    const goShopCart = (id) => {
      router.push({
        name: "shopcart",
        params: {
          id,
        },
      });
    };
    return {
      route,
      goShopCart,
    };
  },
});
</script>

<style scoped lang="less">
.goods-detail {
  width: 1220px;
  margin: 40px auto;
  text-align: center;
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
