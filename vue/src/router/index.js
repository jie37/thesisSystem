
import { createRouter, createWebHistory } from 'vue-router'
import Login from '../views/Login.vue'
import Home from "../views/Home.vue";
import Topic from "@/views/Topic";
import Info from "@/views/Info";
import ThesisUpload from "@/views/ThesisUpload";
import ManageStudents from "@/views/ManageStudents";


const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login,
  },
  {
    path: '/logout',
    name: 'Logout',
    },
  {
    path: '/home',
    name: 'Home',
    component: Home,
    children:[
        {
            path:'/info',
            name:'Info',
            component: Info
        },
        {
            path: '/topic',
            name: 'Topic',
            component: Topic
        },
        {
            path: '/upload',
            name: 'Upload',
            component: ThesisUpload
        },
        {
            path: '/manage',
            name: 'Manage',
            component: ManageStudents
        },
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
