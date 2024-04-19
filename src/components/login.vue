<template>
    <div class="login">

        <h1 style="text-align: center">登录</h1>
        <el-form ref="form" :model="form" :rules="rules" label-width="80px">
            <el-form-item label="用户名：" prop="name">
                <el-input v-model="form.name" placeholder="请输入用户名"></el-input>
            </el-form-item>

            <el-form-item label="密码：" prop="passwd">
                <el-input v-model="form.passwd" placeholder="请输入密码" show-password clearable></el-input>
            </el-form-item>

            <el-form-item label-width="0px">
                <!-- <el-button size="medium" style="border-color: #ded9d9; margin-right: 43%; left: 0px;" @click="clickRegister">创建账户</el-button> -->
                <el-button type="primary" size="medium" :loading = "isLoading" @click="ClickLogin" >{{text}}</el-button>
            </el-form-item>

        </el-form>
    </div>
</template>

<script>

import axios from 'axios';
    export default {
        name: "login",
        data() {
            return {
                state: -1,//状态为1，说明登录成功
                type: 0,
                text: "登录",
                isDisabled: false,
                isLoading: false,
                form: {
                    name: '',
                    passwd: '',
                },
                rules: {
                    name: [
                        {
                            required: true, message: "请输入用户名", trigger: 'blur'
                        },
                    ],
                    passwd: [
                        {
                            required: true, message: "请输入密码", trigger: 'blur'
                        },
                        {
                            min: 6, message: "密码必须大于6", trigger: 'blur'
                        }
                    ]
                },
            }
        },
        methods: {
            ClickLogin() {
                // this.isLoading = !this.isLoading;
                // this.text = "";
                if (this.isLoading) {
                    this.text = ""
                }
                //发送post请求，先注释掉  /login apiUrl
                console.log("logining="+this.baseUrl+":"+this.port+"/user/login")
                this.$refs["form"].validate((valid) => {
                    if (valid) {
                        console.log("submit!"+this.form.name+this.form.passwd);
                        this.$axios({
                            url: this.baseUrl+":"+this.port+"/user/login",//123.57.172.153 182.92.149.21
                            method: 'post',
                            data: JSON.stringify({
                                username: this.form.name,
                                password: this.form.passwd,
                            }),
                            headers: { 'Content-Type': 'application/json' }

                            
                        }).then(res => {//code msg data

                            this.text = "";
                            this.isLoading = true;
                            this.$store.state.token = res.data.token;
                            this.$store.state.user = this.form.user;
                            // this.$store.state.type = res.data.data;//对应类型，如果0--t，1--s
                            this.$store.state.code = res.data.code;//登录成功返回code 1
                            this.loginProcess();
                        })
                    } else {
                        this.text = "登录";
                        this.isLoading = false;
                        console.log('error submit!!');
                        return false;
                    }
                });
            },

                            /*data: {
                                user: this.form.name,
                                password: this.form.passwd,
                            },
                            transformRequest: [function (data) {
                                let ret = '';
                                for (let it in data) {
                                    ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
                                }
                                return ret
                            }],
                            headers: {'Content-Type': 'application/x-www-form-urlencoded'}*/
            loginProcess() {
                console.log("code="+this.$store.state.code);
                if (this.$store.state.code === "0") {//登录成功 字符串
                    this.$router.push('/main');
                }else {
                    this.text = "登录";
                    this.isLoading = false;
                    console.log("账号或密码错误！");
                    this.$message('账号或密码错误！');
                }
            },
        },




    }
</script>

<!-- scoped -->
<style >

    .login {
        margin: auto;
        height: 300px;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        width: 20rem;
        position: absolute;
        background-color: rgba(255, 255, 255, 0.8);
        padding: 20px 20px 10px 20px;
        border-radius: 10px;
        box-shadow: 0px 15px 25px 0px rgba(0, 0, 0, 0.11);
    }

</style>
