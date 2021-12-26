<template>
  <div class="goods-show">
    <div class="header">
      <ul>
        <li @click="tapClick(1)">
          <img src="../../assets/images/cake1.png" alt /> 全部商品
        </li>
        <li @click="tapClick(2)">
          <img src="../../assets/images/cake2.png" alt /> 条幅推荐
        </li>
        <li @click="tapClick(3)">
          <img src="../../assets/images/cake3.png" alt /> 热销推荐
        </li>
        <li @click="tapClick(4)">
          <img src="../../assets/images/cake4.png" alt /> 新品推荐
        </li>
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
        <tr v-for="item in goodsList" :key="item.id">
          <td>{{item.id}}</td>
          <td>
            <img :src="item.image1" alt />
          </td>
          <td>
            {{item.name}}
            <textarea v-show="item.id==currentId" cols="20" rows="4" v-model="name"></textarea>
          </td>
          <td>
            {{item.intro}}
            <textarea v-show="item.id==currentId" cols="20" rows="4" v-model="intro"></textarea>
          </td>
          <td>
            {{item.price}}
            <input v-show="item.id==currentId" type="text" v-model="price" />
          </td>
          <td>
            {{item.typeName}}
            <select v-model="typeId" v-show="item.id==currentId">
              <option value="1">蛋糕</option>
              <option value="2">面包</option>
              <option value="3">冰淇凌</option>
              <option value="4">下午茶</option>
              <option value="5">设计师礼品</option>
            </select>
          </td>
          <td>
            <div v-if="item.isHot" @click="changeGoodsState(item.id,1)">移除热销</div>
            <div v-else style="background-color: green" @click="changeGoodsState(item.id,2)">加入热销</div>
            <div v-if="item.isNew" @click="changeGoodsState(item.id,3)">移除新品</div>
            <div v-else style="background-color: green" @click="changeGoodsState(item.id,4)">加入新品</div>
            <div style="background-color: #e63326" @click="deleteGoods(item.id)">删除</div>
            <div v-if="!isChange" style="background-color: #e6a726" @click="changeGoods(item.id)">修改</div>
            <div v-else style="background-color: #a6a123" @click="CompleteChange">完成</div>
          </td>
        </tr>
      </tbody>
    </table>
    <Pagination :total="total" :pageSize="eachPageSize" :pageNo="currentPage" :continues="5" class="pagination" @getPageNo="getPageNo" />
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, toRefs, nextTick } from 'vue'
import { useRouter } from 'vue-router'
import {
  reqAllGoods,
  reqAllRecommend,
  reqHotRecommend,
  reqDeleteGoodsManager,
  reqNewRecommend,
  reqRemoveHot,
  reqRemoveNew,
  reqToHot,
  reqToNew,
  reqChangeGoods
} from '../../../src/api/index.js'
export default defineComponent({
  setup() {
    const state = reactive({
      goodsList: [],
      currentIndex: 1,
      whichPage: 1, //发送给服务端请求的页码
      eachPageSize: 2,
      total: 0,
      currentPage: 1,
      currentTapId: 1,
      currentId: '',
      isChange: false
    })

    const router = useRouter()
    // 根据不同导航选项的切换内容
    function navClick(id) {
      const data = {
        whichPage: state.whichPage,
        eachPageSize: state.eachPageSize
      }
      let result = null
      // 请求所有商品数据
      if (id === 1) {
        reqAllGoods(data).then(res => {
          console.log(res)
          result = res.data.response
          state.goodsList = result.data
          state.total = result.databaseDataSize
          state.currentPage = result.currentPage
        })
      } else if (id === 2) {
        reqAllRecommend(data).then(res => {
          console.log(res)
          result = res.data.response
          state.goodsList = result.data
          state.total = result.databaseDataSize
          state.currentPage = result.currentPage
        })
      } else if (id === 3) {
        reqHotRecommend(data).then(res => {
          console.log(res)
          result = res.data.response
          state.goodsList = result.data
          state.total = result.databaseDataSize
          state.currentPage = result.currentPage
        })
      } else {
        reqNewRecommend(data).then(res => {
          console.log(res)
          result = res.data.response
          state.goodsList = result.data
          state.total = result.databaseDataSize
          state.currentPage = result.currentPage
        })
      }
    }
    navClick(1)

    // 分页器控制
    function getPageNo(num) {
      state.whichPage = num
      navClick(state.currentTapId)
    }
    // tap切换
    function tapClick(id) {
      if (state.currentTapId != id) {
        //重新初始化
        state.currentPage = 1
        state.whichPage = 1
      }
      state.currentTapId = id
      navClick(id)
    }
    // 删除商品
    function deleteGoods(id) {
      reqDeleteGoodsManager({ id }).then(res => {
        router.go(0) //刷新页面
      })
    }
    //切换商品的热销/新品状态  1-移除热销 2-加入热销  3-移除新品 4-加入新品
    function changeGoodsState(id, num) {
      switch (num) {
        case 1:
          reqRemoveHot({ id }).then(res => {
            console.log(res)
          })
          break
        case 2:
          reqToHot({ id }).then(res => {
            console.log(res)
          })
          break
        case 3:
          reqRemoveNew({ id }).then(res => {
            console.log(res)
          })
          break
        case 4:
          reqToNew({ id }).then(res => {
            console.log(res)
          })
          break
      }
      // router.go(0)
    }
    // 修改商品数据的参数
    const data = reactive({
      name: '',
      price: 0,
      image1: 5,
      image2: 1,
      intro: '',
      stock: 99,
      typeId: 1,
      isHot: false,
      isNew: false,
      id: 1
    })
    // 修改商品数据
    function changeGoods(id) {
      state.isChange = true
      state.goodsList.forEach(item => {
        if (item.id == id) {
          data.id = item.id
          data.name = item.name
          data.image1 = item.image1
          data.image2 = item.image2
          data.intro = item.intro
          data.name = item.name
          data.price = item.price
          data.isHot = item.isHot
          data.isNew = item.isNew
          switch (item.typeName) {
            case '蛋糕':
              data.typeId = 1
              break
            case '面包':
              data.typeId = 2
              break
            case '冰淇凌':
              data.typeId = 3
              break
            case '下午茶':
              data.typeId = 4
              break
            case '设计师礼品':
              data.typeId = 5
              break
          }
        }
      })
      state.currentId = id
    }
    // 完成修改
    function CompleteChange() {
      reqChangeGoods(data).then(res => {
        state.isChange = false
        state.currentId = ''
        nextTick(() => {
          router.go(0)
        })
      })
    }
    return {
      ...toRefs(state),
      ...toRefs(data),
      navClick,
      getPageNo,
      tapClick,
      deleteGoods,
      changeGoodsState,
      changeGoods,
      CompleteChange
    }
  }
})
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
  .pagination {
    margin-top: 20px;
  }
}
</style>
