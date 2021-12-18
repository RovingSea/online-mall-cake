<template>
  <div class="list-container">
    <div class="block">
      <el-carousel height="502px" arrow="never" :interval='2000'>
        <el-carousel-item v-for="item in bannerList" :key="item.id">
          <img :src="item.imgUrl" alt="">
        </el-carousel-item>
      </el-carousel>
    </div>
    <div class="main">
      <video autoplay muted loop preload poster="../../assets/images/video.jpg">
        <source src="../../assets/images/video.jpg" />
      </video>
      <p>ONLINE CAKE </p>
    </div>
  </div>
</template>

<script >
import { defineComponent, reactive, toRefs } from "vue";
import { reqBanners } from '@/api/index.js'
export default defineComponent({
  setup() {
    let HomeInfo = reactive({
      bannerList: [],
    })
    reqBanners().then(res => {
      HomeInfo.bannerList = res
    })
    return {
      ...toRefs(HomeInfo),
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
.main {
  margin-top: 20px;
  .box {
    width: 700px;
    height: 500px;
    position: relative;
  }
  video,
  p {
    width: 100%;
    height: 500px;
    position: absolute;
    top: 600px;
    left: 0;
    z-index: 10;
  }
  p {
    font-size: 50px;
    font-weight: 700;
    text-align: center;
    background: white;
    mix-blend-mode: screen;
  }
}
</style>
