<template>
    <div class="mt-5">
        <b-container class="bv-example-row">
            <b-row>
                <b-col><router-link to="/following"><center><img src="@/assets/followingicon.jpg" style="width:100px"><br>피드보기</center></router-link></b-col>
                <b-col><router-link to="/board"><center><img src="@/assets/photoicon.jpg" style="width:100px"><br>사진보기</center></router-link></b-col>
                <b-col><router-link to="/house"><center><img src="@/assets/houseicon.jpg" style="width:100px"><br>집보기</center></router-link></b-col>
                <b-col><router-link to="/apt"><center><img src="@/assets/dealicon.jpg" style="width:100px"><br>매매정보보기</center></router-link></b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
export default {
    name: 'Homeiconlist',

    data() {
        return {
            mainProps: { blank: true, blankColor: '#777', width: 75, height: 75, class: 'm1' }
        };
    },

    mounted() {
        
    },

    methods: {
        
    },
};
</script>

<style scoped>

</style>