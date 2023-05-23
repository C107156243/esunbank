<template>

    <v-btn @click="test()">新增商品</v-btn>

    

</template>

<script>
import axios from 'axios';


    export default {
        name: 'ProductList',
        data(){
            return{
                products : [],
                pid: "",
                pname: "",
                price: 0,
                quantity: 0,
            }
        },
        methods: {
            test(){
                axios.get('http://localhost:8080/order/Ms20250805157824').then((response) =>{
                    console.log(response);
                })
            },
            toEdit(product){
                this.$router.push({
                    name:'EditForm',
                    params:{
                        pid: product.pid,
                        pname: product.pname,
                        price: product.price,
                        quantity: product.quantity
                    }
                })
            }
        },
    }
</script>

<style>

</style>