<template>
  <div class="main">
    <ul>
      <li>
        <label for>用户名</label>
        <input type="text" />
      </li>
      <li>
        <label for>邮箱</label>
        <input type="text" />
      </li>
      <li>
        <label for>收件人</label>
        <input type="text" />
      </li>
      <li>
        <label for>用户名</label>
        <input type="text" />
      </li>
      <li>
        <label for>用户名</label>
        <input type="text" />
      </li>
      <li>
        <label for>用户名</label>
        <input type="text" />
      </li>
    </ul>
    <div class="save">提交保存</div>
  </div>
</template>

<script>
import { defineComponent } from 'vue'
export default defineComponent({
  setup() {
    return {}
  }
})
</script>

<style scoped lang="less">
.main {
  width: 100%;
  margin: 0 auto;
  color: @fontColor;
  cursor: pointer;
  ul {
    width: 400px;
    margin: 0 auto;
  }
  li {
    width: 400px;
    margin-bottom: 20px;
    display: flex;
    label {
      flex: 1;
      text-align: right;
      margin-right: 20px;
      font-weight: 600;
    }
    input {
      flex: 5;
      outline: none;
    }
  }
  .save {
    width: 200px;
    margin: 20px auto;
    text-align: center;
    height: 40px;
    line-height: 40px;
    border-radius: 20px;
    background-color: @fontColor;
    color: #fff;
  }
}
</style>
