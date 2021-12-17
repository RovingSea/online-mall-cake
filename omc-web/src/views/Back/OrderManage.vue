<template>
  <div>
    <div class="header">
      <ul>
        <li
          v-for="(item, index) in orders"
          :key="index"
          :class="{ active: index === currentIndex }"
          @click="changeIndex(index)"
          :data-a="currentIndex"
        >
          {{ item }}
        </li>
      </ul>
    </div>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>总价</th>
          <th>商品详情</th>
          <th>收获信息</th>
          <th>订单状态</th>
          <th>支付方式</th>
          <th>下单用户</th>
          <th>下单时间</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>77</td>
          <td>299</td>
          <td>草莓冰淇淋</td>
          <td>管理员</td>
          <td>订单状态</td>
          <td>微信</td>
          <td>admin</td>
          <td>2019</td>
          <td>
            <button>完成</button>
            <button>删除</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import { defineComponent, ref } from 'vue'
export default defineComponent({
  setup() {
    let orders = ['全部订单', '未付款', '已付款', '配送中', '已完成']
    let currentIndex = ref(0)
    function changeIndex(index) {
      currentIndex.value = index
    }
    return {
      currentIndex,
      changeIndex,
      orders,
    }
  },
})
</script>

<style scoped lang="less">
.header {
  ul {
    display: flex;
    margin-top: 40px;
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
</style>
