<template>
  <main v-if="!isNotCategory">
    <Header></Header>
    <Content></Content>
    <Footer></Footer>
  </main>
  <NotFound v-else></NotFound>
</template>

<script>
import Header from '@/components/Header';
import Footer from '@/components/Footer';
import NotFound from '@/components/NotFound';
import Content from './Content';
export default {
  data () {
    return {
      status: 200,
    };
  },
  computed: {
    isNotCategory () {
      return this.status === 404;
    },
  },
  components: {
    Header, Footer, NotFound, Content,
  },
};
</script>

<style lang='scss' scoped>

</style>
