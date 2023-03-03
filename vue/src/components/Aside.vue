<template>
  <div>
    <el-menu
        @select="menuClick"
        default-active="2"
        class="el-menu-vertical-demo">
        <el-menu-item index='/info'>
            <el-icon><location /></el-icon>
            <span>个人信息</span>
        </el-menu-item>
      <el-menu-item index="/topic">
        <el-icon><location /></el-icon>
        <span>论文题目</span>
      </el-menu-item>
        <div v-if="user.status==='student'">
          <el-sub-menu index="3">
              <template #title>
                <el-icon><location /></el-icon>
                <span>毕业设计(论文)</span>
              </template>
              <el-menu-item index="/upload">
                <el-icon><location /></el-icon>
                <span>上传</span>
              </el-menu-item>
          </el-sub-menu>
        </div>

        <div  v-else-if="user.status==='teacher'">
          <el-menu-item index="3">
            <el-icon><icon-menu /></el-icon>
            <span>选择学生</span>
          </el-menu-item>
          <el-sub-menu index="4">
            <template #title>
              <el-icon><location /></el-icon>
              <span>毕业设计(论文)</span>
            </template>
            <el-menu-item index="4-1">
              <el-icon><location /></el-icon>
              <span>查看开题报告</span>
            </el-menu-item>
            <el-menu-item index="4-2">
              <el-icon><location /></el-icon>
              <span>评审论文</span>
            </el-menu-item>
          </el-sub-menu>
        </div>

        <div v-else-if="user.status==='manager'">
          <el-menu-item index="/manage" >
            <el-icon><icon-menu /></el-icon>
            <span>学生管理</span>
          </el-menu-item>
        </div>

    </el-menu>
  </div>
</template>
<script>
  export default {
    name:'Aside',
    data(){
      return {

        user:JSON.parse(window.sessionStorage.getItem('user')),
      }
    },
    methods:{
      menuClick(index){
        this.$router.push(index)
        },

      }
  }
</script>

<style>
.el-menu-item{
    width:200px;
}
.el-menu-vertical-demo{
    min-height:100vh;
}
</style>