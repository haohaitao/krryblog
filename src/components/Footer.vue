<template>
  <footer>
    <div class="container">
      <span class="name">© 2018 乐诗</span>
      <BackTop :height="600" :bottom="60"></BackTop>
    </div>
  </footer>
</template>

<script>
export default {
  data () {
    return {
    };
  },
  components: {
  },
};
</script>

<style lang='scss' scoped>
footer {
  height: 120px;
  background: rgba(255, 255, 255, 0.5);

  .container {
    width: 1080px;
    max-width: 100%;
    margin: 0 auto;
    height: 100%;
    text-align: center;

    .name {
      line-height: 120px;
    }
  }
}
</style>
