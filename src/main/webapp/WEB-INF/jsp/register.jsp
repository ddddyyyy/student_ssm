<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/css; charset=UTF-8">
<link href="css/main.css" rel="stylesheet" type="text/css">
<title>注册界面</title>
</head>
<body>
	<form action="registerUser" method="get">
		<table border="1" align="center">
			<tr>
				<td colspan="2" align="center" bgcolor="#E8E8E8">用户注册
			</tr>
			<tr>
				<td>用户名：
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>密码：
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"><input
					type="reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>