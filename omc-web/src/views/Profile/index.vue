<template>
  <div class="profile">
    <div class="header">
      <img src="../../assets/images/avatar.jpg" alt />
      <span class="name">{{userInfo.name}}</span>
      <span class="address">{{userInfo.address}}</span>
    </div>
    <div class="main"></div>
  </div>
</template>

<script>
import { reqProfileInfo } from '@/api/index.js'
import { reactive, onMounted } from 'vue'
export default {
  setup() {
    const state = reactive({
      userInfo: {}
    })
    onMounted(() => {
      reqProfileInfo().then(res => {
        console.log(res)
        state.userInfo = res.data.response
      })
    })
    return state
  }
}
</script>

<style lang="less" scoped>
.profile {
  width: 1200px;
  margin: 20px auto;
  .header {
    display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
    img {
      width: 150px;
      border-radius: 50%;
    }
    .name {
      margin-top: 10px;
      font-weight: 600;
      font-size: 20;
    }
    .address {
      margin-top: 20px;
    }
  }
}
</style>