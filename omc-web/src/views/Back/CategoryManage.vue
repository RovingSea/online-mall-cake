<template>
  <div class="category">
    <div class="search">
      <input type="text" placeholder="请输入需要添加的蛋糕种类" v-model="cakeClass" />
      <button>添加种类</button>
    </div>

    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>名称</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in categoryList" :key="item.id">
          <td>{{item.id}}</td>
          <td>{{item.name}}</td>
          <td>
            <div>修改</div>
            <div>删除</div>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script >
import { defineComponent, reactive } from 'vue'
import { reqAllGoodsCategory } from '../../../src/api/index.js'
export default defineComponent({
  setup() {
    const state = reactive({
      categoryList: []
    })
    // 初始化所有种类数据
    reqAllGoodsCategory().then(res => {
      console.log(res)
      state.categoryList = res.data.response
    })
    return state
  }
})
</script>

<style scoped lang="less">
.category {
  width: 95%;
  box-sizing: border-box;
  margin: 20px auto;
  .search {
    display: flex;
    width: 700px;
    margin-left: 100px;
    input {
      flex: 5;
      margin-right: 10px;
      height: 30px;
      outline: none;
    }
    button {
      flex: 1;
    }
  }
  table {
    margin-top: 30px;
    width: 100%;
    border: 3px solid rgb(133, 119, 75);
    border-collapse: collapse;
    color: @fontColor;
    thead {
      height: 50px;
      line-height: 50px;
      border-bottom: 2px solid rgb(133, 119, 75);
    }
    tbody {
      width: 100%;
      tr {
        text-align: center;
        width: 100%;
        height: 40px;
        border: 1px solid rgb(133, 119, 75);
        th {
          flex: 1;
        }
        td {
          flex: 1;
          border-right: 1px solid rgb(133, 119, 75);
          div {
            width: 50px;
            margin: 1px auto;
            cursor: pointer;
            background-color: @deleteColor;
            color: #fff;
          }
          div:nth-child(1) {
            background-color: @changeColor;
          }
        }
      }
    }
  }
}
</style>
