<template>
  <section>
    <article v-for="(val, index) in blogList" :key="index">
      <div class="bg-img" :style="{background: `url(${val.image}) 0% 0% / cover`}"></div>
      {{val.title}} <br>
      {{val.description}}
    </article>
    <div class="clear"></div>
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
  width: 100%;
  padding: 0 72px;
  box-sizing: border-box;

  article {
    width: 280px;
    height: 400px;
    float: left;
    border-radius: 4px;
    background: rgba(255, 255, 255, 0.5);
    box-sizing: border-box;
    margin: 0 16px;
    box-shadow: 0 2px 9px 0 rgba(0, 0, 0, .08);
    border: 1px solid #e6ebf5;

    &:hover {
      box-shadow: 1px 2px 12px 1px rgba(0, 0, 0, 0.15);
      background: #fff;
    }

    .bg-img {
      height: 350px;
      border-radius: 4px;
    }
  }
}
</style>
