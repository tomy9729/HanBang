<template>
    <div>
        <div v-for="(boardno, index) in boardnos" :key="index">
            <FollowCard :boardno="boardno"></FollowCard>
        </div>
        
    </div>
</template>

<script>
import {axios_contact} from "@/common.js"
import FollowCard from "@/components/following/followingcard.vue";
export default {
    name: 'Following',
    components : {
        FollowCard,
    },
    data() {
        return {
            email: this.$store.state.userEmail,
            followings : [],
            boardnos : [],
        };
    },

    created(){
        this.setFollowing();
    },
    mounted() {
        
    },

    methods: {
        setFollowing(){
            axios_contact({
                method : "get",
                url : "/follow/from/"+this.email,
            }).then(({data})=>{
                this.followings = data;
                for(var i=0;i<this.followings.length;i++){
                    var fEmail = this.followings[i].touser;
                    axios_contact({
                        method : "get",
                        url : "/board/email/"+fEmail,
                    }).then(({data})=>{
                        console.log(data);
                        for(var j=0;j<data.length;j++){
                            this.boardnos.push(data[j]);
                        }
                    })
                }
            })
        },
    },
};
</script>

<style scoped>

</style>