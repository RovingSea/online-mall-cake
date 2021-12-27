<template>
  <el-container>
    <!-- 导航栏 -->
    <el-header>
      <Header />
    </el-header>
    <!-- 主要内容 -->
    <el-main>
      <router-view></router-view>
    </el-main>
  </el-container>
</template>

<script >
import Header from './Header.vue'
import { defineComponent } from 'vue'
export default defineComponent({
  components: {
    Header
  },
  setup() {
    return {}
  }
})
</script>

<style scoped lang="less">
.el-header {
  padding-left: 0;
}
.el-main {
  margin: 90px auto 0;
  width: 1200px;
}
</style>
