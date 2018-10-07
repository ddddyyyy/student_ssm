<%@page import="java.util.Iterator"%>
<%@page import="com.mdy.student.bean.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		</tbody>
	</table>
</div>