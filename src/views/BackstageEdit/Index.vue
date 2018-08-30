<template>
  <main>
    <section>
      <Breadcrumb>
        <BreadcrumbItem to="/">博客首页</BreadcrumbItem>
        <BreadcrumbItem to="/">后台中心</BreadcrumbItem>
        <BreadcrumbItem>博客编辑页</BreadcrumbItem>
      </Breadcrumb>
      <input type="text" maxlength="36" class="blog-title" v-model="title" placeholder="博客标题..." style="width: 100%" />
      <mavon-editor @save="save" placeholder="编辑内容，支持 Markdown"></mavon-editor>
      <div class="upload-img">
        封面图片：
        <Upload
          ref="upload"
          :on-success="handleSuccess"
          :format="['jpg','jpeg','png']"
          :max-size="2048"
          :on-format-error="handleFormatError"
          :on-exceeded-size="handleMaxSize"
          type="drag"
          action="//jsonplaceholder.typicode.com/posts/">
          <div class="upload-icon">
            <Icon type="ios-camera" size="20"></Icon>
          </div>
        </Upload>
      </div>
      <div class="blog-btn">
        <Button type="primary" size="large" @click="commit">保存 & 提交</Button>
        <Button style="margin-left: 50px" size="large" @click="back">返回</Button>
      </div>
    </section>
    <Footer></Footer>
  </main>
</template>

<script>
import Header from '@/components/Header';
import Footer from '@/components/Footer';
export default {
  data () {
    return {
      title: '',
      markdownDesc: '',
      translateDesc: '',
      defaultList: [],
      imgName: '',
      visible: false,
      uploadList: [],
    };
  },
  methods: {
    // markdown save
    save (value, render) {
      this.markdownDesc = value;
      this.translateDesc = render;
    },

    handleView (name) {
      this.imgName = name;
      this.visible = true;
    },
    handleRemove (file) {
      const fileList = this.$refs.upload.fileList;
      this.$refs.upload.fileList.splice(fileList.indexOf(file), 1);
    },
    handleSuccess (res, file) {
      file.url = 'https://o5wwk8baw.qnssl.com/7eb99afb9d5f317c912f08b5212fd69a/avatar';
      file.name = '7eb99afb9d5f317c912f08b5212fd69a';
    },
    handleFormatError (file) {
      this.$Notice.warning({
        title: 'The file format is incorrect',
        desc: 'File format of ' + file.name + ' is incorrect, please select jpg or png.',
      });
    },
    handleMaxSize (file) {
      this.$Notice.warning({
        title: 'Exceeding file size limit',
        desc: 'File  ' + file.name + ' is too large, no more than 2M.',
      });
    },

    // save and commit
    commit () {
      // TODO
    },
    back () {
      window.history.back(-1);
    },
  },
  components: {
    Header, Footer,
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

  .upload-img {
    padding: 30px 0 40px;
    font-size: 14px;

    .ivu-upload {
      margin: 0 auto;
      width:200px;
      .upload-icon {
        cursor: url(../../assets/pic/cursor.cur), pointer !important;
        width: 200px;
        height:200px;
        line-height: 200px;
        i {
          font-size: 36px !important;
        }
      }
    }
  }

  .blog-btn {
    text-align: center;

    button {
      width: 160px;
    }
  }
}
</style>
<style>
.v-note-wrapper .v-note-op .v-left-item .op-icon, .op-icon input {
  cursor: url(../../assets/pic/cursor.cur), pointer !important;
}
</style>
