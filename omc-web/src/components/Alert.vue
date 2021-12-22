<template>
  <div class="alert" v-show="isShow">
    <el-alert :title="title" :type="type" center effect="dark"></el-alert>
  </div>
</template>

<script>
import { reactive, toRefs } from 'vue'

export default {
  name: 'Alert',
  props: ['title', 'type'],
  setup(props) {
    const state = reactive({
      isShow: true
    })
    const type = props.type
    const title = props.title
    // 开启自动关闭功能
    setTimeout(() => {
      state.isShow = false
    }, 2000)
    return {
      ...toRefs(state),
      type,
      title
    }
  }
}
</script>

<style lang="less" scoped>
.alert {
  .el-alert {
    position: fixed;
    top: 0px;
    left: 0;
    z-index: 10000000000000000;
  }
}
</style>