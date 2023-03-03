<template>
  <div class="message">
    <el-card class="box-card">
        <div class="card-header">
          <span>个人信息</span>
        </div>
      <div v-for="(value,key) in info" class="text item">{{key}}：{{ value }}</div>
    </el-card>
  </div>
</template>

<script>
import {getRequest} from "@/utils/api";

export default {
  name: "Info",
  data(){
    return{
      user:JSON.parse(window.sessionStorage.getItem('user')),
      info:'',
    }
  },
  mounted:function() {
    this.getInfo();
  },
  methods:{
    getInfo() {
      if (this.user.status === "student") {
        getRequest('/student/info').then(resp => {
          if (resp) {
            this.info = resp
          }
        })
      } else if (this.user.status === "teacher") {
          getRequest('/teacher/info').then(resp => {
            if (resp) {
              this.info = resp
            }
          })
      } else {
        getRequest('/manager/info').then(resp => {
          if (resp) {
            this.info = resp
          }
        })
      }
    }
  }
}
</script>

<style >
.message{

  margin:25px 25px;
}
.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 25px;

}
.text{
  font-size: 14px;
}
.item{
  margin-bottom: 18px;
}
.box-card{
  width: 480px;
}
</style>