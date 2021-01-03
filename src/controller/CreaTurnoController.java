package controller;

import dao.PrenotaDao;
import entity.TurnoTab;

public class CreaTurnoController {


	private PrenotaDao turnodao;
	
	public CreaTurnoController() {
		turnodao = new PrenotaDao();
	}
	
	
	public boolean creaEvento(int codCar, String Giorno, String oraIni, String oraFin, int numPart, String newNote) {
		return turnodao.creaTurno(codCar, Giorno, newNote, oraIni, oraFin, numPart);
	}
}
