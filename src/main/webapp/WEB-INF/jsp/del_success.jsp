<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="js/returnUrlByTime.js">
</script>
<link href="css/main.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除成功</title>
</head>
<body onload="returnUrlByTime()">
	<%@include file="主页.jsp"%>
	<h1 align="center">
		
		删除成功
	</h1>
	<p align="center">
		<strong id="layer" style="color: red;">3</strong>秒后跳转回查看成绩页面
	</p>
	<%
		request.getSession().setAttribute("pagebean", null);
		response.setHeader("Refresh", "3;url=ViewData.jsp");
	%>
</body>
</html>