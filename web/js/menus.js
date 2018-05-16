/*
 * 页面的加载事件，发送异步请求
 */
//1 配置ztree树
var setting={

    data:{
        simpleData:{
            enable:true,  //ztree提供数据的json为简单json
            idKey:"mid",
            pIdKey:"pmid"
        },
        key:{

            name:"mname"
        }
    }

};
//2发送异步请求
$(document).ready(function(){

    $.post("loadMenusResources.action",function(data){
        //window.alert(data)

        //3 显示ztree
        $.fn.zTree.init($("#treeDemo"),setting,data)
    });
});