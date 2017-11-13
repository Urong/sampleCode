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

var weddingImageArray = [ '/img/b3.jpg', '/img/a1.jpg', '/img/a2.jpg',
		'/img/b1.jpg', '/img/c1.jpg', '/img/c2.jpg', '/img/c3.jpg',
		'/img/c4.jpg', '/img/d1.jpg', '/img/d2.jpg', '/img/d3.jpg',
		'/img/d4.jpg', '/img/d5.jpg', '/img/d6.jpg', '/img/e1.jpg',
		'/img/e2.jpg', '/img/e3.jpg', '/img/f1.jpg', '/img/f2.jpg',
		'/img/g1.jpg', '/img/h1.jpg', '/img/h2.jpg', '/img/i1.jpg',
		'/img/i2.jpg', '/img/i3.jpg', '/img/j1.jpg', '/img/j2.jpg',
		'/img/j3.jpg', '/img/k1.jpg', '/img/k2.jpg', '/img/k3.jpg',
		'/img/k4.jpg', '/img/k5.jpg', '/img/k6.jpg', '/img/l1.jpg',
		'/img/l2.jpg', '/img/l3.jpg', '/img/l4.jpg', '/img/l5.jpg',
		'/img/l6.jpg' ];

Rsvp.prototype.appendImg = function() {
	var testArray = [
			'js/Slides-SlidesJS-3/examples/playing/img/example-slide-1.jpg',
			'js/Slides-SlidesJS-3/examples/playing/img/example-slide-2.jpg',
			'js/Slides-SlidesJS-3/examples/playing/img/example-slide-3.jpg',
			'js/Slides-SlidesJS-3/examples/playing/img/example-slide-4.jpg' ]

	var target = $("#img_box");
	var pageTag = $("#page");

	var page = parseInt(pageTag.val());
	var offset = 10;

	var num = (page - 1) * offset;
	var count = num + offset;

	for (var num; num < count; num++) {
		var path = weddingImageArray[num];
		var html = '<img data-original="/wedding/' + path
				+ '" class="lazy imgs" style="height : 100%; width : 100%;" />';

		target.append(html);
	}

	var pageNum = parseInt(page) + 1;
	pageTag.val(pageNum);

	$('img.lazy').lazyload({
		placeholder : "/wedding/img/spinner.gif"
	});
};
