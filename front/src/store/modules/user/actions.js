import * as Types from './mutations-type.js';

export default {
  // 设置用户名
  async [Types.SETUSERNAME] ({ commit }, name) {
    commit(Types.SETUSERNAME, name);
  },
  // 设置用户 ID
  async [Types.SETUSERID] ({ commit }, id) {
    commit(Types.SETUSERID, id);
  },
};
