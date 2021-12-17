<template>
  <div class="">
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
        <tr>
          <td>ID</td>
          <td>用户名</td>
          <td>邮箱</td>
          <td>收件人</td>
          <td>电话</td>
          <td>地址</td>
          <td>操作</td>
        </tr>
      </tbody>
    </table>
    <Pagination :total="50" :pageSize="4" :pageNo="1" :continues="5" />
  </div>
</template>

<script>
import { defineComponent } from 'vue'
export default defineComponent({
  setup() {
    return {}
  },
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
