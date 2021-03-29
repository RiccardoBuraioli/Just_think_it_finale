<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="RegistrationShopBoundary" scope="request" class="beanWeb.RegistrationShopBoundary"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="RegistrationShopManagerBoundary" property="*"/>


<%
Class.forName("com.mysql.jdbc.Driver");
 		if(request.getParameter("COMPLETA REGISTRAZIONE")!=null){
 			String i = request.getParameter("Password");
 			String ii = request.getParameter("confermaPassword");
 			if (ii.equalsIgnoreCase(i)){
 			//	if(request.getParameter("NomeNegozio") != null && request.getParameter("NomeNegozio") != "" && request.getParameter("IndirizzoNeg") != null && request.getParameter("IndirizzoNeg") != "" && request.getParameter("RecapitoTel") != null && request.getParameter("RecapitoTel") != "" && request.getParameter("Email") != null && request.getParameter("Email") != "" && request.getParameter("Città") != null && request.getParameter("Città") != "" &&  request.getParameter("nCivico") != null &&   request.getParameter("nCivico") != "" && request.getParameter("Via") != null &&  request.getParameter("Via") == null){
 				if ("clothes".equals(request.getParameter("Tipologia"))) {
 					String x = "Vestiti";
 					if ((RegistrationShopBoundary.registraNegozioPressed(x,request.getParameter("NomeNegozio"),request.getParameter("Password"),request.getParameter("IndirizzoNeg")+" "+ request.getParameter("Via")+ " "+ request.getParameter("nCivico"),request.getParameter("RecapitoTel"),request.getParameter("Email"),request.getParameter("Città")) == true )){ 			
%>
		<jsp:forward page="homeVolontario.jsp"/>
<%	
			}}
 			else if ("food".equals(request.getParameter("Tipologia"))){
 					String x = "Cibo";
	 				if ((RegistrationShopBoundary.registraNegozioPressed(x,request.getParameter("NomeNegozio"),request.getParameter("Password"),request.getParameter("IndirizzoNeg")+ request.getParameter("Via")+ " "+ request.getParameter("nCivico"),request.getParameter("RecapitoTel"),request.getParameter("Email"),request.getParameter("Città")) == true )){
 			
%>
 			<jsp:forward page="homeVolontario.jsp"/>
<% 			
	 				 }//}
	 				}
 				}
 			}
 		
 	
 	
 	 %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTRAZIONE NEGOZIO</title>
<link rel="icon" sizes="64x64" href="../img/favicon.png">
<link rel="stylesheet" href =" ../css/registrazioneShop.css">
</head>
<body>
    <a href ="registrazione.jsp"> Indietro </a>
		<div class = "titolo"><h2>Registrazione Negozio</h2></div>
	<form action = "registrazioneShop.jsp" name = "reg" method = "POST">
    <div class="Negozio">
  				<h3>Nome Negozio</h3>
        <input type="text" id = "NomeNegozio" name= "NomeNegozio" placeholder="es. Mario"/>
        	<h3>Password</h3>
        <input type="password" id= "Password" name= "Password"/>
        	<h3>Conferma Password</h3>
        <input type="password" id= "confermaPassword" name= "confermaPassword"/>
	</div>
	<div class= "citta">			
				<h3>Provincia</h3>
        <input type="text" id = "Città" name= "Città"   placeholder="es. Roma">
				<h3>Comune di Residenza</h3>
        <input type="text" id ="IndirizzoNeg" name= "IndirizzoNeg"  placeholder="es. Mario"/>
	<h3>Via&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspN civico</h3>
      <div class = "via"> <input type="text" id = "Via" name= "Via" placeholder="es. Luigi settembrini" /></div> 
      <div class = "n"><input type="text" id = "nCivico" name= "Indirizzo" placeholder="es.54"/></div>
     </div>
     <div class = "fine">
			 	 <h3>Telefono</h3>
        <input type="text" id= "RecapitoTel" name= "RecapitoTel" placeholder="es.34324234"/>
        <h3>Email</h3>
        <input type="text" id = "Email"  name="Email" placeholder="es.mariorossi@gmail.com"/>
         <br/><br/><h3>clothes<input type="checkbox" name="Tipologia" value="clothes"/>
			 <input type="checkbox" name="Tipologia" value="food"/> food </h3>
      </div>
      <div class = "box">
		<br/><h3><button type="submit" name= "COMPLETA REGISTRAZIONE" value="COMPLETA REGISTRAZIONE">COMPLETA REGISTRAZIONE</button></h3>
		</div>
	</form>
</body>
</html>