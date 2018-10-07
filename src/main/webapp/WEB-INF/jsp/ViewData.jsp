<%@page import="java.util.Iterator"%>
<%@page import="com.mdy.student.bean.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${requesrScope.pagebean == null}">
	<c:set scope="request" var="list" value="${pagebean.list}"></c:set>
</c:if>
<div align="center" style="height: 300px; overflow: auto;">
	<table class=table1_1 id="td">
		<thead>
			<tr>
				<th id="sid">学号</th>
				<th id="sname">姓名</th>
				<th id="schinese">语文成绩</th>
				<th id="smath">数学成绩</th>
				<th id="senglish">英语成绩</th>
				<th id="sper">平均分</th>
				<th id="shomescore">作业成绩</th>
				<th id="slevel">成绩等级</th>
			</tr>
		</thead>
		<tbody id="body">
			<c:forEach items="${list}" var="s">
				<tr>
					<td>${s.id}</td>
					<td>${s.name}</td>
					<td>${s.chinese}</td>
					<td>${s.math}</td>
					<td>${s.english}</td>
					<td>${s.per}</td>
					<td>${s.homework}</td>
					<td>${s.level}</td>
					<td><a href="editStudent?id=${s.id}">编辑</a></td>
					<td><a href="delStudent?id=${s.id}"
						onclick="javascript: return confirm('真的要删除吗');">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>