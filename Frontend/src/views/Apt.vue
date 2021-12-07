<template>
    <div class="container mb-5">
        <div>
            <b-container class="bv-example-row">
                <b-row>
                    <b-col>
                        <div>
                            <b-form-select v-model="sido" :options="sidoList" style="width:29%" @change="sidochange"></b-form-select>
                            <b-form-select v-model="gugun" :options="gugunList" style="width:29%" @change="gugunchange(gugun)"></b-form-select>
                            <b-form-select v-model="dong" :options="dongList" style="width:29%" @change="dongchange(dong)"></b-form-select>
                            <b-button variant="info" style="width:13%" @click="search">검색</b-button>
                        </div>
                    </b-col>
                    <b-col>
                        
                    </b-col>
                </b-row>
                <div id="map" style="width:100%;height:500px" class="mt-3"></div>
            </b-container>
        </div>
        <!-- <div v-if="aptcheck">
            <DealMap 
            :dongCode="dong"
            :apart="apart"></DealMap>
        </div> -->
    </div>
</template>

<script>
// import DealMap from "@/components/deal/dealmap.vue"
import {axios_contact} from "@/common.js"
export default {
    name: 'HangbangApt',
    components:{
        // DealMap,
    },
    data() {
        return {
            markers:[],
            apart:[],
            aptcheck: true,
            sido:null,
            sidoList:[
                {value:null, text:"시도"},
                {value:"서울특별시",text:"서울특별시"}
            ],
            gugun:null,
            gugunList:[
                {value:null, text:"구군"},
            ],
            dong:null,
            dongList:[
                {value:null, text:"동"},
            ],
            map:null,
        };
    },

    mounted() {
        if (window.kakao && window.kakao.maps) {
        this.initMap();
        } else {
        const script = document.createElement("script");
        /* global kakao */
        script.onload = () => kakao.maps.load(this.initMap);
        script.src =
            "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=09c7de4547a571802b31f020730abd7a";
            document.head.appendChild(script);
        }
    },

    methods: {
        search(){
            this.setCenter(this.dong);
            this.setMarkers();
        },
        setCenter(dongCode){
            axios_contact({
                method:"get",
                url:"/apt/"+dongCode,
            }).then(({data})=>{
                // 이동할 위도 경도 위치를 생성합니다 
                var moveLatLon = new kakao.maps.LatLng(data.lat,data.lng);
                // 지도 중심을 이동 시킵니다
                this.map.setCenter(moveLatLon); 
                this.map.setLevel(5);
            })
        },
        setMarkers(){
            if (this.markers.length > 0) {
                this.markers.forEach((marker) => marker.setMap(null));
            }

            for(var i=0;i<this.apart.length;i++){
                this.addMarker(this.apart[i]);
            }
        },
        addMarker(aptInfo){
            const that = this;
            var marker = new kakao.maps.Marker({
                position: new kakao.maps.LatLng(aptInfo.lat,aptInfo.lng) 
            });
            marker.setMap(this.map);
            this.markers.push(marker);

            kakao.maps.event.addListener(marker, 'click', function(){
                    that.$router.push("/aptdetail/"+aptInfo.dongCode+"/"+aptInfo.aptCode);
            });
        },
        sidochange(){
          axios_contact({
              method:"get",
              url:"/apt/gugunlist",
          }).then(({data})=>{
              for(var index=0;index<data.length;index++){
                  this.gugunList.push({value:data[index].gugunName, text:data[index].gugunName})
              }
          })
        },
        gugunchange(gugun){
            //console.log(gugun);
            axios_contact({
                method:"get",
                url:"/apt/donglist/"+gugun,
            }).then(({data})=>{
                this.dong=null;
                this.dongList=[
                {value:null, text:"동"},
            ];
                for(var index=0;index<data.length;index++){
                  this.dongList.push({value:data[index].dongCode, text:data[index].dongName})
              }
            })
        },
        dongchange(dongCode){
            axios_contact({
                method:"get",
                url:"/apt/dong/"+dongCode,
            }).then(({data})=>{
                //console.log(data)
                this.apart=[];
                for(var index=0;index<data.length;index++){
                  this.apart.push(data[index])
              }
            })
        },

        initMap() {
            const container = document.getElementById("map");
            const options = {
                center: new kakao.maps.LatLng(37.4998616,126.97429917),
                level: 9,
            };
            this.map = new kakao.maps.Map(container, options);
        },

    },
};
</script>

<style lang="scss" scoped>

</style>