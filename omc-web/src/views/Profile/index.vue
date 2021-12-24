<template>
  <div class="profile">
    <div class="header">
      <img src="../../assets/images/avatar.jpg" alt />
      <span class="name">{{userInfo.name}}</span>
      <span class="address">收获地址: {{userInfo.address}}</span>
    </div>
    <div class="main">
      <h2>个人订单汇总</h2>
      <table>
        <thead class="order-header">
          <tr>
            <th>图片</th>
            <th>名称</th>
            <th>单价</th>
            <th>数量</th>
            <th>总价</th>
            <th>状态</th>
          </tr>
        </thead>
        <tbody>
          <tr class="order-list" v-for="item in orderList" :key="item.id">
            <td>
              <img :src="item.image1" alt />
            </td>
            <td>{{item.goodsName}}</td>
            <td class="price">{{item.price}}</td>
            <td class="amount">{{item.amount}}</td>
            <td class="total">{{item.price*item.amount}}</td>
            <td class="status">{{item.status==1? '已支付':'未支付'}}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import { reqProfileInfo, reqProfileOrder } from '@/api/index.js'
import { reactive, onMounted } from 'vue'
export default {
  setup() {
    const state = reactive({
      userInfo: {},
      orderList: []
    })
    onMounted(() => {
      reqProfileInfo().then(res => {
        state.userInfo = res.data.response
      })
      //请求所有订单信息
      reqProfileOrder().then(res => {
        console.log(res)
        state.orderList = res.data.response
      })
    })
    return state
  }
}
</script>

<style lang="less" scoped>
.profile {
  width: 1200px;
  margin: 20px auto;
  .header {
    display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
    img {
      width: 150px;
      border-radius: 50%;
    }
    .name {
      margin-top: 10px;
      font-weight: 600;
      font-size: 20;
    }
    .address {
      margin-top: 20px;
    }
  }
  .main {
    margin-top: 20px;
    h2 {
      text-align: center;
    }
    .order-header tr {
      width: 1200px;
      display: flex;
      justify-content: space-around;
      th {
        width: 170px;
        align-items: center;
      }
    }
    .order-list {
      height: 50px;
      display: flex;
      justify-content: space-around;
      border-bottom: 1px solid @hoverColor;
      td {
        width: 200px;
        text-align: center;
        line-height: 50px;
        overflow: hidden;
      }
      img {
        height: 40px !important;
        vertical-align: middle;
      }
    }
  }
}
</style>