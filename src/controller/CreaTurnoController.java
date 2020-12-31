package controller;

import dao.Prenota_dao;
import entity.TurnoTab;

public class CreaTurnoController {


	private Prenota_dao turnodao;
	
	public CreaTurnoController() {
		turnodao = new Prenota_dao();
	}
	
	
	public boolean creaEvento(int codCar, String Giorno, String oraIni, String oraFin, int numPart, String newNote) {
		return turnodao.creaTurno(codCar, Giorno, newNote, oraIni, oraFin, numPart);
	}
}
