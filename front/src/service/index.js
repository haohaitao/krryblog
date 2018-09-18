import Api from './api';

export default {
  async getBlog (reqData) {
    let res = await Api.fetchBlog(reqData);
    return res;
  },
  async getBlogDetail (id) {
    let res = await Api.fetchBlogDetail(id);
    return res;
  },
  async getClassify () {
    let res = await Api.fetchClassify();
    return res.data;
  },
  async getBlogByClassifyId (id, reqData) {
    let res = await Api.fetchBlogByClassifyId(id, reqData);
    return res;
  },
  async addBlog (reqData) {
    let res = await Api.addBlog(reqData);
    return res;
  },
  async updateBlog (reqData) {
    let res = await Api.updateBlog(reqData);
    return res;
  },
  async getLinkOrAbout (reqData) {
    let res = await Api.fetchLinkOrAbout(reqData);
    return res;
  },
  async getBlogByTag (reqData) {
    let res = await Api.fetchBlogByTag(reqData);
    return res;
  },
  async getBlogByKeyword (reqData) {
    let res = await Api.fetchBlogByKeyword(reqData);
    return res;
  },
  async getLogin (reqData) {
    let res = await Api.fetchLogin(reqData);
    return res;
  },
  async getAllBlog (reqData) {
    let res = await Api.fetchAllBlog(reqData);
    return res;
  },
};
