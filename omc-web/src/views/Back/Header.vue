<template>
  <div class="Header">
    <div class="title flex-item">蛋糕店后台</div>
    <li>订单管理</li>
    <li>客户管理</li>
    <li>商品管理</li>
    <li>类目管理</li>
    <li>退出</li>
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
  height: 50px;
  line-height: 50px;
  padding-left: 20px;
  background-image: linear-gradient(to right, #f0e3af, #f0ead7);
  li {
    flex: 1;
  }
  .title {
    flex: 2;
    font-size: 30px;
    font-weight: 600;
  }
}
</style>
