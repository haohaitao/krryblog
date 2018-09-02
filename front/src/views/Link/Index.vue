<template>
  <main v-if="!isNoBlog">
    <Header></Header>
    <SectionHeader :title="blog.title" :description="description"></SectionHeader>
    <Detail :blog="blog" :isNoBlog="isNoBlog"></Detail>
    <Footer></Footer>
  </main>
  <NotFound v-else></NotFound>
</template>

<script>
import Header from '@/components/Header';
import Footer from '@/components/Footer';
import SectionHeader from '@/components/SectionHeader';
import Detail from '@/components/Detail';
import NotFound from '@/components/NotFound';
export default {
  data () {
    return {
      blog: {
        title: '友情链接',
        description: `<h2><a id=\"var__letconst_0\"></a>var 和 let、const</h2>\n<blockquote>\n<p>js 变量中有 var 定义和无 var 定义的区别以及 es6 中 let 命令和 const 命令</p>\n</blockquote>\n<ul>\n<li>可以知道定义的 x 和 y 都被挂载在 window 对象上，变为window 下的属性</li>\n</ul>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\">x = <span class=\"hljs-number\">10</span>;\n<span class=\"hljs-keyword\">var</span> y = <span class=\"hljs-number\">20</span>;\n<span class=\"hljs-built_in\">console</span>.log(x); <span class=\"hljs-comment\">// 10</span>\n<span class=\"hljs-built_in\">console</span>.log(y); <span class=\"hljs-comment\">// 20</span>\n<span class=\"hljs-built_in\">console</span>.log(<span class=\"hljs-built_in\">window</span>.x); <span class=\"hljs-comment\">// 10</span>\n<span class=\"hljs-built_in\">console</span>.log(<span class=\"hljs-built_in\">window</span>.y); <span class=\"hljs-comment\">// 20</span>\n</code></div></pre>\n<ul>\n<li>但执行 delete 命令时，有问题</li>\n</ul>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-keyword\">delete</span> x <span class=\"hljs-comment\">// true</span>\n<span class=\"hljs-keyword\">delete</span> y <span class=\"hljs-comment\">// false</span>\n<span class=\"hljs-built_in\">console</span>.log(<span class=\"hljs-built_in\">window</span>.x); <span class=\"hljs-comment\">// undefined</span>\n<span class=\"hljs-built_in\">console</span>.log(<span class=\"hljs-built_in\">window</span>.y); <span class=\"hljs-comment\">// 20</span>\n</code></div></pre>\n<ul>\n<li>\n<p>再看看执行上面代码之后 y 属性没有被删除，x 被删除了，这是区别就来了</p>\n</li>\n<li>\n<p>在通过 var 进行定义后的变量不能被 delete 删除，这是什么原因？</p>\n</li>\n<li>\n<p>ECMAScript 5标准中，可以通过 Object.getOwnPropertyDescriptor() 来获取对象自身某个 property 的属性信息：<br />\n<img src=\"https://raw.githubusercontent.com/Krryxa/WORK-LEARNING/master/images/p_18.jpg\" alt=\"\" /></p>\n</li>\n<li>\n<p>当不使用 var 进行定义时，变量默认的 configurable 为 true，可以进行 delete 等命令进行操作</p>\n</li>\n<li>\n<p>而当 var 在定义一个全局变量的时候 configurable 变为了false，即不会被delete删除</p>\n</li>\n<li>\n<p>注意：使用 let 定义，是不会挂载到 window 对象上，更不能 delete</p>\n</li>\n</ul>\n<h3><a id=\"_31\"></a>变量提升</h3>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\">alert(a); <span class=\"hljs-comment\">// Uncaught ReferenceError: a is not defined</span>\na = <span class=\"hljs-number\">100</span>;\n\nalert(b);<span class=\"hljs-comment\">// undefined</span>\n<span class=\"hljs-keyword\">var</span> b = <span class=\"hljs-number\">200</span>;\n</code></div></pre>\n<blockquote>\n<p>先说第二段代码，var 声明的全局变量 b 在 js 中会进行代码提升，也就是说 var b = 200; 会被分解为 var b; b=200; 代码解析的第时候会将 var b;提升到最前面，并且在内存中开辟一个空间，由于 b 没有被赋值，默认为 undefined</p>\n</blockquote>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-comment\">// 上面第二段代码等同于：</span>\n<span class=\"hljs-keyword\">var</span> b;\nalert(b);\nb = <span class=\"hljs-number\">200</span>;\n</code></div></pre>\n<blockquote>\n<p>第一段代码中当 js 执行 alert() 函数时候由于没有进行 var 声明，变量没有被提升，不存在内存开辟，所以在 alert 时候直接报错</p>\n</blockquote>\n<ul>\n<li>在 ECMAScript6 标准中,一个重要的概念就是“JavaScript严格模式”，需要在最前面加上&quot;use strict&quot;;</li>\n<li>严格模式下不能使用未声明的变量</li>\n</ul>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-meta\">\"use strict\"</span>;\nx = <span class=\"hljs-number\">3.14</span>;       <span class=\"hljs-comment\">// 报错 (x 未定义)</span>\n</code></div></pre>\n<h2><a id=\"let__55\"></a>let 注意点</h2>\n<ol>\n<li>\n<p>let 拥有块级作用域，一个 {} 就是一个作用域</p>\n</li>\n<li>\n<p>let 在其作用域下面不存在变量提升</p>\n</li>\n<li>\n<p>let 在其作用域中不能被重复声明（函数作用域和块级作用域）</p>\n</li>\n</ol>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\">alert(a); <span class=\"hljs-comment\">// Uncaught ReferenceError: a is not defined 变量没有提升</span>\n<span class=\"hljs-keyword\">let</span> a = <span class=\"hljs-number\">100</span>;\n</code></div></pre>\n<h2><a id=\"const_66\"></a>const</h2>\n<ol>\n<li>\n<p>const 用来声明常量，一旦声明，其值就不可以更改</p>\n</li>\n<li>\n<p>const 的作用域与 let 相同，只在声明所在的块级作用域内有效，并且也是和 let 一样不可以重复进行声明</p>\n</li>\n</ol>\n<p>注意点：const arr = [1,2]; arr.push(3); 是成功的</p>\n<h2><a id=\"_73\"></a>面试题</h2>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-keyword\">var</span> funcs = [];\n<span class=\"hljs-keyword\">for</span> (<span class=\"hljs-keyword\">var</span> i=<span class=\"hljs-number\">0</span>; i&lt;<span class=\"hljs-number\">10</span>; i++) {\n  funcs.push(<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> (<span class=\"hljs-params\"></span>) </span>{<span class=\"hljs-built_in\">console</span>.log(i)});\n}\nfuncs.forEach(<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> (<span class=\"hljs-params\">func</span>) </span>{\n  func();\n});\n</code></div></pre>\n<p>一看就知道输出 10 个 10，但是如果想要依次输出 0 到 9 呢？</p>\n<ol>\n<li>闭包可解决</li>\n</ol>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-comment\">// 函数自执行，闭包解决方案，直接把每次循环的数值代进去了</span>\n<span class=\"hljs-keyword\">var</span> funcs = [];\n<span class=\"hljs-keyword\">for</span> (<span class=\"hljs-keyword\">var</span> i=<span class=\"hljs-number\">0</span>; i&lt;<span class=\"hljs-number\">10</span>; i++) {\n  funcs.push(\n    (<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> (<span class=\"hljs-params\">value</span>) </span>{\n      <span class=\"hljs-keyword\">return</span> <span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span>(<span class=\"hljs-params\"></span>) </span>{<span class=\"hljs-built_in\">console</span>.log(value)}\n    })(i) <span class=\"hljs-comment\">// 函数自执行，这里不能加分号</span>\n  );\n}\nfuncs.forEach(<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> (<span class=\"hljs-params\">func</span>) </span>{\n  func();\n});\n</code></div></pre>\n<ol start=\"2\">\n<li>es6 语法</li>\n</ol>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-comment\">// 使用 let</span>\n<span class=\"hljs-keyword\">const</span> funcs = [];\n<span class=\"hljs-keyword\">for</span> (<span class=\"hljs-keyword\">let</span> i=<span class=\"hljs-number\">0</span>; i&lt;<span class=\"hljs-number\">10</span>; i++) {\n  funcs.push( <span class=\"hljs-function\"><span class=\"hljs-params\">()</span> =&gt;</span> <span class=\"hljs-built_in\">console</span>.log(i));\n}\nfuncs.forEach( <span class=\"hljs-function\"><span class=\"hljs-params\">func</span> =&gt;</span> func());\n</code></div></pre>\n<p><a href=\"https://www.ainyi.com\" target=\"_blank\">音乐博客</a></p>\n`,
        image: 'https://muz1.xyz/templates/themes/default/static/img/rand/6.jpg',
        blogId: '2015',
        createTime: '2018-02-03',
        updateTime: '2018-03-21',
        hit: 468,
        comment: 20,
        classify: '链接',
        classifyId: '1',
        label: [],
        status: 0, // 发布状态，0 未发布
      },
      status: 200,
      description: 'Network correlation',
    };
  },
  computed: {
    isNoBlog () {
      return this.status === 404;
    },
  },
  created () {
    this.getLinksDetail();
  },
  methods: {
    getLinksDetail () {
      // fetch about api
      this.status = 200;
      // 404 的标题在 axios 拦截器已经定义
      if (this.status !== 404) {
        document.title = `${this.blog['title']} - ${document.title}`;
      }
    },
  },
  components: {
    Header, Footer, NotFound, SectionHeader, Detail,
  },
};
</script>

<style lang='scss' scoped>

</style>
