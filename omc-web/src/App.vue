<template>
  <div>
    <router-view></router-view>
  </div>
</template>

<script >
import Back from "./views/Back/index.vue";
import { defineComponent } from "vue";
export default defineComponent({
  components: {
    Back,
  },
});
</script>

<style scoped lang="less">
</style>
