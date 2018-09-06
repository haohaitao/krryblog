<template>
  <section>
    <SectionHeader :title="keyWord" :description="description"></SectionHeader>
    <SectionArticle :blogList="blogList" class="wrapper" v-if="!hasNoResult"></SectionArticle>
    <NoResult v-else></NoResult>
    <Page v-if="blogLen > 12" :total="blogLen" size="small" show-elevator show-total/>
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
    keyWord: {
      type: String,
    },
    hasNoResult: {
      type: Boolean,
    },
  },
  data () {
    return {
      description: '相关内容 —— 搜索',
      blogLen: 10,
    };
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
    width: 1080px;
    padding-top: 20px;
  }
}
</style>
