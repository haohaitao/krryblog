// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import App from './App';
import router from './router';
import store from './store';
import iView from 'iview';
import mavonEditor from 'mavon-editor';
import 'mavon-editor/dist/css/index.css';
import 'iview/dist/styles/iview.css';
import 'animate.css';

Vue.config.productionTip = false;

Vue.use(iView);
Vue.use(mavonEditor);

router.beforeEach((to, from, next) => {
  let toRouteName = to.name;
  let username = sessionStorage.getItem('username');
  if (toRouteName === 'login') {
    if (username !== null) {
      // 已登录，进入列表页
      store.dispatch('user/SETUSERNAME', username);
      next({name: 'list'});
    } else {
      next();
    }
  } else if (to.meta.requireAuth) {
    // 如果需要登录通过的页面
    if (username !== null) {
      // 已登录，进入下一个页面
      store.dispatch('user/SETUSERNAME', username);
      next();
    } else {
      // 否则进入登录页面
      next({name: 'login'});
    }
  } else {
    next();
  }
});

router.afterEach((to, from) => {
  let title = to.meta.title;
  document.title = title;
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>',
});
