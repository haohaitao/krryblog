import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      component: () => import('../views/Home'),
      meta: {title: 'Krry blog - 你的美好，我都记得'},
    },
    {
      path: '*',
      redirect: '/',
    },
  ],
});
