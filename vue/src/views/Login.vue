<template>
    <div>
        <el-form :rules="rules" ref="loginForm" :model="loginForm" class="loginContainer">
            <h3 class="loginTitle">登录</h3>
            <!-- prop与rules中对应，但两者都不代表data中的数据 -->
            <el-form-item prop="username">
                <el-input type="text" autocomplete="false" v-model="loginForm.username" placeholder="请输入用户名">
                </el-input>
            </el-form-item>
            <el-form-item prop="password">
                <el-input type="password" autocomplete="false" v-model="loginForm.password" placeholder="请输入密码">
                </el-input>
            </el-form-item>
                <el-checkbox v-model="loginForm.checked" class="loginRemember">记住我</el-checkbox>
                <el-button type="primary" style="width:100%" @click="submitLogin">登录</el-button>
        </el-form>
    </div>
</template>

<script>


import { postRequest} from "@/utils/api";

export default {
    name:'Login',
    data(){
        return {
            loginForm: {
                username:'',
                password:''
            },
            checked:false,
            rules:{
                // 校验是否为空
                username:[{required:true,message:'请输入用户名',trigger:'blur'}],
                password:[{required:true,message:'请输入密码',trigger:'blur'}],
            }
        }
    },
    methods:{
        submitLogin(){
            // 登录检验
          this.$refs.loginForm.validate((valid)=>{
            if(valid){
              // 检验通过
              postRequest("/login",this.loginForm).then(resp=>{
                if(resp){
                  //存储用户token
                  const tokenStr=resp.obj.tokenHead+resp.obj.token;
                  window.sessionStorage.setItem('tokenStr',tokenStr);
                  //调转首页
                  //this.$router.push('/home');
                  this.$router.replace('/home');
                }
              })
            }else{
              // 检验失败
              this.$message.error('请输入所有字段');
              return false;
                }
            });
        },
    }
}
</script>

<style>
.loginContainer{
    border-radius: 15px;
    background-clip: padding-box;
    margin: 180px auto;
    width: 350px;
    padding: 15px 35px 15px 35px;
    background-color: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
}
.loginTitle{
    margin: 0px auto 10px auto;
    text-align: center;
}
.loginRemember{
    text-align: left;
    margin: 0px 0px 15px 0px;
}

</style>