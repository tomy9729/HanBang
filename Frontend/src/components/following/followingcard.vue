<template>
    <div class="container mb-5">
        <b-row>
            <b-col></b-col>
            <b-col>
            <div>
                <b-card :title="board.subject" :header="board.nickname" :img-src="img" img-top style="width:35rem" img-height="500px">
                    <b-card-text>
                        {{board.content}}
                    </b-card-text>
                    <template #footer>
                        <small class="text-muted">
<!-- 
                            <b-icon icon="suit-heart" scale="2" v-if=heart @click="clickHeart" style="cursor:pointer"></b-icon>
                            <b-icon icon="suit-heart-fill" scale="2" variant="danger" v-else @click="clickHeart" style="cursor:pointer"></b-icon> -->
                            <b-icon icon="chat" scale="2"   style="cursor:pointer"  @click="movetodetail"></b-icon>
                        </small>
                    </template>
                </b-card>
            </div>
            </b-col>
            <b-col></b-col>
        </b-row>
    </div>
</template>

<script>
import {axios_contact} from "@/common.js"
export default {
    name: 'Followingcard',
    
    props:["boardno"],
    data() {
        return {
            email : this.$store.state.userEmail,
            heart : true,
            board : null,
            img : null,
        };
    },

    created(){
        const that = this;
        axios_contact({
            method : "get",
            url : "/board/"+this.boardno,
        }).then(({data})=>{
            this.board=data;

             axios_contact({
                method : "get",
                url : "/image/"+this.board.img,
            }).then(({data})=>{
                //console.log(data);
                that.img=data;
            })
        })

       
    },

    mounted() {
        
    },

    methods: {
        clickHeart(){
            this.heart = !this.heart;
        },
        movetodetail(){
            console.log("디테일로가자")
            this.$router.push("/boarddetail/"+this.boardno);
        },
    },
};
</script>

<style scoped>

</style>