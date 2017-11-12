var Rsvp = function() {

}

Rsvp.prototype.confirmRsvp = function(flag) {
	var name = $("#name").val();

	if ("" == name || null == name) {
		$("#msg").focus();
		$("#msg").text("Info ! 이름을 작성 후, 참석여부를 선택해주세요.");
		$("#msg_div").show();
		return false;
	}

	var data = {
		name : name,
		flag : flag
	};

	data = JSON.stringify(data);

	$.ajax({
		url : "/wedding/rsvp",
		type : 'POST',
		data : data,
		contentType : 'application/json',

		success : function(response) {
			if (response == "success") {
				$("#id01").hide();
			} else {

			}
		},
		error : function(request, status, error) {

		}
	});
};
