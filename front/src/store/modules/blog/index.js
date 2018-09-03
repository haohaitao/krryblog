import actions from './actions';
import mutations from './mutations';

const state = {
  classifyList: [],
};

// 计算属性
const getters = {
  classify: state => state.classifyList, // this.$store.getters['blog/classify'];
};

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations,
};
