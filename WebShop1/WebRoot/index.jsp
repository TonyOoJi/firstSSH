<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
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

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type='text/javascript' src='/WebShop1/dwr/interface/check.js'></script>
<script type='text/javascript' src='/WebShop1/dwr/engine.js'></script>
<script type='text/javascript' src='/WebShop1/dwr/util.js'></script>
<script type="text/javascript">
	function checkUser() {
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
	This is my JSP page.
	<br>
	<form action="user/login.action" method="post">
		username:<input type="text" name=username onblur="checkUser()"><span id="msg"></span><br>
		password:<input type="password" name=password><br>
		<input type="submit" value=submit>
	</form>
</body>
</html>
