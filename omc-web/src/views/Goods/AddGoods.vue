<template>
  <div class="add-goods">
    <h2>用于添加蛋糕界面</h2>
    <div class="main">
      <ul>
        <li>
          <label for="name">名称:</label><input type="text" id="name">
        </li>
        <li>
          <label for="price">价格:</label><input type="text" id="price">
        </li>
        <li>
          <label for="stock">库存:</label><input type="text" id="stock">
        </li>
        <li>
          <label for="img1">封面图片:</label><input type="file" id="img1">
        </li>
        <li>
          <label for="img1">详情图片1:</label><input type="file" id="img1">
        </li>
        <li>
          <label for="img2">详情图片2:</label><input type="file" id="img1">
        </li>
        <li>
          <label for="category">种类:</label>
          <select id="category">
            <option value="volvo">Volvo</option>
            <option value="saab">Saab</option>
            <option value="opel">Opel</option>
            <option value="audi">Audi</option>
          </select>
        </li>
        <li>
          <button class="submit">提交保存</button>
        </li>
      </ul>
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
.add-goods {
  text-align: center;
  .main {
    width: 800px;
    margin: 0 auto;
    border: 1px solid;
    li {
      width: 400px;
      margin: 30px auto;
      display: flex;
      label {
        flex: 2;
        text-align: left;
      }
      input,
      select {
        width: 200px;
      }
    }
  }
}
</style>
