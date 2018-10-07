<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<ul class=page>
		<li>学号<input style="width: 50px" name="id" id="id">
		<li>能力等级 <select name="level" id="level">
				<option value="Z">任意
				<option value="A">A
				<option value="B">B
				<option value="C">C
				<option value="D">D
				<option value="S">S
		</select>
		<li>姓名<input style="width: 50px" name="name" id="name">
		<li><select name="scoreN" class="scoreN" id="scoreN">
				<option value="无">任意
				<option value="语文成绩">语文成绩
				<option value="数学成绩">数学成绩
				<option value="英语成绩">英语成绩
				<option value="平均分">平均分
				<option value="作业成绩">作业成绩
		</select>
		<li><input style="width: 30px" name="scoreU" id="scoreU" value="0.0">to
		<li><input style="width: 30px" name="scoreD" id="scoreD" value="100.0">
		<li><select name="sortType" id="sortType">
				<option value="无">不排序
				<option value="平均分">平均分
				<option value="数学成绩">数学成绩
				<option value="英语成绩">英语成绩
				<option value="语文成绩">语文成绩
				<option value="作业成绩">作业成绩
		</select>
		<li><select name="sort" id="sort">
				<option value="desc">降序</option>
				<option value="asc">升序</option>
		</select>
		<li><button type="button" onclick="search(1)">提交</button>
		<li><button type="reset">重置</button>
	</ul>
</div>