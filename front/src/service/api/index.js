import Ax from '@/service/axios';
import qs from 'qs';

export default {
  fetchBlog () {
    return Ax.get('/krryblog/blog/getBlog');
  },
  fetchClassify () {
    return Ax.get('/krryblog/blog/getClassify');
  },
  addBlog (reqData) {
    return Ax.post('/krryblog/blog/addBlog', qs.stringify(reqData));
  },
};
