(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-ca0538b6"],{"06aa":function(t,e,n){"use strict";var a=n("5dfa"),r=n.n(a);r.a},"0c33":function(t,e,n){},"25e8":function(t,e,n){},"4e82":function(t,e,n){"use strict";var a=n("23e7"),r=n("1c0b"),s=n("7b0b"),o=n("d039"),i=n("b301"),l=[].sort,c=[1,2,3],u=o((function(){c.sort(void 0)})),d=o((function(){c.sort(null)})),m=i("sort"),f=u||!d||m;a({target:"Array",proto:!0,forced:f},{sort:function(t){return void 0===t?l.call(s(this)):l.call(s(this),r(t))}})},5231:function(t,e,n){"use strict";var a=n("25e8"),r=n.n(a);r.a},"5dfa":function(t,e,n){},"65d1":function(t,e,n){},"6f00":function(t,e,n){"use strict";var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("el-card",{staticClass:"asidebox"},[n("el-aside",{attrs:{width:"200px"}},[n("el-menu",{attrs:{router:""}},[n("h3",{staticStyle:{"margin-left":"-100px"}},[t._v("订单中心")]),n("el-menu-item",{staticClass:"meauitem",attrs:{index:"/mydata"}},[t._v("我的订单")]),n("el-menu-item",{staticClass:"meauitem",attrs:{index:"/mygame"}},[t._v("我的游戏")]),n("h3",{staticStyle:{"margin-left":"-100px"}},[t._v("我的账号")]),n("el-menu-item-group",[n("el-menu-item",{staticClass:"meauitem",attrs:{index:"/myinfo"}},[t._v("基本信息")]),n("el-menu-item",{staticClass:"meauitem",attrs:{index:"/mysafe"}},[t._v("账户安全")])],1)],1)],1)],1)],1)},r=[],s={},o=s,i=(n("79c9"),n("2877")),l=Object(i["a"])(o,a,r,!1,null,"308d4405",null);e["a"]=l.exports},"79c9":function(t,e,n){"use strict";var a=n("65d1"),r=n.n(a);r.a},ae2a:function(t,e,n){"use strict";var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("el-row",{staticClass:"row",attrs:{gutter:21}},[n("el-col",{attrs:{span:3}},[n("el-image",{staticStyle:{width:"100px",height:"50px","padding-top":"5px"},attrs:{src:t.url,fit:"contain"}})],1),n("el-col",{attrs:{span:6}},[n("el-menu",{attrs:{router:"","default-active":t.activeIndex,mode:"horizontal"},on:{select:t.handleSelect}},[n("el-menu-item",{attrs:{index:"/index"}},[t._v("首页")]),n("el-submenu",{attrs:{index:"2"}},[n("template",{slot:"title"},[t._v("游戏")]),t._l(t.sort,(function(e,a){return n("el-menu-item",{key:a,on:{click:function(e){return t.jump(a)}}},[t._v(t._s(e.sortName))])})),n("hr"),n("el-menu-item",{attrs:{index:"/allgame"}},[t._v("查看所有游戏")])],2),n("el-menu-item",{attrs:{index:"/community"}},[t._v("社区")])],1)],1),n("el-col",{attrs:{span:6}},[n("el-input",{staticClass:"sel",attrs:{placeholder:"请输入关键字"},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.search()}},model:{value:t.sel,callback:function(e){t.sel=e},expression:"sel"}})],1),n("el-col",{attrs:{span:4}},[n("div",{staticClass:"selbtn"},[n("el-button",{attrs:{type:"primary",icon:"el-icon-search",plain:""},on:{click:function(e){return t.search()}}},[t._v("搜索")])],1)]),n("el-col",{attrs:{span:5}},[t.loginbol?t._e():n("div",{staticStyle:{"padding-top":"10px"}},[n("el-button",{attrs:{type:"text"},on:{click:function(e){return t.out()}}},[t._v("登陆注册")])],1),t.loginbol?n("div",{staticClass:"demo-type"},[n("el-popover",{staticClass:"popover",attrs:{placement:"top-start",trigger:"hover"}},[n("el-avatar",{attrs:{slot:"reference",size:"medium",plain:!0},on:{error:t.errorHandler},slot:"reference"},[t.loginbol?t._e():n("img",{attrs:{src:"https://cube.elemecdn.com/e/fd/0fc7d20532fdaf769a25683617711png.png"},on:{click:function(e){return t.skips()}}}),t.loginbol?n("img",{attrs:{src:t.userpic},on:{click:function(e){return t.skips()}}}):t._e()]),t.loginbol?n("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.toMydata()}}},[t._v("个人中心")]):t._e(),n("el-button",{attrs:{type:"danger"},on:{click:function(e){return t.out()}}},[t.loginbol?n("span",[t._v("登出")]):t._e()])],1)],1):t._e()])],1)},r=[],s=(n("4e82"),n("b640")),o=n.n(s),i={data:function(){return{url:o.a,activeIndex:"/index",sel:"",userpic:"https://cube.elemecdn.com/e/fd/0fc7d20532fdaf769a25683617711png.png",userId:"",msgs:"",thisName:"",refash:!1,loginbol:!1,sort:[{sortName:""}]}},created:function(){this.userId=sessionStorage.getItem("userId"),this.loadSort(),this.loadAvatar(),this.loadMsgData()},mounted:function(){var t=this,e=setInterval((function(){t.loadMsgData2(),t.refash&&t.ShowMsg()}),3e3);this.$once("hook:beforeDestroy",(function(){clearInterval(e)}))},methods:{loadAvatar:function(){var t=this,e=JSON.stringify({userinfoId:this.userId});this.$axios.post("/user/showuser",e).then((function(e){e.data?(e.data.userinfoImg&&(t.userpic=e.data.userinfoImg),t.loginbol=!0):t.loginbol=!1})).catch((function(t){return console.log("err",t),t}))},loadSort:function(){var t=this;this.$axios.post("/sort/showsort").then((function(e){e&&(t.sort=e.data)})).catch((function(t){return console.log("err",t),t}))},loadMsgData:function(){var t=this,e=JSON.stringify({privatemsgAcceptid:this.userId});this.$axios.post("/msg/refreshmsg",e).then((function(e){e&&t.msgs!==e.data.privatemsgContent&&(t.msgs=e.data.privatemsgContent,t.thisName=e.data.privatemsgSendname)})).catch((function(t){return console.log("err",t),t}))},loadMsgData2:function(){var t=this,e=JSON.stringify({privatemsgAcceptid:this.userId});this.$axios.post("/msg/refreshmsg",e).then((function(e){e&&(t.msgs!==e.data.privatemsgContent?(t.msgs=e.data.privatemsgContent,t.thisName=e.data.privatemsgSendname,t.refash=!0):t.refash=!1)})).catch((function(t){return console.log("err",t),t}))},ShowMsg:function(){this.$notify({title:this.thisName,iconClass:"el-icon-chat-dot-round",message:this.msgs})},handleSelect:function(t,e){console.log(t,e)},out:function(){this.$router.push({path:"/us_login"}),sessionStorage.removeItem("userId")},search:function(){this.$router.push({path:"/selgame",query:{sel:this.sel}})},errorHandler:function(){return!0},jump:function(t){this.$router.push({path:"/allgame",query:{sortname:this.sort[t].sortName}})},skips:function(){this.loginbol?this.$router.push({path:"/othersdata",query:{thisId:this.userId}}):this.$message.error("请先登陆")},toMydata:function(){this.loginbol?this.$router.push({path:"/mydata"}):this.$message.error("请先登陆")}}},l=i,c=(n("c382"),n("2877")),u=Object(c["a"])(l,a,r,!1,null,null,null);e["a"]=u.exports},b301:function(t,e,n){"use strict";var a=n("d039");t.exports=function(t,e){var n=[][t];return!n||!a((function(){n.call(null,e||function(){throw 1},1)}))}},b640:function(t,e,n){t.exports=n.p+"img/logo.78c810f6.jpg"},c382:function(t,e,n){"use strict";var a=n("0c33"),r=n.n(a);r.a},ce19:function(t,e,n){"use strict";n.r(e);var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("el-container",[n("el-header",[n("indexheader")],1),n("el-container",[n("el-main",{staticClass:"main"},[n("hr",{staticClass:"line"}),n("div",{staticClass:"conbox"},[n("el-row",[n("el-col",{attrs:{span:8}},[n("myaside")],1),n("el-col",{attrs:{span:16}},[n("mybox")],1)],1)],1)])],1)],1)],1)},r=[],s=n("ae2a"),o=n("6f00"),i=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("el-card",{staticClass:"databox"},[n("el-table",{staticStyle:{width:"800px"},attrs:{data:t.ordertabel}},[n("el-table-column",{attrs:{prop:"gameImg",label:"商品图片",width:"200",align:"center"},scopedSlots:t._u([{key:"default",fn:function(t){return[n("img",{attrs:{src:t.row.gameImg,width:"200",height:"120"}})]}}])}),n("el-table-column",{attrs:{prop:"orderName",label:"商品名称",align:"center"}}),n("el-table-column",{attrs:{prop:"orderTime",label:"下单日期",formatter:t.setDate,width:"200",align:"center"}}),n("el-table-column",{attrs:{prop:"orderId",label:"订单号",align:"center"}}),n("el-table-column",{attrs:{prop:"orderPrice",label:"价格",align:"center"}})],1)],1)],1)},l=[],c=n("c1df"),u=n.n(c),d={data:function(){return{userId:"",ordertabel:[{gameImg:"",orderName:"",orderTime:"",orderId:"",orderPrice:""}]}},created:function(){this.userId=sessionStorage.getItem("userId"),this.loadData()},mounted:function(){},methods:{loadData:function(){var t=this,e=JSON.stringify({orderUserid:this.userId});this.$axios.post("/order/showorder",e).then((function(e){e&&200===e.status&&(t.ordertabel=e.data)})).catch((function(t){return console.log("err",t),t}))},setDate:function(t,e){var n=t[e.property];return void 0===n?"":u()(n).format("YYYY-MM-DD HH:mm:ss")}}},m=d,f=(n("5231"),n("2877")),h=Object(f["a"])(m,i,l,!1,null,"80f5a1ac",null),p=h.exports,g={components:{indexheader:s["a"],myaside:o["a"],mybox:p},data:function(){return{}}},v=g,b=(n("06aa"),Object(f["a"])(v,a,r,!1,null,null,null));e["default"]=b.exports}}]);
//# sourceMappingURL=chunk-ca0538b6.e1d0f7b3.js.map