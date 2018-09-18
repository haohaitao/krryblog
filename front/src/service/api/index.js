import Ax from '@/service/axios';
import qs from 'qs';

export default {
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
  fetchLinkOrAbout (reqData) {
    return Ax.get('/krryblog/krry/getLinkOrAbout', {params: reqData});
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
  fetchAllBlog (reqData) {
    return Ax.get(`/krryblog/krry/getBlog`, {params: reqData});
  },
};
