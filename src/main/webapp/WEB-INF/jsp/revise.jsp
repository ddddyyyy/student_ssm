<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.mdy.student.bean.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<script type="text/javascript" src="../js/Check.js"></script>
<script type="text/javascript">
function re(){
	window.location.href=""
}
</script>
<link href="../css/main.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改信息</title>
</head>
<body>
	<%@include file="主页.jsp"%>
	<form action="/student_ssm/manager/edit" onsubmit="return validate_form(this)" method="post">
		<div align="center">
		<input value="${student.id}" name="id" style="width: 50px" type="hidden">
			<table>
				<tbody>
					<tr>
						<td>学号：<input value="${student.id}" maxlength="6" name="id" style="width: 50px" disabled="disabled"></td>
					</tr>
					<tr>
						<td>姓名：<input value="${student.name}" name="name" id="name" style="width: 50px"></td><td><strong id="_name" style="color:red;"></strong>
					</tr>
 					<tr>
						<td>语文成绩：<input value="${student.chinese}"maxlength="6" name="chinese" id="chinese" style="width: 50px"><td><strong id="_chinese" style="color:red;"></strong>
					</tr>
					<tr>
						<td>数学成绩：<input value="${student.math}" maxlength="6"name="math" id="math" style="width: 50px"><td><strong id="_math" style="color:red;"></strong></td>
					</tr>
					<tr>
						<td>英语成绩：<input value="${student.english}" maxlength="6"name="english" id="english" style="width: 50px"><td><strong id="_english" style="color:red;"></strong></td>
					</tr>
					<tr>
						<td>作业成绩：<input value="${student.homework}" maxlength="6"name="homework" id="homework" style="width: 50px"><td><strong id="_homework" style="color:red;"></strong></td>
					</tr> 
					<tr>
						<td><button type="submit" >提交</button></td>
						<td><button type="reset">重置</button></td>
						<td><button type="button" onclick="re()">取消</button></td>
					</tr>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>