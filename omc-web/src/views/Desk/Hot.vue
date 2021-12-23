<template>
  <div class="hot">
    <div class="cake" v-for="item in hotList" :key="item.goodsId">
      <router-link :to="{name:'detail',params:{id:'002'}}">
        <img :src="item.image1" />
        <span class="title">{{item.goodsName}}</span>
        <span class="desc">{{item.typeName}}</span>
      </router-link>
      <div class="footer">
        <span>￥{{item.price}}</span>
        <div class="add-cart">加入购物车</div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, reactive } from 'vue'
import { reqHotGoods } from '../../api/index.js'
export default defineComponent({
  setup() {
    const state = reactive({
      hotList: []
    })
    onMounted(() => {
      reqHotGoods().then(res => {
        state.hotList = res.data.response
      })
    })
    return state
  }
})
</script>

<style scoped lang="less">
.hot {
  width: 1200px;
  margin: 20px auto 0;
  .cake {
    width: 300px;
    box-sizing: border-box;
    display: flex;
    flex-direction: column;
    align-items: left;
    img {
      width: 300px;
    }
    .title {
      font-size: 18x;
      color: @fontColor;
    }
    .desc {
      color: rgb(184, 171, 171);
    }
    .footer {
      margin-top: 15px;
      display: flex;
      width: 100%;
      justify-content: space-between;
      color: @hoverColor;
      div {
        width: 100px;
        background-color: @fontColor;
        color: #fff;
        font-size: 15px;
        text-align: center;
      }
    }
  }
}
</style>
