<template>
  <section>
    <div class="search-box">
      <input type="text"
        ref="search"
        v-model.trim="keyWord"
        @keyup.enter="search"
        placeholder="查找你喜欢的内容..."
        :maxlength="30"
        autocomplete="off"
        size="large"
        class="inp-search" />
      <button class="inp-btn" @click="search">Search</button>
      <div class="clear"></div>
    </div>
    <p class="msg">Sorry，没找到你想要的~~</p>
    您可以换个关键词&nbsp;
    <span class="border-line rep-search" @click="focusSearch">重新搜索</span>
    &nbsp;或&nbsp;
    <router-link to="/" class="border-line">返回首页</router-link>
  </section>
</template>

<script>
import Header from '@/components/Header';
import Footer from '@/components/Footer';
export default {
  data () {
    return {
      keyWord: '',
    };
  },
  methods: {
    search () {
      // 不需要去掉字符串中间的空格，两边的空格在 v-model.trim 已经去掉
      // this.keyWord = this.keyWord.replace(/\s*/g, '');
      if (this.keyWord !== '') {
        console.log(this.keyWord);
        console.log('search api...');
      }
    },
    focusSearch () {
      this.$refs.search.focus();
    },
  },
  components: {
    Header, Footer,
  },
};
</script>

<style lang='scss' scoped>
section {
  animation: fadeIn .6s linear;
  padding: 50px 0;
  text-align: center;
  line-height: 70px;

  .msg {
    margin-top: 26px;
    font-size: 26px;
  }

  .search-box {
    width: 580px;
    margin: 0 auto;

    &:hover {
      .inp-btn {
        background: #f60;
        border-color: #f60;
      }
      .inp-search {
        border-color: #f60;
      }
    }

    .inp-search {
      transition: .3s;
      float: left;
      margin: 0 auto;
      width: 500px;
      height: 38px;
      border-radius: 5px 0 0 5px;
      border: 1px solid #dcdee2;
      border-right: none;
      outline: none;
      padding: 4px 9px;
      font-size: 14px;

      &:focus {
        border-color: #f60;
        box-shadow: 0 0 0 2px rgba(255, 118, 19, 0.2);
      }
    }
    .inp-btn {
      transition: .3s;
      float: left;
      width: 80px;
      height: 38px;
      border-radius: 0 5px 5px 0;
      border: 1px solid #ff8737;
      border-left: none;
      background: #ff8f44;
      line-height: 38px;
      color: #fff;
      font-size: 14px;
      outline: none;
    }
  }
  .border-line {
    transition: .3s;
    border-bottom: 1px solid #ccc;

    &:hover {
      color: #eb5055;
      border-bottom: 1px solid #eb5055;
    }
  }
  .rep-search {
    cursor: url(../../../assets/pic/cursor.cur), pointer !important;
  }
}
</style>
