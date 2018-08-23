<template>
  <div>
    <Header></Header>
    <Content></Content>
    <Footer></Footer>
  </div>
</template>

<script>
import Header from '@/components/Header';
import Footer from '@/components/Footer';
import Content from './Content';
export default {
  data () {
    return {
    };
  },
  components: {
    Header, Footer, Content,
  },
};
</script>

<style lang='scss' scoped>

</style>
