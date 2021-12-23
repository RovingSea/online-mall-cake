<template>
  <div class="profile">
    <div class="header">
      <img src="../../assets/images/avatar.jpg" alt />
      <span class="name">UserName</span>
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

<style lang="less" scoped>
.profile {
  width: 1200px;
  margin: 20px auto;
  .header {
    display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
    img {
      width: 150px;
      border-radius: 50%;
    }
    .name {
      margin-top: 10px;
      font-weight: 600;
      font-size: 20;
    }
  }
}
</style>