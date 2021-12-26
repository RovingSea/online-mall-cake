<template>
  <div class="add-goods">
    <h2>填入待添加蛋糕的参数</h2>
    <div class="main">
      <ul>
        <li>
          <label for="name">名称:</label>
          <input v-model="name" type="text" id="name" />
        </li>
        <li>
          <label for="price">价格:</label>
          <input v-model="price" type="text" id="price" />
        </li>
        <li>
          <label for="stock">库存:</label>
          <input v-model="stock" type="text" id="stock" />
        </li>
        <li>
          <label for="intro">介绍:</label>
          <input v-model="intro" type="text" id="intro" />
        </li>
        <li>
          <label for="img1">封面图片:</label>
          <input type="file" id="img1" :ref="img1" />
        </li>
        <li>
          <label for="category">种类:</label>
          <select id="category" v-model="categoryId">
            <option :value="item.id" v-for="item in categoryList" :key="item.id">{{item.name}}</option>
          </select>
        </li>
        <li>
          <button class="submit" @click="submit">提交保存</button>
        </li>
      </ul>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, toRefs, reactive } from 'vue'
import { reqGoodsCategory, reqAddGoods } from '../../api/index'
import { useRouter } from 'vue-router'
export default defineComponent({
  setup() {
    const state = reactive({
      name: '',
      price: 0,
      stock: 0,
      img1: '',
      intro: '',
      categoryId: 1,
      categoryList: []
    })
    const router = useRouter()
    reqGoodsCategory().then(res => {
      console.log(res)
      state.categoryList = res.data.response
    })
    // 添加图片数据

    function submit() {
      const data = {
        name: state.name,
        image1: 'https://oss.51cocoa.com//goods/14593363138999.jpg',
        image2: 'https://oss.51cocoa.com//goods/14593363138999.jpg',
        price: state.price * 1,
        intro: state.intro,
        stock: 99,
        typeId: 1
      }
      const { name, price, stock } = state
      if (name == '' || price == null || stock == null) {
        return alert('必填内容不能为空')
      }
      reqAddGoods(data).then(res => {
        alert(res.data.msg)
        router.back()
      })
    }
    return {
      ...toRefs(state),
      submit
    }
  },
  methods: {}
})
</script>

<style scoped lang="less">
.add-goods {
  text-align: center;
  color: @fontColor;
  h2 {
    margin: 20px;
    color: @fontColor;
  }
  .main {
    width: 800px;
    margin: 0 auto;
    border: 1px solid;
    li {
      width: 400px;
      margin: 30px auto;
      display: flex;
      label {
        flex: 2;
        text-align: left;
      }
      input,
      select {
        width: 200px;
      }
    }
    .submit {
      width: 180px;
      height: 40px;
      margin: 0 auto;
      background-color: @fontColor;
      color: #fff;
      border-radius: 20px;
      cursor: pointer;
    }
    .submit:hover {
      color: @hoverColor;
    }
  }
}
</style>
