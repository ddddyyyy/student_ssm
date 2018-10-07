<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div align="center">
	<ul class=page id="page">
		<!-- 首页 -->
		<li><a href="javascript: search(1);">首页</a>
			<div id="tip"></div> 
		<!-- 页数标签 -->
		<li><label><span id="number">1</span>/<span id="numberMax">1</span></label> 
		<!-- 跳转页面输入框 --> 
		<input style="width: 30px;" name="pageNum" value="1" id="pageNum"> 
		<!-- 跳转按钮， 使用JS进行输入框内容校验 -->
		<li><button type="button" onclick="return CheckPage(form)">跳转</button>
	</ul>
</div>