<template>
  <el-container>
    <!-- 导航栏 -->
    <el-header>
      <Header />
    </el-header>
    <!-- 主要内容 -->
    <el-main>
      Main
      <router-view></router-view>
    </el-main>
  </el-container>
</template>

<script >
import Header from './Header.vue'
import { defineComponent } from "vue";
export default defineComponent({
  components: {
    Header
  },
  setup() {
    return {};
  },
});
</script>

<style scoped lang="less">
</style>
