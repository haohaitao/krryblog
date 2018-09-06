<template>
  <section>
    <SectionHeader :title="categoryName" :description="description"></SectionHeader>
    <SectionArticle :blogList="blogList" class="wrapper"></SectionArticle>
    <Page v-if="blogLen > 12" :total="blogLen" size="small" show-elevator show-total />
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
