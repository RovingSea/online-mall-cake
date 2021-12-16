<template>
  <div class="Header">
    <div class="title">蛋糕店后台</div>
    <ul>
      <li>订单管理</li>
      <li>客户管理</li>
      <li>商品管理</li>
      <li>类目管理</li>
      <li>退出</li>
    </ul>
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
.Header {
  display: flex;
  ul {
    display: flex;
  }
}
</style>
