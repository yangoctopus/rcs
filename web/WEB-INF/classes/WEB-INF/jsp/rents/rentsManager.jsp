<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
        <meta charset="UTF-8">
        <title>出租单管理</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/color.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
        
        <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
         <script type="text/javascript" src="${pageContext.request.contextPath}/js/rentsManager.js"></script>
    </head>
    <body>

    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="editRent()">修改出租单</a>
        <input name="begindate" id="begindate" class="easyui-datetimebox" data-options="formatter:myformatter,parser:myparser" required="true" label="起租时间:" style="width:20%">
        <input name="returndate" id="returndate" class="easyui-datetimebox" data-options="formatter:myformatter,parser:myparser" required="true" label="还车时间:" style="width:20%">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick=" findMess()" style="width:80px">搜索</a>
    </div>
    <table id="dg"></table>


        
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
                    <input name="rentflag" class="easyui-textbox" required="true" label="车辆状态:" style="width:100%">
                </div>
                <div style="margin-bottom:10px">
                    <input name="custid" class="easyui-textbox" required="true" label="客户编号:" style="width:100%">
                </div>
                <div style="margin-bottom:10px">
                    <input name="carid" class="easyui-textbox" required="true" label="车牌号:" style="width:100%">
                </div>
                <div style="margin-bottom:10px">
                    <input name="username" class="easyui-textbox" required="true" label="业务人员:" style="width:100%">
                </div>
            </form>
        </div>
        <div id="dlg-buttons">
            <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveRent()" style="width:90px">保存</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
        </div>
        
       
    </body>
    </html>