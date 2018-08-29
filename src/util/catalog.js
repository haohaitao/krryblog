'use strict';

var _typeof = typeof Symbol === 'function' && typeof Symbol.iterator === 'symbol' ? function (obj) { return typeof obj; } : function (obj) { return obj && typeof Symbol === 'function' && obj.constructor === Symbol && obj !== Symbol.prototype ? 'symbol' : typeof obj; };

export default function (opts) {
  var defaultOpts = {
    linkClass: 'cl-link', // 所有目录项都有的类
    linkActiveClass: 'cl-link-active', // active的目录项
    datasetName: 'data-cata-target', // 目录项DOM的attribute存放对应目录的id
    selector: ['h1', 'h2', 'h3', 'h4', 'h5', 'h6'], // 按优先级排序
    // scrollWrapper: null, // 滚动条区域
    activeHook: null, // 激活时候回调
    topMargin: 0,
    bottomMargin: 0,
  };

  var Opt = Object.assign({}, defaultOpts, opts);

  var $content = document.getElementById(Opt.contentEl); // 内容获取区
  // var $scrollWrap = Opt.scrollWrapper; // 滚动条区域
  var $catalog = document.getElementById(Opt.catalogEl); // 目录容器

  var allCatalogs = $content.querySelectorAll(Opt.selector.join());
  var tree = getCatalogsTree(allCatalogs);

  try {
    $catalog.innerHTML = '<div class=\'cl-wrapper\'>' + generateHtmlTree(tree, { id: -1 }) + '</div>';
  } catch (e) {
    console.error('error in progress-catalog', e);
  }

  // 事件注册
  $catalog.addEventListener('click', clickHandler);
  Opt.cool || window.addEventListener('scroll', simpleScrollHandler);

  /**
   * 滚动事件
   */
  function simpleScrollHandler (el) {
    var scrollToEl = null;
    for (var i = allCatalogs.length - 1; i >= 0; i--) {
      var scrollTop = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;
      if (allCatalogs[i].offsetTop <= scrollTop + 80) {
        scrollToEl = allCatalogs[i];
        break;
      }
    }
    if (scrollToEl) {
      setActiveItem(scrollToEl.id);
    } else {
      setActiveItem(null); // 无匹配的元素
    }
  }
  /**
   * 点击事件
   */
  function clickHandler (_ref) {
    var target = _ref.target;

    var datasetId = target.getAttribute(Opt.datasetName);
    target.classList.contains(Opt.linkClass) && document.getElementById(datasetId).scrollIntoView({ behavior: 'smooth', block: 'start' });
  }

  /**
   * 获取目录树，生成类似于Vnode的树
   * @param catalogs
   */
  function getCatalogsTree (catalogs) {
    var title = void 0;
    var tagName = void 0;
    var tree = [];
    var treeItem = {};
    var parentItem = { id: -1 };
    var lastTreeItem = null;
    var id = void 0;

    for (var i = 0; i < catalogs.length; i++) {
      title = catalogs[i].innerText || catalogs[i].textContent;
      tagName = catalogs[i].tagName;
      id = 'heading-' + i;
      catalogs[i].id = id;
      treeItem = {
        name: title,
        tagName: tagName,
        id: id,
        level: +getLevel(tagName),
        parent: parentItem,
      };
      if (lastTreeItem) {
        if (getLevel(treeItem.tagName) > getLevel(lastTreeItem.tagName)) {
          treeItem.parent = lastTreeItem;
        } else {
          treeItem.parent = findParent(treeItem, lastTreeItem);
        }
      }
      lastTreeItem = treeItem;
      tree.push(treeItem);
    }
    return tree;
  }

  /**
   * 找到当前节点的父级
   * @param currTreeItem
   * @param lastTreeItem
   * @returns {*|Window}
   */
  function findParent (currTreeItem, lastTreeItem) {
    var lastTreeParent = lastTreeItem.parent;
    while (lastTreeParent && getLevel(currTreeItem.tagName) <= getLevel(lastTreeParent.tagName)) {
      lastTreeParent = lastTreeParent.parent;
    }
    return lastTreeParent || { id: -1 };
  }

  /**
   *  获取等级
   * @param tagName
   * @returns {*}
   */
  function getLevel (tagName) {
    return tagName ? tagName.slice(1) : 0;
  }

  /**
   * 生成DOM树
   * @param tree
   * @param _parent
   * @return {string}
   */
  function generateHtmlTree (tree, _parent) {
    var ul = void 0;
    var hasChild = false;
    if (tree) {
      ul = '<ul>';
      for (var i = 0; i < tree.length; i++) {
        if (isEqual(tree[i].parent, _parent)) {
          hasChild = true;
          ul += '<li><div class=\'' + Opt.linkClass + ' cl-level-' + tree[i].level + '\' ' + Opt.datasetName + '=\'' + tree[i].id + '\'>' + tree[i].name + '</div>';
          ul += generateHtmlTree(tree, tree[i]);
          ul += '</li>';
        }
      }
      ul += '</ul>';
    }
    return hasChild ? ul : '';
  }

  /**
   * 判断是否是相同节点
   */
  function isEqual (node, node2) {
    return node && node2 && (typeof node === 'undefined' ? 'undefined' : _typeof(node)) === 'object' && (typeof node2 === 'undefined' ? 'undefined' : _typeof(node2)) === 'object' && node.id === node2.id;
  }

  /**
   *  设置选中的项
   */
  function setActiveItem (id) {
    var _this = this;

    var catas = [].concat(_toConsumableArray($catalog.querySelectorAll('[' + Opt.datasetName + ']')));

    catas.forEach(function (T) {
      if (T.getAttribute(Opt.datasetName) === id) {
        typeof Opt.activeHook === 'function' && !T.classList.contains(Opt.linkActiveClass) && Opt.activeHook.call(_this, T); // 执行active钩子
        T.classList.add(Opt.linkActiveClass);
      } else {
        T.classList.remove(Opt.linkActiveClass);
      }
    });
  }
};

function _toConsumableArray (arr) {
  if (Array.isArray(arr)) {
    for (var i = 0, arr2 = Array(arr.length); i < arr.length; i++) {
      arr2[i] = arr[i];
    }
    return arr2;
  } else {
    return Array.from(arr);
  }
}
