<template>
  <main>
    <SectionArticle :blogList="blogList"></SectionArticle>
    <Page v-if="blogLen > 12" :total="blogLen" size="small" show-elevator show-total />
  </main>
</template>

<script>
import SectionArticle from '@/components/SectionArticle';
export default {
  data () {
    return {
      blogList: [
        {
          title: '博客1',
          description: '这是一段博客描述1',
          image: 'https://muz1.xyz/templates/themes/default/static/img/rand/6.jpg',
          blogId: '2015',
          createTime: '2018-02-03',
          updateTime: '2018-03-21',
          hit: 468,
          comment: 20,
          classify: '技术',
          classifyId: '1',
          label: ['JavaScript', 'vue', 'html'],
          status: 1, // 发布状态，0 未发布
        },
      ],
      blogLen: 13,
    };
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
