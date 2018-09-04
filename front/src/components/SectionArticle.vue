<template>
  <section>
    <article v-for="(val, index) in blogList" :key="index">
      <div class='bg-container'>
        <div class="bg-img" :style="{background: `url(${val.image}) 0% 0% / cover`}"></div>
      </div>
      <!-- 这里使用命名路由，效果与下面一样 -->
      <router-link :to="{name: 'blog', params: {id: val.id, title: val.title}}">
        <div class="bg-cover">
          <p>{{val.description}}</p>
        </div>
      </router-link>
      <div class="other-bgcover right-bgcover"></div>
      <div class="other-bgcover"></div>
      <div class="desc">
        <!-- 这里直接用 id 作为路径，与上面一样 -->
        <router-link :to="`/${val.id}`">
          <p class="title">{{val.title}}</p>
        </router-link>
        <div class="desc-bottom">
          <div class="d-detail">
            <Icon type="md-calendar" />
            {{val.createTime}}
            <Icon type="md-eye" />
            {{val.hit}}
            <Icon type="md-chatboxes" />
            {{val.comment}}
          </div>
          <router-link :to="`/category/${val.classifyId}`">
            <div class="item-icon" :title="val.classify" :style="{backgroundPosition: `0 ${-val.classifyId*70}px`}"></div>
          </router-link>
        </div>
      </div>
    </article>
    <div class="clear"></div>
  </section>
</template>

<script>
export default {
  props: {
    blogList: {
      type: Array,
    },
  },
  data () {
    return {
    };
  },
  computed: {
  },
  components: {
  },
};
</script>

<style lang='scss' scoped>
section {
  animation: fadeIn .6s linear;
  width: 100%;
  padding: 0 60px;
  box-sizing: border-box;

  article {
    width: 280px;
    height: 340px;
    float: left;
    position: relative;
    border-radius: 4px;
    background: rgba(255, 255, 255, 0.5);
    box-sizing: border-box;
    margin: 20px;
    box-shadow: 0 2px 9px 0 rgba(0, 0, 0, .08);
    overflow: hidden;

    &:hover {
      box-shadow: 1px 2px 12px 1px rgba(0, 0, 0, 0.15);
      background: #fff;

      .bg-img {
        filter: blur(3px);
        transform: scale(1.1);
      }

      .bg-cover {
        background-color: rgba(0,0,0,.5);

        p {
          transition: .5s;
          margin-top: 0px;
          opacity: 1;
        }
      }
    }

    .bg-container {
      &::before {
        content: "Loading...";
        position: absolute;
        border-radius: 4px 4px 0 0;
        width: 100%;
        left: 0;
        background-color: rgba(169, 169, 169, 0.75);
        text-align: center;
        line-height: 230px;
        font-size: 26px;
        color: #333333;
        z-index: -1;
      }

      &::after {
        content: "";
        position: absolute;
        border-radius: 4px 4px 0 0;
        width: 100%;
        left: 0;
        background-color: rgba(255, 255, 255, 0);
        line-height: 230px;
        z-index: -1;
      }

      .bg-img {
        transition: all .5s ease;
        height: 230px;
        border-radius: 4px 4px 0 0;
      }
    }

    .bg-cover {
      position: absolute;
      top: 0;
      overflow: hidden;
      width: 100%;
      height: 100%;
      padding: 40px 28px;
      cursor: url(../assets/pic/cursor.cur), pointer !important;

      p {
        font-size: 14px;
        margin: 0;
        margin-top: 26px;
        padding: 0;
        display: -webkit-box;
        -webkit-box-orient: vertical;
        -webkit-line-clamp: 4;
        overflow: hidden;
        opacity: 0;
        line-height: 26px;
        color: #fff;
      }
    }

    .other-bgcover {
      position: absolute;
      z-index: 0;
      right: 0;
      bottom: 1px;
      left: 0;
      width: 110%;
      min-height: 100px;
      transform: rotate(5deg) translate(-10px, -20px);
      background-color: #fff;
    }
    .right-bgcover {
      transform: rotate(-10deg) translate(10px,-30px);
      opacity: .7;
      background-color: rgba(0, 0, 0, .5) !important;
    }

    .desc {
      width: 100%;
      height: 110px;
      background: #fff;
      position: relative;
      padding: 7px 15px 10px;
      box-sizing: border-box;

      .title {
        color: #000;
        font-size: 16px;
        display: -webkit-inline-box;
        -webkit-box-orient: vertical;
        -webkit-line-clamp: 2;
        overflow: hidden;
        &:hover {
          color: #ff8b18;
        }
      }

      .desc-bottom {
        position: absolute;
        right: 0;
        bottom: 0;
        width: 100%;
        padding: 0 15px 10px;
        text-align: right;

        .d-detail {
          position: absolute;
          bottom: 10px;

          i {
            font-size: 14px;
            margin-top: -2px;

            &:not(:first-child) {
              margin-left: 12px;
            }
          }
        }

        .item-icon {
          background: url(https://raw.githubusercontent.com/Krryxa/krryblog/master/front/src/assets/pic/bg-ico.png) no-repeat;
          height: 37px;
          width: 37px;
          float: right;
          border: 1px solid #eaeaea;
          border-radius: 50%;
          background-size: cover;
        }
      }
    }
  }
}
</style>
