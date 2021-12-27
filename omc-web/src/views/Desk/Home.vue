<template>
  <div class="list-container">
    <Carousel />
    <div class="main">
      <!-- <video autoplay muted loop preload poster="../../assets/images/vido.mp4">
        <source src="../../assets/images/video.jpg" />
      </video>-->
      <p>ONLINE CAKE</p>
    </div>
    <div class="footer">
      <h2>长沙学院大三JavaWeb课程设计</h2>

      <img src="../../assets/images/shcool.png" alt />
      <ul>
        <li>后端: Masker github 地址: https://github.com/1262917629</li>
        <li>前端: VuJson github 地址: https://github.com/1024shao</li>
      </ul>
    </div>
  </div>
</template>

<script >
import { defineComponent, reactive, toRefs } from 'vue'
import Carousel from '../../components/Carousel.vue'
export default defineComponent({
  components: {
    Carousel
  },
  setup() {
    let HomeInfo = reactive({
      bannerList: []
    })
    return {
      ...toRefs(HomeInfo)
    }
  }
})
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
  p {
    width: 100%;
    height: 271px;
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
.footer {
  position: relative;
  bottom: 0;
  height: 250px;
  background-position: 100%;
  color: #000;
  h2 {
    margin-top: 20px;
    text-align: center;
  }
  img {
    position: absolute;
    left: 0;
    top: 0;
    height: 100px;
    border-radius: 50px;
  }
  ul {
    position: absolute;
    bottom: 0;
    right: 0;
    li {
      padding: 20px;
      margin-right: 40px;
      font-weight: 600;
    }
  }
}
</style>
