package controller;

import java.util.List;

import dao.PrenotaDao;
import entity.TurnoTab;

public class GestioneTurniCaritas {
	
	private PrenotaDao turniDao;

	
	public GestioneTurniCaritas() {
		this.turniDao = new PrenotaDao();
	}
	
	
	
	
	
	public boolean modificaTurno(int idTurn, String newNote, int codCar) {
		
		return this.turniDao.modificaTurno(idTurn, newNote, codCar);
		
	}
	
	
	
	public boolean cancellaTurno(int idTurn) {
		
		return this.turniDao.cancellaTurno(idTurn);
		
	}
	
	
	
	public List<TurnoTab> caricaTurni(int idCaritas) {

		List<TurnoTab> list = this.turniDao.visualizzaTurni(idCaritas);
		
		
		return list;
	}

}
