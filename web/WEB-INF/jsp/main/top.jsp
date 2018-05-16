<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<title>人事管理</title>
 
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px;
	color: #2b7dbb;
}
-->
</style>
<script type="text/JavaScript">

//刷新桌面页面
function freshDesk()
{
	window.parent.frames["mainFrame"].frames["content"].location.reload();
	//alert(window.parent.frames["mainFrame"].frames["content"].location);
}
//退出系统
function exit(){
	if(window.confirm("你确定退出吗？"))
	{
		window.parent.parent.location="exit.jsp";
	}
}
</script>


</head>

<body onload="MM_preloadImages('${pageContext.request.contextPath}/images/frame/main_07_1.gif','${pageContext.request.contextPath}/images/frame/main_08_1.gif','${pageContext.request.contextPath}/images/frame/main_10_1.gif','${pageContext.request.contextPath}/images/frame/main_11_1.gif','${pageContext.request.contextPath}/images/frame/main_12_1.gif','${pageContext.request.contextPath}/images/frame/main_13_1.gif','${pageContext.request.contextPath}/images/frame/main_14_1.gif');">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="57" background="${pageContext.request.contextPath}/images/frame/main_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="110" height="57" background="${pageContext.request.contextPath}/images/frame/main_01.gif">&nbsp;</td>
        <td><table width="743" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="28" background="${pageContext.request.contextPath}/images/frame/main_03.gif">&nbsp;</td>
          </tr>
          <tr>
            <td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="61" height="29" background="${pageContext.request.contextPath}/images/frame/main_06.gif">&nbsp;</td>
                <td width="72"><a href="updatePWD.jsp" target="content"><img src="${pageContext.request.contextPath}/images/frame/main_07.gif" name="Image1" width="72" height="29" border="0" id="Image1" onmouseover="MM_swapImage('Image1','','${pageContext.request.contextPath}/images/frame/main_07_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                <td width="72"><a href="#"><img src="${pageContext.request.contextPath}/images/frame/main_08.gif" name="Image2" width="72" height="29" border="0" id="Image2" onmouseover="MM_swapImage('Image2','','${pageContext.request.contextPath}/images/frame/main_08_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                <td width="292" background="${pageContext.request.contextPath}/images/frame/main_09.gif">&nbsp;</td>
                <td width="40"><a href="loadDesk.action" target="content"><img src="${pageContext.request.contextPath}/images/frame/main_10.gif" name="Image3" width="40" height="29" border="0" id="Image3" onmouseover="MM_swapImage('Image3','','${pageContext.request.contextPath}/images/frame/main_10_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                <td width="44"><a href="#" onclick="javaScript:history.go(-1)"><img src="${pageContext.request.contextPath}/images/frame/main_11.gif" name="Image4" width="44" height="29" border="0" id="Image4" onmouseover="MM_swapImage('Image4','','${pageContext.request.contextPath}/images/frame/main_11_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                <td width="43"><a href="#" onclick="javascript:history.go(1)"><img src="${pageContext.request.contextPath}/images/frame/main_12.gif" name="Image5" width="43" height="29" border="0" id="Image5" onmouseover="MM_swapImage('Image5','','${pageContext.request.contextPath}/images/frame/main_12_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                <td width="44"><a href="#" onclick="freshDesk();"><img src="${pageContext.request.contextPath}/images/frame/main_13.gif" name="Image6" width="44" height="29" border="0" id="Image6" onmouseover="MM_swapImage('Image6','','${pageContext.request.contextPath}/images/frame/main_13_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                <td width="39"><a href="#" onclick="exit();"><img src="${pageContext.request.contextPath}/images/frame/main_14.gif" name="Image7" width="39" height="29" border="0" id="Image7" onmouseover="MM_swapImage('Image7','','${pageContext.request.contextPath}/images/frame/main_14_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                <td width="36"><img src="${pageContext.request.contextPath}/images/frame/main_15.gif" width="36" height="29"/></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="102" background="${pageContext.request.contextPath}/images/frame/main_05.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="26" background="${pageContext.request.contextPath}/images/frame/main_18.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="180" height="26" background="${pageContext.request.contextPath}/images/frame/main_16.gif">&nbsp;</td>
        <td>
        <!-- ----欢迎管理员---- -->
        <div align="left">
        	<img src="${pageContext.request.contextPath}/images/frame/001.gif" width="10" height="10" />
        	<span class="STYLE1">欢迎您:${sessionScope.loguser.fullname}  角色:管理员</span>
        </div>
        </td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>