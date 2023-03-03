<template>
  <div id="header">
    <div id='left'>论文选题系统</div>
    <div id='mid'></div>
    <div id="right">
        <el-dropdown @command="handleCommand">
            <span class="el-dropdown-link">
                头像
            </span>
            <template #dropdown>
                <el-dropdown-menu >
                     <el-dropdown-item command="logout">退出系统</el-dropdown-item>
                </el-dropdown-menu>
             </template>
        </el-dropdown>
    </div>
  </div>
</template>

<script>
import {postRequest} from "@/utils/api";

export default {
    name:'Header',
    methods:{
      handleCommand(command){
        if (command === 'logout') {
         this.$confirm('是否退出登录?','提示',{
            confirmButtonText:'确定',
            cancelButtonText:'取消',
            type:'warning'
          }).then(()=> {
           //注销登录
           postRequest('/logout');
           //清空用户，令牌
           window.sessionStorage.removeItem('tokenStr');
           window.sessionStorage.removeItem('user');
           //跳转到登录页
           this.$router.replace('/');
          }).catch(()=>{
            this.$message({
              type:'info',
              message:'已取消退出'
            });
          });

        }
      }
    }

}
</script>

<style>
#header{
    height: 50px;
    Line-height: 50px;
    border-bottom: 1px solid #ccc;
    display: flex;
    background-color: blue;
}
#left{
   width:200px;
   padding-left: 30px;
   font-weight: bold;
   color:#ccc;
}
#mid{
    flex: 1;
}
#right{
    width:100px;
    color:#ccc;
}

</style>