<template>
  <div class="head">
    <button @click="showAddStudent()" style="margin:5px">添加学生</button>
    <el-upload
        style="display: inline-flex"

        :action=importStudent
    >
      <button>导入学生</button>

    </el-upload>
  </div>
  <el-dialog
      v-model="dialogVisible"
      title="添加学生"
      width="80%"
  >
    <div class="addStudent">
      <el-form ref="studentForm" :model="newStudent" :rules="rules">
        <el-row>
          <el-col :span="6">
            <el-form-item label="学号：" prop="stuId">
              <el-input size="small" style="width: 150px;"
                        v-model="newStudent.stuId"
                        autocomplete="false"
                        type="text"
                        placeholder="请输入学生学号">
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="6">
            <el-form-item label="姓名：" prop="stuName">
              <el-input size="small" style="width: 150px;"
                        v-model="newStudent.stuName"
                        type="text"
                        placeholder="请输入学生姓名">
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="6">
            <el-form-item label="性别：" prop="stuSex">
              <el-input size="small" style="width: 150px;"
                        v-model="newStudent.stuSex"
                        type="text"
                        placeholder="请输入学生性别">
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="10">
            <el-form-item label="所在系：" prop="deparId">
              <el-input size="small" style="width: 150px;"
                        v-model="newStudent.deparId"
                        type="text"
                        placeholder="请输入学生所在系编号">
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="10">
            <el-form-item label="学生联系方式：" prop="phone">
              <el-input size="small" style="width: 150px;"
                        v-model="newStudent.phone"
                        type="text"
                        placeholder="请输入学生联系方式">
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>

      </el-form>
    </div>

    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="addStudent">
          确定
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script>
import {postRequest} from "@/utils/api";

export default {
  name: "ManageStudents.vue",
  data(){
    return{
      dialogVisible:false,
      newStudent:{
        stuId:"",
        stuName:"",
        stuSex:"",
        deparId:"",
        phone:"",
      },
      rules:{
        // 校验是否为空
        stuId:[{required:true,message:'请输入学生学号',trigger:'blur'}],
        stuName:[{required:true,message:'请输入学生姓名',trigger:'blur'}],
        stuSex:[{required:true,message:'请输入学生性别',trigger:'blur'}],
        deparId:[{required:true,message:'请输入学生所在系编号',trigger:'blur'}],
        phone:[{required:true,message:'请输入学生联系方式',trigger:'blur'}]
      },
    }
  },
  methods:{
    showAddStudent(){
      this.dialogVisible=true
    },
    addStudent(){
      this.$refs.studentForm.validate((valid)=>{
        if(valid){
          // 检验通过
          postRequest("/manager/addStudent",this.newStudent).then(resp=>{
            if(resp){
              this.dialogVisible = false;
            }
          })
        }else{
          // 检验失败
          this.$message.error('请输入所有字段');
          return false;
        }
      });
    },
    importStudent(){
            // 检验通过
            postRequest("/manager/import").then(resp=>{
              if(resp){
                this.dialogVisible = false;
              }
            })
    }
  }
}
</script>

<style>

</style>