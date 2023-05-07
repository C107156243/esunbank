<template>
    <div class="container">
        <v-form>
            <br>
            <h1 class="text-center">商品詳情</h1>
            <br>
            <v-text-field v-model="pid" label="Pid"></v-text-field>
            <v-text-field v-model="pname" label="Pname"></v-text-field>
            <v-text-field v-model="price" label="Price"></v-text-field>
            <v-text-field v-model="quantity" label="Quantity"></v-text-field>
            <v-btn color="red" @click="toList()">取消</v-btn>
            <v-btn color="success" @click="submit({pid,pname,price,quantity})">送出</v-btn>
        </v-form>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    data(){
            return{
                pid: this.$route.params.pid,
                pname: this.$route.params.pname,
                price: this.$route.params.price,
                quantity: this.$route.params.quantity
            }
        },

    methods: {
        submit(product){
            if(product.pid) {
                axios.post("http://localhost:8080/", product);
            }else{
                axios.put("http://localhost:8080/updateProduct", product);
            }
            this.$router.push('/ProductList')
        },
        toList(){
            this.$router.push('/ProductList')
        }
    }
}
</script>

<style>

</style>