<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<title>汽车租赁系统</title>

</head>
<frameset rows="83,*" cols="*" framespacing="0" frameborder="no" border="0">
  <frame src="loadTop.action" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />
  <frame src="loadCenter.action" name="mainFrame" id="mainFrame" />
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>
