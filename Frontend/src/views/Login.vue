<template>
    <div class="container mb-5">
        <b-container class="bv-example-row bv-example-row-flex-cols">
            <b-row align-v="center">
                <b-col></b-col>
                <b-col>
                    <center><img src="@/assets/icon.jpg" style="width:150px"></center>
                    <div>
                        <!-- <b-form @submit="onSubmit"> -->
                         <b-form>   
                            <b-form-input type="email" v-model="form.email" placeholder="이메일" required></b-form-input>
                            <b-form-input type="password" v-model="form.pwd" placeholder="비밀번호" required></b-form-input>
                            <div class="mt-4">
                                <b-button type="button" variant="info" style="width:100%" @click="onSubmit">로그인</b-button>
                            </div>
                        </b-form>
                        <div class="mt-3">
                            <center>
                            <!-- <a href="">비밀번호 재설정</a> -->
                            아이디가 없으신가요?
                             <a href="">회원가입</a>
                             </center>
                        </div>
                        <hr>
                    </div>
                </b-col>
                <b-col></b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
import {axios_contact} from "@/common.js"
export default {
    name: 'Login',

    data() {
        return {
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

    mounted() {
        
    },

    methods: {
        onSubmit() {
            //event.preventDefault()
            console.log(this.form);
            axios_contact({
                method : "get",
                url : "/user/"+this.form.email,
            }).then(({data})=>{
                if(this.form.pwd === data.pwd){
                    console.log("로그인 성공")
                    this.$store.commit("nowUser",this.form.email);
                    this.$store.commit("nowUserNickname",data.nickname);
                    this.form.email;
                    this.form.userno=data.userno;
                    this.form.nickname = data.nickname;
                    this.form.followingcount=data.followingcount;
                    this.form.followercount=data.followercount;
                    this.form.status=1;
                    //console.log(this.form)
                    axios_contact({
                        method : "put",
                        url : "/user/"+this.form.email,
                        data : this.form,
                    }).then(({data})=>{
                        if(data=="success"){
                            this.$router.push("/");
                        }
                    })
                }else{
                    console.log("로그인 실패")
                    alert("이메일 또는 비밀번호를 확인하세요.")
                }
            }).finally(()=>{
            });
        },
    },
};
</script>

<style scoped>

</style>