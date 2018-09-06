<template>
  <main v-if="!isNoBlog">
    <Header></Header>
    <SectionHeader :title="blog.title" :description="description"></SectionHeader>
    <Detail :blog="blog" :isNoBlog="isNoBlog"></Detail>
    <Footer></Footer>
  </main>
  <NotFound v-else></NotFound>
</template>

<script>
import Header from '@/components/Header';
import Footer from '@/components/Footer';
import SectionHeader from '@/components/SectionHeader';
import Detail from '@/components/Detail';
import NotFound from '@/components/NotFound';
import Service from '@/service';
export default {
  data () {
    return {
      blog: {},
      status: 200,
      description: 'Network correlation',
    };
  },
  computed: {
    isNoBlog () {
      return this.status === 404;
    },
  },
  created () {
    this.getLink();
  },
  methods: {
    async getLink () {
      let reqData = {
        title: '友情链接',
      };
      // fetch about api
      let res = await Service.getLinkOrAbout(reqData);
      this.blog = res.data;
      this.status = res.status;
      // 404 的标题在 axios 拦截器已经定义
      if (this.status !== 404) {
        document.title = `${this.blog['title']} - ${document.title}`;
      }
    },
  },
  components: {
    Header, Footer, NotFound, SectionHeader, Detail,
  },
};
</script>

<style lang='scss' scoped>

</style>
