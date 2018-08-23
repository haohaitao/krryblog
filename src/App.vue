<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App',
};
</script>

<style>
html, body {
  height: 100%;
  cursor: url(./assets/pic/pointer.cur), default;
}
a, button {
  cursor: url(./assets/pic/cursor.cur), pointer !important;
}
a {
  color: #666;
}
a:hover {
  color: #eb5055;
  transition: .4s;
}
ul li {
  list-style: none;
}
.right {
  float: right;
}
.left {
  float: left;
}
img {
  vertical-align: middle;
}

/* 滚动条优化 */
::-webkit-scrollbar {
  width: 8px;
  height: 8px;
}
::-webkit-scrollbar-track {
  background-color: transparent;
  -webkit-border-radius: 2em;
  -moz-border-radius: 2em;
  border-radius: 2em;
}
::-webkit-scrollbar-track-piece {
  background:#fff;
}
::-webkit-scrollbar-thumb {
  background-color: #ff8b18;
  background-image: -webkit-linear-gradient(45deg,rgba(255,255,255,.4) 25%,transparent 25%,transparent 50%,rgba(255,255,255,.4) 50%,rgba(255,255,255,.4) 75%,transparent 75%,transparent);
  -webkit-border-radius: 2em;
  -moz-border-radius: 2em;
  border-radius: 2em;
}
::-webkit-scrollbar-thumb:hover {
  cursor: url(./assets/pic/cursor.cur), pointer;
  background-color: #ff4f00;
}
::-webkit-scrollbar-corner {
  background: #535353;
}
::-webkit-scrollbar-resizer {
  background: #FF0BEE;
}
scrollbar {
  -moz-appearance: none !important;
  background: rgb(0,255,0) !important;
}
scrollbarbutton {
  -moz-appearance: none !important;
  background-color: rgb(0,0,255) !important;
}
scrollbarbutton:hover {
  -moz-appearance: none !important;
  background-color: rgb(255,0,0) !important;
}
/* 隐藏上下箭头 */
scrollbarbutton {
  display: none !important;
}
/* 纵向滚动条宽度 */
scrollbar[orient="vertical"] {
  min-width: 12px !important;
}
::selection {
  background: #FF5252;
  color: #fff;
}
</style>
