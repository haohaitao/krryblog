<template>
  <main>
    <Header></Header>
    <Content :blogList="blogList" :keyword="keyword" :blogLen="blogLen" :hasNoResult="hasNoResult" @changePage="changePage"></Content>
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
      keyword: '',
      blogLen: 0,
      status: 200,
      pageNo: 1,
      pageSize: 9,
    };
  },
  computed: {
    hasNoResult () {
      return this.status === 406;
    },
  },
  created () {
    this.getSearch();
  },
  methods: {
    async getSearch () {
      this.keyword = this.$route.params['keyword'];
      document.title = `${this.keyword} 的搜索结果 - ${document.title}`;
      let reqData = {
        pageNo: this.pageNo,
        pageSize: this.pageSize,
        keyword: this.keyword,
      };
      let res = await Service.getBlogByKeyword(reqData);
      this.status = res.status;
      this.blogList = res.data;
      this.blogLen = res.blogLen;
    },
    changePage (pageNo) {
      this.pageNo = pageNo;
      this.getSearch();
    },
  },
  watch: {
    $route (to, from) {
      this.getSearch();
    },
  },
  components: {
    Header, Footer, Content,
  },
};
</script>

<style lang='scss' scoped>

</style>
