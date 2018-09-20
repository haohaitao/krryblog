<template>
  <section>
    <SectionHeader :title="keyword" :description="description"></SectionHeader>
    <SectionArticle :blogList="blogList" class="wrapper" v-if="!hasNoResult"></SectionArticle>
    <NoResult v-else></NoResult>
    <Page v-if="blogLen > 9" :total="blogLen" size="small" :page-size="9" show-elevator show-total @on-change="changePage"/>
  </section>
</template>

<script>
import SectionHeader from '@/components/SectionHeader';
import SectionArticle from '@/components/SectionArticle';
import NoResult from './NoResult';
export default {
  props: {
    blogList: {
      type: Array,
    },
    keyword: {
      type: String,
    },
    blogLen: {
      type: Number,
    },
    hasNoResult: {
      type: Boolean,
    },
  },
  data () {
    return {
      description: '相关内容 —— 搜索',
    };
  },
  methods: {
    changePage (pageNo) {
      this.$emit('changePage', pageNo);
    },
  },
  components: {
    SectionHeader, SectionArticle, NoResult,
  },
};
</script>

<style lang='scss' scoped>
section {
  margin: 0 auto;
  .wrapper {
    padding-top: 20px;
  }
}
</style>
