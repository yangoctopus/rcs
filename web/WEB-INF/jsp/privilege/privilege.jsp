<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">

<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="ztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="ztree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="js/privilege.js"></script>
 
 
</head>
<body>
 	<div id="treeDemo" class="ztree"></div>
 	<input id="roleid" value="${roleid}" type="hidden"/>
 	<hr/>
 	<div>
	 	<a href="javascript:void(0)" class="easyui-linkbutton c6" 
	     iconCls="icon-ok" onclick="grantPrivilege()" style="width:90px">授权</a>
	     <a href="javascript:void(0)" class="easyui-linkbutton" 
	     iconCls="icon-cancel" onclick="javascript:window.close()" 
	     style="width:90px">关闭</a>
 	</div>
</body>
</html>