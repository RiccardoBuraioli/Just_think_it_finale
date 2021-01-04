package controller;

import java.util.List;
import dao.PrenotaDao;
import entity.Orario;
import entity.Turno;
import entity.PartecipaTurno;
import javafx.event.ActionEvent;


public class PrenotaTurnoController {

	private int idUtente;

	private int idCaritas;

	private PrenotaDao checkTurniPossibili;

	
	public void indietro(ActionEvent event) {
		//forse anche questo
	}


	public boolean prenotaTurno(String giorno, String oraIn, String oraFin, String cv) {
		boolean error;

		int idTurno = 0;

		Turno turno = new Turno(giorno ,oraIn, oraFin);

		idTurno = checkTurniPossibili.trovaTurno(turno);

		PartecipaTurno partecipazione = new PartecipaTurno(idUtente, idTurno, idCaritas, cv);

		error = checkTurniPossibili.partecipazioneTurno(partecipazione);

		return error;

	}
	
	

	public void setDataController(int idCar, int idUte) {
		this.idCaritas = idCar;
		this.idUtente = idUte;
	}

	public String[] inizializzaGiorni() {
		String[] giorni = new String[8];

		checkTurniPossibili = new PrenotaDao();
		giorni = checkTurniPossibili.visualizzaGiorni();
		return giorni;
	}

	
	public  List<Orario> initializzaOrari() {
		
		List<Orario> oraArrayList = checkTurniPossibili.visualizzaOrario();
		
		return oraArrayList;

	}
}
