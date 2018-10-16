<template>
  <footer>
    <div class="container">
      <!-- 需要用到的竖线使用全角竖线｜ -->
      <span class="footer-flot fir-desc-footer">
        <a href="http://www.miitbeian.gov.cn" target="_blank">粤ICP备17158733号-1</a>
      </span>
      <span class="footer-flot fir-footer-flot">｜</span>
      <span class="footer-flot sec-desc-footer">
        <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=44081102000040" target="_blank">粤公网安备44081102000040号</a>
      </span>
      <span class="footer-flot sec-footer-flot">｜</span>
      <p class="link-git">
        <span class="name">Copyright © 2018 乐诗</span>&nbsp;
        <span class="github">
          <a target="_blank" href="https://github.com/Krryxa"><Icon type="logo-github" /></a>
        </span>
      </p>
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
    position: relative;
    line-height: 26px;

    .footer-flot {
      position: relative;
      top: 50%;
      transform: translateY(-50%);
      display: inline-block;
    }
    .link-git {
      position: relative;
      top: 50%;
      transform: translateY(-50%);
      display: inline-block;

      .github {
        i {
          font-size: 18px;
          margin-top: -5px;
        }
      }
    }
  }
}
</style>
