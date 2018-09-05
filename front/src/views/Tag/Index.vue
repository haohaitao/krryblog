<template>
  <main v-if="!isNotCategory">
    <Header></Header>
    <Content :blogList="blogList" :TagName="TagName"></Content>
    <Footer></Footer>
  </main>
  <NotFound v-else></NotFound>
</template>

<script>
import Header from '@/components/Header';
import Footer from '@/components/Footer';
import NotFound from '@/components/NotFound';
import Content from './Content';
export default {
  data () {
    return {
      blogList: [
        {
          title: '博客1',
          description: '这是一段博客描述1',
          image: 'https://muz1.xyz/templates/themes/default/static/img/rand/6.jpg',
          id: '2015',
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
          id: '2016',
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
          id: '2017',
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
          id: '2018',
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
          id: '2019',
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
          id: '2019',
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
          id: '2019',
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
      TagName: 'JavaScript',
      status: 200,
    };
  },
  computed: {
    isNotCategory () {
      return this.status === 404;
    },
  },
  created () {
    this.getTags();
  },
  methods: {
    getTags () {
      this.status = 200;
      // 404 的标题在 axios 拦截器已经定义
      if (this.status !== 404) {
        document.title = `${this.TagName} - ${document.title}`;
      }
    },
  },
  watch: {
    $route (to, from) {
      this.getTags();
    },
  },
  components: {
    Header, Footer, NotFound, Content,
  },
};
</script>

<style lang='scss' scoped>

</style>
