import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

import './assets/css/global.css'
import {getRequest} from "@/utils/api";

createApp(App).use(store).use(router).use(ElementPlus).mount('#app')

router.beforeEach((to,from,next)=>{
    if(window.sessionStorage.getItem('tokenStr')){
        //判断用户信息是否存在
        if(!window.sessionStorage.getItem('user')){
            return getRequest('/user/info').then(resp=>{
                if(resp){
                    //存入用户信息
                    window.sessionStorage.setItem('user',JSON.stringify(resp));
                    next();
                }
            })
        }
        next();
    }else {
        next();
    }
})