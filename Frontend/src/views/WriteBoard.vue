<template>
    <div class="container mb-5">
        <div>
            <b-container class="bv-example-row">
                <b-row>
                    <b-col class="mt-3">
                        <WriteMap @aptCode="setaptCode" @dongCode="setdongCode"></WriteMap>
                    </b-col>
                    <b-col>
                        <div class="mt-3">
                            <input type="file" @change="fileInput" class="mb-2"><br>
                            <img :src="image" style="border-width : 2px; border-style:dotted; width:100%; height:300px">
                        </div>
                    </b-col>
                </b-row>
            </b-container>
            <div class="mt-4">
                <div>
                    <b-form-select v-model="form.sqft" :options="sqftList" style="width:25%" ></b-form-select>
                    <b-form-select v-model="form.housetype" :options="housetypeList" style="width:25%" ></b-form-select>
                    <b-form-select v-model="form.style" :options="styleList" style="width:25%" ></b-form-select>
                    <b-form-select  v-model="form.space" :options="spaceList" style="width:25%" ></b-form-select>
                </div>
                <b-form-input class="mt-2" type="text" v-model="form.subject" placeholder="제목" required></b-form-input>
                <b-form-textarea class="mt-2" v-model="form.content" placeholder="내용" rows="7" required></b-form-textarea>
                <b-button variant="info" class="mt-2" @click="writeboard">올리기</b-button>
            </div>
        </div>
    </div>
</template>

<script>
import {axios_contact} from "@/common.js"
import WriteMap from "@/components/write/writemap.vue";
export default {
    name: 'HangbangWriteboard',
    components : {
        WriteMap
    },
    data() {
        return {
            aptCode : 0,
            dongCode : "",
            image : require("@/assets/uploadimage.jpg"),
            form:{
                sqft:null,
                housetype:null,
                style:null,
                space:null,
                subject:"",
                content:"",
                heartcount:0,
                img:0,
                email:this.$store.state.userEmail,
                nickname:this.$store.state.ninkname,
            },
            img:{
                bno : 0,
                hno : 0,
                imageName : "",
                imagePath : "",
                imageno : 0,
            },
            sqftList:[
                {value:null, text:"평수"},
                {value:"10평대",text:"10평대"},
                {value:"20평대",text:"20평대"},
                {value:"30평대",text:"30평대"},
                {value:"40평대",text:"40평대"},
            ],
            housetypeList:[
                {value:null, text:"주거형태"},
                {value:"원룸", text:"원룸"},
                {value:"아파트", text:"아파트"},
            ],
            styleList:[
                {value:null, text:"스타일"},
                {value:"모던", text:"모던"},
                {value:"북유럽", text:"북유럽"},
                {value:"내추럴", text:"내추럴"},
                {value:"한국", text:"한국"},
            ],
            spaceList:[
                {value:null, text:"공간"},
                {value:"원룸", text:"원룸"},
                {value:"거실", text:"거실"},
                {value:"침실", text:"침실"},
                {value:"주방", text:"주방"},
                {value:"욕실", text:"욕실"},
                {value:"드레스룸", text:"드레스룸"},
                {value:"서재", text:"서재"},
                {value:"베란다", text:"베란다"},
                {value:"현관", text:"현관"},
            ],
        };
    },

    mounted() {
        
    },

    methods: {
        fileInput(event){
            const that = this;
            console.log(event.target.files);
            var image = event.target.files[0];
            var reader = new FileReader();
            reader.onload=function(){
                var encodedString = reader.result;
                that.form.imageName = encodedString;
                //서버로 전송
                axios_contact({
                    method : "post",
                    url : "/image",
                    data : that.form,
                }).then(({data})=>{
                    if(data=="success"){
                        axios_contact({
                            methods:"get",
                            url:"/image/imageno",
                        }).then(({data})=>{
                            // console.log(data)
                            that.form.img = data;
                            that.img.imageno = data;
                            that.getImage();
                        })
                    }
                })
            };
            reader.readAsDataURL(image);
        },
        getImage(){
            axios_contact({
                method : "get",
                url : "/image/"+this.img.imageno,
            }).then(({data})=>{
                console.log(data);
                this.image = data;
            })
        },

        writeboard(){
            const that = this;
            axios_contact({
                method : "post",
                url : "/board",
                data : this.form
            }).then(({data})=>{
                if(data=="success"){
                    axios_contact({
                        method:"get",
                        url : "/board/no",
                    }).then(({data})=>{
                        that.img.bno = data;
                        axios_contact({
                            method : "put",
                            url : "/image",
                            data : that.img
                        }).then(({data})=>{
                            if(data=="success"){
                                axios_contact({
                                    method : "get",
                                    url : "/board/no"
                                }).then(({data})=>{
                                    axios_contact({
                                        method : "post",
                                        url : "/link",
                                        data : {
                                            aptCode: that.aptCode,
                                            boardno: data,
                                            dongCode: that.dongCode,
                                            no: 0
                                        }
                                    })
                                    that.$router.push("/boarddetail/"+data)
                                })
                                
                            }
                        })
                    })
                }
            })
        },
        setaptCode(value){
            this.aptCode = value;
        },
        setdongCode(value){
            this.dongCode = value;
        },
    },
};
</script>

<style scoped>

</style>