<template>
  <div class="category">
    <div class="search">
      <input type="text"><button>添加类目</button>
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
.category {
  margin-top: 20px;

  .search {
    display: flex;
    width: 700px;
    margin-left: 100px;
    input {
      flex: 5;
      margin-right: 10px;
    }
    button {
      flex: 1;
    }
  }
}
</style>
