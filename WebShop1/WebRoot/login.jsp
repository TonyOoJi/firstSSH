<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>login</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
<link href="css/login2.css" rel="stylesheet" type="text/css"/>
<script src="js/jquery-3.2.1.js" type="text/javascript"></script>
<script type="text/javascript" src='js/login.js'></script>
<script type="text/javascript" src='js/my.js'></script>
<script type='text/javascript' src='/WebShop1/dwr/interface/check.js'></script>
<script type='text/javascript' src='/WebShop1/dwr/engine.js'></script>
<script type='text/javascript' src='/WebShop1/dwr/util.js'></script>

<script type="text/javascript"> 
	function checkUser1() {
		var username = document.all.username.value;
		check.checkUser(username, onData);
	}
	function onData(data) {
		if (data == true) {
			document.all.msg.innerHTML = "用户名存在，正确的用户名";
		} else
			document.all.msg.innerHTML = "不存在的用户，请注册";
	}
</script>
</head>

<body>
<s:if test="#session.user!=null"><% session.invalidate(); %></s:if>
<%-- <%=session.getAttribute("user")%> --%>
	<h1>---WEBSHOP---</h1>
<div class="login" style="margin-top:50px;">
    <!--  -->
    <div class="header">
        <div class="switch" id="switch_qlogin" style="margin-left:80px">
     	    快速登录
        </div>
    </div>
    
    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">
		<!--登录-->
        <div class="web_login" id="web_login">
		<div class="login-box">

			<div class="login_form">
				<form action="user/login.action" name="loginform" accept-charset="utf-8" id="login_form" class="loginForm" method="post">
					<input type="hidden" name="did" value="0"/>
               		<input type="hidden" name="to" value="log"/>
                	<div class="uinArea" id="uinArea">
                		<label class="input-tips" for="u">帐号：</label>
                		<div class="inputOuter" id="uArea">
                   			<input type="text" id="u" name="username" class="inputstyle" onblur="checkUser1()"/>
              			</div>
                	</div>
               		<div class="pwdArea" id="pwdArea">
               			<label class="input-tips" for="p">密码：</label> 
               			<div class="inputOuter" id="pArea">
                   			<input type="password" id="p" name="password" class="inputstyle"/>
                		</div>
              		</div>
              		<span id="msg"></span>
                	<div style="padding-left:50px;margin-top:20px;">
                		<input type="submit" value="登 录" style="width:150px;" class="button_blue"/>
                	</div>
                	<s:fielderror></s:fielderror>
              	</form>
           </div>
           
		</div>
		</div>
  	</div>
  	<!--登录end-->
</div>
	<a href="regist.jsp">注册</a>
</body>
</html>
