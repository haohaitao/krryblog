import * as Types from './mutations-type.js';

export default {
  // 设置博客分类
  [Types.SETCLASSIFY] (state, classifyList) {
    state.classifyList = classifyList;
  },
};
