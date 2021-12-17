<template>
  <div class="">
    <div class="header">
      <ul class="left">
        <li>首页</li>
        <li>商品分类</li>
        <li>热销</li>
        <li>新品</li>
        <li>注册</li>
        <li>登录</li>
      </ul>
      <div class="right">
        <div class="search">
          <input type="text" placeholder="search cake">
          <svg t="1639728476700" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3962" width="200" height="200">
            <path d="M1005.312 914.752l-198.528-198.464A448 448 0 1 0 0 448a448 448 0 0 0 716.288 358.784l198.4 198.4a64 64 0 1 0 90.624-90.432zM448 767.936A320 320 0 1 1 448 128a320 320 0 0 1 0 640z" fill="#bfbfbf" p-id="3963"></path>
          </svg>
        </div>
        <div class="shop-cart">
          <svg t="1639728896369" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5698" width="200" height="200">
            <path d="M767.06828 766.074649 383.346875 766.074649c-27.38572 0-51.461045-18.137079-59.015092-44.459584l-116.169813-404.748301L64.091714 316.866764l0-122.796744 190.325743 0c27.38572 0 51.461045 18.137079 59.015092 44.459584l24.02723 83.712587 520.570189 0c19.243273 0 37.372166 9.021467 48.976458 24.370037 11.604292 15.349593 15.341407 35.251875 10.095939 53.765531l-90.962711 321.035714C818.654168 747.837286 794.530748 766.074649 767.06828 766.074649zM429.602362 643.277906l291.046702 0 56.169277-198.23897-404.113851 0L429.602362 643.277906z" p-id="5699" fill="#684029"></path>
            <path d="M449.069739 894.490368m-62.930261 0a61.497 61.497 0 1 0 125.860523 0 61.497 61.497 0 1 0-125.860523 0Z" p-id="5700" fill="#684029"></path>
            <path d="M701.0681 894.490368m-62.930261 0a61.497 61.497 0 1 0 125.860523 0 61.497 61.497 0 1 0-125.860523 0Z" p-id="5701" fill="#684029"></path>
          </svg>
        </div>
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
.header {
  position: fixed;
  display: flex;
  width: 100%;
  height: 80px;
  line-height: 80px;
  text-align: center;
  background-color: #fff;
  box-shadow: 2px 0px 4px 0px #684029;
  .left {
    flex: 5;
    display: flex;
    li {
      flex: 1;
      color: @fontColor;
      cursor: pointer;
    }
  }
  .right {
    line-height: 100px;
    display: flex;
    flex: 4;
    .search {
      flex: 6;
      text-align: right;
      input {
        width: 250px;
        outline: none;
        height: 25px;
        border: none;
        border-bottom: 1px solid @fontColor;
      }
      svg {
        cursor: pointer;
        left: 0;
        text-align: left;
        height: 30px;
        width: 30px;
        vertical-align: middle;
      }
    }
    .shop-cart {
      flex: 2;
      text-align: left;
      margin-left: 30px;
      svg {
        text-align: left;
        height: 40px;
        width: 40px;
        cursor: pointer;
        vertical-align: middle;
      }
    }
  }
}
</style>
