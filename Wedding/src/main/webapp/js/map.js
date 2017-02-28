var Map = function() {
};

Map.prototype.initializeGoogleMap = function(latitude, longtitude) {
	if ($("#google_map").length) {

		var mapOptions = {
			zoom : 16,
			center : new google.maps.LatLng(latitude, longtitude),
			scrollwheel : true,
			mapTypeControl : false,
		};

		var map = new google.maps.Map(document.getElementById('google_map'),
				mapOptions);

		var marker = new google.maps.Marker({
			map : map,
			position : map.getCenter(),
		});

		google.maps.event.addDomListener(window, "resize", function() {

			var center = map.getCenter();
			google.maps.event.trigger(map, "resize");
			map.setCenter(center);
		});

	}
};
