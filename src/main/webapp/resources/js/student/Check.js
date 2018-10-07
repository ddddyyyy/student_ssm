function validate_required_score(field) {
	var num = /^[0-9]+.?[0-9]*$/
	with (field) {
		if (value == null || value == "") {
			return false
		} else {
			if (num.test(value) && 0 <= value && value <= 100) {
				return true
			} else {
				return false
			}
		}
	}
}
function validate_required_id(field) {
		var num = /^[0-9]*$/
		///^[0-9]*$/;
		with (field) {
				if (num.test(value)) {
					return true
				} else {
					return false
				}
			}
}
function validate_form(thisform) {
	with (thisform) {
		if (validate_required_score(chinese) == false) {
			chinese.focus()
			document.getElementById("_chinese").innerHTML = "成绩必须在0到100之间"
			return false
		}else{
			document.getElementById("_chinese").innerHTML = ""
		}
		if (validate_required_id(id) == false) {
			id.focus()
			document.getElementById("_id").innerHTML = "学号必须为数字"
			return false
		}else{
			document.getElementById("_id").innerHTML = ""
		}
		if (validate_required_score(math) == false) {
			math.focus()
			document.getElementById("_math").innerHTML = "成绩必须在0到100之间"
			return false
		}else{
			document.getElementById("_math").innerHTML = ""
		}
		if (validate_required_score(english) == false) {
			english.focus()
			document.getElementById("_english").innerHTML = "成绩必须在0到100之间"
			return false
		}else{
			document.getElementById("_english").innerHTML = ""
		}
		if (validate_required_score(homework) == false) {
			homework.focus()
			document.getElementById("_homework").innerHTML = "成绩必须在0到100之间"
			return false
		}else{
			document.getElementById("_homework").innerHTML = ""
		}

	}
}