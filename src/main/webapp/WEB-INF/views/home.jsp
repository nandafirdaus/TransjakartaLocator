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
<script type="text/javascript">
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

			$.getJSON("${pageContext.request.contextPath}/getNearest", {
				latitude : $('#w-input-search-latitude').val(),
				longitude : $('#w-input-search-longitude').val()
			}, function(data) {

				var data = JSON.stringify(data);
				var json = JSON.parse(data);

				showMap(json);

			});

		});

		function showMap(shelter) {

			var shelter1 = shelter[0];
			var shelter2 = shelter[1];
			var googleLatandLong1 = new google.maps.LatLng(shelter1['latitude'], shelter1['longitude']);
			var googleLatandLong2 = new google.maps.LatLng(shelter2['latitude'], shelter2['longitude']);
			var googleLatandLong3 = new google.maps.LatLng($('#w-input-search-latitude').val(), $('#w-input-search-longitude').val());

			var mapOptions = {
				zoom : 15,
				center : googleLatandLong1,
				mapTypeId : google.maps.MapTypeId.ROADMAP
			};

			var mapDiv = document.getElementById("map");
			map = new google.maps.Map(mapDiv, mapOptions);

			addMarker(map, googleLatandLong1, shelter1['name'], shelter1['name']);
			addMarker(map, googleLatandLong2, shelter2['name'], shelter2['name']);
			addMarker(map, googleLatandLong3, $('#w-input-search-name').val(), $('#w-input-search-name').val());

			var latlngbounds = new google.maps.LatLngBounds();
			latlngbounds.extend(googleLatandLong1);
			latlngbounds.extend(googleLatandLong2);
			latlngbounds.extend(googleLatandLong3);

			map.fitBounds(latlngbounds);
		}

		function addMarker(map, latlong, title, content) {

			var markerOptions = {
				position : latlong,
				map : map,
				title : title,
				clickable : true
			};
			var marker = new google.maps.Marker(markerOptions);
			var infowindow = new google.maps.InfoWindow();

			google.maps.event.addListener(marker, 'click', function() {
				infowindow.setContent("<p>" + title + "</p>");
				infowindow.open(map, marker);
			});
		}

	});

	function initialize() {
		var mapOptions = {
			center : {
				lat : -6.2297465,
				lng : 106.829518
			},
			zoom : 11
		};
		var map = new google.maps.Map(document.getElementById('map'), mapOptions);

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
	<div id="map" style="clear: both; z-index: 100;"></div>
</body>
</html>
