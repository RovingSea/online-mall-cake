<template>
  <div class>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>用户名</th>
          <th>邮箱</th>
          <th>收件人</th>
          <th>电话</th>
          <th>地址</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in userList" :key="item.id">
          <td>{{item.id}}</td>
          <td>{{item.username}}</td>
          <td>{{item.email}}</td>
          <td>{{item.name}}</td>
          <td>{{item.phone}}</td>
          <td>{{item.address}}</td>
          <td>操作</td>
        </tr>
      </tbody>
    </table>
    <Pagination :total="total" :pageSize="eachPageSize" :pageNo="whichPage" :continues="3" @getPageNo="getPageNo" />
  </div>
</template>

<script>
import { defineComponent, reactive, toRefs } from 'vue'
import { reqDeleteUSesr, reqAllUser, reqChangeUserInfo } from '@/api/index.js'
export default defineComponent({
  setup() {
    const state = reactive({
      userList: [],
      whichPage: 1,
      eachPageSize: 4,
      total: 0
    })
    function getUserInfo() {
      const data = {
        whichPage: state.whichPage,
        eachPageSize: state.eachPageSize
      }
      reqAllUser(data).then(res => {
        console.log(res)
        state.userList = res.data.response.data
        state.total = res.data.response.databaseDataSize
      })
    }
    getUserInfo()
    // 分页器进行切换
    function getPageNo(num) {
      state.whichPage = num
      getUserInfo()
    }
    return {
      ...toRefs(state),
      getPageNo
    }
  }
})
</script>

<style scoped lang="less">
table {
  width: 1200px;
  border: 3px solid rgb(133, 119, 75);
  border-collapse: collapse;
  color: @fontColor;
  margin-bottom: 20px;
  thead {
    height: 50px;
    line-height: 50px;
    border-bottom: 2px solid rgb(133, 119, 75);
  }
  tbody {
    tr {
      border: 1px solid rgb(133, 119, 75);
      height: 50px;
      line-height: 50px;
      text-align: center;
      td {
        border-right: 1px solid rgb(133, 119, 75);
      }
    }
  }
}
</style>
