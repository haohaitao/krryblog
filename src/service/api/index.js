import Ax from '@/service/axios';
// import qs from 'qs';

export default {
  fetchBlog () {
    return Ax.get('/index.php?c=banners_new&m=getUserTags&is_privilege=1');
  },
};