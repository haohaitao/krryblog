# krryblog

> My blog

## 从零搭建一个博客系统

## 技术栈
1. vue、iview
2. java、ssm
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
2. 有侧边栏，每行一张卡片


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
2. 首页侧边栏可放个人简介、搜索、友情链接、最热文章
3. 单页面项目，点击跳转的时候，做一个顶部的加载条显示
4. 回到顶部
5. 根据滚动条上滑出现吸顶盒，下滑隐藏
6. markdown 语法保存，保存两份，一份是原始 markdown 语法，一份是转义后的 html
7. 使用了 progress-catalog 插件自动生成目录
8. 所有页面都使用 fadeIn 动画显示 animation: fadeIn .6s linear;
9. 自己封装了图片点击放大的插件、生成目录的插件
10. 将“关于”文章的数据库状态设置为 不发布，这样在浏览博客就不会查到“关于”的文章，只有点击页面顶部“关于”才会查询出来
11. 做一个后台系统，存放所有的博客文章，包括状态为 不发布 的“关于”文章，这样可编辑和管理所有博客

##  图片正方形
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
