function resetForm(result) {
	document.getElementById("level").value = result.level;
	document.getElementById("id").value = result.id;
	document.getElementById("name").value = result.name;
	document.getElementById("scoreN").value = result.scoreN;
	document.getElementById("scoreU").value = result.scoreU;
	document.getElementById("scoreD").value = result.scoreD;
	document.getElementById("sort").value = result.sort;
	document.getElementById("sortType").value = result.sortType;
}