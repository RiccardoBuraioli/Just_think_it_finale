<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PRENOTA TURNO</title>
<link rel="stylesheet" href ="../css/prenotaT.css">
</head>
<body>
	<h2 class = "logo">JUST THINK IT</h2>
	<div class = "title">
	<h4>Grazie al tuo sostegno moltissime persone te ne saranno<br/> grate e potranno essere aiutate!</h4>
	</div>
	<h4 class = "descr">*dopo aver inviato la richiesta verrà inoltrata una notifica se accettata</h4>
	<div class = "body">
	<h3 class = "turno">In quale turno ti vuoi prenotare?</h3>
	<select name="scelteGiorni" >
	<option value="Lunedì" selected="selected">Lunedì</option>
	<option value="Martedì">Martedì </option>
	<option value="Mercoledì">Mercoledì</option>
	<option value="Giovedì" selected="selected">Giovedì</option>
	<option value="Venerdì">Venerdì</option>
	<option value="Sabato">Sabato</option>
	<option value="Domenica">Domenica</option>
	</select>

	<h3 class = "orari">Orari disponibili</h3>
	<select name="scelteOrari" >
	<option value="" selected="selected">8:00</option>
	<option value="">11:00</option>
	<option value="">14:00</option>
	<option value="" selected="selected">17:00</option>
	<option value="">20:00</option>
	</select>
	</div>
	<div class = "text">
	<h3 class = "cv">Inserisci il tuo cv</h3>
	<textarea placeholder = "Sono Mario, ho 40 anni e nella vita ho fatto tanto volontariato."></textarea>
	</div>
    <a href ="">Indietro</a>
	<div class = "prenota">
	<button type="submit" name= "PRENOTA" value="PRENOTA">PRENOTA</button>
	</div>
	
</body>
</html>