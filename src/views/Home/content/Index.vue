<template>
  <main>
    <section>
      <ContentSection></ContentSection>
      <ContentAside></ContentAside>
    </section>
    <div class="clear"></div>
  </main>
</template>

<script>
import ContentSection from './ContentSection';
import ContentAside from './ContentAside';
export default {
  data () {
    return {
    };
  },
  components: {
    ContentSection, ContentAside,
  },
};
</script>

<style lang='scss' scoped>
main {
  width: 1080px;
  margin: 56px auto;
}
</style>
