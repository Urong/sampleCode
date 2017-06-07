$(document).ready(function() {

	var rsvp = new Rsvp();

	$("#yes").click(function(e) {
		rsvp.confirmRsvp("O");
	});

	$("#no").click(function(e) {
		rsvp.confirmRsvp("X");
	});

});