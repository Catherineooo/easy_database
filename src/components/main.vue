<template>
    <div>
        <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">退出登录</el-breadcrumb-item>
        </el-breadcrumb>
      <h1>学生查询</h1>

      <div>
    <el-row type="flex" justify="center" align="middle" >
      <el-col :span="10">
        <el-form :model="form" label-width="80px">
          <el-form-item label="姓名:" style="display: flex; align-items: center;">
            <el-input v-model="form.name" placeholder="请输入姓名" style="width: 200px;" prefix-icon="el-icon-search" clearable ></el-input>
            <el-button type="primary" @click="fetchFormData" style="margin-left:20px">查询</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </div>
      
      <div>
        <el-table  :data="tableData" 
        style="width: 100%">
            <el-table-column
                    label="序号"
                    prop="index"
            >
            </el-table-column>
            <el-table-column
                    label="name"
                    prop="name">
            </el-table-column>
            <el-table-column
                    label="age"
                    prop="age">
            </el-table-column>
            
            <el-table-column
                    label="class"
                    prop="classes">
            </el-table-column>
            <el-table-column
                    label="height"
                    prop="height">
            </el-table-column>
            <el-table-column
                    label="weight"
                    prop="weight">
            </el-table-column>
        </el-table>

      </div>
    </div>
  </template>
  
  <script>
  import axios from "axios";
  
  export default {
    data() {
      return {
        form: {
          age: null,//要查询的年龄
          name:''
        },
        formData: null,

        homeworkDialogVisible: false,
        tableData: [],
        /*[
        {
            index:'1',
            name:'apple',
            age:18,
            class:2,
            height:180,
            weight:60
        }],*/
      };
    },
    created(){
        if(this.$store.state.token == ""){
            this.$message('请登录')
            this.$router.push('/');
        }
    },
    methods: {
        fetchFormData() {//async
        console.log("name="+this.form.name)
        this.$axios({
                url: this.baseUrl+":"+this.port+"/query/name",//123.57.172.153  182.92.149.21
                method: 'post',
                data: JSON.stringify({
                    name: this.form.name
                }),
                headers: { 'Content-Type': 'application/json' }                
            }).then(res => {//code msg data
                this.tableData = res.data.map((item, index) => {
                    return { ...item, index: index + 1 };
                });
            }).catch(error => {
                console.error("Error occurred:", error);
            });
        }

     }
      
    }

  </script>
  
  <style scoped>
  /* 在这里可以定义组件的样式 */
  </style>
  