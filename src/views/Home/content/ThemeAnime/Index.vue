<template>
  <div>
    <AnimeSection></AnimeSection>
    <AnimeAside></AnimeAside>
  </div>
</template>

<script>
import AnimeSection from './AnimeSection';
import AnimeAside from './AnimeAside';
export default {
  data () {
    return {
    };
  },
  components: {
    AnimeSection, AnimeAside,
  },
};
</script>

<style lang='scss' scoped>

</style>
