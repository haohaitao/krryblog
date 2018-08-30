<template>
  <section>
    <div class="header">
      <h1>『知识总结』</h1>
      <h4>相关内容 —— 归档</h4>
    </div>
    <SectionArticle :blogList="blogList"></SectionArticle>
    <Page v-if="blogLen > 12" :total="blogLen" size="small" show-elevator show-total />
  </section>
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
        },
        {
          title: '博客2',
          description: '这是一段博客描述2',
          image: 'https://muz1.xyz/templates/themes/default/static/img/rand/4.jpg',
          blogId: '2016',
          createTime: '2018-02-03',
          updateTime: '2018-03-21',
          hit: 468,
          comment: 20,
          classify: '技术',
          classifyId: '2',
          label: ['JavaScript', 'vue', 'html'],
        },
        {
          title: '博客3',
          description: '这是一段博客描述3',
          image: 'https://muz1.xyz/templates/themes/default/static/img/rand/7.jpg',
          blogId: '2017',
          createTime: '2018-02-03',
          updateTime: '2018-03-21',
          hit: 468,
          comment: 20,
          classify: '技术',
          classifyId: '3',
          label: ['JavaScript', 'vue', 'html'],
        },
        {
          title: '博客3',
          description: '这是一段博客描述3',
          image: 'https://muz1.xyz/templates/themes/default/static/img/rand/6.jpg',
          blogId: '2018',
          createTime: '2018-02-03',
          updateTime: '2018-03-21',
          hit: 468,
          comment: 20,
          classify: '技术',
          classifyId: '3',
          label: ['JavaScript', 'vue', 'html'],
        },
        {
          title: '博客3',
          description: '这是一段博客描述3',
          image: 'https://muz1.xyz/templates/themes/default/static/img/rand/6.jpg',
          blogId: '2019',
          createTime: '2018-02-03',
          updateTime: '2018-03-21',
          hit: 468,
          comment: 20,
          classify: '技术',
          classifyId: '3',
          label: ['JavaScript', 'vue', 'html'],
        },
        {
          title: '博客3',
          description: '这是一段博客描述3',
          image: 'https://muz1.xyz/templates/themes/default/static/img/rand/6.jpg',
          blogId: '2019',
          createTime: '2018-02-03',
          updateTime: '2018-03-21',
          hit: 468,
          comment: 20,
          classify: '技术',
          classifyId: '3',
          label: ['JavaScript', 'vue', 'html'],
        },
        {
          title: '博客3',
          description: '这是一段博客描述3',
          image: 'https://muz1.xyz/templates/themes/default/static/img/rand/6.jpg',
          blogId: '2019',
          createTime: '2018-02-03',
          updateTime: '2018-03-21',
          hit: 468,
          comment: 20,
          classify: '技术',
          classifyId: '3',
          label: ['JavaScript', 'vue', 'html'],
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
section {
  .header {
    background: url(../../../assets/pic/category.jpg) no-repeat;
    background-size: cover;
    padding: 96px 0 30px;
    text-align: center;
    margin-bottom: 20px;

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
}
</style>
