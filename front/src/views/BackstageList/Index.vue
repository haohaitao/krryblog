<template>
  <main>
    <Header></Header>
    <Content :blogList="blogList" :blogLen="blogLen" @statusBlog="statusBlog" @deleteBlog="deleteBlog" @changePage="changePage"></Content>
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
      pageNo: 1,
      pageSize: 10,
    };
  },
  created () {
    this.getBlog();
  },
  methods: {
    async getBlog () {
      let reqData = {
        pageNo: this.pageNo,
        pageSize: this.pageSize,
      };
      let res = await Service.getAllBlog(reqData);
      this.status = res.status;
      // 404 的标题在 axios 拦截器已经定义
      if (this.status !== 404) {
        // 将点击数和评论数合并
        for (let val of res.data) {
          let hitComment = `${val.hit} / ${val.comment}`;
          delete val.hit;
          delete val.comment;
          val.hitComment = hitComment;
        }
        this.blogList = res.data;
        this.blogLen = res.blogLen;
      }
    },
    statusBlog (reqData) {
      let id = reqData.id;
      let status = reqData.status;
      for (let val of this.blogList) {
        if (val.id === id) {
          val.status = status;
          break;
        }
      }
    },
    deleteBlog (id) {
      this.blogList = this.blogList.filter(item => item.id !== id);
      --this.blogLen;
      if (this.blogList.length === 0) {
        this.pageNo = --this.pageNo > 0 ? this.pageNo : 1;
        this.getBlog();
      }
    },
    changePage (pageNo) {
      this.pageNo = pageNo;
      this.getBlog();
    },
  },
  components: {
    Header, Footer, Content,
  },
};
</script>

<style lang='scss' scoped>

</style>
