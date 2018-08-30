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
        description: `<h2><a id=\"_0\"></a>普通对象与函数对象</h2>\n<ul>\n<li>javascript 中的对象分为普通对象和函数对象，Object、Function 是 js 自带的函数对象</li>\n</ul>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-keyword\">let</span> o1 = {}; \n<span class=\"hljs-keyword\">let</span> o2 =<span class=\"hljs-keyword\">new</span> <span class=\"hljs-built_in\">Object</span>();\n<span class=\"hljs-keyword\">let</span> o3 = <span class=\"hljs-keyword\">new</span> f1();\n\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">f1</span>(<span class=\"hljs-params\"></span>)</span>{}; \n<span class=\"hljs-keyword\">let</span> f2 = <span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span>(<span class=\"hljs-params\"></span>)</span>{};\n<span class=\"hljs-keyword\">let</span> f3 = <span class=\"hljs-keyword\">new</span> <span class=\"hljs-built_in\">Function</span>(<span class=\"hljs-string\">'str'</span>,<span class=\"hljs-string\">'console.log(str)'</span>);\n\n<span class=\"hljs-built_in\">console</span>.log(<span class=\"hljs-keyword\">typeof</span> <span class=\"hljs-built_in\">Object</span>); <span class=\"hljs-comment\">//function </span>\n<span class=\"hljs-built_in\">console</span>.log(<span class=\"hljs-keyword\">typeof</span> <span class=\"hljs-built_in\">Function</span>); <span class=\"hljs-comment\">//function  </span>\n\n<span class=\"hljs-built_in\">console</span>.log(<span class=\"hljs-keyword\">typeof</span> f1); <span class=\"hljs-comment\">//function </span>\n<span class=\"hljs-built_in\">console</span>.log(<span class=\"hljs-keyword\">typeof</span> f2); <span class=\"hljs-comment\">//function </span>\n<span class=\"hljs-built_in\">console</span>.log(<span class=\"hljs-keyword\">typeof</span> f3); <span class=\"hljs-comment\">//function   </span>\n\n<span class=\"hljs-built_in\">console</span>.log(<span class=\"hljs-keyword\">typeof</span> o1); <span class=\"hljs-comment\">//object</span>\n<span class=\"hljs-built_in\">console</span>.log(<span class=\"hljs-keyword\">typeof</span> o2); <span class=\"hljs-comment\">//object</span>\n<span class=\"hljs-built_in\">console</span>.log(<span class=\"hljs-keyword\">typeof</span> o3); <span class=\"hljs-comment\">//object</span>\n</code></div></pre>\n<blockquote>\n<p>在上面的例子中 o1 o2 o3 为普通对象，f1 f2 f3 为函数对象。凡是通过 new Function() 创建的对象都是函数对象，其他的都是普通对象。f1,f2,归根结底都是通过 new Function()的方式进行创建的。Function、Object 也都是通过 New Function() 创建的</p>\n</blockquote>\n<h2><a id=\"_24\"></a>构造函数</h2>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">Person</span>(<span class=\"hljs-params\">name, age, job</span>) </span>{\n  <span class=\"hljs-keyword\">this</span>.name = name;\n  <span class=\"hljs-keyword\">this</span>.age = age;\n  <span class=\"hljs-keyword\">this</span>.job = job;\n  <span class=\"hljs-keyword\">this</span>.sayName = <span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span>(<span class=\"hljs-params\"></span>) </span>{ alert(<span class=\"hljs-keyword\">this</span>.name) } \n}\n<span class=\"hljs-keyword\">let</span> person1 = <span class=\"hljs-keyword\">new</span> Person(<span class=\"hljs-string\">'krry'</span>, <span class=\"hljs-number\">28</span>, <span class=\"hljs-string\">'Software Engineer'</span>);\n<span class=\"hljs-keyword\">let</span> person2 = <span class=\"hljs-keyword\">new</span> Person(<span class=\"hljs-string\">'Mick'</span>, <span class=\"hljs-number\">23</span>, <span class=\"hljs-string\">'Doctor'</span>);\n\n<span class=\"hljs-built_in\">console</span>.log(person1.constructor == Person); <span class=\"hljs-comment\">//true</span>\n<span class=\"hljs-built_in\">console</span>.log(person2.constructor == Person); <span class=\"hljs-comment\">//true</span>\n</code></div></pre>\n<blockquote>\n<p>上面的例子中 person1 和 person2 都是 Person 的实例。这两个实例都继承了 Person 的原型对象 prototype 的 constructor 属性，该属性（是一个指针）指向 Person （相等）</p>\n</blockquote>\n<h2><a id=\"_40\"></a>原型对象</h2>\n<ul>\n<li>在 JavaScript 中，只有函数对象 function 才具有 prototype 属性。</li>\n<li>每当定义一个函数对象，对象（Person）中都会包含一些预定义的属性。其中每个函数对象都有一个 prototype 属性，这个属性就是函数的原型对象：Person.prototype</li>\n<li>在默认情况下，所有的原型对象都有一个 constructor（构造函数）属性，这个属性（是一个指针）指向 prototype 属性所在的函数（Person）即：Person.prototype.constructor == Person</li>\n<li>可以在原型对象里定义一些属性：</li>\n</ul>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\">Person.prototype = {\n  <span class=\"hljs-attr\">name</span>:  <span class=\"hljs-string\">'krry'</span>,\n  <span class=\"hljs-attr\">age</span>: <span class=\"hljs-number\">28</span>,\n  <span class=\"hljs-attr\">job</span>: <span class=\"hljs-string\">'Software Engineer'</span>,\n  <span class=\"hljs-attr\">sayName</span>: <span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span>(<span class=\"hljs-params\"></span>) </span>{\n    alert(<span class=\"hljs-keyword\">this</span>.name);\n  }\n}\n</code></div></pre>\n<ul>\n<li>在上面我们谈到实例的构造函数属性（constructor）指向构造函数：person1.constructor == Person</li>\n</ul>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\">person1.constructor == Person\nPerson.prototype.constructor == Person\n</code></div></pre>\n<h2><a id=\"___proto____61\"></a>__ proto __：隐式原型</h2>\n<ul>\n<li>JS 在创建对象的实例（不论是普通对象还是函数对象）的时候，都有一个叫做__proto__ 的内置属性，称为隐式原型，指向创建它的构造函数的原型对象 prototype，这也保证了实例能够访问在构造函数原型中定义的属性和方法（继承）</li>\n</ul>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\">Person.prototype.constructor == Person;\nperson1.__proto__ == Person.prototype;\nperson1.constructor == Person;\n</code></div></pre>\n<h3><a id=\"_68\"></a>区分一下</h3>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-comment\">// 实例的__proto__ === 对象的prototype</span>\n<span class=\"hljs-comment\">// 而对象Person也是Function(函数对象)的实例</span>\n<span class=\"hljs-comment\">// 所以：Person.__proto__ === Function.prototype</span>\n</code></div></pre>\n<h2><a id=\"_75\"></a>构造器</h2>\n<pre><div class=\"hljs\"><code class=\"lang-JavaScript\"><span class=\"hljs-keyword\">let</span> obj = {}\n<span class=\"hljs-comment\">// 它等同于下面这样：</span>\n<span class=\"hljs-keyword\">let</span> obj = <span class=\"hljs-keyword\">new</span> <span class=\"hljs-built_in\">Object</span>()\n\n<span class=\"hljs-comment\">// obj 是构造函数（Object）的一个实例。所以：</span>\nobj.constructor === <span class=\"hljs-built_in\">Object</span>\nobj.__proto__ === <span class=\"hljs-built_in\">Object</span>.prototype\n\n<span class=\"hljs-comment\">// 同理，可以创建对象的构造器不仅仅有 Object，也可以是 Array，Date，Function等</span>\n<span class=\"hljs-comment\">// 所以我们也可以构造函数来创建 Array、 Date、Function</span>\n\n<span class=\"hljs-keyword\">let</span> b = <span class=\"hljs-keyword\">new</span> <span class=\"hljs-built_in\">Array</span>();\nb.constructor === <span class=\"hljs-built_in\">Array</span>;\nb.__proto__ === <span class=\"hljs-built_in\">Array</span>.prototype;\n\n<span class=\"hljs-keyword\">let</span> c = <span class=\"hljs-keyword\">new</span> <span class=\"hljs-built_in\">Date</span>(); \nc.constructor === <span class=\"hljs-built_in\">Date</span>;\nc.__proto__ === <span class=\"hljs-built_in\">Date</span>.prototype;\n\n<span class=\"hljs-keyword\">let</span> d = <span class=\"hljs-keyword\">new</span> <span class=\"hljs-built_in\">Function</span>();\nd.constructor === <span class=\"hljs-built_in\">Function</span>;\nd.__proto__ === <span class=\"hljs-built_in\">Function</span>.prototype;\n</code></div></pre>\n<ul>\n<li>如下构造器都是函数对象：<br />\n<img src=\"https://raw.githubusercontent.com/Krryxa/WORK-LEARNING/master/images/p_6.jpg\" alt=\"\" /></li>\n</ul>\n<h2><a id=\"_103\"></a>小总结</h2>\n<ul>\n<li>javascript 里所有的对象都有__proto__属性(不论是普通对象还是函数对象)，指向创建它的构造函数的原型对象 prototype</li>\n<li>只有函数对象 function 才具有 prototype 属性。这个属性是一个指针，指向一个对象：原型对象。这个对象的用途就是包含所有实例共享的属性和方法。原型对象也有属性，有个叫做 constructor，这个属性包含了一个指针，指回原构造函数</li>\n<li>普通对象的__proto__ === Object.prototype</li>\n<li>函数对象的__proto__ === Function.prototype</li>\n<li>Function.prototype === Object.__ proto __ === 函数对象的__proto__</li>\n<li>如：</li>\n</ul>\n<pre><div class=\"hljs\"><code class=\"lang-JavaScript\"><span class=\"hljs-comment\">// 普通对象newObj 和 Object</span>\n<span class=\"hljs-keyword\">let</span> newObj = <span class=\"hljs-keyword\">new</span> <span class=\"hljs-built_in\">Object</span>(); <span class=\"hljs-comment\">// 或者 let newObj = {};</span>\n<span class=\"hljs-comment\">// 因为 newObj.__proto__ === newObj.constructor.prototype</span>\n<span class=\"hljs-comment\">// 因为 newObj.constructor === Object</span>\n<span class=\"hljs-comment\">// 所以 newObj.__proto__ === Object.prototype</span>\n\n<span class=\"hljs-comment\">// 函数对象Person 和 Function</span>\n<span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">Person</span>(<span class=\"hljs-params\">name, age, job</span>) </span>{\n  <span class=\"hljs-keyword\">this</span>.name = name;\n  <span class=\"hljs-keyword\">this</span>.age = age;\n  <span class=\"hljs-keyword\">this</span>.job = job;\n}\n<span class=\"hljs-comment\">// 因为 Person.__proto__ === Person.constructor.prototype</span>\n<span class=\"hljs-comment\">// 因为 Person.constructor === Function</span>\n<span class=\"hljs-comment\">// 所以 Person.__proto__ === Function.prototype</span>\n</code></div></pre>\n<ul>\n<li>实例对象的__proto__ === 对象的prototype</li>\n</ul>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-comment\">// 实例对象 person 和 对象 Person</span>\n<span class=\"hljs-comment\">// 因为：person1.__proto__ === person1.constructor.prototype</span>\n<span class=\"hljs-comment\">// 因为：person1.constructor === Person</span>\n<span class=\"hljs-comment\">// 所以：person1.__proto__ === Person.prototype</span>\n</code></div></pre>\n<ul>\n<li>Person.prototype.__ proto __ === Object.prototype</li>\n</ul>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-comment\">// prototype 是原型对象，也是一个普通对象，我们无需关注它有哪些属性，只要记住它是一个普通对象</span>\n
        <span class=\"hljs-comment\">// 因为一个普通对象的构造函数 === Object （obj.constructor === object）</span>\n<span class=\"hljs-comment\">// 所以 Person.prototype.__proto__ === Object.prototype （普通对象的__proto__ === Object.prototype）</span>\n<span class=\"hljs-comment\">// 小总结第一点也可以得出 Person.prototype.__ proto __ === Object.prototype （普通对象的__proto__ === Object.prototype）</span>\n</code></div></pre>\n<ul>\n<li>Function.prototype.__ proto __ === Object.prototype</li>\n</ul>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-comment\">// 同上一点，prototype 是原型对象，也是一个普通对象，所以：</span>\n<span class=\"hljs-comment\">// Function.prototype.__proto__ === Object.prototype</span>\n</code></div></pre>\n<ul>\n<li>Object.prototype.__proto __ === null</li>\n</ul>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-comment\">// Object.prototype 对象也有proto属性，但它比较特殊，为 null，因为 null 处于原型链的顶端，这个只能记住</span>\n<span class=\"hljs-comment\">// Object.prototype.__proto__ === null</span>\n</code></div></pre>\n<h2><a id=\"Prototype_156\"></a>Prototype</h2>\n<blockquote>\n<p>在 ECMAScript 核心所定义的全部属性中，最耐人寻味的就要数 prototype 属性了。对于 ECMAScript 中的引用类型而言，prototype 是保存着它们所有实例方法的真正所在。换句话所说，诸如 toString()和 valuseOf() 等方法实际上都保存在 prototype 名下，只不过是通过各自对象的实例访问罢了。</p>\n</blockquote>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-keyword\">let</span> obj = <span class=\"hljs-keyword\">new</span> <span class=\"hljs-built_in\">Object</span>()\n</code></div></pre>\n<ul>\n<li>obj 是 Object 的实例，所以 obj 继承了Object 的原型对象Object.prototype 上所有的方法：<br><br />\n<img src=\"https://raw.githubusercontent.com/Krryxa/WORK-LEARNING/master/images/p_7.jpg\" alt=\"\" /></li>\n<li>Object 的每个实例都具有以上的属性和方法。</li>\n<li>所以我可以用 Person.constructor 也可以用 Person.hasOwnProperty</li>\n</ul>\n<h2><a id=\"_167\"></a>原型链</h2>\n<ul>\n<li>在使用 new 初始化函数的时候得到的新对象的__proto__属性会指向函数对象的原型对象，而函数对象的原型对象又继承至原始对象。所以呈现以下结构：</li>\n</ul>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\">person1.__proto__ === Person.prototype -&gt;\nPerson.prototype.__proto__ === <span class=\"hljs-built_in\">Object</span>.prototype -&gt;\n<span class=\"hljs-built_in\">Object</span>.prototype.__proto__ === <span class=\"hljs-literal\">null</span>\n</code></div></pre>\n<blockquote>\n<p>把这个有__proto__串起来的直到 Object.prototype.__proto __ 为 null 的链叫做原型链，原型链实际上就是 js 中数据继承的继承链</p>\n</blockquote>\n<h2><a id=\"_176\"></a>总结</h2>\n<ul>\n<li>原型和原型链是JS实现继承的一种模型。</li>\n<li>原型链的形成是真正是靠__proto__ 而非prototype</li>\n</ul>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-keyword\">let</span> animal = <span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span>(<span class=\"hljs-params\"></span>)</span>{};\n<span class=\"hljs-keyword\">let</span> dog = <span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span>(<span class=\"hljs-params\"></span>)</span>{};\n\nanimal.price = <span class=\"hljs-number\">2000</span>;\ndog.prototype = animal;\n<span class=\"hljs-keyword\">let</span> tidy = <span class=\"hljs-keyword\">new</span> dog();\n<span class=\"hljs-built_in\">console</span>.log(dog.price) <span class=\"hljs-comment\">// undefined</span>\n<span class=\"hljs-built_in\">console</span>.log(tidy.price) <span class=\"hljs-comment\">// 2000</span>\n\n\n<span class=\"hljs-comment\">// 相当于</span>\n<span class=\"hljs-keyword\">let</span> dog = <span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span>(<span class=\"hljs-params\"></span>)</span>{};\ndog.prototype.price = <span class=\"hljs-number\">2000</span>;\n<span class=\"hljs-keyword\">let</span> tidy = <span class=\"hljs-keyword\">new</span> dog();\n<span class=\"hljs-built_in\">console</span>.log(dog.price); <span class=\"hljs-comment\">// undefined，price 属性存在于原型对象中</span>\n<span class=\"hljs-built_in\">console</span>.log(tidy.price); <span class=\"hljs-comment\">// 2000，继承</span>\n</code></div></pre>\n<blockquote>\n<p>实例（tidy）和 原型对象（dog.prototype）存在一个连接。不过，要明确的真正重要的一点就是，这个连接是存在于实例（tidy）与构造函数的原型对象（dog.prototype）之间，而不是存在于实例（tidy）与构造函数（dog）之间</p>\n</blockquote>\n`,
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
    this.status = 200;
    // 404 的标题在 axios 拦截器已经定义
    if (this.status !== 404) {
      document.title = `${this.blog['title']} - ${document.title}`;
    }
  },
  mounted () {
    // 查询有博客的时候进行目录编排和图片点击事件
    if (!this.isNoBlog) {
      Catalog({
        contentEl: 'blog',
        catalogEl: 'directory',
        selector: ['h1', 'h2', 'h3'],
      });
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
