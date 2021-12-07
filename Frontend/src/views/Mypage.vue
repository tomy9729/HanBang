<template>
    <div class="container mb-5">
        <b-container class="bv-example-row">
            <b-row >
                <b-col cols="3">
                    <div class="text-center">
                        <b-card
                            header-bg-variant="dark"
                            :title="form.nickname"
                        >
                            <b-card-text>
                                <b-icon class="h1" icon="person" variant="secondary" style="width: 120px; height: 120px;"></b-icon><br>
                                <span style="cursor:pointer">팔로워 {{form.followercount}}</span> 
                                | 
                                <span style="cursor:pointer">팔로잉 {{form.followingcount}}</span><br>
                                <b-button class="mt-2" variant="outline-secondary" @click="changeToSetting">설정</b-button>
                                <hr>
                                <b-container class="bv-example-row">
                                    <b-row>
                                        <b-col style="cursor:pointer" @click="changeToPhoto">
                                            <b-icon  class="h5" icon="instagram" variant="primary" ></b-icon><br>
                                            사진
                                        </b-col>
                                        <b-col style="cursor:pointer" @click="changeToInterest" >
                                            <b-icon  class="h5" icon="star" variant="warning" ></b-icon><br>
                                            관심
                                        </b-col>
                                        <b-col style="cursor:pointer" @click="changeToHeart">
                                            <b-icon  class="h5" icon="heart" variant="danger" ></b-icon><br>
                                            하트
                                        </b-col>
                                    </b-row>
                                </b-container>
                            </b-card-text>
                        </b-card>
                    </div>
                </b-col>
                <b-col >
                    <div>
                        <component v-bind:is="currentTabComponent"></component>
                    </div>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
import {axios_contact} from "@/common.js"
import Default from "@/components/mypage/default.vue";
import Setting from "@/components/mypage/setting.vue";
import Heart from "@/components/mypage/heart.vue";
import Interest from "@/components/mypage/interest.vue";
export default {
    name: 'HangbangMypage',
    components : {
        Default,
        Setting,
        Heart,
        Interest,
    },
    data() {
        return {
            currentTabComponent : Default,
            de:true,
            follower : false,
            following:true,
            interest:false,
            heart:false,
            form:{
                userno:0,
                email:"",
                pwd:"",
                nickname:"",
                followingcount:0,
                followercount:0,
                status:0,
            },
        };
    },
    created(){
        this.setUser();
    },
    mounted() {
        
    },

    methods: {
        setUser(){
            this.form.email = this.$store.state.userEmail;
            if(this.form.email==null)return;
            axios_contact({
                method : "get",
                url : "/user/"+this.form.email,
            }).then(({data})=>{
                this.form = data;
                //console.log(this.form)
                axios_contact({
                    method : "get",
                    url : "/follow/fromcount/"+this.form.email,
                }).then(({data})=>{
                    this.form.followingcount=data;
                })
                axios_contact({
                    method : "get",
                    url : "/follow/tocount/"+this.form.email,
                }).then(({data})=>{
                    this.form.followercount=data;
                })
            })
            return true;
        },
        changeToSetting(){
            this.currentTabComponent = Setting
        },
        changeToPhoto(){
            this.currentTabComponent = Default  
        },
        changeToHeart(){
            this.currentTabComponent = Heart  
        },
        changeToInterest(){
            this.currentTabComponent = Interest  
        }
    },
};
</script>

<style scoped>

</style>