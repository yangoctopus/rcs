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
	},
	check:{ //在树节点前面显示复选框
		enable:true
	}
	
};
//2发送异步请求
$(document).ready(function(){
	//加载所有资源
	$.post("loadMenus.action",function(data){
		
		//3 显示ztree
		$.fn.zTree.init($("#treeDemo"),setting,data)
		
		//发送二次ajax请求，加载某个角色的资源
		var rid=$("#roleid").val();
		
		$.post("loadRoleMenus.action","roleid="+rid,function(data){
			//获得整棵树对象
			var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
			
			$(data).each(function(index,item){
				var mid=item.mid; //获得需要回显树节点对应的id
				//获得需要选中的节点对象
				var node = treeObj.getNodesByParam("mid", mid, null)[0];
				/*if(node.isParent){
					treeObj.expandNode(node,true,false); 
				};*/
				treeObj.checkNode(node,true,false);
				
			});
			
			
			
			
		});
		
	});
});


/*
提交授权的请求
*/
function grantPrivilege(){
	//获得需要提交的角色的id
	var rid=$("#roleid").val();
	
	var rmids=rid+",";
	//1,2,3,5 
	//获得被选中的资源的id
	var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
	var nodes = treeObj.getCheckedNodes(true);
	//遍历nodes节点
	for(var x=0;x<nodes.length;x++){
		if(x==nodes.legnth-1){
			rmids=rmids+nodes[x].mid;
		}else{
			rmids=rmids+nodes[x].mid+",";
		}
	}
	
	//发送ajax请求
	$.post("grantMenusToRoles.action","rmids="+rmids,function(result){
		 if (result.errorMsg){
             $.messager.show({//弹出消息框
                 title: 'Error',
                 msg: result.errorMsg
             });
         } else{
             window.close();  
         }
		
	});
}












