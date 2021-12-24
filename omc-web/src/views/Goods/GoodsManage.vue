<template>
  <div class="goodsManager">
    <button class="add-good" @click="addGoods">添加商品</button>
    <router-view></router-view>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import { useRoute, useRouter } from 'vue-router'
export default defineComponent({
  setup() {
    const router = useRouter()
    const route = useRoute()
    function addGoods() {
      router.push({ name: 'addgoods' })
    }
    return {
      addGoods,
      route
    }
  }
})
</script>

<style scoped lang="less">
.add-good {
  position: fixed;
  top: 100px;
  right: 50px;
  margin: 0 40px 0 0;
  width: 120px;
  height: 40px;
  background-color: #fff;
  border: 2px solid @fontColor;
  font-size: 14px;
  cursor: pointer;
  overflow: hidden;
}
.add-good:hover {
  background-color: @hoverColor;
}

.add-good::after {
  display: block;
  clear: both;
}
</style>
