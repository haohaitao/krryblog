<template>
  <main v-if="!isNotCategory">
    <Header></Header>
    <Content :blogList="blogList" :TagName="TagName" :blogLen="blogLen"></Content>
    <Footer></Footer>
  </main>
  <NotFound v-else></NotFound>
</template>

<script>
import Header from '@/components/Header';
import Footer from '@/components/Footer';
import NotFound from '@/components/NotFound';
import Content from './Content';
import Service from '@/service';
export default {
  data () {
    return {
      blogList: [],
      TagName: '',
      blogLen: 0,
      status: 200,
    };
  },
  computed: {
    isNotCategory () {
      return this.status === 404;
    },
  },
  created () {
    this.getTags();
  },
  methods: {
    async getTags () {
      this.TagName = this.$route.params['name'];
      let reqData = {
        tag: this.TagName,
      };
      let res = await Service.getBlogByTag(reqData);
      this.status = res.status;
      // 404 的标题在 axios 拦截器已经定义
      if (this.status !== 404) {
        this.blogList = res.data;
        this.blogLen = res.blogLen;
        document.title = `${this.TagName} - ${document.title}`;
      }
    },
  },
  watch: {
    $route (to, from) {
      this.getTags();
    },
  },
  components: {
    Header, Footer, NotFound, Content,
  },
};
</script>

<style lang='scss' scoped>

</style>
