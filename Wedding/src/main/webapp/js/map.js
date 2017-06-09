var Map = function() {
};

Map.prototype.initializeGoogleMap = function(latitude, longtitude) {
	if ($("#google_map").length) {

		var mapOptions = {
			zoom : 16,
			center : new google.maps.LatLng(latitude, longtitude),
			scrollwheel : false,
		};

		var map = new google.maps.Map(document.getElementById('google_map'),
				mapOptions);

		var marker = new google.maps.Marker({
			map : map,
			animation : google.maps.Animation.DROP,
			position : map.getCenter(),
		});

		var contentString = '서울특별시 강남구<br/>역삼1동 633-31 아모르하우스';

		var infowindow = new google.maps.InfoWindow({
			content : contentString
		});

		marker.addListener('click', function() {
			infowindow.open(map, marker);
		});

		google.maps.event.addDomListener(map, "idle", function() {

			var center = map.getCenter();
			google.maps.event.trigger(map, "resize");
			map.setCenter(center);

			marker.setAnimation(google.maps.Animation.BOUNCE);

		});

	}
};
