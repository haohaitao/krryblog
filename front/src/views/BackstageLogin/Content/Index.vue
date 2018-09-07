<template>
  <section class="login">
    <h1>Wellcome Login</h1>
    <Form :label-width="73" label-position="right">
      <FormItem label="name">
        <Input v-model.trim="name" placeholder="Enter name..."/>
      </FormItem>
      <FormItem label="password">
        <Input v-model.trim="password" type="password" placeholder="Enter password..."/>
      </FormItem>
      <FormItem class="my-button">
        <Button type="primary" @click="beforeSubmit">Submit</Button>
        <Button style="margin-left: 38px" @click="back">Cancel</Button>
      </FormItem>
    </Form>
  </section>
</template>

<script>
import Service from '@/service';
export default {
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
        this.$Spin.show({
          render: (h) => {
            return h('div', [
              h('Icon', {
                'class': 'demo-spin-icon-load',
                props: {
                  type: 'ios-loading',
                  size: 26,
                },
              }),
              h('div', '正在登录哦~~'),
            ]);
          },
        });
        let reqData = {
          name: this.name,
          password: this.password,
        };
        this.submit(reqData);
      }
    },
    async submit (reqData) {
      let res = await Service.getLogin(reqData);
      if (res !== 'success') {
        this.$Message.warning(res);
      } else {
        // 成功登录
        console.log('成功登录');
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
    width: 400px;
    margin: 40px auto 0;
    position: relative;
    left: -37px;
  }
}
</style>
<style lang="scss">
.login {
  .ivu-form {
    .ivu-form-item-label {
      font-size: 14px;
    }
    input {
      font-size: 14px;
    }
    .my-button {
      margin-top: 60px;
      .ivu-form-item-content {
        margin-left: 63px !important;
        text-align: center;

        button {
          width: 120px;
        }
      }
    }
  }
}
</style>
