
import Vue from 'vue';
import Vuex from 'vuex';
import logger from 'vuex/dist/logger'; // logger是一个日志插件

import blog from './modules/blog';

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    blog,
  },
  plugins: [logger()], // 导入日志插件
  strict: true, // 严格模式，只能通过 mutation 来更改状态
});
