<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="PrenotaTurnoBoundary" scope="request" class="bean2.PrenotaTurnoBoundary"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="PrenotaTurnoBoundary" property="*"/>

<%
Class.forName("com.mysql.jdbc.Driver");
	if(request.getParameter("PARTECIPA")!=null){
		if (PrenotaTurnoBoundary.prenotaTurno(request.getParameter("nome_giorno"),request.getParameter("ora_inizio"),request.getParameter("ora_fine"),request.getParameter("Curriculum")) == 0){


%>
	<jsp:forward page="homeCaritas.jsp"/>
<%
		}}
%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PRENOTA TURNO</title>
<link rel="stylesheet" href ="../css/prenotaTurno2.css">
</head>
<body>
	<form action = "prenotaTurno.jsp" name = "reg" method = "POST">
	<div class = "center">
		<div class = "content">
			<div class = "header">
				<h2>JUST THINK IT</h2>
			</div>
			<h4>Grazie al tuo sostegno moltissime persone te ne saranno grate e potranno essere aiutate!</h4>
			<h6>*dopo aver inviato la richiesta verrà inoltrata una notifica se accettata</h6>
			<div class = "opzioni">
	<h3 class = "turno">Giorni di prenotazione</h3>
	<select id = "nome_giorno" name="nome_giorno" >
	<option id = "nome_giorno" value="Lunedì" selected="selected">Lunedì</option>
	<option id = "nome_giorno" value="Martedì"  selected="selected">Martedì </option>
	<option id = "nome_giorno"value="Mercoledì"  selected="selected">Mercoledì</option>
	<option id = "nome_giorno" value="Giovedì" selected="selected">Giovedì</option>
	<option id = "nome_giorno" value="Venerdì"  selected="selected">Venerdì</option>
	<option id = "nome_giorno" value="Sabato"  selected="selected">Sabato</option>
	<option id = "nome_giorno" value="Domenica" selected="selected">Domenica</option>
	</select>

	<h3 class = "orari">Orari disponibili</h3>
	<select id = "ora_inizio" name="scelteOrari" >
	<option id = "ora_inizio" value="ora_inizio" selected="selected">8:00</option>
	<option id = "ora_inizio" value="ora_inizio" >11:00</option>
	<option id = "ora_inizio" value="ora_inizio" >14:00</option>
	<option id = "ora_inizio" value="ora_inizio"  selected="selected">17:00</option>
	<option id = "ora_inizio" value="ora_inizio" >20:00</option>
	</select>
	<select id = "ora_fine" name="fineOrari" >
	<option id = "ora_fine" value = "ora_fine" selected="selected">8:00</option>
	<option id = "ora_fine" value = "ora_fine" selected="selected">11:00</option>
	<option id = "ora_fine" value = "ora_fine" selected="selected">14:00</option>
	<option id = "ora_fine" value = "ora_fine" selected="selected">17:00</option>
	<option id = "ora_fine" value = "ora_fine" selected="selected">20:00</option>
	</select>
	</div>
	<div class = "text">
	<h3 class = "cv">Inserisci il link al cv</h3>
	<input type="text" id ="Curriculum" name= "Curriculum"  placeholder="es.www.github.it"/>
	</div>
			<button type="submit" name= "PARTECIPA" value="PARTECIPA">PARTECIPA</button>
			<div class = "ind">
			<a href= "">INDIETRO</a>
			</div>
		</div>
	</div>
	</form>
</body>
</html>