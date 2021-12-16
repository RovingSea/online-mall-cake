<template>
  <div class="Header">
    <div class="title flex-item">蛋糕店后台</div>
    <router-link :to="{name:'order'}">订单管理</router-link>
    <router-link :to="{name:'customer'}">客户管理</router-link>
    <router-link :to="{name:'goods'}">商品管理</router-link>
    <router-link :to="{name:'category'}">类目管理</router-link>
    <a>退出</a>
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
@fontColor: #684029;
@hoverColor: #bb9772;
.Header {
  position: relative;
  display: flex;
  height: 80px;
  color: @fontColor;
  line-height: 80px;
  padding-left: 20px;
  z-index: 20;
  // box-shadow: 0 12px 2px 0 rgb(195 195 195 / 50%);
  border-bottom: @fontColor 2px solid;
  a {
    flex: 1;
    display: block;
    text-align: center;
  }
  a:hover {
    color: @hoverColor;
    cursor: pointer;
  }
  .title {
    flex: 2;
    font-size: 30px;
    font-weight: 600;
    cursor: pointer;
  }
}
</style>
