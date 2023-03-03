<template>
  <div id="message">
    <div v-if="status='student'">
      <div v-for="u in user"></div>
    <el-card class="box-card" style="width:400px">
      <div>用户姓名：<el-card>{{user.name}}</el-card></div>
      <div>用户ID：<el-card>{{user.id}}</el-card></div>
      <div>身份：<el-card>{{user.status}}</el-card></div>
      <div>电话号码：<el-card>{{user.phone}}</el-card></div>
      {{user}}
<!--    </el-card>-->
<!--      <div v-if="status='teacher'">-->
<!--        <el-card class="box-card" style="width:400px">-->
<!--          <div>用户姓名：<el-card>{{user.username}}</el-card></div>-->
<!--          <div>用户ID：<el-card>{{user.id}}</el-card></div>-->
<!--          <div>身份：<el-card>{{user.status}}</el-card></div>-->
<!--          <div>电话号码：<el-card>{{user.phone}}</el-card></div>-->

<!--          {{info}}-->
        </el-card>
<!--      </div>-->
    </div>
  </div>


</template>

<script >

export default {
  name: 'UserInfo',
  data(){
    return {
      status:(JSON.parse(window.sessionStorage.getItem('user'))).status,
      user:JSON.parse(window.sessionStorage.getItem('user')),
      info:JSON.parse(window.sessionStorage.getItem('student')),


    }
  },
  computed:{
    path:{
      get(){
        return '/'+this.status + '/info'}
    },
      set(){

    }
  },
  methods: {

  }
}
</script>
<style>
#message{

  padding: 30px ;
}

</style>