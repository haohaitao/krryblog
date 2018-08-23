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
3. 首页侧边栏可去掉，每行就显示三张卡片的博客

For a detailed explanation on how things work, check out the [guide](http://vuejs-templates.github.io/webpack/) and [docs for vue-loader](http://vuejs.github.io/vue-loader).
