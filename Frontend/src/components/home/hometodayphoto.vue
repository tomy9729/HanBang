<template>
    <div class="mt-5">
        
        <b-container class="bv-example-row">
            <p class="h3 mb-2">오늘의 인기사진 <b-icon icon="camera"></b-icon></p>
            <b-row  class="mb-3" v-for="(r,index) in rowno" :key="index">
                <b-col v-for="(n,index) in colno" :key="index">
                    <div>
                        <b-card
                        style="height:250px; cursor:pointer;"
                        img-height="250px"
                        overlay
                        :img-src="rankList[(r-1)*4+(n-1)+3].img"
                        text-variant="white"
                        :title="rankList[(r-1)*4+n+2].subject"
                        @click="test(rankList[(r-1)*4+n+2].boardno)"
                        >
                        <b-card-text>
                            {{rankList[(r-1)*4+n+2].nickname}}
                        </b-card-text>
                        </b-card>
                    </div>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
import {axios_contact} from "@/common.js"
export default {
    name: 'Hometodayphoto',

    data() {
        return {
            rowno : 2,
            colno : 4,
            rankList : [],
        };
    },
    created(){
        axios_contact({
        method : "get",
        url : "/board/rank3",
      }).then(({data})=>{
        this.rankList=data;
        for(var i=0;i<this.rankList.length;i++){
          this.setImg(i)
        }
      })
    },
    mounted() {
        
    },

    methods: {
        setImg(i){
        axios_contact({
            method : "get",
            url : "/image/"+this.rankList[i].img,
          }).then(({data})=>{
            // console.log(data)
            //console.log(this.rankList[0].img)
            //console.log(this.rankList[i].img)
            this.rankList[i].img=data
          })
      },
        test(boardno){
            this.$router.push("/boarddetail/"+boardno)
        },
    },
};
</script>

<style scoped>

</style>