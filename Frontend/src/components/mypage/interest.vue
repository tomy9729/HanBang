<template>
    <div class="container">
        <div>
            <h3>관심지역</h3>
            <div>
                내가 관심있는 아파트에요.
                <div class="mt-3">
                    <div>
                        <b-table
                        sort-by="번호"
                        @row-selected="moveToApt"
                        selectable
                        select-mode="single"
                        id="my-table"
                        :items="myAptList"
                        :per-page="perPage"
                        :current-page="currentPage"
                        small
                        hover
                        ></b-table>
                    </div>
                     <b-row>
                        <b-col></b-col>
                        <b-col>
                            <div class="mt-4">
                        <b-pagination
                            style="postion : absolute"
                            v-model="currentPage"
                            :total-rows="myAptList.length"
                            :per-page="perPage"
                            aria-controls="my-table"
                            ></b-pagination>
                        </div>
                        </b-col>
                        <b-col></b-col>
                    </b-row>
                    
                </div>
            </div>
        </div>
        <!-- <div>
            <h3>집들이</h3>
            <div>
                내가 올린 집들이에요.
            </div>
        </div> -->
    </div>
</template>

<script>
import {axios_contact} from "@/common.js"
export default {
    name: 'HangbangDefault',

    data() {
        return {
            userno:0,
            perPage: 5,
            currentPage: 1,
            email : this.$store.state.userEmail,
            myAptList : [],
        };
    },
    created(){
        axios_contact({
            method : "get",
            url : "/user/"+this.email
        }).then(({data})=>{
            this.userno = data.userno;
            const that = this;
            axios_contact({
                method : "get",
                url : "/interest/list/"+that.userno
            }).then(({data})=>{
                console.log(data)
                for(var i =0;i<data.length;i++){
                    axios_contact({
                        method : "get",
                        url : "/apt/info/"+data[i].aptCode
                    }).then(({data})=>{
                        console.log(data)
                        var temp = [];
                        temp.번호=data.aptCode;
                        temp.이름=data.aptName;
                        temp.동=data.dongName;
                        temp.지번=data.jibun;
                        temp.동코드=data.dongCode
                        that.myAptList.push(temp)
                    })
                }
            })
        })
    },

    mounted() {
        
    },

    methods: {
        moveToApt(items){
            console.log(items)
            this.$router.push("/aptdetail/"+items[0].동코드+"/"+items[0].번호)
        },
    },
};
</script>

<style scoped>

</style>