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
        <div class="manager">
          <router-link :to="{name:'back'}">
            <svg t="1639729868714" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="7343" width="200" height="200">
              <path d="M146.162688 662.038528l183.54688-87.602176a56.889344 56.889344 0 0 1 24.50432-5.547008h315.573248c8.47872 0 16.850944 1.8944 24.50432 5.547008l183.545856 87.602176a56.889344 56.889344 0 0 1 32.385024 51.341312v196.842496c0 31.418368-25.469952 56.88832-56.889344 56.88832H170.667008c-31.419392 0-56.889344-25.469952-56.889344-56.88832v-196.84352a56.889344 56.889344 0 0 1 32.385024-51.340288zM568.889344 768c0 15.709184 12.734464 28.444672 28.443648 28.444672h113.777664c15.710208 0 28.444672-12.735488 28.444672-28.444672s-12.734464-28.444672-28.444672-28.444672h-113.77664c-15.710208 0-28.444672 12.735488-28.444672 28.444672zM512 512c-125.67552 0-227.555328-101.879808-227.555328-227.555328S386.32448 56.889344 512 56.889344s227.555328 101.879808 227.555328 227.555328S637.67552 512 512 512z" fill="#684029" p-id="7344"></path>
            </svg>后台管理
            <span>Vujson + Master</span>
          </router-link>
        </div>
      </div>
    </div>
    <div class="main">
      <router-view></router-view>
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
  z-index: 1000;
  display: flex;
  width: 100%;
  height: 80px;
  line-height: 80px;
  text-align: center;
  background-color: #fff;
  margin-bottom: 80px;
  color: @fontColor !important;
  box-shadow: 2px 0px 4px 0px #684029;
  .left {
    flex: 5;
    display: flex;
    li {
      flex: 1;
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
    .manager {
      a {
        display: block;
        cursor: pointer;
        height: 40px;
        width: 150px;
        line-height: 40px;
        font-size: 18px;
        font-weight: 600;
        color: @fontColor;
        svg {
          width: 30px;
          height: 30px;
          vertical-align: middle;
          margin-right: 10px;
        }
      }
    }
    .manager:hover {
      color: @hoverColor;
    }
  }
}
.main {
  padding-top: 80px;
}
</style>
