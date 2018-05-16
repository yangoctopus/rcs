<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<title>菜单</title>
<link href="images/frame/css_menu.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="ztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="js/menus.js"></script>

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.menutitle{
	height:25px; 
	background-image:url(images/frame/main_43.gif);
	CURSOR:pointer;
	
	padding-left:60px;
	padding-top:5px;
	font-size:9pt; 
	color:#bfdbeb;filter:glow(color=#1070a3,strength=1)
}
.menuleft{
	padding-left:30px;
}
-->
</style>
<SCRIPT language=javascript1.2>
function showsubmenu(sid)
{
	whichEl = eval("submenu" + sid);
	if (whichEl.style.display == "none")
	{
		eval("submenu" + sid + ".style.display=\"\";");
	}
	else
	{
		eval("submenu" + sid + ".style.display=\"none\";");
	}
}
</SCRIPT>
<SCRIPT type="text/javascript">
		 
	</SCRIPT>
</head>

<body bgcolor="#e5f4fd">
<table width="171" height="23" background="images/frame/main_29.gif" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td align="center">
			<font style="font-size:9pt; color:#bfdbeb;filter:glow(color=#1070a3,strength=1)">&nbsp;&nbsp;&nbsp;&nbsp;系统菜单</font>
        </td>
      </tr>
</table>

 <!-- ------------------------------------------------------------- -->
<div class="zTreeDemoBackground left">
	<ul id="treeDemo" class="ztree">
	
	
	</ul>
</div>
<!-- ------------------------------------------------------------- -->
</body>
</html>