<template>
  <div class="order">
    <div class="header">
      <ul>
        <li
          v-for="(item, index) in orders"
          :key="index"
          :class="{ active: index === currentIndex }"
          @click="changeIndex(index)"
          :data-a="currentIndex"
        >{{ item }}</li>
      </ul>
    </div>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>总价</th>
          <th>收获地址</th>
          <th>订单状态</th>
          <th>支付方式</th>
          <th>下单用户</th>
          <th>下单时间</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in orderInfo" :key="item.id">
          <td>{{item.orderId}}</td>
          <td>{{item.total}}</td>
          <td>{{item.address}}</td>
          <td>{{item.status==1? '已付款':'未付款'}}</td>
          <td>微信</td>
          <td>{{item.name}}</td>
          <td>{{item.datetime}}</td>
        </tr>
      </tbody>
    </table>
    <Pagination :total="total" :pageSize="eachPageSize" :pageNo="whichPage" :continues="2" class="pagination" @getPageNo="getPageNo" />
  </div>
</template>

<script>
import { defineComponent, reactive, toRefs } from 'vue'
import { reqAllOrders, reqAllUnpaidOrder, reqAllPaidOrder } from '@/api/index.js'
export default defineComponent({
  setup() {
    const state = reactive({
      orders: ['全部订单', '未付款', '已付款'],
      currentIndex: 0,
      whichPage: 1,
      eachPageSize: 3,
      orderInfo: [],
      total: 0
    })
    function changeIndex(index) {
      state.currentIndex = index
      getOrder()
      state.whichPage = 1
    }
    // 初始化数据
    function getOrder() {
      const data = {
        whichPage: state.whichPage,
        eachPageSize: state.eachPageSize
      }
      switch (state.currentIndex) {
        case 0:
          reqAllOrders(data).then(res => {
            state.orderInfo = res.data.data
            state.total = res.data.databaseDataSize
          })
          break
        case 1:
          reqAllUnpaidOrder(data).then(res => {
            state.orderInfo = res.data.data
            state.total = res.data.databaseDataSize
          })
          break
        case 2:
          reqAllPaidOrder(data).then(res => {
            console.log(res)
            state.orderInfo = res.data.data
            state.total = res.data.databaseDataSize
          })
          break
      }
    }
    getOrder()
    // 修改分页
    function getPageNo(num) {
      state.whichPage = num
      getOrder()
    }
    return {
      ...toRefs(state),
      getOrder,
      changeIndex,
      getPageNo
    }
  }
})
</script>

<style scoped lang="less">
.order {
  width: 1200px;
  margin: 0 auto;
}
.header {
  width: 700px;
  margin: 0 auto;
  ul {
    display: flex;
    margin-top: 30px;
    width: 700px;
    height: 50px;
    line-height: 50px;
    text-align: center;
    border-bottom: 2px solid @fontColor;
    li {
      flex: 1;
      cursor: pointer;
    }
    .active {
      color: @hoverColor;
    }
  }
}
table {
  color: @fontColor;
  margin-top: 10px;
  width: 1200px;
  border: 3px solid rgb(133, 119, 75);
  border-collapse: collapse;
  thead {
    height: 50px;
    line-height: 50px;
    border-bottom: 2px solid rgb(133, 119, 75);
    tr {
      display: flex;
      th {
        flex: 1;
      }
    }
  }
  tbody {
    width: 100%;
    tr {
      height: 40px;
      line-height: 40px;
      display: flex;
      border: 1px solid rgb(133, 119, 75);
      td {
        text-align: center;
        flex: 1;
        border-right: 1px solid rgb(133, 119, 75);
      }
    }
  }
}
.pagination {
  margin-top: 20px;
}
</style>
