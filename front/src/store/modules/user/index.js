import actions from './actions';
import mutations from './mutations';

const state = {
  username: '',
};

// 计算属性
const getters = {
  username: state => state.username, // this.$store.getters['user/classify'];
};

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations,
};
