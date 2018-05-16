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
<script type="text/javascript" src="js/roleManager.js"></script>

</head>
<body>
<!-- 用户的DataGrid空间 -->
<table id="dg">

</table>

<!-- DataGrid空间工具栏 -->
<div id="toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton"
       iconCls="icon-add" plain="true" onclick="newRole()">添加职务</a>
    <a href="javascript:void(0)" class="easyui-linkbutton"
       iconCls="icon-edit" plain="true" onclick="editRole()">编辑职务</a>
    <a href="javascript:void(0)" class="easyui-linkbutton"
       iconCls="icon-remove" plain="true" onclick="delRole()">删除职务</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" id="win"
       iconCls="icon-add" plain="true" onclick="openPrivilege()">角色授权</a>
</div>


<!-- 添加对话框，对话框有表单存在 -->
<div id="dlg" class="easyui-dialog" style="width:400px;"
     closed="true"  shadow="false" buttons="#btn">

    <form id="fm" method="post"
          novalidate style="margin:0;padding:20px 50px">
        <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">职务信息</div>
        <div style="margin-bottom:10px">
            <input name="rolename" class="easyui-textbox" required="true" label="职务名称:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="roledesc" class="easyui-textbox" required="true" label="职务描述:" style="width:100%">
        </div>

    </form>


</div>

<!-- 给对话框添加按钮 -->
<div id="btn">
    <a href="javascript:void(0)" class="easyui-linkbutton c6"
       iconCls="icon-ok" onclick="saveRole()" style="width:90px">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton"
       iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
       style="width:90px">取消</a>
</div>
<script type="text/javascript">

</script>
</body>

</html>