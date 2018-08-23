<template>
  <section>
    <article v-for="(val, index) in blogList" :key="index">
      <div class="bg-img" :style="{background: `url(${val.image}) 0% 0% / cover`}"></div>
      <div class="other-bgcover right-bgcover"></div>
      <div class="other-bgcover"></div>
      <div class="desc">
        <p class="title">{{val.title}}</p>
        <span></span>
      </div>
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
          image: 'https://muz1.xyz/templates/themes/default/static/img/rand/6.jpg',
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
          image: 'https://muz1.xyz/templates/themes/default/static/img/rand/4.jpg',
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
          image: 'https://muz1.xyz/templates/themes/default/static/img/rand/7.jpg',
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
  padding: 0 87px;
  box-sizing: border-box;

  article {
    width: 270px;
    height: 400px;
    float: left;
    position: relative;
    border-radius: 4px;
    background: rgba(255, 255, 255, 0.5);
    box-sizing: border-box;
    margin: 0 16px;
    box-shadow: 0 2px 9px 0 rgba(0, 0, 0, .08);
    overflow: hidden;

    &:hover {
      box-shadow: 1px 2px 12px 1px rgba(0, 0, 0, 0.15);
      background: #fff;
    }

    .bg-img {
      height: 300px;
      border-radius: 4px 4px 0 0;
    }

    .other-bgcover {
      position: absolute;
      z-index: 0;
      right: 0;
      bottom: 15px;
      left: 0;
      width: 110%;
      min-height: 100px;
      transform: rotate(7deg) translate(-10px,0);
      background-color: #fff;
    }
    .right-bgcover {
      transform: rotate(-10deg) translate(10px,-10px);
      opacity: .7;
      background-color: rgba(0, 0, 0, .5) !important;
    }

    .desc {
      width: 100%;
      height: 100px;
      background: #fff;
      position: relative;
      padding: 0px 20px 20px;
      box-sizing: border-box;

      .title {
        font-size: 16px;
      }
    }
  }
}
</style>
