import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      component: () => import('../views/Home'),
      name: 'home',
      meta: {title: 'Krry blog - 你的美好，我都记得'},
    },
    {
      path: '/:id',
      component: () => import('../views/Detail'),
      name: 'detail',
      meta: {title: '你的美好，我都记得'},
    },
    {
      path: '/category/:id',
      component: () => import('../views/Category'),
      name: 'category',
      meta: {title: '你的美好，我都记得'},
    },
    {
      path: '/backstage/edit',
      component: () => import('../views/Backstage/Edit'),
      name: 'edit',
      meta: {title: '新增博客 - 你的美好，我都记得'},
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
