import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Following from "../views/Following.vue"
import Board from "../views/Photo.vue"
import House from "../views/House.vue"
import Apt from "../views/Apt.vue"
import Login from "../views/Login.vue"
import Sign from "../views/Sign.vue"
import Aptdetail from "../views/aptdealdetail.vue"
import Mypage from "../views/Mypage.vue"
import WriteBoard from "../views/WriteBoard.vue"
import BoardDetail from "../views/BoardDetail.vue"

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/following",
    name: "Following",
    component: Following,
  },
  {
    path: "/board",
    name: "Board",
    component: Board,
  },
  {
    path: "/house",
    name: "House",
    component: House,
  },
  {
    path: "/apt",
    name: "Apt",
    component: Apt,
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
  {
    path: "/sign",
    name: "Sign",
    component: Sign,
  },
  {
    path: "/aptdetail/:dongCode/:aptCode",
    name: "Aptdetail",
    component: Aptdetail,
  },
  {
    path: "/mypage",
    name: "Mypage",
    component: Mypage,
  },
  {
    path: "/writeboard",
    name: "WriteBoard",
    component: WriteBoard,
  },
  {
    path: "/boarddetail/:boardno",
    name: "BoardDetail",
    component: BoardDetail,
  },
  
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
