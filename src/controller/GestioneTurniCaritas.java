package controller;

import java.util.List;

import dao.Prenota_dao;
import entity.TurnoTab;

public class GestioneTurniCaritas {
	
	private Prenota_dao turni_dao;
	private List<TurnoTab> list;
	
	public GestioneTurniCaritas() {
		this.turni_dao = new Prenota_dao();
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
