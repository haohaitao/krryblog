<template>
  <section class="left">
    <article v-for="(val, index) in blogList" :key="index">
      <div class="bg-img" :style="{background: `url(${val.image}) 0% 0% / cover`}"></div>
      {{val.title}} <br>
      {{val.description}}
    </article>
  </section>
</template>

<script>
export default {
  data () {
    return {
      blogList: [
        {
          title: '博客1',
          description: '这是一段博客描述1',
          image: 'https://52huameng.com/wp-content/themes/kratos/images/thumb/thumb_10.jpg',
          createTime: '2018-02-03',
          updateTime: '2018-03-21',
          hit: 468,
          comment: 20,
          classify: '技术',
          label: ['JavaScript', 'vue', 'html'],
        },
        {
          title: '博客2',
          description: '这是一段博客描述2',
          image: 'https://52huameng.com/wp-content/themes/kratos/images/thumb/thumb_10.jpg',
          createTime: '2018-02-03',
          updateTime: '2018-03-21',
          hit: 468,
          comment: 20,
          classify: '技术',
          label: ['JavaScript', 'vue', 'html'],
        },
        {
          title: '博客3',
          description: '这是一段博客描述3',
          image: 'https://52huameng.com/wp-content/themes/kratos/images/thumb/thumb_10.jpg',
          createTime: '2018-02-03',
          updateTime: '2018-03-21',
          hit: 468,
          comment: 20,
          classify: '技术',
          label: ['JavaScript', 'vue', 'html'],
        },
      ],
    };
  },
  components: {
  },
};
</script>

<style lang='scss' scoped>
section {
  width: 720px;

  article {
    width: 680px;
    height: 300px;
    border-radius: 4px;
    box-shadow: black 0px 0px 4px;
    background: rgba(255, 255, 255, 0.5);
    box-sizing: border-box;
    transition: all .3s ease-in-out;

    &:not(:first-child) {
      margin-top: 36px;
    }

    &:hover {
      box-shadow: black 0px 0px 10px;
      background: #fff;
    }

    .bg-img {
      height: 300px;
    }
  }
}
</style>
