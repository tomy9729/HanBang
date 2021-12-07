<template>
    <div class="container mb-5">
        <b-container class="bv-example-row bv-example-row-flex-cols">
            <b-row align-v="center">
                <b-col></b-col>
                <b-col>
                    <center><img src="@/assets/icon.jpg" style="width:150px"></center>
                    <div>
                        <b-form>
                            <b-form-group
                                id="input-group-1"
                                label="이메일"
                                label-for="input-1"
                            >
                                <b-form-input
                                id="input-1"
                                v-model="form.email"
                                type="email"
                                placeholder="이메일"
                                required
                                ></b-form-input>
                            </b-form-group>
                            <b-form-group
                                id="input-group-2"
                                label="비밀번호"
                                label-for="input-2"
                                description="영문, 숫자를 포함한 8자리 이상의 비밀번호를 입력해주세요."
                            >
                                <b-form-input
                                id="input-2"
                                v-model="form.pwd"
                                type="password"
                                placeholder="비밀번호"
                                required
                                ></b-form-input>
                            </b-form-group>
                            <b-form-group
                                id="input-group-3"
                                label="비밀번호 확인"
                                label-for="input-3"
                                
                            >
                                <b-form-input
                                id="input-3"
                                v-model="form.pwdcheck"
                                type="password"
                                placeholder="비밀번호 확인"
                                required
                                ></b-form-input>
                            </b-form-group>
                            <b-form-group
                                id="input-group-4"
                                label="닉네임"
                                label-for="input-4"
                                description="다른 유저와 겹치지 않는 별명을 입력해주세요. (2~15자)"
                            >
                                <b-form-input
                                id="input-4"
                                v-model="form.nickname"
                                type="text"
                                placeholder="별명"
                                required
                                ></b-form-input>
                            </b-form-group>
                            <div class="mt-4">
                                <b-button type="button" variant="info" style="width:100%" @click="onSubmit">회원가입</b-button>
                            </div>
                        </b-form>
                        <hr>
                        <center>이미 아이디가 있으신가요? <router-link to="/login" >로그인</router-link></center>
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
    name: 'HangbangSign',

    data() {
        return {
            form:{
                userno:0,
                email:"",
                pwd:"",
                pwdcheck:"",
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
            if(this.form.pwd != this.form.pwdcheck){
                alert("비밀번호가 다릅니다.")
                return;
            }
            axios_contact({
                method : "post",
                url : "/user",
                data: this.form,
            }).then(({data})=>{
                //console.log(data)
                if(data=="success"){
                    this.$router.push("/login");
                }
            })
        },
    },
};
</script>

<style scoped>

</style>