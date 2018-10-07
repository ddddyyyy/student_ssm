<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="<%=config.getServletContext().getContextPath()%>/JS/returnUrlByTime.js"></script>
<link href="main.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="returnUrlByTime()">
	<%@include file="主页.jsp"%>
	<h1 align="center">
		${name}的信息修改成功
	</h1>
	<p align="center">
		<strong id="layer" style="color: red;">3</strong>秒后跳转回查看成绩页面
	</p>
	<%
		request.getSession().setAttribute("pagebean", null);
		response.setHeader("Refresh", "3;url=");
	%>
</body>
</html>