<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="BachecaPersonaleBoundary" scope="application" class="bean2.BachecaPersonaleBoundary"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="BachecaPersonaleBoundary" property="*"/>

<%
Class.forName("com.mysql.jdbc.Driver");
		if(request.getParameter("CONFERMA") != null){
			if (BachecaPersonaleBoundary.eliminaNecessita(request.getParameter("id_necessitÓ")) == true){
%>
		<jsp:forward page="bachecaNecc.jsp"/>	
<%
		}
		}
%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ELIMINA NECESSITA'</title>
<link rel="stylesheet" href ="../css/elimina.css">
</head>
<body>
<form action = "eliminaNecessitÓ.jsp" name = "reg" method = "POST">
	<h1>Inserisci l'ID della necessitÓ che vorresti eliminare</h1>
	<p>(vedere nella tabella della pagina precedente)</p>
	<input type="text" id = "id_necessitÓ" name= "id_necessitÓ"   placeholder="4">
	<div class ="CONFERMA">
	<button type="submit" name= "CONFERMA" value="CONFERMA">CONFERMA</button>
	</div>
</form>
	<div class = "INDIETRO">
	<a href = "bachecaNecc.jsp"><button type = "submit" name = "indietro" value = "indietro">INDIETRO</button></a>
	</div>
</body>
</html>