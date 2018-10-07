function CheckPage(form) {
	var page_num = /^[0-9]+.?[0-9]*$/;
	with (form) {
		with (pageNum) {
			if (value == "") {
				value = "1"
			} else {
				if (page_num.test(value)) {
					if (parseInt(value) <= parseInt($('#numberMax').html())) {
						if(parseInt(value)>=1){
							search(value)
						}
						else{
							value = "1"
						}
					} else{
						value = parseInt($('#numberMax').html())
					}
				} else {
					value = "1"
				}
			}
		}
	}
}