<template>
  <section>
    <SectionHeader :title="categoryName" :description="description"></SectionHeader>
    <SectionArticle :blogList="blogList" class="wrapper"></SectionArticle>
    <Page v-if="blogLen > 9" :total="blogLen" size="small" :page-size="9" show-elevator show-total @on-change="changePage"/>
  </section>
</template>

<script>
import SectionHeader from '@/components/SectionHeader';
import SectionArticle from '@/components/SectionArticle';
export default {
  props: {
    blogList: {
      type: Array,
    },
    categoryName: {
      type: String,
    },
    blogLen: {
      type: Number,
    },
  },
  data () {
    return {
      description: '相关内容 —— 归档',
    };
  },
  methods: {
    changePage (pageNo) {
      this.$emit('changePage', pageNo);
    },
  },
  components: {
    SectionHeader, SectionArticle,
  },
};
</script>

<style lang='scss' scoped>
section {
  margin: 0 auto;
  .wrapper {
    width: 1080px;
    padding-top: 20px;
  }
}
</style>
