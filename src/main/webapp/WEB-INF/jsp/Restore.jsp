<%@ page contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@page
	import="java.io.*,java.nio.charset.StandardCharsets"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript"
			src="<%=config.getServletContext().getContextPath()%>js/student/returnUrlByTime.js"></script>
<link href="<%=config.getServletContext().getContextPath()%>css/main.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>恢复数据库</title>
</head>
<body onload="returnUrlByTime()">
	<%@include file="主页.jsp"%>
	<%
		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec(
				"g:\\mysql-5.7.20-winx64\\bin\\mysql -hlocalhost -uadmin -padmin --default-character-set=utf8 student");
		OutputStream outputStream = process.getOutputStream();
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(session.getServletContext().getRealPath("/SQL")+"/student.sql"), StandardCharsets.UTF_8));
		String str;
		StringBuilder sb = new StringBuilder();
		while ((str = br.readLine()) != null) {
			sb.append(str).append("\r\n");
		}
		str = sb.toString();
		// System.out.println(str);
		OutputStreamWriter writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
		writer.write(str);
		writer.flush();
		outputStream.close();
		writer.close();
		br.close();
	%>
	<h1 align="center">恢复成功</h1>
	<p align="center">
		<strong id="layer" style="color: red;">3</strong>秒后跳转回添加页面
	</p>
	<%
		response.setHeader("Refresh",
				"3;url=" + config.getServletContext().getContextPath() + "/JSP/add_student.jsp");
	%>
</body>
</html>