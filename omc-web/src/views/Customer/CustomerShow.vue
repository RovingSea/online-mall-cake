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
          <td>
            <textarea v-if="item.id==changeId" v-model="email" cols="30" rows="2"></textarea>
            <span v-else>{{item.email}}</span>
          </td>
          <td>
            <textarea v-if="item.id==changeId" v-model="name" cols="15" rows="2"></textarea>
            <span v-else>{{item.name}}</span>
          </td>
          <td>
            <textarea v-if="item.id==changeId" v-model="phone" cols="15" rows="2"></textarea>
            <span v-else>{{item.phone}}</span>
          </td>
          <td>
            <textarea v-if="item.id==changeId" v-model="address" cols="30" rows="2"></textarea>
            <span v-else>{{item.address}}</span>
          </td>
          <td>
            <button @click="deleteUser(item.id)">删除</button>
            <button @click="changeUser(item.id)" v-if="(changeId!=item.id)|| !isChange">修改</button>
            <button @click="completeChange(item.id)" v-show="isChange&&changeId==item.id" style="backgroundColor:#0ca070">完成</button>
          </td>
        </tr>
      </tbody>
    </table>
    <Pagination :total="total" :pageSize="eachPageSize" :pageNo="whichPage" :continues="3" @getPageNo="getPageNo" />
  </div>
</template>

<script>
import { defineComponent, reactive, nextTick, toRefs } from 'vue'
import { reqAllUser, reqDeleteUser, reqUpdateUser } from '@/api/index.js'
export default defineComponent({
  setup() {
    const state = reactive({
      userList: [],
      whichPage: 1,
      eachPageSize: 4,
      total: 0,
      changeId: '',
      isChange: false
    })
    function getUserInfo() {
      const data = {
        whichPage: state.whichPage,
        eachPageSize: state.eachPageSize
      }
      reqAllUser(data).then(res => {
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
    // 删除用户
    function deleteUser(id) {
      console.log(id)
      reqDeleteUser({ id }).then(res => {
        console.log(res)
        getUserInfo()
      })
    }
    const data = reactive({
      address: '',
      email: '',
      id: 1,
      isAdmin: true,
      isValidate: true,
      name: '',
      password: '',
      phone: '',
      username: ''
    })
    // 跟新某个用户
    function changeUser(id) {
      state.isChange = true
      state.userList.forEach(item => {
        if (item.id == id) {
          for (let k in item) {
            data[k] = item[k]
          }
        }
      })
      state.changeId = id
    }
    // 完成修改
    function completeChange(id) {
      state.isChange = false
      state.changeId = ''
      reqUpdateUser(data).then(res => {
        console.log(res)
      })
    }
    return {
      ...toRefs(state),
      ...toRefs(data),
      getPageNo,
      deleteUser,
      changeUser,
      completeChange
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
  textarea {
    margin-top: 4px;
  }
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
        button {
          margin-left: 5px;
          width: 40px;
          background-color: rgb(155, 155, 7);
          color: white;
        }
        button:nth-child(1) {
          background-color: red;
        }
      }
    }
  }
}
</style>
