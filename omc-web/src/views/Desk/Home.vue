<template>
  <div class="list-container">
    <div class="block">
      <el-carousel height="502px">
        <el-carousel-item v-for="item in bannerList" :key="item">
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
    return {
      ...toRefs(HomeInfo)
    };
  },
});
</script>

<style scoped lang="less">
@font-face {
  font-family: "webfont";
  src: url("//at.alicdn.com/t/webfont_9fm5seiutdt.eot?#iefix")
      format("embedded-opentype"),
    url("//at.alicdn.com/t/webfont_9fm5seiutdt.svg#杨任东竹石体-Bold")
      format("svg");
}

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
    height: 100px;
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
