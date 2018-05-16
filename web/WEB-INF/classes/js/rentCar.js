function checkCustomer(){
	/*
	 发送ajax请求，验证客户信息
	 */
	var identity=$("#customerId").val();
	$.post("checkConsumer.action","identity="+identity,function(data){
		
		if(data=='success'){
			//显示工具栏div
			$("#toolbar").css({"display":"block"});
			//加载可出租的车辆列表
			$("#dg").datagrid({
				url:"loadCarsStatusList.action",
				fitColumns:true,
				singleSelect:true,
				pagination:true,
				toolbar:"#toolbar",
				columns:[[    
				          {field:'carnumber',title:'车牌号'},    
				          {field:'cartype',title:'类型',width:100,align:'right'},    
				          {field:'price',title:'价格',width:150,align:'right'},
				          {field:'rentprice',title:'租金',width:150,align:'right'},
				          {field:'deposit',title:'押金',width:150,align:'right'},
				          {field:'isrenting',title:'状态',width:150,align:'right'}

				      ]],
			    view: detailview,
				detailFormatter: function(rowIndex, data){
					
					
					    return "<table style='width:50%;border:0'>" +
					    		"<tr><td rowspan='2' style='width:35%;border:0'>" +
					    		"<img src='"+data.carimg+"' width=100  hegiht=100/></td>" +
					    		"<td>颜色:"+data.color+"</td>" +
					    		"</tr><tr>" +
					    		"<td style='width:35%;border:0'>" +
					    		"描述:"+data.description+"</td>" +
					    		"</tr></table>";
					    		
			          
					}
			});

		}else{
			$('#dg').datagrid('loadData', { total: 0, rows: [] }); 
			 
		}
	});
}

/*
打开办理出租的对话框
*/
var url;
function rentCar(){
	
	url="saveRents.action";
	var row =$("#dg").datagrid('getSelected');
	if(row){
		//打开对话框
		$("#dlg").dialog("open").dialog('setTitle','出租信息').panel("move",{top:15});
		
		//获得客户的身份证号
		var custid=$("#customerId").val();
		
		//发送ajax请求
		$.post("loadRentData.action", "carid="+row.carnumber+"&custid="+custid,
				function(json){
					$('#fm').form('load',json);
		});
		
	}
}


////////////////////////////////////////////////////////////////

function myformatter(date){
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    var d = date.getDate();
    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}
function myparser(s){
    if (!s) return new Date();
    var ss = (s.split('-'));
    var y = parseInt(ss[0],10);
    var m = parseInt(ss[1],10);
    var d = parseInt(ss[2],10);
    if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
        return new Date(y,m-1,d);
    } else {
        return new Date();
    }
}


/////////////////////////////////////////////////////

/*
 * 发送保存出租单信息的请求
 * */

function saveRents(){
	
	$('#fm').form('submit',{
        url: url,  
        onSubmit: function(){
            return $(this).form('validate');
        },
        success: function(result){
            if (result.errorMsg){
                $.messager.show({//弹出消息框
                    title: 'Error',
                    msg: result.errorMsg
                });
            } else{
                $('#dlg').dialog('close');       
                $('#dg').datagrid('reload');  
            }
        }
    });
	
}









