import Ax from '@/service/axios';
import qs from 'qs';

export default {
  fetchBlog () {
    return Ax.get('/krryblog/blog/getBlog');
  },
  fetchBlogDetail (id) {
    return Ax.get(`/krryblog/blog/getBlogDetail/${id}`);
  },
  fetchClassify () {
    return Ax.get('/krryblog/blog/getClassify');
  },
  fetchBlogByClassifyId (id) {
    return Ax.get(`/krryblog/blog/getBlogByClassifyId/${id}`);
  },
  addBlog (reqData) {
    return Ax.post('/krryblog/blog/addBlog', qs.stringify(reqData));
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
};
