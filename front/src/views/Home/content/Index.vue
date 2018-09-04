<template>
  <main>
    <SectionArticle :blogList="blogList"></SectionArticle>
    <Page v-if="blogLen > 12" :total="blogLen" size="small" show-elevator show-total />
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
    };
  },
  created () {
    this.getBlog();
  },
  methods: {
    async getBlog () {
      let res = await Service.getBlog();
      if (res.status === 200) {
        this.blogList = res.data;
        this.blogLen = res.blogLen;
        console.log(res);
      }
    },
  },
  components: {
    SectionArticle,
  },
};
</script>

<style lang='scss' scoped>
main {
  width: 1080px;
  margin: 90px auto 0;
}
</style>
