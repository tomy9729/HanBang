<template>
    <div>
        <b-container class="bv-example-row">
          <b-row>
            <b-col cols="8">
              <div>
                <b-card
                  overlay
                  :img-src="rankList[0].img"
                  text-variant="white"
                  :title="rankList[0].subject"
                  sub-title="오늘의 1등 사진"
                  @click="test(rankList[0].boardno)"
                  style="cursor:pointer"
                >
                  <b-card-text>
                    {{rankList[0].ninkname}}
                  </b-card-text>
                  <b-button >보러가기</b-button>
                </b-card>
              </div>
             </b-col>
            <b-col cols="4">
              <div>
                <label for="">
                <b-card
                  overlay
                  :img-src="rankList[1].img"
                  text-variant="white"
                  :title="rankList[1].subject"
                  sub-title="오늘의 2등 사진"
                  @click="test(rankList[1].boardno)"
                  style="cursor:pointer"
                >
                  <b-card-text>
                    {{rankList[1].ninkname}}
                  </b-card-text>
                  <b-button >보러가기</b-button>
                </b-card>
                </label>
              </div>
              <div>
                <label for="">
                <b-card
                  overlay
                  :img-src="rankList[2].img"
                  text-variant="white"
                  :title="rankList[2].subject"
                  sub-title="오늘의 3등 사진"
                  @click="test(rankList[2].boardno)"
                  style="cursor:pointer"
                >
                  <b-card-text>
                    {{rankList[2].ninkname}}
                  </b-card-text>
                  <b-button >보러가기</b-button>
                </b-card>
                </label>
              </div>
            </b-col>
          </b-row>
      </b-container>
    </div>
</template>

<script>
import {axios_contact} from "@/common.js"
export default {
    name: 'Hometodayhouse',

    data() {
        return {
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