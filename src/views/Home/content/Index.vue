<template>
  <main>
    <section>
      <!-- default use ThemeConcise -->
      <ThemeConcise></ThemeConcise>
      <!-- ThemeAnime -->
      <!-- <ThemeAnime></ThemeAnime> -->
    </section>
    <div class="clear"></div>
  </main>
</template>

<script>
import ThemeAnime from './ThemeAnime';
import ThemeConcise from './ThemeConcise';
export default {
  data () {
    return {
    };
  },
  components: {
    ThemeAnime, ThemeConcise,
  },
};
</script>

<style lang='scss' scoped>
main {
  width: 1080px;
  margin: 100px auto 36px;
}
</style>
