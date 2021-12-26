<template>
  <div class="main">
    <ul>
      <li>
        <label for>用户名</label>
        <input type="text" v-model="username" />
      </li>
      <li>
        <label for>邮箱</label>
        <input type="text" v-model="email" />
      </li>
      <li>
        <label for>收件人</label>
        <input type="text" v-model="name" />
      </li>
      <li>
        <label for>电话</label>
        <input type="text" v-model="phone" />
      </li>
      <li>
        <label for>地址</label>
        <input type="text" v-model="address" />
      </li>
    </ul>
    <div class="save" @click="submit">提交保存</div>
  </div>
</template>

<script>
import { defineComponent, toRefs, reactive } from 'vue'
import { reqRegister } from '@/api/index.js'
import { useRouter } from 'vue-router'
export default defineComponent({
  setup() {
    const router = useRouter()
    const state = reactive({
      username: '',
      password: '123456',
      email: '',
      phone: '',
      address: '',
      name: ''
    })
    // 添加客户
    function submit() {
      Object.keys(state).forEach(item => {
        if (state[item] == '') return false
      })
      const data = {
        ...state,
        isAdmin: false,
        isValidate: true
      }
      reqRegister(data).then(res => {
        alert(res.data.response)
        router.back()
      })
    }
    return {
      ...toRefs(state),
      submit
    }
  }
})
</script>

<style scoped lang="less">
.main {
  width: 100%;
  margin: 0 auto;
  color: @fontColor;
  cursor: pointer;
  ul {
    width: 400px;
    margin: 0 auto;
  }
  li {
    width: 400px;
    margin-bottom: 20px;
    display: flex;
    label {
      flex: 1;
      text-align: right;
      margin-right: 20px;
      font-weight: 600;
    }
    input {
      flex: 5;
      outline: none;
    }
  }
  .save {
    width: 200px;
    margin: 20px auto;
    text-align: center;
    height: 40px;
    line-height: 40px;
    border-radius: 20px;
    background-color: @fontColor;
    color: #fff;
  }
}
</style>
