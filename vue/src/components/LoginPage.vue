<template>
    <div class="container">
    <h1 class="text-center">Login</h1>
    帳號:<v-text-field v-model="userid" label="userid"></v-text-field>
    密碼:<v-text-field v-model="userpassword" label="userpassword"></v-text-field>
    <v-btn @click="Login()">登入</v-btn>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    data(){
            return{
                userid:"",
                userpassword:""
            }
        },
    methods: {
            Login(){
                axios.post("http://localhost:8080/Login",{
                    userid: this.userid,
                    userpassword: this.userpassword
                }).then((response) =>{
                    if(response.data=='0'){
                        sessionStorage.setItem('userid',this.userid);
                        sessionStorage.setItem('admin',response.data)
                        this.$router.push('/OrderProduct');
                    }
                    else if(response.data=='1'){
                        sessionStorage.setItem('userid',this.userid);
                        sessionStorage.setItem('admin',response.data)
                        this.$router.push('/ProductList');
                    }
                    else{
                        alert(response.data);
                    }
                })
            }
        },
        created(){
            if(sessionStorage.getItem('admin')=='1') this.$router.push('/ProductList');
            if(sessionStorage.getItem('admin')=='0') this.$router.push('/OrderProduct');
        }
}
</script>

<style>

</style>