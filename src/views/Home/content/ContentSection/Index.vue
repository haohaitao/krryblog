<template>
  <section class="left">
    <article v-for="(val, index) in blogList" :key="index">
      {{val.title}} <br>
      {{val.description}}
    </article>
  </section>
</template>

<script>
export default {
  data () {
    return {
      blogList: [
        {
          title: '博客1',
          description: '这是一段博客描述1',
        },
        {
          title: '博客2',
          description: '这是一段博客描述2',
        },
        {
          title: '博客3',
          description: '这是一段博客描述3',
        },
      ],
    };
  },
  components: {
  },
};
</script>

<style lang='scss' scoped>
section {
  width: 720px;

  article {
    width: 700px;
    height: 300px;
    border-radius: 4px;
    box-shadow: black 0px 0px 4px;
    background: rgba(255, 255, 255, 0.5);
    padding: 20px;
    box-sizing: border-box;
    transition: all .3s ease-in-out;

    &:not(:first-child) {
      margin-top: 36px;
    }

    &:hover {
      box-shadow: black 0px 0px 10px;
      background: #fff;
    }
  }
}
</style>
