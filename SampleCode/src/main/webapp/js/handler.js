window.onload = function() {

	$("#call_button").click(function(e) {
		callServer();
	});

	$("#trigger_button").click(function(e) {
		sendMessage("modacom~~");
	});

}