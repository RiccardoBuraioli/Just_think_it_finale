<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import = "entity.CoordinateMap" %>

<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="CercaCaritas" scope="application" class="bean2.CercaCaritas"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="CercaCaritas" property="*"/>

<!DOCTYPE html>
<html>
  <head>
  	<link rel="stylesheet" href="../css/map.css" />
    <meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.3.1/leaflet.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.3.1/leaflet.js"></script>
   <style>
      #map {position: absolute; top: 80px; right: 0; bottom: 0; left: 350px; 	width: 980px; height: 550px}
    </style>
  </head>
  <body>
   <form action = "map.jsp" name ="my" method = "POST">   
	<div class = "header">
		<h2>JUST THINK IT</h2>
	</div>
  	<div class = "ind">
		<a href= "">INDIETRO</a>
	</div>
    <div id="map"></div>
    
    <div id="nav">
      <ul>
        <li><a href="#">OPZIONI</a> 
        <ul>
            <li><a href="creaDonazione.jsp">CREA PACCO DONAZIONE</a></li>
            <li><a href="#">PRENOTA TURNO VOLONTARIATO</a></li>
            <li><a href="#"></a>VEDI BACHECA</li>
        </ul>
        </li>
    </ul>   
<div id="map"></div>
<div>
  <input type="checkbox" class="gaucher" id="1" name="gaucher[]" onchange="processCheck(this)">
  <label for="1">CARITAS</label>
</div>
<div>
  <input type="checkbox" class="gaucher" id="2" name="gaucher[]" onchange="processCheck(this)">
  <label for="2">EVENTI</label>
</div>

<div>
  <input type="checkbox" class="gaucher" id="3" name="gaucher[]" onchange="processCheck(this)">
  <label for="3">DONAZIONI</label>
</div>
<div>
  <input type="checkbox" class="gaucher" id="4" name="gaucher[]" onchange="processCheck(this)">
  <label for="4">INDICATORE</label>
</div>

<% List<CoordinateMap> list = CercaCaritas.initMarkersCaritas();
	int i = 0;
	double x = 0;
	double y = 0;
	while (i < list.size()){
		x  = list.get(i).getLatitudine();
		y = list.get(i).getLongitudine(); %>
<%i++;} %>
<script>	 



var bicycleRental = {
    "type": "FeatureCollection",
    "features": [
        {
            "geometry": {
                "type": "Point",
                "coordinates": [
                    -104.9998241,
                    39.7471494
                ]
            },
            "type": "Feature",
            "properties": {
                "popupContent": "This is a B-Cycle Station. Come pick up a bike and pay by the hour. What a deal!"
            },
            "id": 51
        },
        {
            "geometry": {
                "type": "Point",
                "coordinates": [
                    -104.9983545,
                    39.7502833
                ]
            },
            "type": "Feature",
            "properties": {
                "popupContent": "This is a B-Cycle Station. Come pick up a bike and pay by the hour. What a deal!"
            },
            "id": 52
        },
        {
            "geometry": {
                "type": "Point",
                "coordinates": [
                    -104.9963919,
                    39.7444271
                ]
            },
            "type": "Feature",
            "properties": {
                "popupContent": "This is a B-Cycle Station. Come pick up a bike and pay by the hour. What a deal!"
            },
            "id": 54
        },
        {
            "geometry": {
                "type": "Point",
                "coordinates": [
                    -104.9960754,
                    39.7498956
                ]
            },
            "type": "Feature",
            "properties": {
                "popupContent": "This is a B-Cycle Station. Come pick up a bike and pay by the hour. What a deal!"
            },
            "id": 55
        },
        {
            "geometry": {
                "type": "Point",
                "coordinates": [
                    -104.9933717,
                    39.7477264
                ]
            },
            "type": "Feature",
            "properties": {
                "popupContent": "This is a B-Cycle Station. Come pick up a bike and pay by the hour. What a deal!"
            },
            "id": 57
        },
        {
            "geometry": {
                "type": "Point",
                "coordinates": [
                    -104.9913392,
                    39.7432392
                ]
            },
            "type": "Feature",
            "properties": {
                "popupContent": "This is a B-Cycle Station. Come pick up a bike and pay by the hour. What a deal!"
            },
            "id": 58
        },
        {
            "geometry": {
                "type": "Point",
                "coordinates": [
                    -104.9788452,
                    39.6933755
                ]
            },
            "type": "Feature",
            "properties": {
                "popupContent": "This is a B-Cycle Station. Come pick up a bike and pay by the hour. What a deal!"
            },
            "id": 74
        }
    ]
};


var coorsField = {
    "type": "Feature",
    "properties": {
        "popupContent": "Coors Field"
    },
    "geometry": {
        "type": "Point",
        "coordinates": [-104.99404191970824, 39.756213909328125]
    }
};
		

		var map = L.map('map').setView([39.74739, -105], 13);

	  var baselayer1 = L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
	    attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
	  }).addTo(map);

		var layer1 = L.geoJSON(bicycleRental);
	//	var layer2 = L.geoJSON(campus);
	//	var layer3 = L.geoJSON(freeBus);
		var layer4 = L.geoJSON(coorsField);
	   
	  var layers = [layer1,layer4];
	  <% i++;%>  
	  selId = null;

	  function processCheck(checkbox) {
	    var checkId = checkbox.id;

	    if (checkbox.checked) {
	      if (selId != null) {
	        map.removeLayer(layers[selId - 1]);
	        document.getElementById(selId).checked = false;
	      }
	      layers[checkId - 1].addTo(map);
	      selId = checkId;
	      }
	    else {
	      map.removeLayer(layers[checkId - 1]);
	      selId = null;
	    }
	  }
	 	
	  var marker = new L.marker(e.latlng, {draggable:'true'});
	  function onMapClick(e) {
	   	  marker.on('dragend', function(event){
	   	    var marker = event.target;
	   	    var position = marker.getLatLng();
	   	    marker.setLatLng(new L.LatLng(position.lat, position.lng),{draggable:'true'});
	   	    map.panTo(new L.LatLng(position.lat, position.lng))
	   	  });
	   	  map.addLayer(marker);	    
	   	  marker.bindPopup("You clicked the map at " + e.latlng.toString()).openPopup();
	   	};
	   	map.on('click', onMapClick);
</script>

    </div>
	</form>
  </body>
</html>