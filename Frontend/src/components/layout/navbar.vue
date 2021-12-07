<template>
    <div style="position:fixed; width:100%">
        <div style="background:#00C8F5;" class="p-3"></div>
        <div class="mb-5" >
            <b-navbar toggleable="lg" type="light" variant="light" >
                <b-navbar-brand>
                    <router-link to="/">
                    <img src="@/assets/icon.png" style="width:90px">
                    </router-link>
                </b-navbar-brand> 

                <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

                <b-collapse id="nav-collapse" is-nav>
                <b-navbar-nav >
                    <b-nav-item router-link to="/"><span :class="{select : homeselect}" @click="menu">홈</span></b-nav-item>
                    <b-nav-item router-link to="/following"><span :class="{select : folselect}" @click="menu">팔로윙</span></b-nav-item>
                    <b-nav-item router-link to="/board"><span :class="{select : photoselect}" @click="menu">사진</span></b-nav-item>
                    <!-- <b-nav-item router-link to="/house"><span :class="{select : houseselect}" @click="menu">집들이</span></b-nav-item> -->
                    <b-nav-item router-link to="/apt"><span :class="{select : dealselect}" @click="menu">매매정보</span></b-nav-item>
                </b-navbar-nav>

                <!-- Right aligned nav items -->
                <b-navbar-nav class="ml-auto">
                    <b-navbar-nav>
                        <b-nav-item v-if="isLogin()"><router-link to="/login" style="color : gray">로그인</router-link></b-nav-item>
                        <b-nav-item v-if="this.$store.state.userEmail  == null"><router-link to="/sign" style="color : gray">회원가입</router-link></b-nav-item>
                        <b-nav-item v-if="this.$store.state.userEmail  != null" @click="logout">로그아웃</b-nav-item>
                        <b-nav-item href="#">고객센터</b-nav-item>
                    </b-navbar-nav> 

                    <b-nav-item-dropdown right v-if="this.$store.state.userEmail  != null">
                        <!-- Using 'button-content' slot -->
                        <template #button-content>
                            <b-icon icon="person-fill"></b-icon>
                        </template>
                        <b-dropdown-item router-link to="/mypage">마이페이지</b-dropdown-item>
                        <b-dropdown-item href="#">고객센터</b-dropdown-item>
                    </b-nav-item-dropdown>

                    <b-dropdown text="글쓰기"  variant="info" v-if="this.$store.state.userEmail  != null">
                        <b-dropdown-item router-link to="/writeboard">사진 올리기</b-dropdown-item>
                        <!-- <b-dropdown-item href="#">집들이 글쓰기</b-dropdown-item> -->
                    </b-dropdown>
                </b-navbar-nav>
                </b-collapse>
            </b-navbar>
        </div>

    </div>
</template>

<script>
import {axios_contact} from "@/common.js"
export default {
    name: 'Navbar',
    components:{
    },
    data() {
        return {
            homeselect : true,
            folselect : false,
            photoselect : false,
            houseselect : false,
            dealselect : false,
            status : false,
        };
    },
    watch:{
    },
    created(){
    },
    mounted() {
    },

    methods: {
        menu(){
            if(this.homeselect) this.homeselect = !this.homeselect;
            if(this.folselect) this.folselect = !this.folselect;
            if(this.photoselect) this.photoselect = !this.photoselect;
            if(this.houseselect) this.houseselect = !this.houseselect;
            if(this.dealselect) this.dealselect = !this.dealselect;
        },
        logout(){
            this.$store.commit("nowUser",null);
            this.$router.push("/")
        },
        isLogin(){
            var email = this.$store.state.userEmail;
            if(email==null)return true;
            axios_contact({
                method : "get",
                url : "/user/"+email,
            }).then(({data})=>{
                console.log(data);
                if(data.status==1){
                    return true;
                }
                else return false;
            })
        },
    },
};
</script>

<style scoped>
    .select{
        
    }
</style>