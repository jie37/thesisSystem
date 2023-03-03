<template>
  <div>
    <div id="head">
      <input type="text" v-model="keyword" placeholder="请输入关键词"/>
      <button @click="search" style="margin:5px">搜索</button>
      <button @click="showAddThesis" style="margin:5px" v-if="user.status==='teacher'">添加题目</button>
    </div>
    <div id="message">
      <el-table :data="filThesis" style="width: 100%">
        <el-table-column prop="subId" label="id" width="180"/>
        <el-table-column prop="subName" label="论文名字" width="180"/>
        <el-table-column prop="introduce" label="具体内容" width="180"/>
        <el-table-column prop="partNum" label="学生上限"/>
        <el-table-column label="选择题目" width="180" v-if="this.user.status==='student'">
          <template #default="scope">
            <el-button size="small" @click="chooseThesis(scope.$index, scope.row)">
              <span v-if="!choose[scope.$index]">选择</span>
              <span v-else>退选</span>
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <el-dialog
        v-model="dialogVisible"
        title="添加论文题目"
        width="80%"
    >
      <div>
        <el-form ref="thesisForm" :model="newThesis" :rules="rules">
          <el-row>
            <el-col :span="6">
              <el-form-item label="编号：" prop="subId">
                <el-input size="small" style="width: 150px;"
                          v-model="newThesis.subId"
                          autocomplete="false"
                          type="text"
                          placeholder="请输入论文编号">
                </el-input>
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="6">
              <el-form-item label="题目：" prop="subName">
                <el-input size="small" style="width: 150px;"
                          v-model="newThesis.subName"
                          type="text"
                          placeholder="请输入论文题目">
                </el-input>
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="6">
              <el-form-item label="内容：" prop="introduce">
                <el-input size="small" style="width: 150px;"
                          v-model="newThesis.introduce"
                          type="text"
                          placeholder="请输入论文内容">
                </el-input>
              </el-form-item>
            </el-col>
          </el-row>

          <el-row>
            <el-col :span="10">
              <el-form-item label="学生上限：" prop="partNum">
                <el-input size="small" style="width: 150px;"
                          v-model="newThesis.partNum"
                          type="text"
                          placeholder="请设置论文参与学生上限">
                </el-input>
              </el-form-item>
            </el-col>
          </el-row>

        </el-form>
      </div>
      <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="addThesis">
          确定
        </el-button>
      </span>
      </template>
    </el-dialog>
  </div>

</template>

<script>
import {deleteRequest, getRequest, postRequest} from "@/utils/api";

export default {
  name: "Topic.vue",
  data() {
    return {
      user: JSON.parse(window.sessionStorage.getItem('user')),
      keyword: '',
      thesis: [],
      filThesis: [],
      dialogVisible: false,
      choose: {
        index: '',
        value: false
      },
      newThesis: {
        subId: "",
        subName: "",
        introduce: "",
        partNum: ""
      },
      rules: {
        // 校验是否为空
        subId: [{required: true, message: '请输入编号', trigger: 'blur'}],
        subName: [{required: true, message: '请输入题目', trigger: 'blur'}],
        introduce: [{required: true, message: '请输入内容', trigger: 'blur'}],
        partNum: [{required: true, message: '请输入上限人数', trigger: 'blur'}]
      },
      transcripts: {
        stuId: '',
        subId: ''
      }
    }
  },
  mounted() {
    this.getThesis();
  },
  methods: {
    getThesis() {
      getRequest('/subject/info').then(resp => {
        if (resp) {
          this.thesis = resp.data;
          this.filThesis = this.thesis
        }
      })
    },
    search() {
      return this.filThesis = this.thesis.filter((t) => {
        return t["subName"].indexOf(this.keyword) !== -1
      })
    },
    chooseThesis(index, row) {
      if (!this.choose[index]) {
        this.transcripts["stuId"] = this.user["id"]
        this.transcripts["subId"] = row["subId"]
        postRequest("/student/chooseThesis", this.transcripts).then(resp => {
          if (resp) {
            this.choose[index] = !this.choose[index]
          }
        })
      } else {
        deleteRequest("/student/" + this.transcripts.stuId).then(resp => {
          if (resp) {
            this.choose[index] = !this.choose[index]
          }
        })
      }
    },
    showAddThesis() {
      this.dialogVisible = true
    },
    addThesis() {    // 添加检验
      this.$refs.thesisForm.validate((valid) => {
        if (valid) {
          // 检验通过
          postRequest("/subject/addThesis", this.newThesis).then(resp => {
            if (resp) {
              this.dialogVisible = false;
            }
          })
        } else {
          // 检验失败
          console.log(this.newThesis)
          this.$message.error('请输入所有字段');
          return false;
        }
      });
    }
  }
}
</script>

<style scoped>
#message {
  margin: 18px 15px;
}

#head {
  margin: 5px 10px;
  text-align: center;
}
</style>