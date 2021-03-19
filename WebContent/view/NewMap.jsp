
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
	  <meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.3.1/leaflet.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.3.1/leaflet.js"></script>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	

	<style>
	
	  html, body {
  	height: 100%;
  	margin: 0;
  }
  #map {
  	width: 100%;
  	height: 70%;
  }
	
	</style>

	</head>
	
	
	
	<body>

<div id="map"></div>
<div>
  <input type="checkbox" class="gaucher" id="1" name="gaucher[]" onchange="processCheck(this)">
  <label for="1">Caritas</label>
</div>
<div>
  <input type="checkbox" class="gaucher" id="2" name="gaucher[]" onchange="processCheck(this)">
  <label for="2">Eventi</label>
</div>

<div>
  <input type="checkbox" class="gaucher" id="3" name="gaucher[]" onchange="processCheck(this)">
  <label for="3">Donazioni</label>
</div>
<div>
  <input type="checkbox" class="gaucher" id="4" name="gaucher[]" onchange="processCheck(this)">
  <label for="4">Chito</label>
</div>
	<script>
	
	
	
	<% 
		
		
		String jsMarker = "";
		for(int i=0; i< caritas.size(); i++){
			double myY = caritas.get(i).getLongitudine();
			double myX = caritas.get(i).getLatitudine();
			
			int id = caritas.get(i).getIdMarker();
			jsMarker += "{\"geometry\": {\"type\": \"Point\",\"coordinates\": ["+ myX +","+ myY + "]},\"type\": \"Feature\",\"properties\": {\"popupContent\": \"Caritas\"},\"id\": " + id + " }";
			if(i != caritas.size() -1 ){
				jsMarker +=",";
			}
		}
		String jsMarkerEvento = "";
		for(int i=0; i< evento.size(); i++){
			double myY = evento.get(i).getLongitudine();
			double myX = evento.get(i).getLatitudine();			
			int id = evento.get(i).getIdMarker();
			jsMarkerEvento += "{\"geometry\": {\"type\": \"Point\",\"coordinates\": ["+ myX +","+ myY + "]},\"type\": \"Feature\",\"properties\": {\"popupContent\": \"Evento\"},\"id\": " + id + " }";
			if(i != evento.size() -1 ){
				jsMarkerEvento +=",";
			}
		}
		 
	
		
		String jsMarkerDonazioni = "";
		for(int i=0; i< evento.size(); i++){
			double myY = donazione.get(i).getLongitudine();
			double myX = donazione.get(i).getLatitudine();			
			int id = donazione.get(i).getIdMarker();
			jsMarkerDonazioni += "{\"geometry\": {\"type\": \"Point\",\"coordinates\": ["+ myX +","+ myY + "]},\"type\": \"Feature\",\"properties\": {\"popupContent\": \"Donazione\"},\"id\": " + id + " }";
			if(i != donazione.size() -1 ){
				jsMarkerDonazioni +=",";
			}
		}
		 
		
	


	
		
	
	%>
	var caritasMarker = {"type": "FeatureCollection","features": [ <%= jsMarker %> ]};
		       	
	var eventoMarker= {"type": "FeatureCollection","features": [ <%= jsMarkerEvento %> ]};
	
	var donazioniMarker = {"type": "FeatureCollection","features": [ <%= jsMarkerDonazioni %> ]};
	
	


	var map = L.map('map').setView([41.87, 12.47], 10);

	  var baselayer1 = L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
	    attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
	  }).addTo(map);

		//var layer1 = L.geoJSON(bicycleRental);
		//var layer2 = L.geoJSON(campus);
		//var layer4 = L.geoJSON(coorsField);
		var layerDonazioni = L.geoJSON(donazioniMarker);
		var layerEvento = L.geoJSON(eventoMarker);
		var layerCaritas = L.geoJSON(caritasMarker);
	   
	  var layers = [layerCaritas, layerEvento, layerDonazioni];
	  
	  selId = null;
	  
		var obj;
	  
	  function onClick(e) {
		   alert(e.layer.feature.id);
		   obj = e;
		}
	  
	  function processCheck(checkbox) {
	    var checkId = checkbox.id;

	    if (checkbox.checked) {
	      if (selId != null) {
	        map.removeLayer(layers[selId - 1]);
	        document.getElementById(selId).checked = false;
	      }
	      layers[checkId - 1].addTo(map).on('click', onClick);
	      selId = checkId;
	      }
	    else {
	      map.removeLayer(layers[checkId - 1]);
	      selId = null;
	    }
	  }

	
	</script>
	

	</body>
	
	
</html>