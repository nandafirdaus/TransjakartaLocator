<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Google Maps</title>
<style type="text/css">
html, body, #map-canvas {
	height: 100%;
	margin: 0;
	padding: 0;
}
</style>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js">
	
</script>
<script
	src="<c:url value="http://code.jquery.com/jquery-2.1.0.min.js" />"></script>
<script src="<c:url value="/resources/jquery-ui/jquery-ui.min.js" />"></script>
<script type="text/javascript">
	$('#w-input-search').each(function() {
		alert('keypress');
	});
	$(document)
			.ready(
					function() {

						$('#w-input-search')
								.autocomplete(
										{
											minLength : 0,
											source : '${pageContext.request.contextPath}/getFoursquare',
											paramName: "tagname",
											delimiter: ",",
											focus : function(event, ui) {
												$("#project")
														.val(ui.item.label);
												return false;
											},
											select : function(event, ui) {
												$("#w-input-search").val(
														ui.item.name);
												$("#w-input-search-latitude").val(
														ui.item.latitude);
												$("#w-input-search-longitude").val(
														ui.item.longitude);
												return false;
											}
										}).autocomplete("instance")._renderItem = function(
								ul, item) {
							return $("<li>").append(
									"<a>" + item.name + "<br>" + item.address
											+ "</a>").appendTo(ul);
						};

					});

		function initialize() {
			var mapOptions = {
				center : {
					lat : -34.397,
					lng : 150.644
				},
				zoom : 8
			};
			var map = new google.maps.Map(document.getElementById('map-canvas'),
					mapOptions);
		}
		google.maps.event.addDomListener(window, 'load', initialize);
</script>

</head>
<body>
	<div style="float: left; z-index: 0">
		<input type="text" id="w-input-search" value="">
		<input type="hidden" id="w-input-search-latitude">
		<input type="hidden" id="w-input-search-longitude">
		<span>
			<button id="button-search" type="button">Search</button>
		</span>
	</div>
	<div id="map-canvas" style="clear: both; z-index: 100;"></div>
</body>
</html>
