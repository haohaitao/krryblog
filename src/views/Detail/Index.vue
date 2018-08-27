<template>
  <main>
    <Header></Header>
    <article>
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
      <div class="content" v-html="blog.description"></div>
    </article>
    <Footer></Footer>
  </main>
</template>

<script>
import Header from '@/components/Header';
import Footer from '@/components/Footer';
export default {
  data () {
    return {
      blog: {
        title: 'setTimeout 参数为0的问题',
        description: '<h2><a id=\"_2\"></a>问题</h2>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-keyword\">for</span>(<span class=\"hljs-keyword\">var</span> val <span class=\"hljs-keyword\">of</span> [<span class=\"hljs-number\">1</span>,<span class=\"hljs-number\">2</span>,<span class=\"hljs-number\">3</span>]){\n  setTimeout(<span class=\"hljs-function\"><span class=\"hljs-params\">()</span> =&gt;</span> {\n    <span class=\"hljs-built_in\">console</span>.log(val)\n  },<span class=\"hljs-number\">0</span>);\n  <span class=\"hljs-built_in\">console</span>.log(val);\n}\n</code></div></pre>\n<ul>\n<li>\n<p>控制台打印的情况 <br/><br />\n<img src=\"https://raw.githubusercontent.com/Krryxa/WORK-LEARNING/master/images/p_4.png\" alt=\"\" /></p>\n</li>\n<li>\n<p>虽然setTimeout函数在每次循环的开始就调用了，但是却被放到循环结束才执行，循环结束，i=3,接连打印了3次3。</p>\n</li>\n<li>\n<p>这里涉及到javascript单线程执行的问题：javascript在浏览器中是单线程执行的，必须在完成当前任务后才执行队列中的下一个任务。</p>\n</li>\n<li>\n<p>另外，对于javascript还维护着一个setTimeout队列，未执行的setTimeout任务就按出现的顺序放到setTimeout队列，等待普通的任务队列中的任务执行完才开始按顺序执行积累在setTimeout中的任务。</p>\n</li>\n<li>\n<p>所以在这个问题里，会先打印1 2 3，而将setTimeout任务放到setTimeout任务队列，等循环中的打印任务执行完了，才开始执行setTimeout队列中的函数，所以在最后会接着打印3次3。</p>\n</li>\n<li>\n<p>由此，可以知道虽然设置为0秒后执行任务，实际上是大于0秒才执行的，</p>\n</li>\n<li>\n<p>用处就在于我们可以改变任务的执行顺序！因为浏览器会在执行完当前任务队列中的任务，再执行setTimeout队列中积累的的任务。</p>\n</li>\n<li>\n<p>通过设置任务在延迟到0s后执行，就能改变任务执行的先后顺序，延迟该任务发生，使之异步执行。</p>\n</li>\n</ul>\n<h2><a id=\"_var__let_1_2_3_1_2_3_22\"></a>如果将上例的 var 改成 let，打印的就是 1 2 3 1 2 3</h2>\n<ul>\n<li>原因就是 let 是块级作用域，在 setTimeout 这个执行环境中，第一次循环的 val 是 1，第二次 2，第三次 3，后面的 val 无法覆盖前面 val，（块级作用域）</li>\n</ul>\n',
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
    };
  },
  created () {
    document.title = `${this.blog['title']} - ${document.title}`;
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
  margin: 10px auto 0;
  background-color: #fff;

  .art-header {
    padding-bottom: 20px;
    border-bottom: 1px dashed #b7b7b7;

    h1 {
      font-size: 21px;
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
}
</style>
<style lang="scss">
article {
  .content {
    ul li {
      list-style: initial;
    }
  }
}
</style>
