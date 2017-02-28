var Map = function() {
};

Map.prototype.initializeGoogleMap = function(latitude, longtitude) {
	if ($("#google_map").length) {

		var mapOptions = {
			zoom : 17,
			center : new google.maps.LatLng(latitude, longtitude),
			scrollwheel : true,
			mapTypeControl : false,
		};

		var map = new google.maps.Map(document.getElementById('google_map'),
				mapOptions);

		var marker = new google.maps.Marker({
			map : map,
			animation : google.maps.Animation.DROP,
			position : map.getCenter(),
		});

		var contentString = '<div style="width: 100%; padding-left:10px; height: 25px;float: left;color:'
				+ '#FFF;background: #ed1e79;line-height: 25px;border-radius:5px 5px 0px 0px;"><strong><b>Location</b></strong>'
				+ '</div><div style="clear:both;height:0px;"><div style="float:left;width:100%;padding:5px 10px;border:1px solid #ccc;border-top:none;border-radius:0px 0px 5px 5px;">'
				+ '<div style="float:left;color:#666;font-size:18px;font-weight:bold;margin:5px 0px;"> <div style="padding: 0px;">'
				+ '서울 종로구 북촌로 1길 30-4 <br/>(안국동 75-1)'
				+ '</div></div><div style="clear:both;height:0px;"></div><div style="float:left;line-height:18px;color:#666;font-size:13px;"></div><div style="clear:both;height:0px;"></div>'
				+ '<a href="https://www.instagram.com/handus_office/"style=\"background:#7e7e7e;float:right;color:#FFF;padding:5px 7px;font-size:10px;font-weight:bold;border:none;margin:5px 0px; border-radius:0px !important;\" >More Info</a></div></div>';

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
