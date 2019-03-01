// import Vue from 'vue';
import Router from 'vue-router';

// Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      component: () => import('../views/Home'),
      name: 'home',
      meta: {title: 'Krryblog - 你的美好，我都记得'},
    },
    {
      path: '/:id(\\d+)',
      component: () => import('../views/Blog'),
      name: 'blog',
      meta: {title: '你的美好，我都记得'},
    },
    {
      path: '/category/:id(\\d+)',
      component: () => import('../views/Category'),
      name: 'category',
      meta: {title: '你的美好，我都记得'},
    },
    {
      path: '/tag/:name',
      component: () => import('../views/Tag'),
      name: 'tag',
      meta: {title: '你的美好，我都记得'},
    },
    {
      path: '/about',
      component: () => import('../views/About'),
      name: 'about',
      meta: {title: '你的美好，我都记得'},
    },
    {
      path: '/link',
      component: () => import('../views/Link'),
      name: 'link',
      meta: {title: '你的美好，我都记得'},
    },
    {
      path: '/search/:keyword',
      component: () => import('../views/Search'),
      name: 'search',
      meta: {title: '你的美好，我都记得'},
    },
    {
      path: '/backstage',
      component: () => import('../views/BackstageLogin'),
      name: 'login',
      meta: {title: '管理员登录 - 你的美好，我都记得', keepAlive: true},
    },
    {
      path: '/backstage/list',
      component: () => import('../views/BackstageList'),
      name: 'list',
      meta: {title: '后台中心 - 你的美好，我都记得', requireAuth: true},
    },
    {
      path: '/backstage/edit',
      component: () => import('../views/BackstageEdit'),
      name: 'edit',
      meta: {title: '新增博客 - 你的美好，我都记得', requireAuth: true},
    },
    {
      path: '*',
      component: () => import('../components/NotFound'),
      name: 'NotFound',
      meta: {title: '404 - 找不到页面'},
    },
  ],
  scrollBehavior (to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition;
    } else {
      return { x: 0, y: 0 };
    }
  },
});
