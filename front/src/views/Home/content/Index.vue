<template>
  <main>
    <SectionArticle :blogList="blogList"></SectionArticle>
    <Page v-if="blogLen > 12" :total="blogLen" size="small" :page-size="12" show-elevator @on-change="changePage" />
  </main>
</template>

<script>
import SectionArticle from '@/components/SectionArticle';
import Service from '@/service';
export default {
  data () {
    return {
      blogList: [],
      blogLen: 0,
      pageNo: 1,
      pageSize: 12,
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
      let res = await Service.getBlog(reqData);
      if (res.status === 200) {
        this.blogList = res.data;
        this.blogLen = res.blogLen;
        console.log(res);
      }
    },
    changePage (pageNo) {
      this.pageNo = pageNo;
      this.getBlog();
    },
  },
  components: {
    SectionArticle,
  },
};
</script>

<style lang='scss' scoped>
main {
  max-width: 1080px;
  margin: 90px auto 0;
}
</style>
