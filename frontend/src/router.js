
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/OrderManager"

import Menu from "./components/Menu"
import MyPage from "./components/MyPage"
import PaymentManager from "./components/PaymentManager"

import OrdermanagementManager from "./components/OrdermanagementManager"

import DeliveryManager from "./components/DeliveryManager"

import Deliverystatus from "./components/Deliverystatus"
import ProductManager from "./components/ProductManager"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/Order',
                name: 'OrderManager',
                component: OrderManager
            },

            {
                path: '/Menu',
                name: 'Menu',
                component: Menu
            },
            {
                path: '/MyPage',
                name: 'MyPage',
                component: MyPage
            },
            {
                path: '/Payment',
                name: 'PaymentManager',
                component: PaymentManager
            },

            {
                path: '/Ordermanagement',
                name: 'OrdermanagementManager',
                component: OrdermanagementManager
            },

            {
                path: '/Delivery',
                name: 'DeliveryManager',
                component: DeliveryManager
            },

            {
                path: '/Deliverystatus',
                name: 'Deliverystatus',
                component: Deliverystatus
            },
            {
                path: '/Product',
                name: 'ProductManager',
                component: ProductManager
            },



    ]
})
