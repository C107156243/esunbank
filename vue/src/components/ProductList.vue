<template>
    <div class="container">
    <h1 class="text-center">Product List</h1>
    <table class="table table-striped">
        <thead>
            <th>商品編號</th>
            <th>商品名稱</th>
            <th>售價</th>
            <th>庫存</th>
            <th>Edit</th>
            <th>Delete</th>
        </thead>
        <tbody>
            <tr v-for = "product in products" v-bind:key = "product.pid">
                <td> {{product.pid}} </td>
                <td> {{product.pname}} </td>
                <td> {{product.price}} </td>
                <td> {{product.quantity}} </td>
                <td> <v-btn @click="toEdit(product)">Edit</v-btn> </td>
                <td> <v-btn @click="deleteProduct(product.pid)">Deletee</v-btn> </td>
            </tr>
        </tbody>
    </table>
    <v-btn @click="toAdd()">新增商品</v-btn>
    <v-btn @click="logout()">登出</v-btn>
    </div>
    

</template>

<script>
import axios from 'axios';
import ProductService from "../services/ProductService"

    export default {
        name: 'ProductList',
        data(){
            return{
                products : [],
                pid: "",
                pname: "",
                price: 0,
                quantity: 0
            }
        },
        methods: {
            getProducts(){
                ProductService.getProducts().then((response) =>{
                    this.products = response.data;
                });
            },
            async deleteProduct(pid){
                await axios.delete("http://localhost:8080/deleteProduct/" + pid);
                this.getProducts();
            },
            toAdd(){
                this.$router.push('/EditForm')
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
            },
            logout(){
                sessionStorage.clear()
                this.$router.push('/LoginPage')  
            }
        },
        created() {
            this.getProducts()
        }
    }
</script>

<style>

</style>