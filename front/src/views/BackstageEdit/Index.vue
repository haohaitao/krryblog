<template>
  <main>
    <section class="add-blog">
      <Breadcrumb>
        <BreadcrumbItem to="/">博客首页</BreadcrumbItem>
        <BreadcrumbItem :to="{name: 'list'}">后台中心</BreadcrumbItem>
        <BreadcrumbItem>博客编辑页</BreadcrumbItem>
      </Breadcrumb>
      <Form>
        <input type="text" maxlength="36" class="blog-title" v-model.trim="title" placeholder="博客标题..." style="width: 100%" />
        <mavon-editor :value="markdownDesc" @save="markdownSave" placeholder="编辑内容，支持 Markdown"></mavon-editor>
        <FormItem label="博客描述：" style="padding-top: 42px">
          <Input v-model.trim="description" :autosize="{minRows: 4,maxRows: 10}" style="width: 460px" type="textarea" :rows="4" placeholder="为博客的写上简单描述吧~~" />
        </FormItem>
        <!-- upload image -->
        <uploadImg :defaultList="defaultUploadList" :uploadImgUrl="uploadImgUrl" :imgName="imgName" @changeImg="changeImg"></uploadImg>
        <FormItem label="分类存档：">
          <RadioGroup v-model="classifyId">
            <Radio :label="item.id" v-for="(item, index) in classifyList" :key="index">
              <span>{{item.name}}</span>
            </Radio>
          </RadioGroup>
        </FormItem>
        <FormItem label="个性标签：">
          <Input v-model.trim="label" placeholder="为博客添加标签吧~~ 英文逗号 , 分割" :maxlength="60" style="width: 360px" />
        </FormItem>
        <FormItem label="是否发布：">
          <i-switch size="large" v-model="statusFlag">
            <span slot="open">ON</span>
            <span slot="close">OFF</span>
          </i-switch>
        </FormItem>
      </Form>
      <div class="blog-btn">
        <Button type="primary" size="large" @click="beforeCommit">保存</Button>
        <Button style="margin-left: 50px" size="large" @click="back">返回</Button>
      </div>
    </section>
    <Footer></Footer>
  </main>
</template>

<script>
import Header from '@/components/Header';
import Footer from '@/components/Footer';
import uploadImg from './UploadImg';
import Service from '@/service';
import '@/assets/css/markdown.css';
import '@/assets/css/github.css';
export default {
  data () {
    return {
      id: 0,
      title: '',
      markdownDesc: '',
      translateDesc: '',
      description: '',
      imgName: '',
      uploadImgUrl: '',
      classifyId: 1,
      label: '',

      statusFlag: true,

      defaultUploadList: [],
    };
  },
  computed: {
    status () {
      return +this.statusFlag;
    },
    // 从接口查询出分类
    classifyList () {
      return this.$store.getters['blog/classify'];
    },
  },
  created () {
    this.getBlogInfo();
  },
  methods: {
    async getBlogInfo () {
      let id = this.$route.params['id'];
      // get blog when edit
      if (id !== undefined) {
        // 设置标题
        document.title = document.title.replace('新增', '编辑');
        let blog = this.$route.params;
        // 参数注入
        for (let key in blog) {
          this[key] = blog[key];
        }
        this.defaultUploadList = [{
          name: this.imgName,
          url: window.location.origin + '/krryblog/' + this.uploadImgUrl,
        }];
      }
    },

    // markdown save
    markdownSave (value, render) {
      this.markdownDesc = value;
      this.translateDesc = render;
    },

    // from child
    changeImg (name, url) {
      this.imgName = name;
      this.uploadImgUrl = url;
    },

    // save and commit
    beforeCommit () {
      let markdownSaveBtn = document.getElementsByClassName('fa-mavon-floppy-o');
      markdownSaveBtn[0].click();
      if (this.title === '') {
        this.$Message.warning('先输入博客标题哦~~');
      } else if (this.translateDesc.trim() === '') {
        this.$Message.warning('先输入博客内容哦~~');
      } else if (this.description === '') {
        this.$Message.warning('先简单描述一下博客哦~~');
      } else if (this.uploadImgUrl === '') {
        this.$Message.warning('先上传封面图片哦~~');
      } else {
        let reqData = this.convertParams();
        this.commit(reqData);
      }
    },
    async commit (reqData) {
      console.log(reqData);
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
            h('div', '正在保存~~'),
          ]);
        },
      });
      if (this.id > 0) {
        // is edit
        console.log('是编辑，id：' + this.id);
        reqData = Object.assign({}, reqData, {id: this.id});
        console.log(reqData);
        let msg = await Service.updateBlog(reqData);
        if (msg === 'success') {
          this.$router.push({name: 'list'});
        } else {
          this.$Message.error('出错了呢，修改失败...');
        }
      } else {
        let id = await Service.addBlog(reqData);
        console.log('保存的id：' + id);
        this.$router.push({name: 'list'});
      }
      this.$Spin.hide();
    },
    convertParams () {
      return {
        title: this.title,
        content_md: this.markdownDesc,
        content_hm: this.translateDesc,
        description: this.description,
        imageName: this.imgName,
        image: this.uploadImgUrl,
        classifyId: this.classifyId,
        label: this.label,
        status: this.status,
      };
    },
    back () {
      window.history.back(-1);
    },
  },
  components: {
    Header, Footer, uploadImg,
  },
};
</script>

<style lang='scss' scoped>
section {
  animation: fadeIn .6s linear;
  padding: 50px;

  .ivu-breadcrumb {
    padding-bottom: 30px;
  }

  .blog-title {
    height: 40px;
    outline: none;
    padding: 0 10px;
    font-size: 14px;
    text-align: center;
    border: none;
    border-top: 1px solid #ddd;
    color: #666;
  }

  .v-note-wrapper {
    z-index: 1009;
  }

  .ivu-form-item {
    padding-top: 24px;
  }

  .blog-btn {
    text-align: center;

    button {
      width: 160px;
    }
  }

  .ivu-radio-wrapper {
    margin-right: 18px;
    cursor: url(../../assets/pic/cursor.cur), pointer !important;
  }
}
</style>
<style lang="scss">
.add-blog {
  .v-note-wrapper .v-note-op .v-left-item .op-icon, .op-icon input, .ivu-radio, .ivu-radio-input {
    cursor: url(../../assets/pic/cursor.cur), pointer !important;
  }

  .ivu-form-item {
    .ivu-form-item-label {
      font-size: 14px;
    }
  }

  .v-note-wrapper {
    .v-note-show {
      .v-show-content {
        ul li {
          list-style: initial !important;
        }
      }
    }
  }
}
</style>
