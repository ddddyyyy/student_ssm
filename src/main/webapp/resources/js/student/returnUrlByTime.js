var time = 4;

function returnUrlByTime() {

	window.setTimeout('returnUrlByTime()', 1000);

	if (time > 0) {
		time = time - 1;
	}

	document.getElementById("layer").innerHTML = time;
}
