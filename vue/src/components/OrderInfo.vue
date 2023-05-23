<template>
    <div class="container">
    <h1 class="text-center">訂單詳情</h1>
    <h2 class="text-center">{{this.orderid}}</h2>
    <h3>訂購人:{{ this.ordermemberid }}</h3>
    <h6>{{this.paystatus==0 ? '未付款' : '已付款'}}</h6>
    <table class="table table-striped" style="text-align:center;">
        <thead>
            <th>訂單詳情流水號</th>
            <th>商品編號</th>
            <th>單價</th>
            <th>數量</th>
            <th>單品總額</th>
        </thead>
        <tbody>
            <tr v-for = "orderitem in this.orderdetail" v-bind:key = "orderitem.orderitemsn">
                <td> {{orderitem.orderItemSN}} </td>
                <td> {{orderitem.productID}} </td>
                <td> ${{thousands(orderitem.standPrice)}} </td>
                <td> {{orderitem.quantity}} </td>
                <td> $  {{thousands(orderitem.itemPrice)}} </td>
            </tr>
            <td colspan="4" align="right">總金額：</td>
            <td>${{ thousands(price) }}</td>
        </tbody>
    </table>
    <v-btn @click="tohome()">回首頁</v-btn>

    </div>
    

</template>

<script>
import axios from 'axios';

    export default {
        data(){
            return{
                orderid:'Ms20230523144832',
                ordermemberid:'',
                paystatus:0,
                price:0,
                orderdetail:[]
            }
        },
        methods: {
            getorder(){
                axios.get('http://localhost:8080/order/'+this.orderid).then((response) =>{
                    this.ordermemberid = response.data.memberid
                    this.paystatus = response.data.paystatus
                    this.price = response.data.price
                    this.orderdetail = response.data.orderDetailList

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
            tohome(){
                this.$router.push('/')
            }
        },
        created() {
            this.getorder()
        }
    }
</script>

<style>

</style>
