import Vue from 'vue';
import Router from 'vue-router'

Vue.use(Router)

export const Routes= [
    {
        path:'/',
        component:()=> import('@/components/HelloWorld.vue'),
    },
    {
        path:'/ProductList',
        name: 'ProductList',
        component:()=> import('@/components/ProductList.vue'),
    },
    {
        path:'/EditForm',
        name:'EditForm',
        component:()=> import('@/components/EditForm.vue'),
    },
    // {
    //     path:'/OrderProduct',
    //     name: 'OrderProduct',
    //     component:()=> import('@/components/OrderProduct.vue'),
    // },
    // {
    //     path:'/OrderDetail',
    //     name: 'OrderDetail',
    //     component:()=> import('@/components/OrderDetail.vue'),
    // },

]

const createRouter = () => new Router({
    mode:'history',
    base: process.env.VUE_APP_BASE_URL,
    routes:Routes,
})

const router = createRouter()

export default router