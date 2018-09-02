import Api from './api';

export default {
  async getBlog () {
    let res = await Api.fetchBlog();
    return res;
  },
};