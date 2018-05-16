<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/echarts.min.js"></script>
<script type="text/javascript" src="js/sellCount.js"></script>

</head>
<body>

	<div class="easyui-tabs" style="width:700px;height:600px" id="tt">
		<c:forEach var="y" items="${evoList}" varStatus="idx">
			<div title="${y.yr}年" style="padding:10px">
			 
				<div id="${idx.index}" style="width:700px;height:500px"></div>
			 
			</div>
		</c:forEach>
	</div>

 

</body>
</html>