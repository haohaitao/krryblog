// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import App from './App';
import router from './router';
import iView from 'iview';
import mavonEditor from 'mavon-editor';
import 'mavon-editor/dist/css/index.css';
import 'iview/dist/styles/iview.css';

Vue.config.productionTip = false;

Vue.use(iView);
Vue.use(mavonEditor);

router.beforeEach((to, from, next) => {
  let title = to.meta.title;
  document.title = title;
  next();
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
});
