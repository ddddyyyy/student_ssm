<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/main.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看成绩</title>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/student/resetForm.js"></script>
<script type="text/javascript" src="../js/student/ajaxSetViewData.js"></script>
<script type="text/javascript">
	function search(number) {
//		var json = {};
		// 只能传json字符串
//		var data = $('#form').serializeArray();
//		console.log(data)
		//将json数组转化为json
/* 		$.each(data, function() {
			if (json[this.name]) {
				if (!json[this.name].push) {
					json[this.name] = [ json[this.name] ];
				}
				json[this.name].push(this.value || '');
			} else {
				json[this.name] = this.value || '';
			}
		})
		json.pageNum = number */
		$('#pageNum').val(number)
		$.ajax({
			type : "POST",
			dataType : "json",
			//contentType : "application/json",
			url : "${pageContext.request.contextPath}/manager/searchStudentJson",
			data : $('#form').serialize(),
			//JSON.stringify(json)
			success : function(result) {
				createTable(result)
				initPage(result)
				//resetForm(result)
				$('#number').html(result.pageNum)
				$('#numberMax').html(result.pageTotal)
			},
			error : function() {
				alert("出错")
			}
		});
	}
</script>
<script type="text/javascript" src="../js/CheckPage.js"></script>
</head>
<body onload="search(1)">
	<%@include file="主页.jsp"%>
	<div>
		<form action="searchStudent" method="post" id="form">
			<%@include file="searchBar.jsp"%>
			<%@include file="ViewData(JSON).jsp"%>
			<%@include file="page.jsp"%>
		</form>
	</div>
</body>
</html>
