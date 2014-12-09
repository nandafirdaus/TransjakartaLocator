<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Google Maps</title>
<style type="text/css">
html, body, #map {
	height: 100%;
	margin: 0;
	padding: 0;
}
</style>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js">
	
</script>
<script
	src="<c:url value="http://code.jquery.com/jquery-2.1.0.min.js" />"></script>
<script src="<c:url value="/resources/jquery-ui/jquery-ui.min.js" />"></script>
<script src="<c:url value="/resources/js/gmaps.js" />"></script>
<script type="text/javascript">
	var map;
	
	$(document).ready(function() {
		
		$('#w-input-search').autocomplete({
			minLength : 0,
			source : '${pageContext.request.contextPath}/getFoursquare',
			paramName : "tagname",
			delimiter : ",",
			focus : function(event, ui) {
				$("#project").val(ui.item.label);
				return false;
			},
			select : function(event, ui) {
				$("#w-input-search").val(ui.item.name);
				$("#w-input-search-name").val(ui.item.name);
				$("#w-input-search-latitude").val(ui.item.latitude);
				$("#w-input-search-longitude").val(ui.item.longitude);

				$("#w-button-search").trigger("click");

				return false;
			}
		}).autocomplete("instance")._renderItem = function(ul, item) {
			return $("<li>").append("<a>" + item.name + "<br>" + item.address + "</a>").appendTo(ul);
		};
		
		$('#w-input-search').change(function() {
			if ($("#w-input-search").val() == "") {
				$("#w-input-search-latitude").val("");
				$("#w-input-search-longitude").val("");
			}
		});

		$("#w-button-search").click(function() {

			if ($("#w-input-search-latitude").val() == "" || 
					$("#w-input-search-latitude").val() == "") {
				return;
			}
			
			var latitude = $('#w-input-search-latitude').val();
			var longitude = $('#w-input-search-longitude').val();
			var title = $('#w-input-search').val();
			getNearest(latitude, longitude, title);

		});
	});
	
	function getNearest(latitude, longitude, title) {
		$.getJSON("${pageContext.request.contextPath}/getNearest", {
			latitude : latitude,
			longitude : longitude
		}, function(data) {

			var data = JSON.stringify(data);
			var json = JSON.parse(data);

			showMap(json, title, latitude, longitude);

		});
	}

	function showMap(shelter, title, latitude, longitude) {

		var shelter1 = shelter[0];
		var shelter2 = shelter[1];

		map.removeMarkers();
		
		addMarker(map, shelter1['latitude'], shelter1['longitude'], shelter1['name'], shelter1['name']);
		addMarker(map, shelter2['latitude'], shelter2['longitude'], shelter2['name'], shelter2['name']);
		addMarker(map, latitude, longitude, title, title);

		map.fitZoom();
	}

	function addMarker(map, latitude, longitude, title, content) {

		map.addMarker({
			lat: latitude,
			lng: longitude,
			title: title,
			infoWindow: {
				content: "<p>" + title + "</p>"
			}
		});
	}

	function initialize() {
		map = new GMaps ({
			div : "#map",
			lat : -6.2297465,
			lng : 106.829518,
			zoom : 11
		});
		
		map.setContextMenu({
			control: 'map',
			options: [{
				title: 'From here',
				name: 'from_here',
				action: function(e) {
					getNearest(e.latLng.lat(), e.latLng.lng(), "Your location");
				}
			}]
		});
	}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>

</head>
<body>
	<div style="float: left; z-index: 0">
		<input type="text" id="w-input-search" value=""> 
		<input type="hidden" id="w-input-search-name"> 
		<input type="hidden" id="w-input-search-latitude"> 
		<input type="hidden" id="w-input-search-longitude"> 
		<span>
			<button id="w-button-search" type="button">Search</button>
		</span>
	</div>
	<div id="map" style="clear: both;"></div>
</body>
</html>
