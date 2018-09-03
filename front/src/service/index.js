import Api from './api';

export default {
  async getBlog () {
    let res = await Api.fetchBlog();
    return res;
  },
  async getClassify () {
    let res = await Api.fetchClassify();
    return res.data;
  },
  async addBlog (reqData) {
    let res = await Api.addBlog(reqData);
    return res;
  },
};
