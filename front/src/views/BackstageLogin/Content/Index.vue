<template>
  <section class="login">
    <h1>Login</h1>
    <Form :label-width="73" label-position="top">
      <FormItem label="name">
        <Input v-model.trim="name" @keyup.enter.native="beforeSubmit" placeholder="Enter name..."/>
      </FormItem>
      <FormItem label="password">
        <Input v-model.trim="password" @keyup.enter.native="beforeSubmit" type="password" placeholder="Enter password..."/>
      </FormItem>
      <FormItem class="my-button">
        <Button type="primary" @click="beforeSubmit">Submit</Button>
        <Button style="margin-top: 20px" @click="back">Cancel</Button>
      </FormItem>
    </Form>
  </section>
</template>

<script>
import Service from '@/service';
import { loading } from '@/mixins/loading';
export default {
  mixins: [loading],
  data () {
    return {
      name: '',
      password: '',
    };
  },
  methods: {
    beforeSubmit () {
      if (this.name === '') {
        this.$Message.warning('先输入用户名哦~~');
      } else if (this.password === '') {
        this.$Message.warning('先输入密码哦~~');
      } else {
        this.openLoading('正在登录~~');
        let reqData = {
          name: this.name,
          password: this.password,
        };
        this.submit(reqData);
      }
    },
    async submit (reqData) {
      let res = await Service.getLogin(reqData);
      if (!res.includes('success')) {
        this.$Message.warning(res);
      } else {
        // 成功登录
        console.log('成功登录');
        // 成功登录的返回值是 success+空格+用户id
        let userId = +res.split(' ')[1];
        sessionStorage.setItem('id', userId);
        sessionStorage.setItem('username', this.name);
        this.$store.dispatch('user/SETUSERID', userId);
        this.$store.dispatch('user/SETUSERNAME', this.name);
        this.$router.push({name: 'list'});
      }
      this.$Spin.hide();
    },
    back () {
      window.history.go(-1);
    },
  },
  components: {
  },
};
</script>

<style lang='scss' scoped>
section {
  animation: fadeIn .6s linear;
  padding: 130px 50px 30px;

  h1 {
    text-align: center;
    color: #ff5050;
    text-shadow: 2px 2px 3px #adadad;
    font-size: 42px;
  }

  .ivu-form {
    width: 300px;
    margin: 40px auto 0;
  }
}
</style>
<style lang="scss">
.login {
  .ivu-form {
    .ivu-form-item-label {
      font-size: 14px;
      text-align: left;
    }
    .ivu-form-item-content {
      margin-left: 0 !important;
    }
    input {
      font-size: 14px;
    }
    .my-button {
      margin-top: 60px;
      .ivu-form-item-content {
        text-align: center;

        button {
          width: 100%;
        }
      }
    }
  }
}
</style>
