<template>
  <div class="shop-cart">
    <!-- <div class="no-goods-show">
      <img src="../../assets/images/cartempty.png" alt="">
      <span>您的购物车里还没有商品</span>
      <router-link :to="{name:'new'}">去购物 > ></router-link>
    </div>
    <div>
    </div> -->
    <div class="header">
      <li class="goods-ti">商品</li>
      <li class="birthday-card-ti">生日牌</li>
      <li class="unit-Price" style="width:115px">单价</li>
      <li class="number-ti" style="width:150px">数量</li>
      <li class="money-ti" colspan="2" style="width:180px">金额</li>
    </div>

    <tbody>
      <tr id="12799" class="cart-object-item  ">
        <td class="goods-img">
          <a href="/product-12799.html" target="_blank">
            <img src="//oss.51cocoa.com/public/images/f9/6f/bd/2484de0a79055f6713bc5f71dbf6100c.jpg">
            <!-- <div class = "exchange-text">兑</div> -->
          </a>
        </td>
        <td class="goods-cake">
          <div>
            <p class="cart-tips">最早配送时间 2021-12-19 09:30~10:00</p>
            <h4 class="cart-title">
              <a href="/product-12799.html" target="_blank">四口味挂耳咖啡混合装（4包入）</a>
            </h4>
            <span class="goods-spec">规格：<span>40g(4包)</span></span>
          </div>
        </td>
        <td class="select-birthday-td">
        </td>
        <td class="cart-unit-Price">
          ¥40.00 </td>
        <td class="number-li">
          <div class="number quantity-update">
            <button>-</button>
            <input type="text" class="quantity _quantity" data-indent="12799" data-price="40.000" data-max="99" value="1">
            <button>+</button>
          </div>
        </td>
        <td class="money" id="total_amount_12799">
          ¥40.00 </td>
        <td class="delete">
          X
        </td>
      </tr>
      <!-- 普通商品结束 -->
    </tbody>

    <!-- 结算 -->
    <div class="cart-submit cart-area">
      <!-- <a href="#" class="cart-submit-empty user-behavior-tj-analysis" data-action="empty_cart"><i></i>全部清空</a> -->
      <ul class="cart-total-detail">
        <li>商品金额：¥ 48.00</li>
        <!--- <li>配送费：¥ 12.00</li> --->
        <li>活动优惠：¥ 0.00</li>
      </ul>
      <div class="cart-total"><span>合计：¥<span>48.00</span></span></div>
      <span class="cart-balance" id="cost-freight-tip"></span>
      <div class="cart-notice-ac"><span></span></div>
      <div class="cart-submit-button">
        <router-link :to="{name:'pay'}">去结算</router-link>
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
.shop-cart {
  width: 1200px;
  margin: 40px auto 0;
  .no-goods-show {
    height: 400px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    a {
      margin-top: 10px;
      color: @fontColor;
    }
    a:hover {
      color: @hoverColor;
    }
  }
  .header {
    background: #fafafa;
    font-size: 13px;
    width: 1200px;
    overflow: hidden;
    line-height: 44px;
    border: 1px solid #e1e1e1;
    li {
      float: left;
      height: 44px;
    }
    .goods-ti {
      margin-left: 166px;
      width: 285px;
    }
    .birthday-card-ti {
      width: 300px;
    }
  }
  // 购物车商品
  tbody {
    width: 1200px;
  }
  .cart-object-item {
    width: 1200px !important;
    position: relative;
    img {
      height: 80px;
      width: 80px;
      border: 1px solid #efefef;
    }
    .goods-cake {
      height: 134px;
      padding-left: 20px;
      p {
        background-image: linear-gradient(180deg, #ceab78 50%, #c69c6d 100%);
        margin-bottom: 0;
        display: inline-block;
        color: #fff;
        padding: 0 6px;
        font-size: 12px;
        line-height: 18px;
        margin-bottom: 2px;
      }
    }
    a:visited,
    a:link,
    a {
      color: #684029;
      text-decoration: none;
      outline: none;
      cursor: pointer;
      -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
      -webkit-tap-highlight-color: transparent;
    }
  }
  .goods-spec {
    font-size: 13px;
    color: #d5bfa7;
    display: block;
  }
  .cart-unit-Price {
    padding-left: 409px;
    font-size: 13px;
  }
  .number-li {
    div {
      margin-left: 54px;
      display: flex;
      button {
        height: 22px;
        width: 22px;
        font-size: 20px;
      }
      input {
        height: 22px;
        width: 48px;
        border: solid #e7e7e7;
        border-width: 1px 0;
        padding-left: 20px;
        box-sizing: border-box;
      }
    }
  }
  .money {
    display: block;
    width: 70px;
    text-align: center;
    line-height: 134px;
    height: 134px;
    color: red;
    margin-left: 63px;
  }
  .delete {
    position: absolute;
    right: -77px;
    top: 55px;
    color: #ccc;
  }

  // 结算
  .cart-submit {
    position: relative;
    width: 1078px;
    height: 180px;
    background: #fbfbfb;
    border: 1px solid #e1e1e1;
    padding: 26px 60px 32px 60px;
    margin: 20px 0;
    li {
      font-size: 13px;
      text-align: right;
      line-height: 18px;
      margin-bottom: 10px;
    }
    .cart-total {
      text-align: right;
    }
    .cart-total > span {
      display: inline-block;
      width: 232px;
      border-top: 2px solid #e2e2e2;
      line-height: 42px;
      font-size: 13px;
    }
  }
  .cart-submit-button a {
    float: right;
    background: #684029;
    width: 232px;
    height: 40px;
    display: inline-block;
    color: #fff;
    line-height: 40px;
    text-align: center;
    font-size: 14px;
    margin-top: 14px;
  }
  .cart-total span {
    color: red;
  }
  .cart-submit-button a::after {
    display: block;
    clear: both;
  }
}
</style>
