<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../js/returnUrlByTime.js"></script>
<link href="../css/main.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加成功</title>
</head>
<body onload="returnUrlByTime()">
<%@include file="主页.jsp" %>
<h1 align="center">${name}添加成功</h1>
<p align="center"><strong id = "layer" style="color:red;">3</strong>秒后跳转回添加页面</p>
<% response.setHeader("Refresh", "3;url="+config.getServletContext().getContextPath()+"/manager/addStudent"); %>
</body>
</html>