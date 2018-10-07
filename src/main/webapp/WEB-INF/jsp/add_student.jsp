<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/main.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加学生成绩</title>
</head>
<body>
	<%@include file="主页.jsp"%>
	<h1>${param.error}</h1>
	<div align="center">
		<form action="/student_ssm/manager/add" method="post">
			<table>
				<tbody>
					<tr>
						<td>学号
						<td><input name="id" style="textfield" size="3"
								maxlength="6"></input>
					</tr>
					<tr>
						<td>姓名
						<td><input name="name" style="textfield" size="6"></input>
					</tr>
					<tr>
						<td><label>数学成绩</label> <input name="math"
								style="textfield" size="2" maxlength="6"></input>
						<td><label>英语成绩</label> <input name="english"
								style="textfield" size="2" maxlength="6"></input>
					</tr>
					<tr>
						<td><label>语文成绩</label> <input name="chinese"
								style="textfield" size="2" maxlength="6"></input>
						<td><label>作业成绩</label> <input name="homework"
								style="textfield" size="2" maxlength="6"></input>
					</tr>
					<tr>
						<td><input value="提交" type="submit" />
						<td><input value="重置" type="reset" />
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>