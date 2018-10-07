function checkdel(){
	return confirm("真的要删除吗");
}
function createTable(result) {
	$("#body").html("")
	for (var i = 0; i < result.list.length; ++i) {
		var s = "<tr><td>"
				+ result.list[i].id
				+ "</td>"
				+ "<td>"
				+ result.list[i].name
				+ "</td>"
				+ "<td>"
				+ result.list[i].chinese
				+ "</td>"
				+ "<td>"
				+ result.list[i].math
				+ "</td>"
				+ "<td>"
				+ result.list[i].english
				+ "</td>"
				+ "<td>"
				+ result.list[i].per
				+ "</td>"
				+ "<td>"
				+ result.list[i].homework
				+ "</td>"
				+ "<td>"
				+ result.list[i].level
				+ "</td>"
				+ "<td><a href='editStudent?id="+result.list[i].id+"'>编辑</a></td><td><a href='delStudent?id="+result.list[i].id+"' onclick='return checkdel()'>删除</a></td></tr>"
		$("#body").append(s)
	}
}
function initPage(result) {
	var s = ""
	$('#tip').html(s)
	var t;
	if (parseInt(result.pageNum) - 1 < 0) {
		s += "<li><a>上一页</a>"
	} else {
		t = parseInt(result.pageNum) - 1
		s += "<li><a href='javascript: search(" + t + ");'>" + "上一页" + "</a>"
	}
	for (t = parseInt(result.start); t <= parseInt(result.end); t++) {
		if (t != parseInt(result.pageNum)) {
			s += "<li><a href='javascript: search(" + t + ");'>[" + t + "]</a>"
		} else {
			s += "<li><a>[" + t + "]</a>"
		}
	}
	if (parseInt(result.pageNum) + 1 > parseInt(result.pageTotal)) {
		s += "<li><a>下一页</a>"
	} else {
		t = parseInt(result.pageNum) + 1
		s += "<li><a href='javascript: search(" + t + ");'>" + "下一页" + "</a>"
	}
	s += "<li><a href='javascript: search(" + result.pageTotal + ");'>尾页</a>"
	$('#tip').append(s)
}