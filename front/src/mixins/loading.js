export let loading = {
  methods: {
    openLoading (message) {
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
            h('div', message),
          ]);
        },
      });
    },
  },
};
