<template>
  <div class="home">
    <div class="container">
      <HomeTodayHouse></HomeTodayHouse>
      <HomeIconList></HomeIconList>
      <HomeTodayPhoto></HomeTodayPhoto>
      <HomeInviteFriend></HomeInviteFriend>

    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import HomeTodayHouse from "@/components/home/hometodayhouse.vue";
import HomeTodayPhoto from "@/components/home/hometodayphoto.vue";
import HomeInviteFriend from "@/components/home/homeinvitefriend.vue";
import HomeIconList from "@/components/home/homeiconlist.vue";
export default {
  name: "Home",
  components: {
    HomeTodayHouse,
    HomeTodayPhoto,
    HomeInviteFriend,
    HomeIconList,
  },
  methods:{
    
  },
};
</script>
