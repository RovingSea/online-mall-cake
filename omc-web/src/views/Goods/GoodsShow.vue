<template>
  <div class="goods-show">
    <div class="header">
      <ul>
        <li>全部商品</li>
        <li>条幅推荐</li>
        <li>热销推荐</li>
        <li>新品推荐</li>
      </ul>

    </div>
    <table>
      <tr>
        <th>ID</th>
        <th>图片</th>
        <th>名称</th>
        <th>介绍</th>
        <th>价格</th>
        <th>种类</th>
        <th>操作</th>
      </tr>
      <tr>
        <td>10</td>
        <td><img src="https://picsum.photos/id/544/200/200" alt=""></td>
        <td>芝士条</td>
        <td>
          。。。。。。。。。。。。。。。。
        </td>
        <td>28.0</td>
        <td>儿童系列</td>
        <td>
          <button>移除条幅</button>
          <button>移除热销</button>
          <button>移除新品</button>
          <button>删除</button>
          <button>修改</button>
        </td>
      </tr>
    </table>
    <router-view></router-view>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
export default defineComponent({
  setup() {
    return {};
  },
});
</script>

<style scoped lang="less">
.goods-show {
  margin: 40px 50px;
  width: 1200px;
  .header {
    height: 40px;
    line-height: 40px;
    border-bottom: 5px dotted @fontColor;
  }
  ul {
    width: 400px;
    display: flex;
    li {
      text-align: center;
      flex: 1;
    }
  }

  table {
    height: 500px;
    width: 100%;
    margin-top: 20px;
    tr {
      display: flex;
      text-align: center;
      height: 50px;
      td,
      th {
        width: 120px;
        flex: 1;

        img {
          width: 100%;
        }
      }
      td {
        overflow: hidden;
        height: 200px;
        word-wrap: break-word;
      }
    }
  }
}
</style>
