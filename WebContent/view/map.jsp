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
  	<link rel="stylesheet" href="../css/maps.css" />
    <meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.3.1/leaflet.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.3.1/leaflet.js"></script>
   <style>
      #map {position: absolute; top: 80px; right: 0; bottom: 0; left: 320px; 	width: 1030px; height: 560px}
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


<div id="mostra-menu">
<li>OPZIONI</li>
  <ul id="menu-a-tendina">
    <li>CREA PACCO DONAZIONE</li>
    <li>PRENOTA TURNO VOLONTARIATO</li>
    <li>VEDI BACHECA</li>
  </ul>
</div>

 
<div class = "check">
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
<script>	
	var map = L.map('map').setView([42.5, 12.05], 13);

	 	 var baselayer1 = L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
	    attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
	  }).addTo(map);

</script>	
<%  List<CoordinateMap> list2 = CercaCaritas.initMarkersEvento();
int ii = 0;
double x = 0;
double y = 0;
while (ii < list2.size()){
	x = list2.get(ii).getLatitudine();
	y = list2.get(ii).getLongitudine();
	System.out.println(x);
%>
<script>	 
  L.marker([<%=y%>,<%=x%>]).addTo(map);
</script>
<%ii++;} %>

<% List<CoordinateMap> list = CercaCaritas.initMarkersCaritas();
	int i = 0;
	double myX = 0;
	double myY = 0;
	while (i < list.size()){
		myX  = list.get(i).getLatitudine();
		myY = list.get(i).getLongitudine(); 
		System.out.println(myX);
		
		%>

<script>	 

	  L.marker([<%=myY%>,<%=myX%>]).addTo(map);
	
</script>
<%i++;} %>
    </div>
	</form>
  </body>
</html>