<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<title>WEBSHOP</title>
</head>
<body>
<div class="center-block" style="width:1000px">
	<br>
	<h1 style="color:#2697FF;wdith:200px;margin-left:280px">&nbsp;&nbsp;WEBSHOP</h1>
	<br>
	<br>
	<table border="1" class="table table-hover" style="width:800px;">
		<tr>
			<th></th>
			<th>商品信息</th>
			<th>数量</th>
			<th style="width:10px;">加入购物车</th>
		</tr>
		<s:iterator value="pager.list">
			<tr>
				<td><s:property value="commodityid" />
				</td>
				<td><s:property value="commodityinfo" />
				</td>
				<td><s:property value="quantity" />
				</td>
				<!-- 购物车action地址-->
				<td class="btn btn-primary" style="background:transparent;color:black;"><a href="">添加</a></td>
			</tr>
		</s:iterator>
	</table>
	<span> 
		共<s:property value="pager.totalPage" /> 页&nbsp;
		<s:property value="pager.allRow" /> 条信息&nbsp;&nbsp;
		
	</span>
	<span style="margin-left:80px">
		<s:if test="%{pager.currentPage == 1}">
			<span class="btn btn-primary" style="background:white;color:black">首页</span>&nbsp;&nbsp;&nbsp;&nbsp;
			<span class="btn btn-primary" style="background:white;color:black">上一页</span>&nbsp;&nbsp;&nbsp;&nbsp;
		</s:if>
		<s:else>
			<a class="btn btn-primary" href="home?page=1">首页&nbsp;&nbsp;&nbsp;&nbsp;</a>
			<a class="btn btn-primary" href="home?page=<s:property value="%{pager.currentPage-1}"/>">上一页&nbsp;&nbsp;&nbsp;&nbsp;</a>
		</s:else>
		
		第 <s:property value="pager.currentPage" /> 页&nbsp;&nbsp;&nbsp;
		
		<s:if test="%{pager.currentPage != pager.totalPage}">
			<a class="btn btn-primary" href="home?page=<s:property value="%{pager.currentPage+1}"/>">下一页&nbsp;&nbsp;&nbsp;&nbsp;</a>
			<a class="btn btn-primary" href="home?page=<s:property value="pager.totalPage"/>">尾页</a>
		</s:if> 
		<s:else>
		<span class="btn btn-primary" style="background:white;color:black">下一页</span>&nbsp;&nbsp;&nbsp;&nbsp; 
		<span class="btn btn-primary" style="background:white;color:black">尾页</span>
		</s:else>
	</span>
</div>
</body>
</html>