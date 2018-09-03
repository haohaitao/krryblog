import Api from './api';

export default {
  async getBlog () {
    let res = await Api.fetchBlog();
    return res;
  },
  async addBlog (reqData) {
    let res = await Api.addBlog(reqData);
    return res;
  },
};