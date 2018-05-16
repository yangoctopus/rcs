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
        <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/datagrid-detailview.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/rentCar.js"></script>
        
        
    </head>
    <body>
    
   	 <div style="margin-bottom:10px;font-size: 12px;" align="center">
            <input id="customerId" name="identity" class="easyui-textbox" 
            required="true" label="身份证号:" style="width:35%" value="421281200401171205">
            <a href="javascript:void(0)" class="easyui-linkbutton" 
            iconCls="icon-search" plain="true" onclick="checkCustomer()">查询</a>
      </div>
        
   	
      <!-- 角色的DataGrid空间 -->
	<table id="dg"></table>  
	
	
	
	
	<div id="toolbar" style="display: none">
            <a href="javascript:void(0)" class="easyui-linkbutton"
             iconCls="icon-add"  onclick="rentCar()">办理出租</a>
    </div>
    
    
    <!-- 办理出租的对话框 -->
    <div id="dlg" class="easyui-dialog" style="width:500px;"
                closed="true" buttons="#dlg-buttons" shadow="false">
            <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
                <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">出租单信息</div>
                <div style="margin-bottom:10px">
                    <input id="rid" name="rentid" class="easyui-textbox" required="true" label="出租单号:" style="width:100%">
                </div>
                <div style="margin-bottom:10px">
                    <input name="price" class="easyui-textbox" required="true" label="出租价格:" style="width:100%">
                </div>
                <div style="margin-bottom:10px">
                    <input name="begindate" class="easyui-datetimebox" data-options="formatter:myformatter,parser:myparser" required="true" label="起租时间:" style="width:100%">
                </div>
                <div style="margin-bottom:10px">
                    <input name="returndate" class="easyui-datetimebox" data-options="formatter:myformatter,parser:myparser" required="true" label="还车时间:" style="width:100%">
                </div>
                
                <div style="margin-bottom:10px">
                    <input id="custid" name="custid" class="easyui-textbox" required="true" label="客户编号:" style="width:100%">
                </div>
                <div style="margin-bottom:10px">
                    <input id="carid" name="carid" class="easyui-textbox" required="true" label="车牌号:" style="width:100%">
                </div>
                <div style="margin-bottom:10px">
                    <input id="username" name="username" class="easyui-textbox" required="true" label="业务人员:" style="width:100%">
                </div>
            </form>
        </div>
        
        
     <!-- 添加对话框的按钮 -->
	<div id="dlg-buttons">
	     <a href="javascript:void(0)" class="easyui-linkbutton c6" 
	     iconCls="icon-ok" onclick="saveRents()" style="width:90px">保存</a>
	     <a href="javascript:void(0)" class="easyui-linkbutton" 
	     iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" 
	     style="width:90px">取消</a>
	 </div>	
 </body>
</html>