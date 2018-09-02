<template>
  <main>
    <Header></Header>
    <section>
      <p class="number">404</p>
      <p>很抱歉，找不到页面~~</p>
      <router-link to="/">
        <Button type="error">返回首页</Button>
      </router-link>
    </section>
    <Footer></Footer>
  </main>
</template>

<script>
import Header from '@/components/Header';
import Footer from '@/components/Footer';
export default {
  data () {
    return {
    };
  },
  components: {
    Header, Footer,
  },
};
</script>

<style lang='scss' scoped>
section {
  animation: fadeIn .6s linear;
  padding: 170px;
  text-align: center;

  .number {
    color: #252932;
    font-size: 98px;
    font-weight: 700;
    line-height: 150px;
    text-shadow: rgba(61,61,61,0.3) 1px 1px, rgba(61,61,61,0.2) 2px 2px, rgba(61,61,61,0.3) 3px 3px;
  }
  p {
    font-size: 30px;
  }

  button {
    margin-top: 32px;
    font-size: 14px;
  }
}
</style>
