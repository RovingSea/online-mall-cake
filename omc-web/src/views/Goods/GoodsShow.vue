<template>
  <div class="goods-show">
    <div class="header">
      <ul>
        <li> <img src="../../assets/images/cake1.png" alt=""> 全部商品</li>
        <li> <img src="../../assets/images/cake2.png" alt=""> 条幅推荐</li>
        <li> <img src="../../assets/images/cake3.png" alt=""> 热销推荐</li>
        <li> <img src="../../assets/images/cake4.png" alt=""> 新品推荐</li>
      </ul>
    </div>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>图片</th>
          <th>名称</th>
          <th>介绍</th>
          <th>价格</th>
          <th>种类</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
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
            <div>移除条幅</div>
            <div>移除热销</div>
            <div>移除新品</div>
            <div style="background-color: #e63326">删除</div>
            <div style="background-color: #e6a726">修改</div>
          </td>
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
            <div>移除条幅</div>
            <div>移除热销</div>
            <div>移除新品</div>
            <div>删除</div>
            <div>修改</div>
          </td>
        </tr>
      </tbody>
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
  margin: 40px 50px 12px;
  width: 1200px;
  .header {
    height: 40px;
    line-height: 40px;
    border-bottom: 5px dotted @fontColor;
  }
  ul {
    width: 700px;
    display: flex;
    li {
      text-align: center;
      flex: 1;
      font-weight: 600;
      color: @hoverColor;
      cursor: pointer;
      img {
        width: 40px;
        vertical-align: middle;
      }
    }
  }

  table {
    border: 3px solid rgb(133, 119, 75);
    border-collapse: collapse;
    height: 500px;
    width: 100%;
    margin-top: 20px;
    thead {
      height: 50px;
      line-height: 50px;
      border-bottom: 2px solid rgb(133, 119, 75);
    }
    tbody {
      tr {
        border: 1px solid rgb(133, 119, 75);
        td {
          border-right: 1px solid rgb(133, 119, 75);
        }
      }
    }
    tr {
      display: flex;
      text-align: center;
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
        color: @fontColor;
        padding: 10px;
        div {
          margin: 0 auto 5px;
          width: 80%;
          background-color: @fontColor;
          color: #fff;
          padding: 5px;
          margin-right: 4px;
          cursor: pointer;
        }
      }
    }
  }
}
</style>
