<template>
  <main v-if="!isNotCategory">
    <Header></Header>
    <Content :blogList="blogList" :categoryName="categoryName" :blogLen="blogLen"></Content>
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
      categoryName: '',
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
    this.getCategory();
  },
  methods: {
    async getCategory () {
      let id = this.$route.params['id'];
      // 不在这个范围内的分类 id 是 404 页面
      if (id < 1 || id > 4) {
        this.status = 404;
      }
      let res = await Service.getBlogByClassifyId(id);
      this.status = res.status;

      // 404 的标题在 axios 拦截器已经定义
      if (this.status !== 404) {
        this.blogList = res.data;
        this.blogLen = res.blogLen;
        this.categoryName = res.categoryName;
        document.title = `${this.categoryName} - ${document.title}`;

        if (this.status === 406) {
          // 分类下没有发布过任何博客的情况
          // TODO
          console.log('分类下没有发布过任何博客的情况');
        }
      }
    },
  },
  watch: {
    $route (to, from) {
      this.getCategory();
    },
  },
  components: {
    Header, Footer, NotFound, Content,
  },
};
</script>

<style lang='scss' scoped>

</style>
