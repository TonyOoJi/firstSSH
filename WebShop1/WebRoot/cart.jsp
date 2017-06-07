<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>=cart.jsp</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="./css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<a class="btn btn-primary" href="${pageContext.request.contextPath}/user/home.action">返回</a>
	<br>
	<h1 style="color:#2697FF;wdith:200px;margin-left:280px">CART</h1>
	<br>
	<br>
	<table  class="table table-hover" style="width:800px;">
		<tr>
			<th>商品id</th>
			<th>商品名</th>
			<th>数量</th>

		</tr>
		<s:iterator value="cartList" id="cart">
			<tr>
				<td><s:property value="#cart.commodityid" /></td>
				<td>
				<!-- 遍历商品名字的list ，相同的id就显示 -->
					<s:iterator value="commodityList" id="commodity">
						<s:if test="#commodity.commodityid==#cart.commodityid">
							<s:property value="#commodity.commodityinfo"/>
						</s:if>
					</s:iterator>
				</td>
				<td><s:property value="quantity" /></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>
