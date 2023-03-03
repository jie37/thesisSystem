<template>
    <div id="message">
      <h1>信息</h1>
      <!-- 搜索栏 -->
    <div  id="search">
      <input type="text" v-model="keyword" placeholder="请输入关键词" />
      <button @click="search" style="margin:5px">搜索</button>
    </div>
    <!-- 内容 -->
    <div>
      <el-table :data="tableData" border style="width: 100%">
        <el-table-column prop="name" label="Name" width='200' />
        <el-table-column prop="message" label="Message" width='200' />
      </el-table>
      <button @click="updateData">编辑</button>
    </div>
    </div>
  
  </template>
  
  <script >
  export default {
    name: 'HomeView',
    data(){
      return  {
        keyword:'',
        status:(JSON.parse(window.sessionStorage.getItem('user'))).status,
        tableData:[{
          user:JSON.parse(window.sessionStorage.getItem('teacher')),

        }]
      }
    },
    methods:{
      search(){
        
      },
      updateData(){
  
      }
    }
  }
  </script>
  <style>
  #message{
    padding: 20px;
  }
  #search{
    margin: 10px 0;
  }
  </style>