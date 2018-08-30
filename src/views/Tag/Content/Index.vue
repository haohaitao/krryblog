<template>
  <section>
    <div class="header">
      <h1>『{{TagName}}』</h1>
      <h4>相关内容 —— 标签</h4>
    </div>
    <div class="article">
      <SectionArticle :blogList="blogList"></SectionArticle>
    </div>
    <Page v-if="blogLen > 12" :total="blogLen" size="small" show-elevator show-total />
  </section>
</template>

<script>
import SectionArticle from '@/components/SectionArticle';
export default {
  props: {
    blogList: {
      type: Array,
    },
    TagName: {
      type: String,
    },
  },
  data () {
    return {
      blogLen: 13,
    };
  },
  components: {
    SectionArticle,
  },
};
</script>

<style lang='scss' scoped>
section {
  .header {
    background: url(../../../assets/pic/category.jpg) no-repeat;
    background-size: cover;
    padding: 96px 0 30px;
    text-align: center;

    h1 {
      font-weight: 100;
      font-size: 30px;
      margin-bottom: 10px;
      letter-spacing: .1em;
      color: #fff;
      text-shadow: 0 4px 8px rgba(7,17,27,.4);
    }

    h4 {
      font-weight: 100;
      font-size: 15px;
      color: rgba(255,255,255,0.54);
    }
  }

  .article {
    width: 1080px;
    margin: 20px auto 0;
  }
}
</style>
