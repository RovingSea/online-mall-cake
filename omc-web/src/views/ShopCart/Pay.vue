<template>
  <div class="pay">
    <h2>确认收货信息</h2>
    <ul class="detail">
      <li>
        <label for="">收货人</label><input type="text">
      </li>
      <li>
        <label for="">收货电话</label><input type="text">
      </li>
      <li>
        <label for="">收获地址</label><input type="text">
      </li>
    </ul>
    <div class="pay-way">
      <h2>选择支付方式</h2>
      <span class="price">支付金额:28</span>
      <div>
        <img src="../../assets/images/vx.jpg" alt="">
        <img src="../../assets/images/zfb.jpg" alt="">
      </div>
      <div class="button">确认订单</div>
    </div>
  </div>
</template>

<script >
import { defineComponent } from "vue";
export default defineComponent({
  setup() {
    return {};
  },
});
</script>

<style scoped lang="less">
.pay {
  width: 1200px;
  margin: 20px auto;
  text-align: center;
  .detail {
    width: 500px;
    margin: 0 auto;
    display: flex;
    flex-direction: column;
    li {
      width: 500px;
      display: flex;
      margin-top: 20px;
      label {
        flex: 1;
        text-align: center;
        color: @fontColor;
        font-size: 20px;
        font-weight: 600;
        margin-right: 20px;
      }
      input {
        outline: none;
        width: 300px;
      }
    }
  }
  .pay-way {
    div {
      margin-top: 40px;
      display: flex;
      justify-content: center;
      img {
        width: 400px;
      }
    }
  }
  .button {
    margin: 10px auto;
    height: 40px;
    line-height: 40px;
    width: 140px;
    background-color: @fontColor;
    color: #fff;
    cursor: pointer;
  }
}
</style>
