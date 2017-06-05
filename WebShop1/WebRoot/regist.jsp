<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type='text/javascript' src='/WebShop1/dwr/interface/check.js'></script>
<script type='text/javascript' src='/WebShop1/dwr/engine.js'></script>
<script type='text/javascript' src='/WebShop1/dwr/util.js'></script>
<script type="text/javascript">
function checkUser1() {
		var username = document.all.username.value;
		check.checkUser(username, onData);
	}
	function onData(data) {
		//alert(data);
		if (data == true) {
			document.all.msg.innerHTML = "用户名重复";
		} else
			document.all.msg.innerHTML = "ok";
	}
</script>
<title>Insert title here</title>
</head>
<body>

	<form name=regist action="user/regist.action" method="post">
		username:<input type=text name=uname id=username onblur="checkUser1()" value="${uname}"> <span id="msg"></span><br>
		password:<input type=password name=password value="${password}"><br>
		password again:<input type=password name=repassword value="${repassword}"><br> 
		email:<input type=text name=email value="${email}"><br>
		<s:fielderror></s:fielderror>
		<input type=submit value=submit>
	</form>
</body>
</html>