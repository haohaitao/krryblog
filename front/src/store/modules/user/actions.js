import * as Types from './mutations-type.js';

export default {
  // 设置用户名
  async [Types.SETUSERNAME] ({ commit }, name) {
    commit(Types.SETUSERNAME, name);
  },
};
