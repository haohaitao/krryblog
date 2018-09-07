<template>
  <main>
    <Header></Header>
    <Content :blogList="blogList" :blogLen="blogLen"></Content>
    <Footer></Footer>
  </main>
</template>

<script>
import Header from '@/components/Header';
import Footer from '@/components/Footer';
import Content from './Content';
import Service from '@/service';
export default {
  data () {
    return {
      blogList: [],
      blogLen: 0,
    };
  },
  created () {
    this.getBlog();
  },
  methods: {
    async getBlog () {
      let res = await Service.getBlog();
      this.status = res.status;
      // 404 的标题在 axios 拦截器已经定义
      if (this.status !== 404) {
        // 将点击数和评论数合并
        res.data.map(val => {
          let hitComment = `${val.hit} / ${val.comment}`;
          delete val.hit;
          delete val.comment;
          val.hitComment = hitComment;
        });
        this.blogList = res.data;
        this.blogLen = res.blogLen;
      }
    },
  },
  components: {
    Header, Footer, Content,
  },
};
</script>

<style lang='scss' scoped>

</style>
