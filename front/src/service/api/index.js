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
  addBlog (reqData) {
    return Ax.post('/krryblog/blog/addBlog', qs.stringify(reqData));
  },
};
