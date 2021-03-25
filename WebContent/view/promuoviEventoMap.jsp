<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="PartecipaEventoBoundary" scope="application" class="bean2.PartecipaEventoBoundary"/>
 
<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="PartecipaEventoBoundary" property="*"/>
 
<%Class.forName("com.mysql.jdbc.Driver"); %>
<%
	if(request.getParameter("CONFERMA") != null){
		PartecipaEventoBoundary.getInstance().partecipaEvento();		
%>
	     <jsp:forward page="NewMap.jsp"/>
<%
	}
%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PROMUOVI EVENTO</title>
<link rel="stylesheet" href ="../css/promuoviEventoMap.css">
</head>
<body>
<form action = "promuoviEventoMap.jsp" name = "reg" method = "POST">
	<div class = "header">
		<h2>JUST THINK IT</h2>
	</div>
		<h4>Proponi un evento alla caritas</h4>
	<div class = "check">
	<h3>Vestiti<input type="checkbox" name="tipo" value="clothes"/>
			<input type="checkbox" name="tipo" value="food"/> Cibo</h3>
	</div>
	<div class = "nome">		
	<h3>Nome evento</h3>
	<input type="text" id = "NomeEvento"  name="NomeEvento" placeholder=""/>
	</div>
	<div class = "prezzo">		
	<h3>Prezzo evento</h3>
	<input type="text" id = "PrezzoEvento"  name="PrezzoEvento" placeholder=""/>
	</div>
	<div class = "note">		
	<h3>Note evento</h3>
	<textarea id = "NoteEvento"></textarea>
	</div>
	<div class = "conferma">
		<button type="submit" name ="CONFERMA" value = "CONFERMA">CONFERMA</button>
	</div>
	<div class = "ind">
		<a href= "">INDIETRO</a>
	</div>
	</form>
</body>
</html>