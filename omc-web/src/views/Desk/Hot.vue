<template>
  <div class="hot">
    <div class="cake" v-for="item in hotList" :key="item.id">
      <router-link :to="{name:'detail',params:{id:item.id}}">
        <img :src="item.image1" />
        <span class="title">{{item.name}}</span>
        <span class="desc">种类:{{item.typeName}}</span>
        <p class="intro">{{item.intro}}</p>
      </router-link>
      <div class="footer">
        <span>￥{{item.price}}</span>
        <div class="add-cart" @click="addToShopCart(item.id)">加入购物车</div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, reactive, toRefs } from 'vue'
import { reqHotGoods, reqAddToShopCart } from '../../api/index.js'
export default defineComponent({
  setup() {
    const state = reactive({
      hotList: [],
      whichPage: 1,
      eachPageSize: 999 //这里请求所有的数据
    })
    onMounted(() => {
      reqHotGoods({ whichPage: state.whichPage, eachPageSize: state.eachPageSize }).then(res => {
        console.log(res)
        state.hotList = res.data.response.data
      })
    })
    function addToShopCart(goodsId) {
      reqAddToShopCart({ goodsId }).then(res => {
        if (res.data.response) {
          alert('添加成功')
        }
      })
    }
    return {
      ...toRefs(state),
      addToShopCart
    }
  }
})
</script>

<style scoped lang="less">
.hot {
  display: flex;
  width: 1200px;
  margin: 20px auto 0;
  flex-wrap: wrap;
  .cake {
    width: 320px;
    margin: 20px;
    box-sizing: border-box;
    display: flex;
    flex-direction: column;
    align-items: left;
    img {
      width: 320px;
      height: 180px;
    }
    .title {
      font-size: 18x;
      color: @fontColor;
    }
    .desc {
      float: right;
      color: rgb(184, 171, 171);
    }
    .add-cart {
      cursor: pointer;
    }
    .intro {
      font-size: 14px;
      color: @fontColor;
      margin-top: 5px;
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
