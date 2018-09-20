<template>
  <header>
    <div class="container">
      <div class="home left">
        <Icon type="md-headset" />
        <router-link to="/">Krryblog</router-link>
      </div>
      <div class="nav right">
        <ul class="nav-far">
          <router-link to="/">
            <li>
              <Icon type="ios-home" />
              首页
            </li>
          </router-link>
          <li class="sub-item">
            <Icon type="ios-list-box" />
            存档
            <ul class="nav-child">
              <li v-for="(item, index) in classifyList" :key="index">
                <router-link :to="`/category/${item.id}`">{{item.name}}</router-link>
              </li>
            </ul>
          </li>
          <li class="sub-item">
            <Icon type="md-color-palette" />
            主题
            <ul class="nav-child">
              <li>
                <router-link to="#">简约优雅</router-link>
              </li>
              <li>
                <router-link to="#">二次元</router-link>
              </li>
            </ul>
          </li>
          <!-- 可使用命名路由 -->
          <router-link :to="{name: 'link'}">
            <li>
              <Icon type="ios-link" style="font-weight: bold;"/>
              友链
            </li>
          </router-link>
          <router-link to="/about">
            <li>
              <Icon type="md-heart" />
              关于
            </li>
          </router-link>
        </ul>
        <div class="search">
          <Icon type="md-search" @click="search"/>
          <input type="text" class="s-inp" v-model.trim="keyWord" @keyup.enter="search" placeholder="查找你喜欢的内容..." maxlength="30" autocomplete="off">
        </div>
      </div>
    </div>
  </header>
</template>

<script>
import Headroom from 'headroom.js';
export default {
  data () {
    return {
      keyWord: '',
    };
  },
  computed: {
    // 从接口查询出分类
    classifyList () {
      return this.$store.getters['blog/classify'];
    },
  },
  created () {
  },
  mounted () {
    // 获取页面元素
    let myElement = document.querySelector('header');
    let headroom = new Headroom(myElement, {
      'tolerance': 5,
      'offset': 80,
      'classes': {
        'initial': 'animated',
        'pinned': 'slideInDown',
        'unpinned': 'slideOutUp',
      },
    });
    headroom.init();
  },
  methods: {
    search () {
      // 不需要去掉字符串中间的空格，两边的空格在 v-model.trim 已经去掉
      // this.keyWord = this.keyWord.replace(/\s*/g, '');
      if (this.keyWord !== '') {
        console.log(this.keyWord);
        console.log('search api...');
        this.$router.push(`/search/${this.keyWord}`);
        this.keyWord = '';
      }
    },
  },
  components: {
  },
};
</script>

<style lang='scss' scoped>
header {
  background: rgba(255, 255, 255, .94);
  width: 100%;
  height: 70px;
  position: fixed;
  top: 0;
  z-index: 1;
  box-shadow: 0 1px 5px rgba(0, 0, 0, .1);

  .container {
    width: 1080px;
    max-width: 100%;
    margin: 0 auto;
    height: 100%;
    color: #3c3c3c;

    a {
      color: #3c3c3c;
    }

    .home {
      height: 100%;
      line-height: 70px;
      font-size: 24px;

      a {
        font-size: 20px;
      }
    }

    .nav {
      height: 100%;
      line-height: 70px;
      font-size: 14px;
      position: relative;

      .nav-far {
        margin-right: 38px;
        li {
          position: relative;
          float: left;
          margin: 0 16px;
          &:hover {
            transition: .4s;
            color: #eb5055;
            cursor: url(../assets/pic/cursor.cur), pointer !important;
          }

          i {
            font-size: 16px;
            margin-top: -3px;
          }

          &.sub-item {
            &:hover > .nav-child {
              visibility: visible;
              opacity: .98;
              top: 100%;
              // transition: all .3s ease-in-out;
            }
            .nav-child {
              z-index: 1501;
              visibility: hidden;
              background: rgba(255, 255, 255, .94);
              opacity: 0;
              top: 80%;
              position: absolute;
              box-shadow: 0 0 10px 0 #cacaca;
              transition: all .3s ease-in-out;
              li {
                float: none;
                margin: 0;

                a {
                  padding: 15px 20px;
                  width: 156px;
                  display: block;
                  height: 50px;
                  line-height: 20px;
                  transition: .4s;

                  &:hover {
                    padding-left: 32px;
                  }
                }
              }
            }
          }
        }
      }
      .search {
        &:hover {
          color: #eb5055;
          transition: .4s;

          .s-inp {
            width: 100%;
            opacity: 1;
            visibility: visible;
          }
        }

        i {
          width: 30px;
          height: 30px;
          line-height: 30px;
          text-align: center;
          position: absolute;
          top: 20px;
          right: 0;
          z-index: 1;
          font-size: 18px;
          cursor: url(../assets/pic/cursor.cur), pointer !important;
        }

        .s-inp {
          transition: .6s;
          visibility: hidden;
          opacity: 0;
          font-size: 12px;
          line-height: 30px;
          position: absolute;
          top: 20px;
          right: 0;
          width: 0%;
          height: 30px;
          padding: 0 30px 0 18px;
          color: #313131;
          border: 1px solid #eb5055;
          border-radius: 20px;
          outline: 0;
          background-color: #fff;
          -webkit-appearance: none;
        }
      }
    }
  }
}
</style>
