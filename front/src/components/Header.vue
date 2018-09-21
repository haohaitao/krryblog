<template>
  <header class="head-page">
    <div class="container">
      <div class="home left">
        <Icon type="md-headset" />
        <router-link to="/">Krryblog</router-link>
      </div>
      <div class="nav-coll-menu" ref="collMenuNavFar" :class="{'nav-coll-menu-padd': isVisibleNavFar}">
        <span class="icon-menu cross" :class="{'icon-menu-close': isVisibleNavFar}">
          <span class="middle"></span>
        </span>
        <span class="click-fun" @click="closeCollMenu"></span>
        <ul class="nav-far" :class="{'visible-nav-far': isVisibleNavFar}">
          <router-link to="/">
            <li>
              首页
            </li>
          </router-link>
          <li class="sub-item">
            存档
            <ul class="nav-child">
              <li v-for="(item, index) in classifyList" :key="index">
                <router-link :to="`/category/${item.id}`">{{item.name}}</router-link>
              </li>
            </ul>
          </li>
          <li class="sub-item">
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
              友链
            </li>
          </router-link>
          <router-link to="/about">
            <li>
              关于
            </li>
          </router-link>
        </ul>
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
      isVisibleNavFar: false,
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
    this.$refs.collMenuNavFar.onmouseleave = () => {
      this.isVisibleNavFar = false;
    };
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
    closeCollMenu () {
      this.isVisibleNavFar = !this.isVisibleNavFar;
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
        position: relative;
        z-index: 1;
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

    .nav-coll-menu-padd {
      padding-bottom: 25px !important;
    }
    /* 小菜单 */
    .nav-coll-menu {
      position: absolute;
      width: 20px;
      top: 15px;
      left: 6px;
      cursor: url(../assets/pic/cursor.cur), pointer;
      z-index: 1;
      display: none;
      height: 16px;
      padding: 10px;
      box-sizing: content-box;

      .click-fun {
        width: 40px;
        height: 36px;
        position: absolute;
        top: 0;
        left: 0;
      }

      .icon-menu-close {
        transform: rotateZ(360deg);

        &::before {
          top: 7px !important;
          transform: rotate(45deg) !important;
          background: #eb5055 !important;
        }
        &::after {
          bottom: 7px !important;
          transform: rotate(135deg) !important;
          background: #eb5055 !important;
        }
        .middle {
          opacity: 0;
        }
      }

      .icon-menu {
        position: relative;
        display: inline-block;
        width: 20px;
        height: 16px;
        transition: all .4s ease-in-out;
        transition-timing-function: cubic-bezier(.61,.04,.17,1.32);

        &::before, &::after {
          position: absolute;
          width: 20px;
          height: 2px;
          content: '';
          transition: all .4s ease-in-out;
          transform-origin: 50% 50% 0;
          background: #313131;
        }
        &::before {
          top: 0;
        }
        &::after {
          bottom: 0;
        }

        .middle {
          position: absolute;
          top: 50%;
          display: inline-block;
          width: 20px;
          height: 2px;
          margin-top: -1px;
          transition: all .4s ease-in-out;
          background: #313131;
        }
      }

      .visible-nav-far {
        visibility: visible !important;
        margin-top: 24px !important;
        opacity: .96 !important;
      }
      .nav-far {
        opacity: 0;
        transition: .4s;
        visibility: hidden;
        width: 130px;
        margin-top: 0;
        box-shadow: 0 0 4px 0 #d4d4d4;
        background: rgba(255, 255, 255, 0.92);
        font-size: 14px;
        // border-radius: 5px;
        li {
          position: relative;
          padding: 0 22px;
          line-height: 50px;
          transition: .4s;
          &:hover {
            transition: .4s;
            padding: 0 32px;
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
              left: 60px;
              z-index: 1501;
              visibility: hidden;
              background: rgba(255, 255, 255, .94);
              opacity: 0;
              top: 38px;
              position: absolute;
              box-shadow: 0 0 4px 0 #d4d4d4;
              transition: all .3s ease-in-out;
              li {
                padding: 0;
                float: none;
                margin: 0;

                a {
                  padding: 15px 22px;
                  width: 130px;
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
    }
  }
}
</style>
