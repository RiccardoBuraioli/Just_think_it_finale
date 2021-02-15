<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="Profile_Boundary" scope="request" class="bean.Profile_Boundary"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="Profile_Boundary" property="*"/>

<%
Class.forName("com.mysql.jdbc.Driver");
	Profile_Boundary.initData(request.getParameter("Email"), request.getParameter("RecapitoTel"), request.getParameter("Indirizzo"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "profilo.jsp" name = "reg" method = "GET">
</form>

</body>
</html>