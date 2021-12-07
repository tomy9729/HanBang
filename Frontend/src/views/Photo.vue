<template>
    <div class="container mb-5" >
        <div>
            <b-container class="bv-example-row" >
                <b-row class="mb-5" v-for="(row, index) in boardes" :key="index">
                    <b-col v-for="(board, index) in row" :key="index">
                        <b>{{board.nickname}}</b>
                        <b-card
                            style="height:250px; cursor:pointer;"
                            img-height="250px"
                            overlay
                            :img-src="board.img"
                            text-variant="white"
                            :title="board.subject"
                            @click="moveToDetail(board.boardno)"
                        >
                        </b-card>
                    <b-container class="bv-example-row">
                        <b-row class="mt-2">
                            {{board.contentShort}}
                        </b-row>
                    </b-container>
                    </b-col>
                </b-row>
            </b-container>
        </div>
    </div>
</template>

<script>
import {axios_contact} from "@/common.js"
export default {
    name: 'HangbangPhoto',

    data() {
        return {
            boardes : [],
        };
    },

    created(){
        axios_contact({
            methods : "get",
            url : "/board",
        }).then(({data})=>{
            //console.log(data)
            for(var i=0;i<data.length/4;i++){
                var deck = [];
                for(var j=0;j<4;j++){
                    if(i*4+j < data.length){
                        if(data[i*4+j].content.length>17){
                            data[i*4+j].contentShort=data[i*4+j].content.substring(0,17)+"..."
                        }
                        else{
                            data[i*4+j].contentShort=data[i*4+j].content
                        }
                        deck.push(data[i*4+j]);
                    }
                }
                this.boardes.push(deck);
            }
            for(i=0;i< this.boardes.length;i++){
                for(j=0;j<4;j++){
                    this.getImage(this.boardes[i][j].img,i,j);
                }
            }
        })
    },
    mounted() {
        
    },

    methods: {
        getImage(imgNo,i,j){
            //console.log(imgNo);
            axios_contact({
                method : "get",
                url : "/image/"+imgNo,
            }).then(({data})=>{
                //console.log(data)
                this.boardes[i][j].img=data;
            })
        },
        moveToDetail(boardno){
            //console.log(boardno)
            this.$router.push("/boarddetail/"+boardno);
        },
    },
    
};
</script>

<style scoped>

</style>