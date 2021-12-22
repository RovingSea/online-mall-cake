<template>
  <div class="cake" v-for="item in goodList" :key="item.id">
    <router-link :to="{name:'detail',params:{id:item.id}}">
      <img :src="item.image1" alt />
      <span class="title">{{item.name}}</span>
      <span class="desc">{{item.intro}}</span>
    </router-link>
    <div class="footer">
      <span>￥{{item.price}}</span>
      <div class="add-cart">加入购物车</div>
    </div>
  </div>
</template>

<script>
export default {
  setup() {
    return {}
  }
}
</script>

<style lang="scss" scoped>
</style>