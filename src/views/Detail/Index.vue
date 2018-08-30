<template>
  <main v-if="!isNoBlog">
    <Header></Header>
    <article class="detail-article">
      <div class="art-header">
        <h1>{{blog.title}}</h1>
        <div class="header-info">
          <Icon type="md-pricetags" />
          <router-link :to="`/category/${blog.classifyId}`">{{blog.classify}}</router-link>
          <Icon type="md-time" />
          {{blog.createTime}}
          <Icon type="md-eye" />
          {{blog.hit}}
          <Icon type="md-chatboxes" />
          {{blog.comment}}
        </div>
        <div class="header-tag">
          <router-link :to="`/tag/${tags}`" v-for="(tags, index) in blog.label" :key="index">{{tags}}</router-link>
        </div>
      </div>
      <div id="blog" class="content markdown-body" v-html="blog.description"></div>
      <div class="content-footer">
        <p>本文由 <router-link to="/">乐诗-Krry</router-link> 创作，转载请注明</p>
        <p>最后编辑时间：{{blog.updateTime}}</p>
      </div>
      <aside id="directory"></aside>
    </article>
    <Footer></Footer>
    <div id="zooms" class="zoom-shadow"></div>
  </main>
  <NotFound v-else></NotFound>
</template>

<script>
import Header from '@/components/Header';
import Footer from '@/components/Footer';
import NotFound from '@/components/NotFound';
import '@/assets/css/markdown.css';
import '@/assets/css/github.css';
import Catalog from '@/util/catalog.js';
export default {
  data () {
    return {
      blog: {
        title: 'Vue网站后台系统',
        // description: `<p><a href=\"https://github.com/Krryxa/WORK-LEARNING/issues/26\" target=\"_blank\">面试 - 未知点(1)</a><br><br />\n<a href=\"https://github.com/Krryxa/WORK-LEARNING/issues/35\" target=\"_blank\">面试 - 未知点(2)</a><br><br />\n<a href=\"https://github.com/Krryxa/WORK-LEARNING/issues/37\" target=\"_blank\">面试 - 未知点(3)</a><br><br />\n<a href=\"https://github.com/Krryxa/WORK-LEARNING/issues/39\" target=\"_blank\">面试 - 未知点(4)</a></p>\n<h2><a id=\"nullundefined_6\"></a>null、undefined</h2>\n<blockquote>\n<p>undefined：表示一个变量最原始的状态，而非人为操作的结果<br><br />\nnull：表示一个对象被人为的重置为空对象，而非一个变量最原始的状态</p>\n</blockquote>\n<p>《JavaScript高级程序设计》一书 53 页：由于相等和不相等操作符存在类型转换问题，而为了保持代码中数据类型的完整性，我们推荐使用全等和不全等操作符</p>\n<p>记住：null == undefined 会返回 true；null === undefined 会返回 false；</p>\n<p>Undefined 和 Null 是 Javascript 中两种特殊的原始数据类型(Primary Type)，它们都只有一个值，分别对应 undefined 和 null ，这两种不同类型的值，即有着不同的语义和场景，但又表现出较为相似的行为：</p>\n<h2><a id=\"undefined_16\"></a>undefined</h2>\n<blockquote>\n<blockquote>\n<p>undefined 的字面意思就是未定义的值，这个值的语义是，希望表示一个变量最原始的状态，而非人为操作的结果。这种原始状态会在以下 4 种场景中出现：</p>\n</blockquote>\n</blockquote>\n<p>【1】声明了一个变量，但没有赋值</p>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-keyword\">var</span> foo;\n<span class=\"hljs-built_in\">console</span>.log(foo); <span class=\"hljs-comment\">//undefined</span>\n</code></div></pre>\n<p>访问foo，返回了undefined，表示这个变量自从声明了以后，就从来没有使用过，也没有定义过任何有效的值，即处于一种原始而不可用的状态。</p>\n<p>【2】访问对象上不存在的属性</p>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-built_in\">console</span>.log(<span class=\"hljs-built_in\">Object</span>.foo); <span class=\"hljs-comment\">// undefined</span>\n</code></div></pre>\n<p>访问Object对象上的 foo 属性，同样也返回 undefined ， 表示Object 上不存在或者没有定义名为 “foo” 的属性。</p>\n<p>【3】函数定义了形参，但没有传递实参</p>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-comment\">//函数定义了形参 a</span>\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">fn</span>(<span class=\"hljs-params\">a</span>) </span>{\n    <span class=\"hljs-built_in\">console</span>.log(a); <span class=\"hljs-comment\">//undefined</span>\n}\nfn(); <span class=\"hljs-comment\">//未传递实参</span>\n</code></div></pre>\n<p>函数 fn 定义了形参a， 但 fn 被调用时没有传递参数，因此，fn 运行时的参数 a 就是一个原始的、未被赋值的变量。</p>\n<p>【4】使用 void 对表达式求值</p>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-keyword\">void</span> <span class=\"hljs-number\">0</span> ; <span class=\"hljs-comment\">// undefined</span>\n<span class=\"hljs-keyword\">void</span> <span class=\"hljs-literal\">false</span>; <span class=\"hljs-comment\">//undefined</span>\n<span class=\"hljs-keyword\">void</span> []; <span class=\"hljs-comment\">//undefined</span>\n<span class=\"hljs-keyword\">void</span> <span class=\"hljs-literal\">null</span>; <span class=\"hljs-comment\">//undefined</span>\n<span class=\"hljs-keyword\">void</span> <span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">fn</span>(<span class=\"hljs-params\"></span>)</span>{} ; <span class=\"hljs-comment\">//undefined</span>\n</code></div></pre>\n<p>ECMAScript 规范 void 操作符 对任何表达式求值都返回 undefined ，这个和函数执行操作后没有返回值的作用是一样的，JavaScript中的函数都有返回值，当没有 return 操作时，就默认返回一个原始的状态值，这个值就是undefined，表明函数的返回值未被定义。</p>\n<p>因此，undefined 一般都来自于某个表达式最原始的状态值，不是人为操作的结果。当然，你也可以手动给一个变量赋值 undefined，但这样做没有意义，因为一个变量不赋值就是 undefined</p>\n<h2><a id=\"null_54\"></a>null</h2>\n<p>null 的字面意思是 空值 ，这个值的语义是，希望表示 一个对象被人为的重置为空对象，而非一个变量最原始的状态 。 在内存里的表示就是，栈中的变量没有指向堆中的内存对象，即：<br />\n<img src=\"https://raw.githubusercontent.com/Krryxa/WORK-LEARNING/master/images/p_19.jpg\" alt=\"\" /></p>\n<p>null 有属于自己的类型 Null，而不属于Object类型，typeof 之所以会判定为 Object 类型，是因为JavaScript 数据类型在底层都是以二进制的形式表示的，二进制的前三位为 0 会被 typeof 判断为对象类型，而 null 的二进制位恰好都是 0 ，因此，null 被误判断为 Object 类型。</p>\n<h2><a id=\"_nullundefined__60\"></a>判断 null、undefined 数据类型</h2>\n<ul>\n<li>获取 null 的真实类型：</li>\n</ul>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-built_in\">Object</span>.prototype.toString.call(<span class=\"hljs-literal\">null</span>); <span class=\"hljs-comment\">// [object Null]</span>\n</code></div></pre>\n<ul>\n<li>\n<p>通过 Object 原型上的 toString() 方法可以获取到JavaScript 中对象的真实数据类型</p>\n</li>\n<li>\n<p>当然 undefined 类型也可以通过这种方式来获取：</p>\n</li>\n</ul>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-comment\">// 要知道，使用 typeof 就可以鉴别 undefined 类型了</span>\n<span class=\"hljs-comment\">// typeof undefined === 'undefined'</span>\n<span class=\"hljs-built_in\">Object</span>.prototype.toString.call(<span class=\"hljs-literal\">undefined</span>); <span class=\"hljs-comment\">// [object Undefined]</span>\n</code></div></pre>\n<ul>\n<li>除此以外，还有比如 Array 的情况，因为 typeof Array 也会返回 object，检测是否是 Array 的方法：</li>\n</ul>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-comment\">// 以下三种方法，如果是数组，返回 true</span>\narr <span class=\"hljs-keyword\">instanceof</span> <span class=\"hljs-built_in\">Array</span>;\n<span class=\"hljs-built_in\">Array</span>.isArray(arr); <span class=\"hljs-comment\">// ES5方法</span>\n<span class=\"hljs-built_in\">Object</span>.prototype.toString.call(arr); <span class=\"hljs-comment\">// [object Array]</span>\n</code></div></pre>\n<h2><a id=\"_81\"></a>相似性</h2>\n<p>虽然 undefined 和 null 的语义和场景不同，但总而言之，它们都表示的是一个无效的值。 因此，在JS中对这类值访问属性时，都会得到异常的结果：</p>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\">Cannot read property <span class=\"hljs-string\">'foo'</span> <span class=\"hljs-keyword\">of</span> <span class=\"hljs-literal\">null</span>\nCannot read property <span class=\"hljs-string\">'foo'</span> <span class=\"hljs-keyword\">of</span> <span class=\"hljs-literal\">undefined</span>\n</code></div></pre>\n<p>ECMAScript 规范认为，既然 null 和  undefined 的行为很相似，并且都表示 一个无效的值，那么它们所表示的内容也具有相似性，即有</p>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-literal\">null</span> == <span class=\"hljs-literal\">undefined</span>; <span class=\"hljs-comment\">// true</span>\n</code></div></pre>\n<p>不要试图通过转换数据类型来解释这个结论，因为转换类型后：</p>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-built_in\">Number</span>(<span class=\"hljs-literal\">null</span>); <span class=\"hljs-comment\">// 0</span>\n<span class=\"hljs-built_in\">Number</span>(<span class=\"hljs-literal\">undefined</span>); <span class=\"hljs-comment\">// NaN，注意 NaN 不等于任何</span>\n\n<span class=\"hljs-comment\">// 在比较相等性之前，null 没有被转换为其他类型</span>\n<span class=\"hljs-literal\">null</span> == <span class=\"hljs-number\">0</span> ; <span class=\"hljs-comment\">// false</span>\n</code></div></pre>\n<p>但 null 和 undefined 使用 全等 === 会返回 false ，因为全等操作 === 在比较相等性的时候，不会主动转换分项的数据类型，而两者又不属于同一种类型：</p>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-literal\">null</span> === <span class=\"hljs-literal\">undefined</span>; <span class=\"hljs-comment\">// false，类型不相同</span>\n<span class=\"hljs-literal\">null</span> !== <span class=\"hljs-literal\">undefined</span>;  <span class=\"hljs-comment\">// true, 类型不相同</span>\n</code></div></pre>\n<h2><a id=\"_105\"></a>总结</h2>\n<p>用一句话总结两者的区别就是：undefined 表示一个变量自然的、最原始的状态值，而 null 则表示一个变量被人为的设置为空对象，而不是原始状态。所以，在实际使用过程中，为了保证变量所代表的语义，不要对一个变量显式的赋值 undefined，当需要释放一个对象时，直接赋值为 null 即可</p>\n`,
        image: 'https://muz1.xyz/templates/themes/default/static/img/rand/6.jpg',
        blogId: '2015',
        createTime: '2018-02-03',
        updateTime: '2018-03-21',
        hit: 468,
        comment: 20,
        classify: '技术',
        classifyId: '1',
        label: ['JavaScript', 'vue', 'html'],
      },
      status: 200,
      directory: [],
    };
  },
  computed: {
    isNoBlog () {
      return this.status === 404;
    },
  },
  created () {
    this.getBlogDetail();
  },
  mounted () {
    // 查询有博客的时候进行目录编排和图片点击事件
    if (!this.isNoBlog) {
      Catalog({
        contentEl: 'blog',
        catalogEl: 'directory',
        selector: ['h1', 'h2', 'h3'],
      });
      let wrapper = document.getElementsByClassName('cl-wrapper')[0];
      // 没有目录，就隐藏
      if (wrapper.innerHTML === '') {
        wrapper.style.display = 'none';
      }
      // 事件委托，处理全部 img 标签的点击事件
      let blog = document.getElementById('blog');
      let zooms = document.getElementById('zooms');
      let target = '';
      blog.addEventListener('click', ev => {
        let eve = ev || window.event;
        target = eve.target || eve.srcElement;
        if (target.nodeName.toLowerCase() === 'img' && target.className !== 'zoom-big-img') {
          zooms.style.visibility = 'visible';
          zooms.style.opacity = '1';
          target.className = 'zoom-big-img';
        } else if (target.className === 'zoom-big-img') {
          zooms.style.visibility = 'hidden';
          zooms.style.opacity = '0';
          target.className = '';
        }
      });
      zooms.addEventListener('click', ev => {
        zooms.style.visibility = 'hidden';
        zooms.style.opacity = '0';
        target.className = '';
      });
    }
  },
  methods: {
    getBlogDetail () {
      this.status = 200;
      // 404 的标题在 axios 拦截器已经定义
      if (this.status !== 404) {
        document.title = `${this.blog['title']} - ${document.title}`;
      }
    },
  },
  components: {
    Header, Footer, NotFound,
  },
};
</script>

<style lang='scss' scoped>
article {
  animation: fadeIn .6s linear;
  max-width: 700px;
  padding: 100px 25px 30px;
  margin: 0 auto;
  background-color: #fff;

  .art-header {
    padding-bottom: 20px;
    border-bottom: 1px dashed #b7b7b7;

    h1 {
      font-size: 22px;
      color: #222;
      font-weight: 400;
      line-height: 1.8;
    }

    .header-info {
      margin: 14px 0px;
      i {
        &:not(:first-child) {
          margin-left: 12px;
        }

        font-size: 14px;
        margin-top: -2px;
      }
    }

    .header-tag {
      a {
        color: #fff;
        border: 1px solid #f16d71;
        border-radius: 15px;
        background: #f16d71;
        display: inline-block;
        margin-right: 10px;
        padding: 0 15px;
        height: 25px;
        line-height: 25px;
        transition: .4s;

        &:hover {
          color: #5f5f5f !important;
          border: 1px solid #f7f7f7;
          outline-style: none;
          background: #f7f7f7;
        }
      }
    }
  }
  .content {
    margin: 26px 0;
  }
  .content-footer {
    border-top: 1px solid #e0e0e0;
    padding-top: 26px;
    color: #24292e;
    font-size: 14px;

    a {
      border-bottom: 1px solid #ccc;
    }
  }
}
.zoom-shadow {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  width: 100%;
  height: 100%;
  visibility: hidden;
  z-index: 1500;
  transition: .3s;
  background: rgba(0, 0, 0 , .6);
  opacity: 0;
}
</style>
<style lang="scss">
.detail-article {
  .content {
    p {
      font-size: 14px !important;
    }
    ul li {
      list-style: initial;
    }
    ul, ol {
      padding-left: 1em;
      li {
        font-size: 14px !important;
      }
    }
    h1, h2, h3 {
      position: relative;
      font-weight: 400;
      font-size: 1.24em;
      &::before {
        line-height: 24px;
        font-size: 20px;
        font-weight: bold;
        position: absolute;
        top: 0;
        left: -15px;
        content: '#';
        color: #eb5055;
      }
    }

    h1 {
      font-size: 1.3em;
      &::before {
        font-size: 21px;
        line-height: 25px;
      }
    }

    h3 {
      font-size: 1.05em;
      &::before {
        font-size: 19px;
        line-height: 21px;
      }
    }
    img {
      cursor: zoom-in;
      transition: .3s;
    }
    .zoom-big-img {
      z-index: 1501;
      position: fixed;
      cursor: zoom-out;
      margin: auto;
      left: 0;
      right: 0;
      top: 0;
      bottom: 0;
      transform: scale(1.1);
    }
  }
}

#directory {
  position: fixed;
  top: 30%;
  margin-left: 686px;
  max-width: 400px;
  .cl-wrapper {
    padding: 5px 0;
    border-left: 2px solid #ddd;
    ul li {
      position: relative;
      line-height: 27px;
      div:hover {
        color: #f44336 !important;
      }
      .cl-link {
        display: initial;
        overflow: hidden;
        text-overflow:ellipsis;
        white-space: nowrap;
        font-size: 14px;
        color: #272727;
        cursor: url(../../assets/pic/cursor.cur), pointer;
      }
    }
    &>ul>li {
      position: relative;
      padding-left: 15px;
      &>.cl-link-active {
        &::before {
          background-color: #f44336 !important;
        }
      }
      &>ul>li {
        &>ul>li {
          div {
            margin-left: 20px;
            color: #5f5f5f !important;
          }
        }
        div {
          margin-left: 10px;
          color: #4e4e4e !important;
        }
      }

      &>.cl-link {
        &::before {
          position: absolute;
          top: 10px;
          left: -5px;
          display: inline-block;
          width: 8px;
          height: 8px;
          content: '';
          border-radius: 50%;
          background-color: #a0a0a0;
        }
      }

      .cl-link-active {
        color: #f44336 !important;
      }
    }
  }
}
</style>
