<template>
  <div class="">
    <div class="add-cur">添加客户</div>
    <div class="main">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import { defineComponent } from 'vue'
export default defineComponent({
  setup() {
    return {}
  },
})
</script>

<style scoped lang="less">
.add-cur {
  position: fixed;
  right: 50px;
  top: 100px;
  height: 50px;
  width: 100px;
  line-height: 50px;
  background-color: @fontColor;
  color: #fff;
  text-align: center;
  cursor: pointer;
}
.add-cur:hover {
  color: @hoverColor;
}
.main {
  margin-top: 40px;
}
</style>
