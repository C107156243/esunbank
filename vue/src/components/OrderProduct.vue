<template>
    <div class="container">
    <h1 class="text-center">訂購商品</h1>
    <h2>會員:{{ memberid }}</h2>
    <table class="table table-striped" style="text-align:center;">
        <thead>
            <th>選購</th>
            <th>商品編號</th>
            <th>商品名稱</th>
            <th>售價</th>
            <th>庫存</th>
            <th v-if="ordered.length>0">購買數量</th>
        </thead>
        <tbody>
            <tr v-for = "product in products" v-bind:key = "product.pid">
                <td><input type="checkbox" v-bind:id="ordered[product.pid]" v-model="ordered" v-bind:value="product.pid" @change="checkchanged(product,orderqty[product.pid])"/></td>
                <td> {{product.pid}} </td>
                <td> {{product.pname}} </td>
                <td> ${{thousands(product.price)}} </td>
                <td> {{product.quantity}} </td>
                <td> <v-text-field v-bind:id="orderqty[product.pid]" v-model="orderqty[product.pid]" label="輸入購買數量" v-if="ordered.includes(product.pid)" @change="qtychanged(product,orderqty[product.pid])" oninput="value=value.replace(/[^\d]/g,'') "></v-text-field> </td>
            </tr>
        </tbody>
    </table>
    <v-btn @click="toDetail()">檢視訂單</v-btn>
    <v-btn @click="logout()">登出</v-btn>
    {{ fin }}
    </div>
    

</template>

<script>
// import axios from 'axios';
import ProductService from "../services/ProductService"

    export default {
        name: 'ProductList',
        data(){
            return{
                products : [],
                ordered : [],
                // pid: "",
                // pname: "",
                // price: 0,
                // quantity: 0,
                orderqty: [],
                memberid: sessionStorage.getItem('userid'),
                fin: []
            }
        },
        methods: {
            getProducts(){
                ProductService.getProducts().then((response) =>{
                    this.products = response.data;
                });
            },
            checkchanged(product,qty){
                if(!this.ordered.includes(product.pid)){
                    for (let i = 0; i < this.fin.length; i++) {
                        if(this.fin[i].pid==product.pid){
                            this.fin.splice(i,1)
                        }
                        
                    }
                    console.log(this.fin)
                }else{
                    if(qty){
                        this.fin.push({
                            pid:product.pid,
                            pname:product.pname,
                            price:product.price,
                            qty:qty
                        });
                    }
                }
            },
            qtychanged(product,qty){
                var exist = false;
                if(qty>product.quantity){
                            alert("庫存不足");
                    for (let i = 0; i < this.fin.length; i++) {
                        if(this.fin[i].pid==product.pid){
                            this.orderqty[product.pid] = this.fin[i].qty;
                            exist = true;
                        }
                    }
                    if(!exist){
                        this.orderqty[product.pid]='';
                    } 
                }
                else{
                    for (let i = 0; i < this.fin.length; i++) {
                        if(this.fin[i].pid==product.pid){
                            this.fin[i].qty=qty;
                            exist = true;
                        }
                    }
                    if(!exist){
                        this.fin.push({
                            pid:product.pid,
                            pname:product.pname,
                            price:product.price,
                            qty:qty
                        });
                    }                    
                }
            },
            toDetail(){

                this.$router.push({
                    name:'OrderDetail',
                    params:{
                        fin: this.fin
                        
                       
                        
                    }
                })
            },
            thousands (value) {
                if (value) {
                value += "";
                var arr = value.split(".");
                var re = /(\d{1,3})(?=(\d{3})+$)/g;
            
                return arr[0].replace(re, "$1,") + (arr.length == 2 ? "." + arr[1] : "");
                } else {
                return ''
                }
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