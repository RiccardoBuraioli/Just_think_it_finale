<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="DonationBoundary" scope="application" class="bean2.DonationBoundary"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="DonationBoundary" property="*"/>

<%
	Class.forName("com.mysql.jdbc.Driver");
	if(request.getParameter("CONFERMA")!=null){
		if("clothes".equals(request.getParameter("tipo"))){
			if (request.getParameter("tipo") != null && request.getParameter("tipo") != "" && request.getParameter("descrizione") != null && request.getParameter("descrizione") != "" && request.getParameter("IndirizzoVolontario") != null && request.getParameter("IndirizzoVolontario") != ""){
				if ((DonationBoundary.creaDonazione(1,request.getParameter("IndirizzoVolontario")))== 0){
					
%>
		<jsp:forward page="homeVolontario.jsp"/>
<%		}}}
			
		
		if("food".equals(request.getParameter("tipo"))){
			if (request.getParameter("tipo") != null && request.getParameter("tipo") != "" && request.getParameter("descrizione") != null && request.getParameter("descrizione") != "" && request.getParameter("IndirizzoVolontario") != null && request.getParameter("IndirizzoVolontario") != ""){
				if ((DonationBoundary.creaDonazione(2,request.getParameter("IndirizzoVolontario")))== 0){
%>
	<jsp:forward page="Volontario.jsp"/>
<%		
	}}}
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DONAZIONE</title>
<link rel="stylesheet" href ="../css/creaDonazione.css">
</head>
<body>
	<form action = "creaDonazione.jsp" name = "reg" method = "POST">
	<div class = "center">
		<div class = "content">
			<div class = "header">
				<h2>JUST THINK IT</h2>
			</div>
			<h4>La tua donazione è veramente importante per noi e fa la differenza </h4>
			<div class = "don">
		  <h3>Cosa vuoi donare?</h3>
			<h3>Vestiti<input type="checkbox" name="tipo" value="clothes"/>
			<input type="checkbox" name="tipo" value="food"/> Cibo</h3>
		</div>
		<div class = "descr">
		<h3>Inserisci breve desrizione del/dei prodotti:</h3>
		<input type="text" id= "descrizione" name= "descrizione"  placeholder="ho donato 3kg di pasta" />
		</div>
		<div class = "indirizzo">
		<h3>Scrivi il tuo indirizzo</h3>
		<input type = "text" id = "IndirizzoVolontario" name = "IndirizzoVolontario"  placeholder = "via Luigi Settembrini">
		</div>
			<button type="submit" name= "CONFERMA" value="CONFERMA">CONFERMA</button>
			<div class = "ind">
			<a href= "">INDIETRO</a>
			</div>
		</div>
	</div>	
</form>
 </body>
</html>