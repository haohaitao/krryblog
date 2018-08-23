<template>
  <header>
    <div class="container">
      <div class="home left">
        <Icon type="md-headset" />
        <a href="#">Krryblog</a>
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
            归档
            <ul class="nav-child">
              <li>
                <a href="#">知识总结</a>
              </li>
               <li>
                <a href="#">分享猫猫</a>
              </li>
               <li>
                <a href="#">标签大全</a>
              </li>
            </ul>
          </li>
          <li class="sub-item">
            <Icon type="md-color-palette" />
            主题
            <ul class="nav-child">
              <li>
                <a href="#">简约优雅</a>
              </li>
               <li>
                <a href="#">二次元</a>
              </li>
            </ul>
          </li>
          <li>
            <Icon type="md-heart" />
            关于
          </li>
          <li>
            <Icon type="ios-paper-plane" />
            登录
          </li>
        </ul>
      </div>
    </div>
  </header>
</template>

<script>
export default {
  data () {
    return {
    };
  },
  components: {
  },
};
</script>

<style lang='scss' scoped>
header {
  background: rgba(255, 255, 255, .5);
  width: 100%;
  height: 70px;
  box-shadow: 0 1px 5px rgba(0, 0, 0, .1);

  .container {
    width: 1080px;
    max-width: 100%;
    margin: 0 auto;
    height: 100%;

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

      .nav-far {
        li {
          position: relative;
          float: left;
          margin: 0 20px;
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
                  width: 160px;
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
