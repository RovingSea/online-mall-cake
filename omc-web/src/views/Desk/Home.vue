<template>
  <div class="list-container">
    <div class="block">
      <el-carousel height="502px">
        <el-carousel-item v-for="item in bannerList" :key="item">
          <img :src="item.imgUrl" alt="">
        </el-carousel-item>
      </el-carousel>
    </div>
  </div>
</template>

<script >
import { defineComponent, onMounted, reactive, toRefs } from "vue";
export default defineComponent({
  setup() {
    let HomeInfo = reactive({
      bannerList: [{
        "id": "1",
        "imgUrl": "../../../public/images/banner1.jpg"
      },
      {
        "id": "2",
        "imgUrl": "../../../public/images/banner2.jpg"
      },
      {
        "id": "3",
        "imgUrl": "../../../public/images/banner3.jpg"
      },
      {
        "id": "4",
        "imgUrl": "../../../public/images/banner4.jpg"
      }
      ]
    })
    onMounted(() => {
      const { bannerList } = HomeInfo
    })
    return {
      ...toRefs(HomeInfo)
    };
  },
});
</script>

<style scoped lang="less">
.list-container block {
  height: 502px;
}
.el-carousel__item img {
  color: #475669;
  width: 100%;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>
