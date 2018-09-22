<template>
  <section class="list">
    <h1>~Wellcome~</h1>
    <router-link :to="{name: 'edit'}">
      <Button type="success" class="add-button">add</Button>
    </router-link>
    <Table border stripe :columns="columns" :data="blogList"></Table>
    <Page v-if="blogLen > 10" :total="blogLen" size="small" :page-size="10" show-elevator @on-change="changePage"/>
  </section>
</template>

<script>
import Service from '@/service';
export default {
  props: {
    blogList: {
      type: Array,
    },
    blogLen: {
      type: Number,
    },
  },
  data () {
    return {
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
          width: 150,
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
          title: '标签',
          key: 'label',
        },
        {
          title: '点击 / 评论',
          width: 103,
          key: 'hitComment',
        },
        {
          title: '发表时间',
          width: 106,
          key: 'createTime',
        },
        {
          title: '最后更新',
          width: 106,
          key: 'updateTime',
        },
        {
          title: '状态',
          width: 90,
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
          width: 140,
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
                      title: params.row.title,
                      markdownDesc: params.row.content_md,
                      description: params.row.description,
                      imgName: params.row.imageName,
                      uploadImgUrl: params.row.image,
                      classifyId: params.row.classifyId,
                      label: params.row.label,
                      statusFlag: !!params.row.status,
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
  methods: {
    changePage (pageNo) {
      this.$emit('changePage', pageNo);
    },
    // 设置发布状态
    async setStatus (id, val) {
      console.log(id, val);
      this.$Spin.show({
        render: (h) => {
          return h('div', [
            h('Icon', {
              'class': 'icon-load',
              props: {
                type: 'ios-loading',
                size: 26,
              },
            }),
            h('div', '正在修改~~'),
          ]);
        },
      });
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
      this.$Spin.show({
        render: (h) => {
          return h('div', [
            h('Icon', {
              'class': 'icon-load',
              props: {
                type: 'ios-loading',
                size: 26,
              },
            }),
            h('div', '正在删除~~'),
          ]);
        },
      });
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
  padding: 90px 0 30px;
  width: 1020px;
  margin: 0 auto;

  h1 {
    text-align: center;
    color: #ff5050;
    text-shadow: 1px 1px 2px #adadad;
    font-size: 36px;
  }

  .add-button {
    float: right;
    width: 80px;
    margin-top: -15px;
  }

  .ivu-table-wrapper {
    margin-top: 28px;
  }
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
