<template>
  <div class="Header">
    <div class="title flex-item">
      <img src="../../assets/logo.png" alt />
      蛋糕店后台
    </div>
    <router-link :to="{ name: 'order' }">订单管理</router-link>
    <router-link :to="{ name: 'customer' }">客户管理</router-link>
    <router-link :to="{ name: 'goods' }">商品管理</router-link>
    <router-link :to="{ name: 'category' }">类目管理</router-link>
    <router-link :to="{ name: 'desk' }">退出</router-link>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
export default defineComponent({
  setup() {
    return {}
  }
})
</script>

<style scoped lang="less">
.Header {
  min-width: 1280px;
  position: fixed;
  z-index: 1000;
  background-color: #fff;
  width: 100%;
  display: flex;
  height: 80px;
  color: @fontColor !important;
  line-height: 80px;
  padding-left: 20px;
  box-shadow: 0px 0 3px 0 @fontColor;
  img {
    width: 40px;
    vertical-align: middle;
  }
  .title {
    flex: 2;
    font-size: 30px;
    font-weight: 600;
    cursor: pointer;
  }
  a {
    flex: 1;
    display: block;
    text-align: center;
    color: @fontColor !important;
  }
  a:hover {
    color: @hoverColor !important;
    cursor: pointer;
  }
  .router-link-active {
    border-left: @hoverColor 3px solid;
    border-right: @hoverColor 3px solid;
    font-size: 17px;
  }
}
</style>
