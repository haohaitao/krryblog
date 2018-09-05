<template>
  <main>
    <section class="add-blog">
      <Breadcrumb>
        <BreadcrumbItem to="/">博客首页</BreadcrumbItem>
        <BreadcrumbItem to="/">后台中心</BreadcrumbItem>
        <BreadcrumbItem>博客编辑页</BreadcrumbItem>
      </Breadcrumb>
      <Form>
        <input type="text" maxlength="36" class="blog-title" v-model.trim="title" placeholder="博客标题..." style="width: 100%" />
        <mavon-editor @save="markdownSave" placeholder="编辑内容，支持 Markdown"></mavon-editor>
        <FormItem label="博客描述：" style="padding-top: 42px">
          <Input v-model.trim="description" :autosize="{minRows: 4,maxRows: 10}" style="width: 460px" type="textarea" :rows="4" placeholder="为博客的写上简单描述吧~~" />
        </FormItem>
        <!-- upload image -->
        <uploadImg :uploadImgUrl="uploadImgUrl" @changeImgUrl="changeImgUrl"></uploadImg>
        <FormItem label="分类归档：">
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
export default {
  data () {
    return {
      title: '',
      markdownDesc: '',
      translateDesc: '',
      description: '',
      uploadImgUrl: '',
      classifyId: 1,
      label: '',

      statusFlag: true,
    };
  },
  computed: {
    status () {
      return +this.statusFlag;
    },
    // 从接口查询出分类归档
    classifyList () {
      return this.$store.getters['blog/classify'];
    },
  },
  created () {
  },
  methods: {
    // markdown save
    markdownSave (value, render) {
      this.markdownDesc = value;
      this.translateDesc = render;
    },

    // from child
    changeImgUrl (url) {
      this.uploadImgUrl = url;
    },

    // save and commit
    beforeCommit () {
      let markdownSaveBtn = document.getElementsByClassName('fa-mavon-floppy-o');
      markdownSaveBtn[0].click();
      if (this.title === '') {
        this.$Message.warning('先输入博客标题哦~~');
        return false;
      } else if (this.translateDesc.trim() === '') {
        this.$Message.warning('先输入博客内容哦~~');
        return false;
      } else if (this.description === '') {
        this.$Message.warning('先简单描述一下博客哦~~');
        return false;
      } else if (this.uploadImgUrl === '') {
        this.$Message.warning('先上传封面图片哦~~');
        return false;
      }
      let reqData = this.convertParams();
      this.commit(reqData);
    },
    async commit (reqData) {
      console.log(reqData);
      let id = await Service.addBlog(reqData);
      console.log(id);
    },
    convertParams () {
      return {
        title: this.title,
        content_md: this.markdownDesc,
        content_hm: this.translateDesc,
        description: this.description,
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
}
</style>
