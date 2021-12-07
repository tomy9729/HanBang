<template>
    <div class="container mb-5">
        <h3>설정</h3>
        <b-container class="bv-example-row bv-example-row-flex-cols">
            <b-row align-v="center">
                <b-col></b-col>
                <b-col>
                    <div>
                        <b-form>
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
                            <div class="mt-4">
                                <b-button type="button" variant="info" style="width:100%" @click="onSubmit">설정완료</b-button>
                            </div>
                        </b-form>
                        <hr>
                        <center>탈퇴하시겠어요? <span style="color:red;cursor:pointer" @click="deleteUser">탈퇴하기</span></center>
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
                email:this.$store.state.userEmail,
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
        deleteUser(){
            console.log(this.form.email)
            if(confirm("계정을 탈퇴하시겠습니까?")){
                axios_contact({
                method : "delete",
                url : "/user/"+this.form.email,
                }).then(({data})=>{
                    data;
                    //console.log(data)
                    this.$store.commit("nowUser",null);
                    this.$router.push("/")
                })
            }
            
        },
    },
};
</script>

<style scoped>

</style>