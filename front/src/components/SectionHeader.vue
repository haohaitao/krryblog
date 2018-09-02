<template>
  <div class="header">
    <h1>『{{title}}』</h1>
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

  h1 {
    font-weight: 100;
    font-size: 30px;
    margin-bottom: 10px;
    letter-spacing: .1em;
    color: #fff;
    text-shadow: 0 4px 8px rgba(7,17,27,.4);
  }

  h4 {
    font-weight: 100;
    font-size: 15px;
    color: rgba(255,255,255,0.54);
  }
}
</style>
