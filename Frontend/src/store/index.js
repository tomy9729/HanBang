import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    userEmail: null,
    ninkname : null,
  },
  mutations: {
    nowUser(state, payload) {
      state.userEmail = payload;
    },
    nowUserNickname(state, payload) {
      state.ninkname = payload;
    },
  },
  actions: {},
  modules: {},
});
