<template>
    <div class="container mb-5">
        <b-container class="bv-example-row bv-example-row-flex-cols">
            <b-row>
                <b-col align-self="center">
                    <img :src="img" style="width:100%; height:300px" id="aptimg">
                </b-col>
                <b-col align-self="stretch">
                    <div>
                        <b-container class="bv-example-row">
                            <b-row>
                                <b-col sm="8"><h2>{{aptInfo.aptName}}</h2></b-col>
                                <b-col sm="4">
                                    <b-icon class="h4" icon="star" variant="dark" v-if="star" @click="interest" style="cursor:pointer"></b-icon>
                                    <b-icon class="h4" icon="star-fill" variant="warning" v-else  @click="nointerest" style="cursor:pointer"></b-icon>
                                </b-col>
                            </b-row>
                        </b-container>
                        
                        <div class="mt-3">
                            <b-icon icon="mailbox2"  variant="danger"></b-icon>
                            {{dongInfo.sidoName}} {{dongInfo.gugunName}} {{aptInfo.dongName}} {{aptInfo.jibun}}<hr>
                        </div>
                        <div>
                            <b-icon icon="alarm-fill" variant="info"></b-icon>
                            {{aptInfo.buildYear}}년에 건축되었어요.<br>
                            <b-icon icon="house-fill" variant="dark"></b-icon>
                            {{aptDeal[0].area}}평 이에요.<hr>
                        </div>
                        <div>
                            <b-icon icon="arrow-bar-up" variant="success"></b-icon>
                            최고 거래가는 {{maxDealAmount()}}만원 이에요.<br>
                            <b-icon icon="arrow-bar-down" variant="success"></b-icon>
                            최저 거래가는 {{minDealAmount()}}만원 이에요.<br>
                            <b-icon icon="cart4" variant="warning"></b-icon>
                            가장 최근 거래일은 {{recentDealDate()}}이에요.<br>
                            <b-icon icon="shop" variant="primary"></b-icon>
                            지난 1년간 {{aptDeal.length}}번 거래되었어요.
                        </div>
                    </div>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
import {axios_contact} from "@/common.js"
export default {
    name: 'HangbangAptdealdetail',
    data() {
        return {
            userno : 0,
            email : this.$store.state.userEmail,
            dongCode : this.$route.params.dongCode,
            aptCode : this.$route.params.aptCode,
            img : require("../assets/aptphoto/apart"+1+".jpg"),
            imgno : 1,
            aptInfo : null,
            aptDeal : [],
            dongInfo : null,
            star : true,
        };
    },
    created(){
        var imgno = this.dongCode%22 +1;
        this.img = require("../assets/aptphoto/apart"+imgno+".jpg");
        
        console.log(imgno)
        axios_contact({
              method:"get",
              url:"/apt/info/"+this.aptCode,
          }).then(({data})=>{
              this.aptInfo = data;
          })

          axios_contact({
              method:"get",
              url:"/apt/deal/"+this.aptCode,
          }).then(({data})=>{
              for(var i=0;i<data.length;i++){
                  this.aptDeal.push(data[i]);
              }
          })

          axios_contact({
              method:"get",
              url:"/apt/"+this.dongCode,
          }).then(({data})=>{
              this.dongInfo=data;
          })
          
          if(this.email != null){
              axios_contact({
                  method : "get",
                  url : "/user/"+this.email,
              }).then(({data})=>{
                  this.userno = data.userno
                  axios_contact({
                      method : "get",
                      url : "/interest/get/"+this.userno+"/"+this.aptCode,
                  }).then(()=>{
                      this.star = false;
                  })
              })
          }
    },
    mounted() {
        
    },

    methods: {
        interest(){
            this.star = false;
            axios_contact({
                method : "post",
                url : "/interest",
                data : {
                    aptCode : this.aptCode,
                    userno : this.userno,
                    interno : 0
                }
            }).then(({data})=>{
                console.log(data)
            })
        },
        nointerest(){
            this.star = true;
            axios_contact({
                method : "delete",
                url : "/interest/delete",
                data : {
                    aptCode : this.aptCode,
                    userno : this.userno,
                    interno : 0
                }
            }).then(({data})=>{
                console.log(data)
            })
        },
        maxDealAmount(){
            var deal = 0;
            for(var i=0;i<this.aptDeal.length;i++){
                var temp = this.aptDeal[i].dealAmount.split(',');
                var aptDealAmountString = temp[0]+temp[1];
                var aptDealAmountInt = Number(aptDealAmountString);
                if(deal < aptDealAmountInt){
                    deal = aptDealAmountInt;
                }
            }
            return deal;
        },
        minDealAmount(){
            var deal = 99999999999999999;
            for(var i=0;i<this.aptDeal.length;i++){
                var temp = this.aptDeal[i].dealAmount.split(',');
                var aptDealAmountString = temp[0]+temp[1];
                var aptDealAmountInt = Number(aptDealAmountString);
                if(deal > aptDealAmountInt){
                    deal = aptDealAmountInt;
                }
            }
            return deal;
        },

        recentDealDate(){
            var date = 0;
            var year = 0;
            var month = 0;
            var day = 0;
            for(var i=0;i<this.aptDeal.length;i++){
                var dealDate = this.aptDeal[i].dealMonth*30 + this.aptDeal[i].dealDay;
                if(date < dealDate){
                    date = dealDate;
                    year = this.aptDeal[i].dealYear;
                    month = this.aptDeal[i].dealMonth;
                    day = this.aptDeal[i].dealDay;
                }
            }
            return year+"년 "+month+"월 "+day+"일";
        },
    },
};
</script>

<style scoped>

</style>