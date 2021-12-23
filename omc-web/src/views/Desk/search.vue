<template>
  <div class="search">
    <div class="main" v-if="goodList.length!==0">
      <div class="cake" v-for="item in goodList" :key="item.id">
        <router-link :to="{name:'detail',params:{id:item.id}}">
          <img :src="item.image1" alt />
          <span class="title">{{item.name}}</span>
          <span class="desc">{{item.intro}}</span>
        </router-link>
        <div class="footer">
          <span>￥{{item.price}}</span>
          <div class="add-cart">加入购物车</div>
        </div>
      </div>
      <!-- 分页器 -->
      <!-- <Pagination  /> -->
    </div>
    <div class="no-data" v-else>
      <h2>没有找到该商品，请重新搜索试试~~</h2>
    </div>
  </div>
</template>

<script>
import { reactive, watch, watchEffect } from 'vue'
import { useRoute } from 'vue-router'
import { reqSearchGoods } from '../../api/index.js'
export default {
  setup() {
    const route = useRoute()
    const data = reactive({
      whichPage: 1,
      eachPageSize: 8,
      name: ''
    })

    const state = reactive({
      goodList: [],
      isShowLoading: false
    })

    function getGoods() {
      data.name = route.params.keyword
      reqSearchGoods(data).then(res => {
        // console.log(res)
        state.goodList = res.data.response.data
      })
    }
    watchEffect(() => {
      getGoods()
    })

    return state
  }
}
</script>

<style lang="less" scoped>
.search {
  width: 1200px;
  margin: 20px auto;
}
.main {
  .cake {
    width: 300px;
    box-sizing: border-box;
    display: flex;
    flex-direction: column;
    align-items: left;
    img {
      width: 100%;
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
  .no-data {
    h2 {
      color: @fontColor;
      text-align: center;
    }
  }
}
</style>