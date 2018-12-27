<template>
  <section class="list">
    <h1>~Wellcome {{userName}}~</h1>
    <router-link :to="{name: 'edit'}">
      <Button type="success" class="add-button">Add</Button>
    </router-link>
    <a href="javascript:void(0)" @click="showDialog" class="modify-buttom">修改个人信息</a>
    <Modal
      width="400"
      v-model="showModel"
      title="Modifying personal information">
      <Form :model="userForm" :rules="rule" label-position="top" ref="userForm">
        <FormItem label="User Name" prop="newName">
          <i-input v-model="userForm.newName" autocomplete="off" :maxlength="10" width="100" placeholder="Please enter your name..."></i-input>
        </FormItem>
        <p class="text-right"><a href="javascript:void(0)" @click="showPW = !showPW">{{showPWmsg}}</a></p>
        <template v-if="showPW">
          <FormItem label="Original Password" prop="originPW">
            <i-input v-model="userForm.originPW" type="password" autocomplete="off" :maxlength="20" placeholder="Please enter your original password..."></i-input>
          </FormItem>
          <FormItem label="New Password" prop="newPW">
            <i-input v-model="userForm.newPW" type="password" autocomplete="off" :maxlength="20" placeholder="Please enter your new password..."></i-input>
          </FormItem>
          <FormItem label="Repeat The New Password" prop="reNewPW">
            <i-input v-model="userForm.reNewPW" type="password" autocomplete="off" :maxlength="20" placeholder="Please repeat enter your new password..."></i-input>
          </FormItem>
        </template>
      </Form>
      <div slot="footer">
        <Button type="warning" size="large" @click="cancel">Cancel</Button>
        <Button type="primary" size="large" @click="confirmUser">Confirm</Button>
      </div>
    </Modal>
    <Table border stripe :columns="columns" :data="blogList"></Table>
    <Page v-if="blogLen > 10" :total="blogLen" size="small" :page-size="10" show-elevator @on-change="changePage"/>
  </section>
</template>

<script>
import Service from '@/service';
import { loading } from '@/mixins/loading';
export default {
  props: {
    blogList: {
      type: Array,
    },
    blogLen: {
      type: Number,
    },
  },
  mixins: [loading],
  data () {
    const validateRepeatPW = (rule, value, callback) => {
      if (this.userForm['newPW'] !== value) {
        return callback(new Error('Two input password must be consistent'));
      } else {
        callback();
      }
    };
    return {
      showModel: false,
      showPW: false,
      userForm: {
        newName: '',
        originPW: '',
        newPW: '',
        reNewPW: '',
      },
      rule: {
        newName: [
          {
            required: true,
            message: 'The user name cannot be empty',
            trigger: 'blur',
          },
        ],
        originPW: [
          {
            required: true,
            message: 'The original password cannot be empty',
            trigger: 'blur',
          },
          {
            type: 'string',
            min: 6,
            message: 'The password no less than 6 words',
            trigger: 'blur',
          },
        ],
        newPW: [
          {
            required: true,
            message: 'The new password cannot be empty',
            trigger: 'blur',
          },
          {
            type: 'string',
            min: 6,
            message: 'The password no less than 6 words',
            trigger: 'blur',
          },
        ],
        reNewPW: [
          {
            required: true,
            message: 'The repeat new password cannot be empty',
            trigger: 'blur',
          },
          {
            type: 'string',
            min: 6,
            message: 'The password no less than 6 words',
            trigger: 'blur',
          },
          {
            validator: validateRepeatPW,
            trigger: 'blur',
          },
        ],
      },
      columns: [
        {
          type: 'selection',
          width: 60,
          align: 'center',
        },
        {
          title: 'ID',
          width: 60,
          key: 'id',
        },
        {
          title: '标题',
          width: 140,
          key: 'title',
          render: (h, params) => {
            return h('router-link', {
              props: {
                to: `/${params.row.id}`,
              },
            }, params.row.title);
          },
        },
        {
          title: '存档',
          width: 97,
          key: 'classify',
          render: (h, params) => {
            return h('router-link', {
              props: {
                to: `/category/${params.row.classifyId}`,
              },
            }, params.row.classify);
          },
        },
        {
          title: '作者',
          key: 'userName',
        },
        {
          title: '标签',
          width: 90,
          key: 'label',
        },
        {
          title: '点击 / 评论',
          width: 97,
          key: 'hitComment',
        },
        {
          title: '发表时间',
          width: 100,
          key: 'createTime',
        },
        {
          title: '最后更新',
          width: 100,
          key: 'updateTime',
        },
        {
          title: '状态',
          width: 80,
          key: 'status',
          align: 'center',
          render: (h, params) => {
            return h('i-switch', {
              props: {
                value: !!params.row.status,
              },
              on: {
                'on-change': val => {
                  this.setStatus(params.row.id, val);
                },
              },
            }, [
              h('Icon', {
                props: {
                  type: 'md-checkmark',
                },
                slot: 'open',
              }),
              h('Icon', {
                props: {
                  type: 'md-close',
                },
                slot: 'close',
              }),
            ]);
          },
        },
        {
          title: '操作',
          key: 'action',
          width: 130,
          align: 'center',
          render: (h, params) => {
            return h('div', {
            }, [
              h('router-link', {
                props: {
                  to: {
                    name: 'edit',
                    params: {
                      id: params.row.id,
                      imgName: params.row.imageName,
                      uploadImgUrl: params.row.image,
                    },
                  },
                },
              }, [
                h('Button', {
                  props: {
                    type: 'primary',
                    size: 'small',
                  },
                  style: {
                    marginRight: '10px',
                  },
                }, '修改'),
              ]),
              h('Button', {
                props: {
                  type: 'error',
                  size: 'small',
                },
                on: {
                  click: () => {
                    this.beforeRemove(params.row['id'], params.row['title']);
                  },
                },
              }, '删除'),
            ]);
          },
        },
      ],
    };
  },
  computed: {
    userName () {
      return this.$store.getters['user/username'];
    },
    userId () {
      return this.$store.getters['user/id'];
    },
    showPWmsg () {
      return this.showPW ? '收起，不修改密码' : '修改密码';
    },
  },
  methods: {
    changePage (pageNo) {
      this.$emit('changePage', pageNo);
    },
    showDialog () {
      this.showModel = true;
      this.userForm['newName'] = this.userName;
    },
    // 确认修改个人信息
    confirmUser () {
      this.$refs['userForm'].validate(async (valid) => {
        if (valid) {
          this.openLoading('正在修改~~');
          let reqData = {
            id: this.userId,
            name: this.userForm['newName'],
          };
          if (this.showPW) {
            // 如果修改密码
            reqData = Object.assign({}, reqData, {
              originWord: this.userForm['originPW'],
              password: this.userForm['newPW'],
            });
          }
          let res = await Service.updateUser(reqData);
          this.$Spin.hide();
          if (res !== 'success') {
            this.$Message.error(res);
          } else {
            // 修改成功，更改 session 和 vuex 中的数据
            sessionStorage.setItem('username', reqData.name);
            this.$store.dispatch('user/SETUSERNAME', reqData.name);
            this.$Message.success('Modified success!');
            this.cancel();
          }
        } else {
        }
      });
    },
    cancel () {
      this.showModel = false;
      this.$refs['userForm'].resetFields();
      this.showPW = false;
    },
    // 设置发布状态
    async setStatus (id, val) {
      console.log(id, val);
      this.openLoading('正在修改~~');
      let reqData = {
        id: id,
        status: val ? 1 : 0,
      };
      let msg = await Service.updateBlog(reqData);
      if (msg === 'success') {
        // 同步已查询出来的数据
        this.$emit('statusBlog', reqData);
        this.$Message.success('修改成功');
      } else {
        this.$Message.error('出错了呢，修改失败...');
      }
      this.$Spin.hide();
    },
    beforeRemove (id, title) {
      console.log('删除id：' + id);
      this.$Modal.confirm({
        title: '提示~',
        content: `<p>是否删除博客 “ ${title} ” ？</p>`,
        onOk: () => {
          this.remove(id);
        },
      });
    },
    async remove (id) {
      this.openLoading('正在删除~~');
      let reqData = {
        id: id,
        isDelete: 1,
      };
      let msg = await Service.updateBlog(reqData);
      if (msg === 'success') {
        // refresh local data
        this.$emit('deleteBlog', id);
        this.$Message.success('删除成功');
      } else {
        this.$Message.error('出错了呢，删除失败...');
      }
      this.$Spin.hide();
    },
  },
  components: {
  },
};
</script>

<style lang='scss' scoped>
section {
  animation: fadeIn .6s linear;
  padding: 90px 0 0px;
  width: 1020px;
  margin: 0 auto;

  h1 {
    text-align: center;
    color: #ff5050;
    text-shadow: 1px 1px 2px #adadad;
    font-size: 36px;
  }

  .add-button {
    float: left;
    width: 80px;
    margin-top: -15px;
  }

  .modify-buttom {
    float: right;
  }

  .ivu-table-wrapper {
    margin-top: 28px;
  }
}
.text-right {
  text-align: right;
}
</style>
<style lang="scss">
.list {
  .ivu-table-wrapper {
    .ivu-table-tbody {
      .ivu-table-cell {
        display: -webkit-box;
        -webkit-box-orient: vertical;
        -webkit-line-clamp: 2;
        overflow: hidden;
      }
    }

    .ivu-checkbox-input {
      cursor: url(../../../assets/pic/cursor.cur), pointer !important;
    }
  }
}
</style>
