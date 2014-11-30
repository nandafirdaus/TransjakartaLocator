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
				$("#w-input-search-latitude").val(ui.item.latitude);
				$("#w-input-search-longitude").val(ui.item.longitude);
				return false;
			}
		}).autocomplete("instance")._renderItem = function(ul, item) {
			return $("<li>").append("<a>" + item.name + "<br>" + item.address + "</a>").appendTo(ul);
		};
		
		$("#w-button-search").click(function() {
			var latitude = $('#w-input-search-latitude').val();
			var longitude = $('#w-input-search-longitude').val();
			
			$.getJSON("${pageContext.request.contextPath}/getNearest",
			{
				{latitude : $('#w-input-search-latitude').val(),
				longitude : $('#w-input-search-longitude').val()}
			},
			function (data) {
				
				var data = JSON.stringify(data);
				var json = JSON.parse(data);
				
				showMap(json["name"], json["latitude"], json["longitude"]);

			});
			
		});
		
		function showMap(title, latitude, longitude) {

			var googleLatandLong = new google.maps.LatLng(latitude, longitude);

			var mapOptions = {
				zoom : 15,
				center : googleLatandLong,
				mapTypeId : google.maps.MapTypeId.ROADMAP
			};

			var mapDiv = document.getElementById("map");
			map = new google.maps.Map(mapDiv, mapOptions);

			var title = $('#w-input-search').val();
			addMarker(map, googleLatandLong, title, "");

		}

		function addMarker(map, latlong, title, content) {

			var markerOptions = {
				position : latlong,
				map : map,
				title : title,
				clickable : true
			};
			var marker = new google.maps.Marker(markerOptions);
		}

	});

	

	function initialize() {
		var mapOptions = {
			center : {
				lat : -34.397,
				lng : 150.644
			},
			zoom : 8
		};
		var map = new google.maps.Map(document.getElementById('map'), mapOptions);
	}

	google.maps.event.addDomListener(window, 'load', initialize);

</script>

</head>
<body>
	<div style="float: left; z-index: 0">
		<input type="text" id="w-input-search" value=""> <input
			type="hidden" id="w-input-search-latitude"> <input
			type="hidden" id="w-input-search-longitude"> <span>
			<button id="w-button-search" type="button">Search</button>
		</span>
	</div>
	<div id="map" style="clear: both; z-index: 100;"></div>
</body>
</html>
