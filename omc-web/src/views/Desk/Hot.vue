<template>
  <div class="hot">
    <div class="cake">
      <img src="../../assets/images/cakehot.png" alt="">
      <span class="title">深爱</span>
      <span class="desc">玫瑰蜜饯,口感丰富</span>
      <div class="footer">
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
  .cake {
    width: 300px;
    box-sizing: border-box;
    display: flex;
    flex-direction: column;
    align-items: left;
    .title {
      font-size: 18x;
      color: @fontColor;
    }
    .desc {
      color: rgb(184, 171, 171);
    }
    .footer {
      margin-top: 15px;
      display: flex;
      width: 100%;
      justify-content: space-between;
      color: @hoverColor;
      div {
        width: 100px;
        background-color: @fontColor;
        color: #fff;
        font-size: 15px;
        text-align: center;
      }
    }
  }
}
</style>
