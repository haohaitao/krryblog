import Ax from '@/service/axios';
import qs from 'qs';

export default {
  // 实际上项目名称就叫 krryblog，而 Tomcat 设置默认首页就是 krryblog，所以 api 接口的访问路径也可以不需要加上 krryblog，默认匹配上 krryblog 这个项目
  // 而 api 接口这里访问路径前面加上 krryblog，是为了 proxyTable 代理的匹配路径统一为 krryblog
  fetchBlog (reqData) {
    return Ax.get('/krryblog/blog/getBlog', {params: reqData});
  },
  fetchBlogDetail (id) {
    return Ax.get(`/krryblog/blog/getBlogDetail/${id}`);
  },
  fetchClassify () {
    return Ax.get('/krryblog/blog/getClassify');
  },
  fetchBlogByClassifyId (id, reqData) {
    return Ax.get(`/krryblog/blog/getBlogByClassifyId/${id}`, {params: reqData});
  },
  addBlog (reqData) {
    return Ax.post('/krryblog/blog/addBlog', qs.stringify(reqData));
  },
  updateBlog (reqData) {
    return Ax.post('/krryblog/blog/updateBlog', qs.stringify(reqData));
  },
  updateCommonBlog (reqData) {
    return Ax.post('/krryblog/blog/updateCommonBlog', qs.stringify(reqData));
  },
  fetchLinkOrAbout (reqData) {
    return Ax.get('/krryblog/krry/getLinkOrAbout', {params: reqData});
  },
  fetchEditBlogDetail (id) {
    return Ax.get(`/krryblog/krry/getBlogDetail/${id}`);
  },
  fetchBlogByTag (reqData) {
    return Ax.get(`/krryblog/part/getBlogByTag`, {params: reqData});
  },
  fetchBlogByKeyword (reqData) {
    return Ax.get(`/krryblog/part/getBlogBykeyword`, {params: reqData});
  },
  fetchLogin (reqData) {
    return Ax.get(`/krryblog/krry/login`, {params: reqData});
  },
  updateUser (reqData) {
    return Ax.post(`/krryblog/krry/updateUser`, qs.stringify(reqData));
  },
  fetchAllBlog (reqData) {
    return Ax.get(`/krryblog/krry/getBlog`, {params: reqData});
  },
};
