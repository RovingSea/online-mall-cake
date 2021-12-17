<template>
  <div class="add-goods">
    <h2>填入待添加蛋糕的参数</h2>
    <div class="main">
      <ul>
        <li>
          <label for="name">名称:</label
          ><input v-model="name" type="text" id="name" />
        </li>
        <li>
          <label for="price">价格:</label
          ><input v-model="price" type="text" id="price" />
        </li>
        <li>
          <label for="stock">库存:</label
          ><input v-model="stock" type="text" id="stock" />
        </li>
        <li>
          <label for="img1">封面图片:</label
          ><input type="file" id="img1" :ref="images[0]" />
        </li>
        <li>
          <label for="img1">详情图片1:</label
          ><input type="file" id="img1" :ref="images[1]" />
        </li>
        <li>
          <label for="img2">详情图片2:</label
          ><input type="file" id="img1" :ref="images[2]" />
        </li>
        <li>
          <label for="category">种类:</label>
          <select id="category" v-model="category">
            <option value="volvo">Volvo</option>
            <option value="saab">Saab</option>
            <option value="opel">Opel</option>
            <option value="audi">Audi</option>
          </select>
        </li>
        <li>
          <button class="submit">提交保存</button>
        </li>
      </ul>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, toRefs, reactive, ref, watchEffect } from 'vue'
export default defineComponent({
  setup() {
    const addObj = reactive({
      name: '',
      price: 0,
      stock: 0,
      category: 'volvo',
    })

    let images = [ref(null), ref(null), ref(null)]

    return {
      ...toRefs(addObj),
      images,
    }
  },
  mounted() {
    this.getBase64()
  },
  methods: {
    getBase64() {
      document.querySelector('#img1').addEventListener('change', (e) => {
        let file = e.target.files[0]
        let fileUrl = window.URL.createObjectURL(file)
        this.imgBase1 = fileUrl
      })
      document.querySelector('#img2').addEventListener('change', (e) => {
        let file = e.target.files[0]
        let fileUrl = window.URL.createObjectURL(file)
        this.imgBase1 = fileUrl
      })
      document.querySelector('#img3').addEventListener('change', (e) => {
        let file = e.target.files[0]
        let fileUrl = window.URL.createObjectURL(file)
        this.imgBase1 = fileUrl
      })
    },
  },
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
