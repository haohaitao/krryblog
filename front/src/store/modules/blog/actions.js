import * as Types from './mutations-type.js';
import Service from '@/service';

export default {
  // 设置博客分类
  async [Types.SETCLASSIFY] ({ commit }) {
    let classifyList = await Service.getClassify();
    commit(Types.SETCLASSIFY, classifyList);
  },
};
