<template>
    <div class="container">
        <div>
            <h3>좋아요</h3>
            <div>
                내가 좋아요한 사진이에요.
                <div class="mt-3">
                    <div>
                        <b-table
                        sort-by="번호"
                        @row-selected="moveToBoard"
                        selectable
                        select-mode="single"
                        id="my-table"
                        :items="myHeartList"
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
                            :total-rows="myHeartList.length"
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
            perPage: 5,
            currentPage: 1,
            email : this.$store.state.userEmail,
            myHeartList : [],
        };
    },
    created(){
        axios_contact({
            method : "get",
            url : "/heart/boardlist/"+this.email,
        }).then(({data})=>{
            console.log(data)
            const that =this;
            for(var i=0;i<data.length;i++){
                axios_contact({
                    method : "get",
                    url : "/board/"+data[i].boardno,
                }).then(({data})=>{
                    var board = [];
                    board.번호 = data.boardno;
                    board.제목 = data.subject;

                    that.myHeartList.push(board)
                })
            }
        })
    },

    mounted() {
        
    },

    methods: {
        moveToBoard(items){
            console.log(items)
            this.$router.push("/boarddetail/"+items[0].번호)
        },
    },
};
</script>

<style scoped>

</style>