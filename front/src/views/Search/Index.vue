<template>
  <main>
    <Header></Header>
    <Content :blogList="blogList" :keyWord="keyWord" :hasNoResult="hasNoResult"></Content>
    <Footer></Footer>
  </main>
</template>

<script>
import Header from '@/components/Header';
import Footer from '@/components/Footer';
import Content from './Content';
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
          status: 1, // 发布状态，0 未发布
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
          status: 1, // 发布状态，0 未发布
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
          status: 1, // 发布状态，0 未发布
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
          status: 1, // 发布状态，0 未发布
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
          status: 1, // 发布状态，0 未发布
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
          status: 1, // 发布状态，0 未发布
        },
      ],
      keyWord: '关键词 的搜索结果',
      status: 200,
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
    getSearch () {
      this.status = 406;
      this.keyWord = this.$route.params['keyword'];
      document.title = `${this.keyWord} 的搜索结果 - ${document.title}`;
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
