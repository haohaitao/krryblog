<template>
  <main>
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
      <aside id="directory" class="didid"></aside>
    </article>
    <Footer></Footer>
  </main>
</template>

<script>
import Header from '@/components/Header';
import Footer from '@/components/Footer';
import '@/assets/css/markdown.css';
import '@/assets/css/github.css';
import Catalog from 'progress-catalog';
export default {
  data () {
    return {
      blog: {
        title: 'Vue网站后台系统',
        description: `<h1><a id=\"Vuemixin_0\"></a>Vue</h1>\n<p>网站后台系统，大部分从接口返回的数据需要 filter，在 Vue 中，一般是在页面上定义 filter 然后在模板文件中使用 | 进行处理：</p>\n<pre><div class=\"hljs\"><code class=\"lang-html\"><span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">td</span> <span class=\"hljs-attr\">class</span>=<span class=\"hljs-string\">\"pro_line pricess\"</span>&gt;</span>{{shop.price | toFixed(2)}}<span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">td</span>&gt;</span>\n</code></div></pre>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-comment\">// 可以有自定义过滤器</span>\nfilters:{\n  <span class=\"hljs-comment\">// 这里的 this 指向 window</span>\n  <span class=\"hljs-comment\">// 第一个参数 input 是管道符前面的值，往后的参数是调用时的参数</span>\n  toFixed(input, param1){\n    <span class=\"hljs-keyword\">return</span> <span class=\"hljs-string\">'￥'</span>+input.toFixed(param1); <span class=\"hljs-comment\">//保留两位小数</span>\n  }\n  <span class=\"hljs-comment\">// 使用 toFixed 前的 input 必须是 float 类型</span>\n},\n</code></div></pre>\n<p>这种方法和以前的遍历数组洗数据是方便了许多，但是，当我发现在许多的页面都有相同的 filter 的时候，每个页面都要复制一遍就显的很蛋疼，决定使用 Vue.mixin() 实现一次代码，无限复用</p>\n<p>最后，还可以将所有的 filter 包装成一个 vue 的插件，使用的时候调用 Vue.use() 即可，甚至可以上传 npm 包，开发不同的项目的时候可以直接 install 使用</p>\n<h2><a id=\"Vuemixin__22\"></a>Vue.mixin 的定义</h2>\n<p>学习一个新的框架或者 API 的时候，最好的途径就是上官网，这里附上 <a href=\"https://cn.vuejs.org/v2/guide/mixins.html#%E5%85%A8%E5%B1%80%E6%B7%B7%E5%85%A5\" target=\"_blank\">Vue.mixin() 官方说明</a></p>\n<ul>\n<li>\n<p>一句话解释，Vue.mixin() 可以把你创建的自定义方法混入所有的 Vue 实例</p>\n</li>\n<li>\n<p>示例代码</p>\n</li>\n</ul>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\">Vue.mixin({\n  <span class=\"hljs-attr\">created</span>: <span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span>(<span class=\"hljs-params\"></span>)</span>{\n    <span class=\"hljs-built_in\">console</span>.log(<span class=\"hljs-string\">\"success\"</span>)\n  }\n});\n</code></div></pre>\n<p>run 项目，会发现在控制台输出 success</p>\n<ul>\n<li>这里的意思是所有的 Vue 组件的 created 方法都被加上了我们自定义的 created 方法（先执行 mixin 的 created 方法，后执行组件实例的 created 方法）</li>\n</ul>\n<h2><a id=\"_Vuemixin_38\"></a>使用 Vue.mixin()</h2>\n<ul>\n<li>\n<p>接下来的思路很简单，我们整合所有的 filter 函数到一个文件，在 main.js 中引入即可。</p>\n</li>\n<li>\n<p>因为我们的自定义方法会在所有的实例中混入，如果按照以前的方法，难免会有覆盖原先的方法的危险，按照官方的建议，混入的自定义方法名增加前缀 $_ 用作区分。</p>\n</li>\n</ul>\n<ol>\n<li>创建一个 config.js 文件，用于保存状态码对应的含义，将其暴露出去</li>\n</ol>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-keyword\">export</span> <span class=\"hljs-keyword\">const</span> typeConfig = {\n  <span class=\"hljs-number\">1</span>: <span class=\"hljs-string\">\"type one\"</span>,\n  <span class=\"hljs-number\">2</span>: <span class=\"hljs-string\">\"type two\"</span>,\n  <span class=\"hljs-number\">3</span>: <span class=\"hljs-string\">\"type three\"</span>\n}\n</code></div></pre>\n<ol start=\"2\">\n<li>再创建一个 filters.js 文件，用于保存所有的自定义函数</li>\n</ol>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-keyword\">import</span> { typeConfig } <span class=\"hljs-keyword\">from</span> <span class=\"hljs-string\">\"./config\"</span>\n<span class=\"hljs-keyword\">export</span> <span class=\"hljs-keyword\">default</span> {\n  <span class=\"hljs-attr\">filters</span>: {\n    <span class=\"hljs-attr\">$_filterType</span>: <span class=\"hljs-function\"><span class=\"hljs-params\">value</span> =&gt;</span> {\n      <span class=\"hljs-keyword\">return</span> typeConfig[value] || <span class=\"hljs-string\">\"type undefined\"</span>\n    }\n  }\n}\n</code></div></pre>\n<ol start=\"3\">\n<li>最后，在 main.js 中引入我们的 filters 方法集</li>\n</ol>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-keyword\">import</span> filter <span class=\"hljs-keyword\">from</span> <span class=\"hljs-string\">\"./filters\"</span>\nVue.mixin(filter)\n</code></div></pre>\n<ul>\n<li>接下来，我们就可以在 .vue 的模板文件中随意使用自定义函数了</li>\n</ul>\n<pre><div class=\"hljs\"><code class=\"lang-html\"><span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">template</span>&gt;</span>\n  <span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">div</span>&gt;</span>{{typeStatus | $_filterType}}<span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">div</span>&gt;</span>\n<span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">template</span>&gt;</span>\n</code></div></pre>\n<h2><a id=\"_74\"></a>包装插件</h2>\n<ul>\n<li>\n<p>接下来简单应用一下 Vue 中插件的制作方法。创建插件之后，就可以 Vue.use(myPlugin) 来使用了。</p>\n</li>\n<li>\n<p>首先附上插件的 <a href=\"https://cn.vuejs.org/v2/guide/plugins.html\" target=\"_blank\">官方文档</a></p>\n</li>\n<li>\n<p>一句话解释，包装的插件需要一个 install 的方法将插件装载到 Vue 上</p>\n</li>\n<li>\n<p>关于 Vue.use() 的源码</p>\n</li>\n</ul>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> <span class=\"hljs-title\">initUse</span> (<span class=\"hljs-params\">Vue</span>) </span>{\n  Vue.use = <span class=\"hljs-function\"><span class=\"hljs-keyword\">function</span> (<span class=\"hljs-params\">plugin</span>) </span>{\n    <span class=\"hljs-keyword\">var</span> installedPlugins = (<span class=\"hljs-keyword\">this</span>._installedPlugins || (<span class=\"hljs-keyword\">this</span>._installedPlugins = []));\n    <span class=\"hljs-keyword\">if</span> (installedPlugins.indexOf(plugin) &gt; <span class=\"hljs-number\">-1</span>) {\n      <span class=\"hljs-keyword\">return</span> <span class=\"hljs-keyword\">this</span>\n    }\n\n    <span class=\"hljs-comment\">// additional parameters</span>\n    <span class=\"hljs-keyword\">var</span> args = toArray(<span class=\"hljs-built_in\">arguments</span>, <span class=\"hljs-number\">1</span>);\n    args.unshift(<span class=\"hljs-keyword\">this</span>);\n    <span class=\"hljs-keyword\">if</span> (<span class=\"hljs-keyword\">typeof</span> plugin.install === <span class=\"hljs-string\">'function'</span>) {\n      plugin.install.apply(plugin, args);\n    } <span class=\"hljs-keyword\">else</span> <span class=\"hljs-keyword\">if</span> (<span class=\"hljs-keyword\">typeof</span> plugin === <span class=\"hljs-string\">'function'</span>) {\n      plugin.apply(<span class=\"hljs-literal\">null</span>, args);\n    }\n    installedPlugins.push(plugin);\n    <span class=\"hljs-keyword\">return</span> <span class=\"hljs-keyword\">this</span>\n  };\n}\n</code></div></pre>\n<ul>\n<li>很直观的就看到在最后调用了 plugin.install 的方法，我们要做的就是处理好这个 install 函数即可</li>\n</ul>\n<h3><a id=\"_105\"></a>代码</h3>\n<ol>\n<li>\n<p>config.js 文件依旧需要，这里保存了所有状态码对应的转义文字</p>\n</li>\n<li>\n<p>创建一个 myPlugin.js 文件，这个就是我们编写的插件</p>\n</li>\n</ol>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-keyword\">import</span> { typeConfig } <span class=\"hljs-keyword\">from</span> <span class=\"hljs-string\">\"./config\"</span>\n\nmyPlugin.install = <span class=\"hljs-function\">(<span class=\"hljs-params\">Vue</span>) =&gt;</span> {\n  Vue.mixin({\n    <span class=\"hljs-attr\">filters</span>: {\n      <span class=\"hljs-attr\">$_filterType</span>: <span class=\"hljs-function\">(<span class=\"hljs-params\">value</span>) =&gt;</span> {\n        <span class=\"hljs-keyword\">return</span> typeConfig[value] || <span class=\"hljs-string\">\"type undefined\"</span>\n      }\n    }\n  })\n}\n<span class=\"hljs-keyword\">export</span> <span class=\"hljs-keyword\">default</span> myPlugin\n</code></div></pre>\n<ol start=\"3\">\n<li>\n<p>插件的 install 函数的第一个参数为 Vue 的实例，后面还可以传入一些自定义参数</p>\n</li>\n<li>\n<p>在 main.js 文件中，我们不用 Vue.mixin() 转而使用 Vue.use() 来完成插件的装载</p>\n</li>\n</ol>\n<pre><div class=\"hljs\"><code class=\"lang-js\"><span class=\"hljs-keyword\">import</span> myPlugin <span class=\"hljs-keyword\">from</span> <span class=\"hljs-string\">\"./myPlugin\"</span>\nVue.use(myPlugin);\n</code></div></pre>\n<p>至此，我们已经完成了一个小小的插件，并将我们的状态码转义过滤器放入了所有的 Vue 实例中，在 .vue 的模板文件中，我们可以使用 {{ typeStatus | $_filterType }} 来进行状态码转义了</p>\n<h2><a id=\"_133\"></a>结语</h2>\n<p>Vue.mixin() 可以将自定义的方法混入所有的 Vue 实例中</p>\n`,
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
      directory: [],
    };
  },
  created () {
    document.title = `${this.blog['title']} - ${document.title}`;
  },
  mounted () {
    new Catalog({
      contentEl: 'blog',
      catalogEl: 'directory',
      selector: ['h1', 'h2', 'h3'],
      cool: false,
    });
  },
  components: {
    Header, Footer,
  },
};
</script>

<style lang='scss' scoped>
article {
  max-width: 700px;
  padding: 30px 25px 30px;
  margin: 70px auto 0;
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
  }
}
#directory {
  position: fixed;
  top: 40%;
  margin-left: 686px;
  svg {
    display: none;
  }
}
</style>
