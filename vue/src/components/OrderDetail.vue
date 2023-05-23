<template>
    <div class="container">
    <h1 class="text-center">訂單內容</h1>
    <h2>會員:{{ memberid }}</h2>
    <table class="table table-striped" style="text-align:center;">
        <thead>
            <th>商品編號</th>
            <th>商品名稱</th>
            <th>單價</th>
            <th>數量</th>
            <th>單品總額</th>
        </thead>
        <tbody>
            <tr v-for = "product in fin" v-bind:key = "product.pid">
                <td> {{product.pid}} </td>
                <td> {{product.pname}} </td>
                <td> ${{thousands(product.price)}} </td>
                <td> {{product.qty}} </td>
                <td> $  {{thousands(product.price*product.qty)}} </td>
            </tr>
            <td colspan="4" align="right">總金額：</td>
            <td>${{ thousands(total) }}</td>
        </tbody>
    </table>
    <v-btn @click="submit({memberid,paystatus,orderDetailList})">送出訂單</v-btn>
    {{ {memberid,paystatus,orderDetailList} }}
    </div>
    

</template>

<script>
import axios from 'axios';

    export default {
        data(){
            return{
                fin: this.$route.params.fin,
                memberid: sessionStorage.getItem('userid'),
                paystatus: 0,
                orderDetailList: [],
                orderID: 878,
                total: 0
            }
        },
        methods: {
            trans(){
                for (let i = 0; i < this.fin.length; i++) {
                    
                    this.orderDetailList.push({
                        productID:this.fin[i].pid,
                        quantity:this.fin[i].qty
                    });
                }
            },
            atotal(){
                for (let i = 0; i < this.fin.length; i++) {
                    this.total+=(this.fin[i].price*this.fin[i].qty);
                }
            },
            submit(orderDto){

                    
                axios.post("http://localhost:8080/order/submit",orderDto).then((response) =>{
                    this.$router.push({
                    name:'OrderInfo',
                    params:{
                    orderid:response.data
                    }})
                });
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
            }

        },
        created() {
            this.trans()
            this.atotal()
        }
    }
</script>

<style>

</style>
