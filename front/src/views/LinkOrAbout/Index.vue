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
    };
  },
  computed: {
    isNoBlog () {
      return this.status === 404;
    },
    type () {
      return this.$route.name;
    },
    description () {
      return this.type === 'link' ? 'Network correlation' : 'About me';
    },
    title () {
      return this.type === 'link' ? '友情链接' : '关于我';
    },
  },
  created () {
    this.getLinkOrAbout();
  },
  methods: {
    async getLinkOrAbout () {
      // fetch about api
      let res = await Service.getLinkOrAbout(this.title);
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
