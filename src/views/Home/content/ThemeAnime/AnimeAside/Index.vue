<template>
  <aside class="my-aside right">
    <aside class="right">
      侧边栏1
    </aside>
  </aside>
</template>

<script>
export default {
  data () {
    return {
    };
  },
  components: {
  },
};
</script>

<style lang='scss' scoped>
.my-aside {
  width: 360px;
  height: 600px;

  aside {
    width: 360px;
    height: 200px;
    border-radius: 4px;
    box-shadow: black 0px 0px 4px;
    background: rgba(255, 255, 255, 0.5);
  }
}
</style>
