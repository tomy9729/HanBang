<template>
  <div id="app">
    <nav-bar style="z-index: 2;" />

    <router-view style="padding-top : 150px; z-index: 2;"/>
    <Footer></Footer>
  </div>
</template>

<script>
import NavBar from "@/components/layout/navbar.vue";
import Footer from '@/components/layout/footer.vue';
export default {
  name : "App",
  components:{
    NavBar,
    Footer,
  },
};
</script>

<style>
/* #app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
} */
/* #app {
  font-family: 'myfont';
  src : 
  color: #2c3e50;
} */
@font-face {
    font-family: 'twayair';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_tway@1.0/twayair.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

#app {
  font-family: 'twayair';
  color: #2c3e50;
} 
</style>
