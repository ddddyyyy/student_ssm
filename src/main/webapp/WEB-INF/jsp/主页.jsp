<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%
	String name = request.getParameter("uname");
	if(name!=null){
		Cookie user = new Cookie("name",name);
		user.setPath(request.getContextPath());
		user.setMaxAge(604800);
		user.setHttpOnly(true);
		response.addCookie(user);
	}
%>
<ul id="nav">
	<li style="color: red;"><strong>学生信息管理系统</strong>
	<li><a href="addStudent">添加学生信息</a></li>
	<li><a href="viewStudent">查看学生信息</a></li>
	<li><a href="">备份</a></li>
	<li><a href="">恢复</a></li>
	<li><a href="">导出数据</a></li>
	<li><span style="color: black;">欢迎你,</span><strong
		style="color: red;">${cookie.name.value}</strong><a href="<%=request.getContextPath()%>/logout">登出</a></li>

</ul>
