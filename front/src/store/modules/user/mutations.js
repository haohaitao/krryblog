import * as Types from './mutations-type.js';

export default {
  // 设置博客分类
  [Types.SETUSERNAME] (state, username) {
    state.username = username;
  },
};
