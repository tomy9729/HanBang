<template>
    <div class="container mb-5">
        <b-container class="bv-example-row">
            <b-row>
                <b-col>
                    <div>
                        <h1>{{form.subject}}</h1>
                        {{form.sqft}} | {{form.style}} 스타일 | {{form.housetype}}
                        <img class="mt-4" :src="image" style="width : 100%">
                    </div>
                    <div class="mt-3" style="font-size : 1.5em">
                        {{form.content}}
                    </div>
                    <div class="mt-5">
                        <hr>
                        <div>
                            <b-button variant="outline-warning" @click="goToApt">아파트</b-button> | 
                            <b-button variant="outline-success" @click="goToBoard">목록</b-button> | 
                            <b-button variant="outline-danger" @click="deleteBoard" v-if="form.email == comment.email">삭제</b-button>
                        </div>
                        <hr>
                        <h5>댓글 {{comments.length}}</h5>
                        <div>
                            <b-container class="bv-example-row">
                                <b-row>
                                    <b-col>
                                        <b-form-input v-model="comment.content" placeholder="칭찬과 격려의 댓글은 작성자에게 큰 힘이 됩니다 :)" ></b-form-input>
                                    </b-col>
                                    <b-col col lg="2">
                                        <b-button variant="outline-primary" @click="insertComment">등록</b-button>
                                    </b-col>
                                </b-row>
                            </b-container>

                            <div class="mt-3" v-for="(comment, index) in comments" :key="index">
                               <b>{{comment.nickname}}</b> {{comment.content}}
                            </div>
                        </div>
                    </div>
                </b-col>
                <b-col col lg="4" class="text-center">
                    <div class="mb-5" >
                        <b-button variant="outline-secondary" style="width :90%; height : 50px" v-if="heart==false" @click="yesheart">
                            <b-icon icon="heart" ></b-icon>
                            {{form.heartcount}}
                        </b-button>
                        <b-button variant="outline-secondary" style="width : 90%; height : 50px" v-else @click="noheart">
                            <b-icon icon="heart-fill" variant="danger"></b-icon>
                            {{form.heartcount}}
                        </b-button>
                    </div>
                    <div>
                        <b-icon class="h1" icon="person" variant="secondary" style="width: 120px; height: 120px;"></b-icon><br>
                        
                        <b-container class="bv-example-row">
                            <b-row>
                                <b-col>{{form.nickname}}</b-col>
                                <b-col></b-col>
                                <b-col>
                                    <b-button variant="outline-secondary"  v-if="follow==false" @click="yesfollow">
                                        팔로우
                                    </b-button>
                                    <b-button variant="info" v-else @click="nofollow">
                                        팔로잉
                                    </b-button>
                                </b-col>
                            </b-row>
                        </b-container>
                    </div>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
import {axios_contact} from "@/common.js"
export default {
    name: 'HangbangBoarddetail',
    
    data() {
        return {
            heart : false,
            follow : false,
            image : null,
            boardno : this.$route.params.boardno,
            form:{
            },
            comments : [],
            comment : {
                boardno : Number(this.$route.params.boardno),
                houseno : 0,
                email : this.$store.state.userEmail,
                content : "",
                comno:0,
            },
        };
    },

    created(){
        axios_contact({
            methods : "get",
            url : "/board/"+this.boardno,
        }).then(({data})=>{
            this.form = data;
            this.getImage();
        })
        axios_contact({
            methods : "get",
            url : "/comment/list/"+this.boardno,
        }).then(({data})=>{
            for(var i=0;i<data.length;i++){
                var content = data[i].content;
                this.setComments(data,i,content);
            }
        })

        if(this.comment.email != null){
            axios_contact({
                method : "get",
                url : "/heart/isHeart/"+Number(this.boardno)+"/"+this.comment.email,
            }).then(({data})=>{
                data;
                this.heart=true;

                axios_contact({
                    method:"get",
                    url : "/follow/"+this.comment.email+"/"+this.form.email
                }).then(({data})=>{
                    data;
                    this.follow=true;
                })
            })
        }

    },
    mounted() {
        
    },

    methods: {
        afterInsertComment(){
            this.comments=[];
            axios_contact({
            methods : "get",
            url : "/comment/list/"+this.boardno,
            }).then(({data})=>{
                for(var i=0;i<data.length;i++){
                    var content = data[i].content;
                    this.setComments(data,i,content);
                }
            })
        },
        getImage(){
            axios_contact({
                method : "get",
                url : "/image/"+this.form.img,
            }).then(({data})=>{
                //console.log(data);
                this.image = data;
            })
        },

        yesheart(){
            //좋아요 누름
            this.heart = true;
            axios_contact({
                method : "post",
                url : "/heart",
                data : {
                    boardno : Number(this.boardno),
                    email : this.comment.email,
                    heartno : 0,
                }
            }).then(({data})=>{
                //console.log(data)
                data;
                this.form.heartcount++;
                const that = this;
                axios_contact({
                    method : "put",
                    url : "/board",
                    data:that.form,
                }).then(({data})=>{
                    data;
                    //console.log(data)
                })
            })


        },
        noheart(){
            //좋아요 취소
            this.heart = false;
            axios_contact({
                method : "delete",
                url : "/heart",
                data : {
                    boardno : Number(this.boardno),
                    email : this.comment.email,
                    heartno : 0,
                }
            }).then(({data})=>{
                //console.log(data)
                data;
                this.form.heartcount--;
                const that = this;
                axios_contact({
                    method : "put",
                    url : "/board",
                    data:that.form,
                })
            })
        },
        yesfollow(){
            //팔로우
            this.follow = true;
            axios_contact({
                method : "post",
                url : "/follow",
                data : {
                    follno : 0,
                    fromuser : this.comment.email,
                    touser : this.form.email,
                },
            }).then(({data})=>{
                data;
                //console.log(data)
            })
        },
        nofollow(){
            //팔로우 취소
            this.follow = false; 
            axios_contact({
                method : "delete",
                url : "/follow",
                data : {
                    follno : 0,
                    fromuser : this.comment.email,
                    touser : this.form.email,
                },
            }).then(({data})=>{
                data;
                //console.log(data)
            })
        },

        setComments(data,i,content){
            const that = this;
            axios_contact({
                    method : "get",
                    url : "/user/"+data[i].email
                }).then(({data})=>{
                    that.comments.push({"nickname":data.nickname,"content":content})
                })
        },

        insertComment(){
            axios_contact({
                method : "post",
                url : "/comment",
                data : this.comment,
            }).then(({data})=>{
                //console.log(data)
                data;
                this.afterInsertComment();
                this.comment.content = "";
            })
        },
        goToBoard(){
            this.$router.push("/board")
        },
        deleteBoard(){
            if(confirm("게시글을 삭제하겠습니까?")){
                axios_contact({
                    method : "delete",
                    url : "/board/"+this.form.boardno
                }).then(()=>{
                    this.$router.push("/board")
                })
            }
        },
        goToApt(){
            axios_contact({
                method : "get",
                url : "/link/"+this.boardno
            }).then(({data})=>{
                console.log(data)
                this.$router.push("/aptdetail/"+data.dongCode+"/"+data.aptCode)
            })
        },
    },
};
</script>

<style scoped>

</style>