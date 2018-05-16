<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/datagrid-detailview.js"></script>
<script type="text/javascript" src="js/carsManager.js"></script>

</head>
<body>
<!-- 用户的DataGrid空间 -->
<table id="dg">
</table>

<!-- DataGrid空间工具栏 -->
<div id="toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton"
       iconCls="icon-add" plain="true" onclick="newCars()">添加车辆</a>
    <a href="javascript:void(0)" class="easyui-linkbutton"
       iconCls="icon-edit" plain="true" onclick="editCars()">编辑车辆</a>
    <a href="javascript:void(0)" class="easyui-linkbutton"
       iconCls="icon-remove" plain="true" onclick="delCars()">删除车辆</a>
</div>

<!-- 添加对话框，对话框有表单存在 -->
<div id="dlg" class="easyui-dialog" style="width:500px;"
     closed="true"  shadow="false" buttons="#btn">

    <div style="top:21%;left:70%;position: absolute;">
        <img  src="" width="110px" height="120px" id="img"/>
    </div>

    <form id="fm" method="post"
          novalidate style="margin:0;padding:20px 50px" enctype="multipart/form-data">
        <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">车辆信息</div>
        <div style="margin-bottom:10px">
            <input name="mf" class="easyui-filebox"  id="mf" label="车辆图片:" style="width:70%" onchange="uploadImg()">

        </div>

        <input type="hidden" id="carimg" name="carimg"/>

        <div style="margin-bottom:10px">
            <input name="carnumber" id="identity" class="easyui-textbox" required="true" label="车辆牌照:" style="width:70%">
        </div>
        <div style="margin-bottom:10px">
            <input name="cartype" class="easyui-textbox" required="true" label="车辆类型:" style="width:70%">
        </div>
        <div style="margin-bottom:10px">
            <input name="color" class="easyui-textbox" required="true" label="车辆颜色:" style="width:70%">
        </div>
        <div style="margin-bottom:10px">
            <input name="price" class="easyui-textbox" required="true" label="车辆价格:" style="width:70%">
        </div>
        <div style="margin-bottom:10px">
            <input name="rentprice" class="easyui-textbox" required="true" label="租赁价格:" style="width:70%">
        </div>
        <div style="margin-bottom:10px">
            <input name="deposit" class="easyui-textbox" required="true" label="押金:" style="width:70%">
        </div>
        <div style="margin-bottom:10px">
            <input name="description" class="easyui-textbox" required="true" label="车辆描述:" style="width:70%">
        </div>


    </form>


</div>

<!-- 给对话框添加按钮 -->
<div id="btn">
    <a href="javascript:void(0)" class="easyui-linkbutton c6"
       iconCls="icon-ok" onclick="saveCars()" style="width:90px">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton"
       iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
       style="width:90px">取消</a>
</div>
<script type="text/javascript">

</script>
</body>

</html>