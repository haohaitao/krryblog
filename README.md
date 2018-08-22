# krryblog

> My blog

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
- 配置 webpack，改写平时 vue-loader 的配置，形如：
```js
module: {
  rules: [
    {
      test: /\.vue$/,
      use: [
        {
          loader: 'vue-loader',
          options: {
              
          }
        },
        // 加上下面这行
        {
          loader: 'iview-loader',
          options: {
            prefix: false
          }
        }
      ]
    }
  ]
}
```

For a detailed explanation on how things work, check out the [guide](http://vuejs-templates.github.io/webpack/) and [docs for vue-loader](http://vuejs.github.io/vue-loader).
