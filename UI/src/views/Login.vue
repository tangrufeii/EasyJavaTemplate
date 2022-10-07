<script type="text/javascript" src="js/jquery.captcha.js"></script>
<template>

  <el-form :model="ruleForm2" :rules="rules2" ref="ruleForm2" label-position="left"  class="demo-ruleForm login-container">
    <h3 class="title">订单管理系统</h3>
    <el-form-item label="账号" prop="account" >
      <el-input type="text" v-model="ruleForm2.account" auto-complete="off" placeholder="账号" ></el-input>
    </el-form-item>
    <el-form-item prop="checkPass" label="密码">
      <el-input type="password" v-model="ruleForm2.checkPass" auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item prop="imageCode" label="验证码">
      <el-input type="text"  v-model="ruleForm2.imageCode" auto-complete="on" placeholder="验证码">

      </el-input>
      <br>
      <label class="captcha">
        <img id="captcha-image-temp" @click="getImageCode"
             class="captcha-image-temp" :src="imageCode" alt="点击换图" title="点击换图" style="vertical-align: middle; cursor: pointer;">
      </label>
    </el-form-item>

    <!--<el-checkbox v-model="checked" checked class="remember">记住密码</el-checkbox>-->
    <el-form-item style="width:100%;">
      <el-button type="primary"   v-show="ruleForm2.imageCode!=''&ruleForm2.imageCode!=''&ruleForm2.imageCode!=''" style="width:100%;" @click.native.prevent="handleSubmit2" :loading="logining">登录</el-button>
      <el-button type="primary"  v-show="ruleForm2.imageCode==''" style="width:100%;" @click.native.prevent="handleSubmit2" :loading="logining" plain disabled>你登录你妈呢</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
  import { requestLogin } from '../api/api';
  //import NProgress from 'nprogress'
  export default {
    data() {
      return {
        imageCodePrefix:"data:image/jpg;base64,",
        logining: false,
        imageCode:'',
        heiheihei:'',
        imageCodeKey:'',
        ruleForm2: {
          account: 'admin',
          checkPass: '123456',
          imageCode: '',
          imageCodeKey:'',
        },
        rules2: {
          account: [
            { required: true, message: '请输入账号', trigger: 'blur' },
            //{ validator: validaePass }
          ],
          checkPass: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            //{ validator: validaePass2 }
          ],
          imageCode: []
        },
        checked: true
      };
    },
    methods: {
      //生成UUID
      createUuid(){
        var s = [];
        var hexDigits = "0123456789abcdefghi";
        for (var i = 0; i < 36; i++) {
          s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
        }
        s[14] = "4"; // bits 12-15 of the time_hi_and_version field to 0010
        s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1); // bits 6-7 of the clock_seq_hi_and_reserved to 01
        s[8] = s[13] = s[18] = s[23] = "-";
        var uuid = s.join("");
        console.log("11111111111111111111");
        console.log(uuid);
        return uuid;
      },
      getImageCode(){

        //发送请求到后台获取数据  VerifycodeController
        let imageCodeValue = sessionStorage.getItem("LoginImageCodeKey");
        if(!imageCodeValue || imageCodeValue === ''){
          //第一次进入页面
          imageCodeValue = this.createUuid();
          sessionStorage.setItem("LoginImageCodeKey",imageCodeValue);
        }
        //发送请求，获取图片验证的Base64数据
        this.$http.get("/jiuzhe/system/login/verifycode/imageCode/"+imageCodeValue).then(res=>{
          //res.data :就是base64编码后的图片的字符串
          this.imageCode =  res.data.data;
          this.imageCodeKey = imageCodeValue;
        });
      },
      //处理登录请求
      handleSubmit2() {
        this.$refs.ruleForm2.validate((valid) => {
          if (valid) {
            this.logining = true;

            var loginParams = {
              userName: this.ruleForm2.account,
              password: this.ruleForm2.checkPass,
              imageCode: this.ruleForm2.imageCode,
              imageCodeKey:this.imageCodeKey
            };

            //发请求获取token
            this.$http.post("/jiuzhe/system/login/login", loginParams).then(res=>{
              if(res != null && res.data != null){
                if(res.data.success){
                  this.$message.success('登录成功！');
                  var token = res.data.data.token;
                  //把token存储起来
                  localStorage.setItem("U-TOKEN",token);
                  localStorage.setItem("avatar",res.data.data.avatar);
                  localStorage.setItem("userName",res.data.data.userName);
                  //修改登录成功后跳转到首页
                  this.$router.push({ path: '/echarts' });
                  this.logining = false;
                  return;
                }else{
                  this.$message.error(res.data.message);
                  this.logining = false;
                  this.getImageCode();
                }
              }else{
                this.$message.error('请求异常');
                this.logining = false;
                this.getImageCode();
              }
            }).catch(error => {
              this.$message.error(error.message);
              this.logining = false;
              this.getImageCode();
              return;
            });
          } else {
            console.log('error submit!!');
            return false;
          }

        });
      }
    },
    mounted(){
      this.getImageCode();
    }
  }

</script>

<style lang="scss" scoped>
  .login-container {
    /*box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);*/
    -webkit-border-radius: 5px;
    border-radius: 5px;
    -moz-border-radius: 5px;
    background-clip: padding-box;
    margin: 180px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
    .title {
      margin: 0px auto 40px auto;
      text-align: center;
      color: #505458;
      font-size: 30px;
    }
    .remember {
      margin: 0px 0px 35px 0px;
    }
  }
</style>