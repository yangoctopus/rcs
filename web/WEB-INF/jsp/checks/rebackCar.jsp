<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
        <meta charset="UTF-8">
        <title>汽车租赁</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/color.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
        
        <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/rebackCar.js"></script>
    </head>
    <body style="background-color: #E5F4FD">
    
    	 <div style="margin-bottom:10px;font-size: 12px;" align="center">
             <input id="rentid"  class="easyui-textbox" required="true" 
             label="出租单号:" style="width:35%">
             <a href="javascript:void(0)" class="easyui-linkbutton"
              iconCls="icon-search" plain="true" onclick="checkRent()">查询</a>
         </div>
         
    	<div  class="easyui-layout" style="width:100%;height:500px;" id="home">
    	
           	<div data-options="region:'north'" title="生成检查单" 
           	style="width:90%;height:45%;padding:10px;border: 1px solid;">
           	 <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
            	<table width="90%" height="90%" style="font-size: 14px">
	           		<tr>
						<td width="50%" align="center">
							<input type="hidden" name="rentid" id="rid"/>
							<input type="hidden" name="carnumber" id="cnum"/>
							<input name="checkid" class="easyui-textbox" required="true" label="检查单号：" style="width:80%"></td>
						<td width="50%" align="center">
							<input name="checkdate" class="easyui-textbox" required="true" label="检查时间：" style="width:80%"></td>
	           		</tr>
	           		<tr>
	           			<td align="center">
							<input name="username" class="easyui-textbox" required="true" label="检查员：" style="width:80%"></td>
						<td align="center">
							<input name="field" class="easyui-textbox" required="true" label="属性：" style="width:80%"></td>
	           		</tr>
	           		<tr>
	           			<td align="center" rowspan="2">
							<input name="problem" class="easyui-textbox" required="true" label="问题：" multiline="true" style="width:80%;height:60px"></td>
						<td align="center">
							<input name="paying" class="easyui-textbox" required="true" label="赔费：" style="width:80%"></td>
	           		</tr>
	           		<tr>
	           			<td align="center">
	           				<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveCheck()" style="width:90px">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
	           			</td> 
	           		</tr>
	           	</table>
	           	</form>
        	</div>
        	
           	<div data-options="region:'west'" title="客户信息" 
           	style="width:35%;height:55%;padding:10px;border: 1px solid;">
	           	<table width="90%" height="90%" style="font-size: 14px">
	           		<tr>
	           		<td width="30%" align="center">身份证：</td> 
	           		<td width="70%" align="left"><font id="ct_id"></font></td></tr>
	           		<tr><td align="center">姓&nbsp;&nbsp;&nbsp;名：</td> <td><font id="ct_name" align="left"></font></td></tr>
	           		<tr><td align="center">性&nbsp;&nbsp;&nbsp;别：</td> <td><font id="ct_sex" align="left"></font></td></tr>
	           		<tr><td align="center">地&nbsp;&nbsp;&nbsp;址：</td> <td><font id="ct_add" align="left"></font></td></tr>
	           		<tr><td align="center">电&nbsp;&nbsp;&nbsp;话：</td> <td><font id="ct_phone" align="left"></font></td></tr>
	           		<tr><td align="center">职&nbsp;&nbsp;&nbsp;业：</td> <td><font id="ct_carrer" align="left"></font></td></tr>
	           	</table>
        	</div>
        	<div data-options="region:'center'" title="车辆信息" 
        	style="width:25%;height:55%;padding:10px;border: 1px solid;">
            		<table width="90%" height="90%" style="font-size: 14px">
	           		<tr><td width="60%" align="center">车牌号：</td> <td width="40%" align="left"><font id="c_num"></font></td></tr>
	           		<tr><td align="center">型&nbsp;&nbsp;&nbsp;号：</td> <td><font id="c_type" align="left"></font></td></tr>
	           		<tr><td align="center">颜&nbsp;&nbsp;&nbsp;色：</td> <td><font id="c_color" align="left"></font></td></tr>
	           		<tr><td align="center">简&nbsp;&nbsp;&nbsp;介：</td> <td><font id="c_desc" align="left"></font></td></tr>
	           		<tr><td align="center">价&nbsp;&nbsp;&nbsp;值：</td> <td><font id="c_price" align="left"></font></td></tr>
	           		<tr><td align="center">出租价：</td> <td><font id="c_rentprice" align="left"></font></td></tr>
	           		<tr><td align="center">押&nbsp;&nbsp;&nbsp;金：</td> <td><font id="c_deposit" align="left"></font></td></tr>
	           		<tr><td align="center">状&nbsp;&nbsp;&nbsp;态：</td> <td><font id="c_isrenting" align="left"></font></td></tr>
	           	</table>
        	</div>
        	<div data-options="region:'east'" title="出租单信息" 
        	style="width:40%;height:55%;padding:10px;border: 1px solid;">
            		<table width="90%" height="90%" style="font-size: 14px">
	           		<tr><td width="30%" align="center">出租单号：</td> 
	           		<td width="70%" align="left"><font id="r_rentid"></font></td></tr>
	           		<tr><td align="center">出租价格：</td> <td><font id="r_price" align="left"></font></td></tr>
	           		<tr><td align="center">开始日期：</td> <td><font id="r_begindate" align="left"></font></td></tr>
	           		<tr><td align="center">归还日期：</td> <td><font id="r_returndate" align="left"></font></td></tr>
	           		<tr><td align="center">车辆状态：</td> <td><font id="r_rentflag" align="left"></font></td></tr>
	           		<tr><td align="center">业务人员：</td> <td><font id="r_username" align="left"></font></td></tr>
	           	</table>
        	</div>
      
        </div>
        
    </body>
    </html>