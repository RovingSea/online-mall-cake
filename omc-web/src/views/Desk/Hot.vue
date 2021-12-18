<template>
  <div class="hot">
    <div class="cake">
      <img src="../../assets/images/cakehot.png" alt="">
      <span class="title">深爱</span>
      <span class="desc">玫瑰蜜饯,口感丰富</span>
      <div>
        <span> ￥389.00(1.0/磅)</span>
        <div class="add-cart">加入购物车</div>
      </div>
    </div>
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
.hot {
  width: 1200px;
  margin: 20px auto 0;
}
</style>
