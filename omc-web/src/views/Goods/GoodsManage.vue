<template>
  <div class="goodsManager">
    <button class="add-good" @click="addGoods">添加商品</button>
    <router-view></router-view>
    <Pagination :total="50" :pageSize="4" :pageNo="1" :continues="5" v-show="route.path=='/back/goods/goodsshow'" />
  </div>
</template>

<script lang="ts">
import Pagination from "../../components/Pagination.vue";
import { defineComponent } from "vue";
import { useRoute, useRouter } from "vue-router";
export default defineComponent({
  components: {
    Pagination,
  },
  setup() {
    const router = useRouter();
    const route = useRoute();
    function addGoods() {
      router.push({ name: "addgoods" });
    }
    console.log(route);
    return {
      addGoods,
      route,
    };
  },
});
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
