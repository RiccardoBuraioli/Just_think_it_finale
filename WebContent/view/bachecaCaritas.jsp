<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BACHECA CARITAS</title>
<link rel="stylesheet" href ="../css/bachecaCaritasMap.css">
</head>
<body>
	<div class = "header">
		<h2>JUST THINK IT</h2>
	</div>
		<h4>Benvenuti nella bacheca Caritas</h4>
	<div class="mytabs">
    <input type="radio" id="tabfree" name="mytabs" checked="checked">
    <label for="tabfree">VESTITI</label>
    <div class="tab">
      <h2>Vestiti</h2>
     
    </div>

    <input type="radio" id="tabsilver" name="mytabs">
    <label for="tabsilver">CIBO</label>
    <div class="tab">
      <h2>Cibo</h2>
    </div>

    <input type="radio" id="tabgold" name="mytabs">
    <label for="tabgold">VARIE</label>
    <div class="tab">
      <h2>Varie</h2>
      </div>
  </div>

	<div class = "contatta">
	<a href = contattaCaritas.jsp><button type="submit">CONTATTA CARITAS</button></a>
	</div>
	<div class = "donazione">
	<a href = creaDonazione.jsp><button type="submit">CREA DONAZIONE</button></a>
	</div>
			<div class = "ind">
			<a href= "">INDIETRO</a>
			</div>
	
</body>
</html>