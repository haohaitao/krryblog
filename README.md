# krryblog

> My blog

## 从零搭建一个博客系统

> 可以说这个项目是把我从实习阶段所总结出来的、包括以前的经验和知识，做的一个项目

## 技术栈
1. vue、iview、markdown
2. java、ssm、maven
3. mysql

## Build Setup

``` bash
# install dependencies
npm install

# serve with hot reload at localhost:8080
npm run dev

# build for production with minification
npm run build

# build for production and view the bundle analyzer report
npm run build --report

# run unit tests
npm run unit

# run e2e tests
npm run e2e

# run all tests
npm test
```

## 路程
8月22号：搭建 vue 脚手架，开始开发前端界面<br>
9月02号：开始编写 java 后台，一边写后台接口，一边前端对接接口<br>
9月17号：博客功能基本完成<br>
9月18号：尝试上线<br>

## 安装依赖
```bash
npm install stylus-loader css-loader style-loader --save-dev
npm install axios
npm install vuex --save
npm install sass-loader --save
npm install node-sass --save
```
- 本项目使用 iview 的 ui 框架
```bash
npm install iview --save
npm install iview-loader --save-dev
```
- iView 将标签渲染为原生 html 标签时，由于这些标签是自闭合的，所以有 end 标签会报错，在 .eslintrc.js 多配置一项：
```js
'vue/no-parsing-error': [2, { 'x-invalid-end-tag': false }],
```
## 两种风格
1. 无侧边栏，每行三张卡片
2. 有侧边栏，每行一张卡片 （暂时废弃）


## 小功能
> 整个页面模块卡片加载的时候，动画加载，翻转加载
1. 更改鼠标样式，鼠标点击时冒爱心
```js
// 需要在 webpack.base.conf.js 中设置多一个 rules cur
{
  test: /\.(png|jpe?g|gif|svg|cur)(\?.*)?$/,
  loader: 'url-loader',
  options: {
    limit: 10000,
    name: utils.assetsPath('img/[name].[hash:7].[ext]')
  }
},
```
2. 首页侧边栏可放个人简介、搜索、友情链接、最热文章（已废弃此条）
3. 单页面项目，点击跳转的时候，做一个顶部的加载条显示
4. 回到顶部
5. 根据滚动条上滑出现吸顶盒，下滑隐藏
6. markdown 语法保存，保存两份，一份是原始 markdown 语法，一份是转义后的 html
7. 使用了 progress-catalog 插件自动生成目录
8. 所有页面都使用 fadeIn 动画显示 animation: fadeIn .6s linear;
9. 自己封装了图片点击放大的插件、生成目录的插件
10. 将“关于”、“友链”文章的数据库状态设置为 不发布，这样在浏览博客就不会查到“关于”的文章，只有点击页面顶部“关于”才会查询出来
11. 做一个后台系统，存放所有的博客文章，包括状态为 不发布 的“关于”文章，这样可编辑和管理所有博客
12. 使用骨架屏，异步加载，慢慢浮现的动画依然不会延迟
13. 使用逻辑删除，isDelete 设置为 1，表示已删除

##  图片长方形：280*230
1. 因为使用 background 来装载博客图片，使用 filter: blur(3px); 使背景图片虚化，当准备做图片懒加载的时候，使用了 ::before{} 在被选元素的前面插入内容，且设置 z-index: -1，使用 content 属性定义插入内容的文本信息，这样子来做图片懒加载，当背景图片加载完成，会自动覆盖 ::before{} 的内容
2. 点击分页的时候，加载数据完成后，section 先 display: none，再 display: block; 才会显示动画

## 数据结构
1. 查询详细博客内容的数据：
```js
{
  blog: {
    title: 'Vue网站后台系统',
    description: ``,
    blogId: '2015',
    createTime: '2018-02-03',
    updateTime: '2018-03-21',
    hit: 468,
    comment: 20,
    classify: '技术',
    classifyId: '1',
    label: ['JavaScript', 'vue', 'html']
  },
  status: 200
}
```

## 问题
1. 如果出现mybatis查询中文没有结果集的情况，或者查询中文出现报错，在jdbc.propersities文件里的db.url=数据库地址加上?useUnicode=true&characterEncoding=UTF-8
2. 若页面已经被 keepAlive 了，那将获取路由参数的钩子应该是 activated，created 和 mounted 钩子无法获取

## 部署
1. 文件路径出错：在 config 的 index.js 下 build 的设置：assetsPublicPath: './',
2. 字体路径出错：
```
真实路径应该是
xxx/static/fonts/icomoon.0125455.woff 
浏览器实际加载路径为：
xxx/static/css/static/fonts/icomoon.0125455.woff 
解决方法：
webpack 配置问题
在 build/webpack.prod.conf.js 中 extract :true 改为 fasle即可。
```
3. css 添加的背景中引用的图片路径出错
在 build 文件夹下 找 utils.js 配置加上 publicPath: '../../',
```js
// Extract CSS when that option is specified
// (which is the case during production build)
if (options.extract) {
  return ExtractTextPlugin.extract({
    use: loaders,
    publicPath: '../../', // 加上这一行
    fallback: 'vue-style-loader'
  })
} else {
  return ['vue-style-loader'].concat(loaders)
}
```
4. 自定义动画不执行，在 vue 项目中找到 build 文件夹下的 vue-loader.conf.js，将 extract：isProduction  改为 extract：false
5. 开发环境和生产环境的接口地址问题
在 config 下 dev.env.js 是配置开发环境，prod.env.js 是配置生产环境<br>
开发环境使用 proxyTable 代理接口，所以不用管接口问题<br>
生产环境时，与线上的接口不产生跨域问题，所以在 prod.env.js 配置：
```js
'use strict'
module.exports = {
  NODE_ENV: '"production"',
  API_ROOT: '"https://www.ainyi.com"'
}

```
所以在 axios 配置：
```js
axios.defaults.baseURL = process.env.NODE_ENV === 'production' ? process.env.API_ROOT : '';
```
6. 路由变成 history 模式

7. 将 vue 打包后输出的 dist 文件夹下面的文件拷贝到 后台接口项目目录结构的 src/main/webapp/ 下面