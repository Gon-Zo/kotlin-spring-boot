// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from "./js/store";

import axios from "axios";

Vue.config.productionTip = false

axios.defaults.baseURL = 'http://localhost:8081'

axios.defaults.timeout = 10000

axios.interceptors.request.use(request => {
  console.log('request', request);
  return request;
}, error => {
  console.log(error);
  return Promise.reject(error);
});

axios.interceptors.response.use(response => {
  console.log('response', response);
  return response;
}, error => {
  console.log(error)
  return Promise.reject(error);
});


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store: store,
  components: {App},
  template: '<App/>'
})
