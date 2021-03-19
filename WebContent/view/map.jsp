<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import = "entity.CoordinateMap" %>
 
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="CercaCaritas" scope="application" class="bean2.CercaCaritas"/>
 
<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="CercaCaritas" property="*"/>
 
 
<%
    List<CoordinateMap> caritas = CercaCaritas.initMarkersCaritas();
    List<CoordinateMap> evento = CercaCaritas.initMarkersEvento();
    List<CoordinateMap> donazione = CercaCaritas.initMarkersDonazione();

%>

<!DOCTYPE html>
<html>
<head>
<title>Map populating form fields</title>
<meta charset="utf-8" />
<link rel="stylesheet"
	href="http://cdn.leafletjs.com/leaflet-0.7.3/leaflet.css" />
<!-- original: http://cdn.leafletjs.com/leaflet-0.7.3/leaflet.css -->
<style>
html, body, #container, #map {
	padding: 0;
	margin: 0;
}

html, body, #map, #container {
	height: 460px;
}
</style>
</head>
<body>
	<form>
		<label for="latitude">Latitude:</label> <input id="latitude"
			type="text" /> <label for="longitude">Longitude:</label> <input
			id="longitude" type="text" /> :: or, enter your own lat-long values
		and <input type="button" value="Jump there"
			onClick="updateLatLng(document.getElementById('latitude').value,document.getElementById('longitude').value,1)">
		:: <a href="#" onclick="map.zoomOut(3, {animate:true})">zoom out</a>
		:: :: <a href="#" onclick="map.zoomIn(3, {animate:true})">zoom in</a>
	</form>
	<div id="map"></div>
	<script src="http://cdn.leafletjs.com/leaflet-0.7.3/leaflet.js"></script>
	<!-- Orginal: http://cdn.leafletjs.com/leaflet-0.7.3/leaflet.js -->
	<script>
		var tileLayer = new L.TileLayer(
				'http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
				{
					attribution : '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a> Contributors'
				});
		//remember last position
		var rememberLat = document.getElementById('latitude').value;
		var rememberLong = document.getElementById('longitude').value;
		if (!rememberLat || !rememberLong) {
			rememberLat = 41.87;
			rememberLong = 12.47;
		}
		var map = new L.Map('map', {
			'center' : [ rememberLat, rememberLong ],
			'zoom' : 12,
			'layers' : [ tileLayer ]
		});
		var marker = L.marker([ rememberLat, rememberLong ], {
			draggable : true
		}).addTo(map);
		marker.on('dragend', function(e) {
			updateLatLng(marker.getLatLng().lat, marker.getLatLng().lng);
		});
		map.on('click', function(e) {
			marker.setLatLng(e.latlng);
			updateLatLng(marker.getLatLng().lat, marker.getLatLng().lng);
		});
		function updateLatLng(lat, lng, reverse) {
			if (reverse) {
				marker.setLatLng([ lat, lng ]);
				map.panTo([ lat, lng ]);
			} else {
				document.getElementById('latitude').value = marker.getLatLng().lat;
				document.getElementById('longitude').value = marker.getLatLng().lng;
				map.panTo([ lat, lng ]);
			}
		}
	</script>
</body>
</html>