package controller;

import java.util.List;

import dao.PrenotaDao;
import entity.TurnoTab;

public class GestioneTurniCaritas {
	
	private PrenotaDao turni_dao;
	private List<TurnoTab> list;
	
	public GestioneTurniCaritas() {
		this.turni_dao = new PrenotaDao();
	}
	
	
	
	
	
	public boolean modificaTurno(int idTurn, String newNote, int codCar) {
		
		return this.turni_dao.modificaTurno(idTurn, newNote, codCar);
		
	}
	
	
	
	public boolean cancella_turno(int idTurn) {
		
		return this.turni_dao.cancellaTurno(idTurn);
		
	}
	
	
	
	public List<TurnoTab> carica_turni(int idCaritas) {

		this.list = this.turni_dao.visualizzaTurni(idCaritas);
		
		
		return this.list;
	}

}
