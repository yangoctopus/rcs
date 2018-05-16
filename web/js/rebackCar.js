/*默认隐藏建查询信息的输入UI*/
$(function(){
	$("#home").hide();
}) 

/*
 * 
 * 发送请求，验证出租单是否存在
 * 
 */
function checkRent(){
	
	//获得输入的出租单信息
	var rentid=$("#rentid").val();
	//alert(rentid);
	$.post("checkRents.action","rentid="+rentid,function(result){
		
		if(result=="success"){
			$("#home").show();  //显示div
			//加载检查单数据
			loadCheckData();
		}
	});
	
}


/*
加载检查单数据
*/
function loadCheckData(){
	//获得输入的出租单信息
	var rentid=$("#rentid").val();
	//发送ajax请求
	$.post("loadCheckData.action","rentid="+rentid,function(data){
		window.alert(data)
		
		
		$("#fm").form("load",data.cks);
		

		$("#rid").val(rentid);
		
		
		//显示客户信息
		var c=data.customer;
		$("#ct_id").text(c.identity);
		$("#ct_name").text(c.custname);
		
		$("#ct_sex").text(c.sex);
		$("#ct_add").text(c.address);
		$("#ct_phone").text(c.phone);
		$("#ct_carrer").text(c.career);
		
	
		
		
		//显示车辆信息
		var car = data.cars
		$("#c_num").text(car.customer);
		$("#c_type").text(car.cartype);
		$("#c_color").text(car.color);
		$("#c_desc").text(car.description);
		$("#c_price").text(car.price);
		$("#c_rentprice").text(car.rentprice);
		$("#c_deposit").text(car.deposit);
		$("#c_isrenting").text(car.isrenting);
		
		//将车牌号放入隐藏域
		$("#cnum").val(car.customer);
		
		//显示出租单信息
		var r=data.rents;
		
		$("#r_rentid").text(r.rentid);
		$("#r_price").text(r.price);
		$("#r_begindate").text(r.begindate);
		$("#r_returndate").text(r.returndate);
		$("#r_rentflag").text(r.rentflag);
		$("#r_username").text(r.username);
		
	});
}

/*
 * 提交保存出租单的请求
 * 
 */
function saveCheck(){
	$('#fm').form('submit',{
        url: 'saveChecks.action',  
        onSubmit: function(){
            return $(this).form('validate');
        },
        success: function(result){
        	
        	result=JSON.parse(result);
        	alert(result);
            if (result.errorMsg){
                $.messager.show({//弹出消息框
                    title: 'Error',
                    msg: result.errorMsg
                });
            } else{
            	/*
            	 * 清空所有数据
            	 * */
            	
            	$("#fm").form("clear");
            	
             
        		$("#ct_id").text("");
        		$("#ct_name").text("");
        		$("#ct_sex").text("");
        		$("#ct_add").text("");
        		$("#ct_phone").text("");
        		$("#ct_carrer").text("");
        	 
        		$("#c_num").text("");
        		$("#c_type").text("");
        		$("#c_color").text("");
        		$("#c_desc").text("");
        		$("#c_price").text("");
        		$("#c_rentprice").text("");
        		$("#c_deposit").text("");
        		$("#c_isrenting").text("");
        		
        		//将车牌号放入隐藏域
        		$("#cnum").val("");
        		$("#r_rentid").text("");
        		$("#r_price").text("");
        		$("#r_begindate").text("");
        		$("#r_returndate").text("");
        		$("#r_rentflag").text("");
        		$("#r_username").text("");
        		
        		
        		$("#rid").val("");
        		//$("#rentid").val("");
        		$("#rentid").textbox('setValue');
        		alert("==========="+$("#rentid").val())
        		$("#home").hide();
            }
        }
    });
	
}






