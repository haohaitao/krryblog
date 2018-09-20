<template>
  <footer>
    <div class="container">
      <!-- 需要用到的竖线使用全角竖线｜ -->
      <span class="name">Copyright © 2018 乐诗</span>&nbsp;
      <span class="github">
        <a target="_blank" href="https://github.com/Krryxa"><Icon type="logo-github" /></a>
      </span>
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
  margin-top: 36px;
  height: 120px;
  background: rgba(255, 255, 255, 0.5);

  .container {
    width: 1080px;
    max-width: 100%;
    margin: 0 auto;
    height: 100%;
    text-align: center;
    font-size: 14px;

    .name {
      line-height: 120px;
    }

    .github {
      i {
        font-size: 18px;
        margin-top: -5px;
      }
    }
  }
}
</style>
