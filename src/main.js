// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from '../store'
import ElementUI from 'element-ui';
import Vuex from 'vuex'
// import './theme/index.css';
import './theme/index.css'
Vue.use(Vuex)  //实际上调用了Vuex中的一个install的方法


import axios from 'axios';
// Set up Axios with Vue
Vue.prototype.$axios = axios;

Vue.use(ElementUI);

Vue.config.productionTip = false

//全局变量
Vue.prototype.baseUrl = "http://182.92.149.21" //"http://182.92.149.21:8002/user/login"182.92.149.21localhost
// Vue.prototype.baseUrl = "http://localhost"
Vue.prototype.port = 8002 //8800
// router.beforeEach((to, from, next) => {
//   // 获取store中的token
//   const token = this.$store.state.token;

//   // 验证用户是否已登录
//   if (to.matched.some(record => record.meta.requiresAuth)) {
//     if (!token) {
//       // 如果用户未登录，重定向到登录页面
//       next({ path: '/login' });
//     } else {
//       // 如果用户已登录，继续导航
//       next();
//     }
//   } else {
//     // 如果页面不需要登录验证，直接继续导航
//     next();
//   }
// });

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
