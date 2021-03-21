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
      <link rel="stylesheet" href="../css/maps.css" />
      <meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no" />
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.3.1/leaflet.css" />
      <script src="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.3.1/leaflet.js"></script>
      <meta charset="ISO-8859-1">
      <title>MAPPA</title>
     <style>
      #map {position: absolute; top: 80px; right: 0; bottom: 0; left: 320px;     width: 1030px; height: 560px}
    </style>
    <script type="text/javascript">
    	var idMarker = 0;
    	
    	function creaPacco(){
    		location.href="./NewMap.jsp?marker=si&prova="+ idMarker;
    	}
    </script>
  </head>
  <body>
  

<input type="button" value="Jump there" onClick="updateLatLng(document.getElementById('latitude').value,document.getElementById('longitude').value,1)">
 <a href="#" onclick="map.zoomOut(3, {animate:true})">zoom out</a> ::
 <a href="#" onclick="map.zoomIn(3, {animate:true})">zoom in</a>
 <label for="latitude">Latitude:</label>
<input id="latitude" type="text" />
<label for="longitude">Longitude:</label>
<input id="longitude" type="text" />
    <div class = "header">
        <h2>JUST THINK IT</h2>
    </div>
      <div class = "ind">
        <a href= "">INDIETRO</a>
    </div>



<div id="mostra-menu">
<li>OPZIONI</li>
  <ul id="menu-a-tendina">
    <li>CREA PACCO DONAZIONE</li>
    <li>PRENOTA TURNO VOLONTARIATO</li>
    <li>VEDI BACHECA</li>
  </ul>
</div>



<div class =  "hidden"></div>
<label id = "Ciao" >Ciaoooo</label>
 <input type="text" id = "prova" name= "prova" placeholder="es. Mario"/> 

<div id = "idd">Ciao sono lucia e sono una sirena</div>
<button id = "marker" name = "marker" onclick="creaPacco()"> Crea Pacco Donazione </button>

<%
	if(request.getParameter("marker") != null){
		//CercaCaritas.creaDonazione();
		String parametro = request.getParameter("prova");
		System.out.println(parametro);
		out.print("<b>"+parametro+"</b>");
		//Preleva dati dal db
	}
%> 


<div id="map"></div>
<div class = "check">
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
  <label for="4">MioMarker</label>
</div>
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

		int idUte = CercaCaritas.getIdUte();

        
        

    %>
    var caritasMarker = {"type": "FeatureCollection","features": [ <%= jsMarker %> ]};

    var eventoMarker= {"type": "FeatureCollection","features": [ <%= jsMarkerEvento %> ]};

    var donazioniMarker = {"type": "FeatureCollection","features": [ <%= jsMarkerDonazioni %> ]};

  
 
   var map = L.map('map').setView([41.87, 12.47], 8);
 
      var baselayer1 = L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
      }).addTo(map);
 

	
        var layerDonazioni = L.geoJSON(donazioniMarker);
        var layerEvento = L.geoJSON(eventoMarker);
        var layerCaritas = L.geoJSON(caritasMarker);
		
        
		
		  var marker = L.marker([41.87, 12.47],{
		    	draggable: true
		    	}).addTo(map);
		    	marker.on('dragend', function (e) {
		    	updateLatLng(marker.getLatLng().lat, marker.getLatLng().lng);
		    	});
		    	map.on('click', function (e) {
		    		marker.setLatLng(e.latlng);
		    		updateLatLng(marker.getLatLng().lat, marker.getLatLng().lng);
		    		});
		
		    	
		    	
		    	
		    	function updateLatLng(lat,lng,reverse) {
		    		if(reverse) {
		    		marker.setLatLng([lat,lng]);
		    		map.panTo([lat,lng]);
		    		} else {
		    		document.getElementById('latitude').value = marker.getLatLng().lat;
		    		document.getElementById('longitude').value = marker.getLatLng().lng;
		    		map.panTo([lat,lng]);
		    		}
		    	}
		    	
		    	
		
		
      var layers = [layerCaritas, layerEvento, layerDonazioni];

      selId = null;

        var  tipo;
        var id;
        
      function onClick(e) {
    	  tipo = e.layer.feature.properties.popupContent;
    	  
    	  if(tipo == "Caritas"){
			id = e.layer.feature.id; 
			//document.getElementById("prova").value = id;
			idMarker = id;
			//p.innerHTML = id;
			
    	  }
          alert(e.layer.feature.properties.popupContent);           
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