<template>
  <div class="header">
    <h1>
      <span class="e-left">『</span>
      <span class="text">{{title}}</span>
      <span class="e-right">』</span>
    </h1>
    <h4>{{description}}</h4>
  </div>
</template>

<script>
export default {
  props: {
    title: {
      type: String,
    },
    description: {
      type: String,
    },
  },
  data () {
    return {
    };
  },
  components: {
  },
};
</script>

<style lang='scss' scoped>
.header {
  background: url(../assets/pic/category.jpg) no-repeat;
  background-size: cover;
  padding: 96px 0 30px;
  text-align: center;
  background-position-x: -50px;

  h1 {
    position: relative;
    font-weight: 100;
    font-size: 30px;
    margin: 0 auto;
    margin-bottom: 10px;
    letter-spacing: .1em;
    color: #fff;
    text-shadow: 0 4px 8px rgba(7, 17, 27, 0.4);

    .e-left {
      position: relative;
      left: 2px;
      top: -12px;
    }
    .e-right {
      right: 2px;
      top: -12px;
      position: relative;
    }
    .text {
      max-width: 660px;
      overflow: hidden;
      text-overflow: ellipsis;
      white-space: nowrap;
      display: inline-block;
    }
  }

  h4 {
    font-weight: 100;
    font-size: 15px;
    color: rgba(255,255,255,0.54);
  }
}
</style>
