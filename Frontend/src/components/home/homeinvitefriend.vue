<template>
    <div class="mt-5 mb-5">
        <div>
            <img src="@/assets/invitefriend.jpg" @click="test" style="cursor:pointer; width:100%;">
        </div>
    </div>
</template>

<script>
export default {
    name: 'Homeinvitefriend',

    data() {
        return {
            
        };
    },

    mounted() {
        
    },

    methods: {
        test(){
            console.log(1)
        }
    },
};
</script>

<style scoped>

</style>