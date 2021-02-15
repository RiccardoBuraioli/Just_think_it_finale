<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="EmailBoundary" scope="application" class="bean2.EmailBoundary"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="EmailBoundary" property="*"/>

<%
Class.forName("com.mysql.jdbc.Driver");
	if(request.getParameter("INVIA")!=null){
		//if(EmailBoundary.send_message(request.getParameter("codice_mittente"),request.getParameter("codice_destinatario"), request.getParameter("messaggio"), request.getParameter("oggetto")) == 0){
			
%>
	<jsp:forward page="homeCaritas.jsp"/>
<%			
		//}

	}
%>
		
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CONTATTA CARITAS</title>
<link rel="stylesheet" href ="../css/contattaCaritas.css">
</head>
<body>
	<form action = "contattaCaritas.jsp" name = "reg" method = "POST">
	<div class = "center">
		<div class = "content">
			<div class = "header">
				<h2>JUST THINK IT</h2>
			</div>
			<h4>Contattaci ti risponderemo appena possibile!</h4>
			<div class = "pt1">
			<input type="text" id = "codice_mittente" name= "codice_mittente" placeholder="Mittente"/>
			</div>
			<div class = "pt2">
			<input type="text" id ="codice_destinatario" name="codice_destinatario" placeholder="Destinatario"/>
			</div>
			<div class = "pt3">
			<input type="text" id = "oggetto" name= "oggetto" placeholder="Oggetto"/>
			</div>
			<div class = "pt4">
			<input type = "text" id = "messaggio" placeholder="Scrivi qui il tuo messaggio"/>
			</div>
			<div class = "invia">
			<button type="submit" name= "INVIA" value="INVIA">INVIA</button>
			</div>
			<div class = "ind">
			<a href= "">INDIETRO</a>
			</div>
		</div>
	</div>
	</form>
</body>
</html>