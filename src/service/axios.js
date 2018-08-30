'use strict';

import axios from 'axios';

axios.defaults.baseURL = 'http://localhost:3000';

axios.interceptors.request.use(config => {
  return config;
}, error => {
  console.log(error);
  return Promise.reject(error);
});

axios.interceptors.response.use(res => {
  const apiRes = res.data;
  if (apiRes.status === 404) {
    document.title = '404 - 找不到页面';
  }
  return apiRes;
}, async error => {
  console.dir(error);
  return Promise.reject(error);
});

export default axios;
