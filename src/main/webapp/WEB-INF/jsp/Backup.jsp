<%@ page contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@page
	import="java.io.BufferedReader,java.io.FileOutputStream,java.io.InputStream,java.io.InputStreamReader,java.io.OutputStreamWriter"%>
<%@ page import="java.nio.charset.StandardCharsets" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="<%=config.getServletContext().getContextPath()%>js/student/returnUrlByTime.js"></script>
<link href="<%=config.getServletContext().getContextPath()%>css/main.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>备份数据库</title>
</head>
<body onload="returnUrlByTime()">
	<%@include file="主页.jsp" %>
	<%
		Runtime rt = Runtime.getRuntime();

		// 调用 调用mysql的安装目录的命令
		Process child = rt.exec("g:\\mysql-5.7.20-winx64\\bin\\mysqldump -h localhost -uadmin -padmin student");
		// 设置导出编码为utf-8。这里必须是utf-8
		// 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行
		InputStream in = child.getInputStream();// 控制台的输出信息作为输入流

		InputStreamReader xx = new InputStreamReader(in, StandardCharsets.UTF_8);
		// 设置输出流编码为utf-8。这里必须是utf-8，否则从流中读入的是乱码

		String inStr;
		StringBuilder sb = new StringBuilder();
		String outStr;
		// 组合控制台输出信息字符串
		BufferedReader br = new BufferedReader(xx);
		while ((inStr = br.readLine()) != null) {
			sb.append(inStr).append("\r\n");
		}
		outStr = sb.toString();

		// 要用来做导入用的sql目标文件：
		FileOutputStream fout = new FileOutputStream(session.getServletContext().getRealPath("/SQL")+"/student.sql");

		OutputStreamWriter writer = new OutputStreamWriter(fout, StandardCharsets.UTF_8);
		writer.write(outStr);
		writer.flush();
		in.close();
		xx.close();
		br.close();
		writer.close();
		fout.close();

	%>
	<h1 align="center">备份成功</h1>
	<p align="center">
		<strong id="layer" style="color: red;">3</strong>秒后跳转回添加页面
	</p>
	<%
		response.setHeader("Refresh",
				"3;url=" + config.getServletContext().getContextPath() + "/JSP/add_student.jsp");
	%>
</body>
</html>