<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
<title>用户登录</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow:hidden;
}
-->
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		 if(window.parent!=window){
			 window.parent.location.href="${pageContext.request.contextPath}/index.jsp";
			 
		 }
	 });
	
function userLogin()
{
	var uid=document.getElementById("uid");
	if(uid.value==""||document.getElementById("upwd").value=="")
	{
		alert("请完整输入！");
		uid.focus();
		return false;
	}
	else
	{
		return true;
	}
};

function userreset()
{
	document.getElementById("uid").value="";
	document.getElementById("upwd").value="";

}
</script>

</head>

<body onLoad="MM_preloadImages('${pageContext.request.contextPath}/common/images/login/login_09_1.gif','${pageContext.request.contextPath}/common/images/login/login_10_1.gif')">
<form  method="post" action="login.action">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td bgcolor="#02395f">&nbsp;</td>
  </tr>
  <tr>
    <td height="607" align="center" background="images/login_02.gif">
	<table width="974" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="331" background="images/login_01.jpg" align="center" valign="bottom" style="font-size: 14px;color: red;" >&nbsp;${loginMsg}</td>
      </tr>
      <tr>
        <td height="116">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="393" height="116" background="images/login_05.gif">&nbsp;</td>
            <td width="174"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="81" background="images/login_06.gif">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="24%">
						<div align="center">
							<font style="height:1;font-size:9pt; color:#bfdbeb;filter:glow(color=#1070a3,strength=1)">用户</font>
						</div>
					</td>
                    <td width="76%" height="25">
						<input type="text" name="username" id="uid" value="admin"  style="width:125px; height:20px; background:#32a2e3; font-size:12px; border:solid 1px #0468a7; color:#14649f;">
					</td>
                  </tr>
                  <tr>
                    <td>
						<div align="center">
							<font style="height:1;font-size:9pt; color:#bfdbeb;filter:glow(color=#1070a3,strength=1)">密码</font>
						</div>
					</td>
                    <td height="25">
						<input type="password" name="userpwd" id="upwd"  value="" style="width:125px; height:20px; background:#32a2e3; font-size:12px; border:solid 1px #0468a7; color:#14649f;">
					</td>
                  </tr>
                </table>
			    </td>
              </tr>
              <tr>
                <td height="35">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="50" height="35"><img src="images/login_08.gif" width="50" height="35"></td>
                    <td width="46"><input  onclick="return userLogin()" type="image" src="images/login_09.gif"  id="Image1" onMouseOver="MM_swapImage('Image1','','images/login_09_1.gif',1)" onMouseOut="MM_swapImgRestore()" style="width:46; height:35; border:none"></td>
                    <td width="45"><a href="#" onClick="return userreset()"><img src="images/login_10.gif" name="Image2" width="45" height="35" border="0" id="Image2" onMouseOver="MM_swapImage('Image2','','images/login_10_1.gif',1)" onMouseOut="MM_swapImgRestore()"/></a></td>
                    <td width="33"><img src="images/login_11.gif" width="33" height="35"></td>
                  </tr>
                </table></td>
              </tr>
            </table>
			</td>
            <td width="407" background="images/login_07.gif">&nbsp;</td>
          </tr>
        </table>
		</td>
      </tr>
      <tr>
        <td height="160" background="images/login_12.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td bgcolor="#02609c">&nbsp;</td>
  </tr>
</table>
</form>
</body>
</html>
