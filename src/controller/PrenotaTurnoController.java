package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dao.EventoDao;
import dao.PrenotaDao;
import entity.Orario;
import entity.Turno;
import entity.PartecipaTurno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class PrenotaTurnoController {

	private int idUtente;

	private int idCaritas;

	private String[] giorni;

	private Turno turno;

	private PrenotaDao checkTurniPossibili;

	private PartecipaTurno partecipazione;

	private List<Orario> oraArrayList;

	
	public void indietro(ActionEvent event) {

	}

	public PrenotaTurnoController() {

	}

	public boolean prenotaTurno(String giorno, String oraIn, String oraFin, String cv) {
		boolean error;

		int idTurno = 0;

		turno = new Turno(giorno ,oraIn, oraFin);

		idTurno = checkTurniPossibili.trovaTurno(turno);

		partecipazione = new PartecipaTurno(idUtente, idTurno, idCaritas, cv);

		error = checkTurniPossibili.partecipazioneTurno(partecipazione);

		return error;

	}
	
	

	public void setDataController(int idCar, int idUte) {
		this.idCaritas = idCar;
		this.idUtente = idUte;
	}

	public String[] inizializzaGiorni() {
		this.giorni = new String[8];

		checkTurniPossibili = new PrenotaDao();
		giorni = checkTurniPossibili.visualizzaGiorni();
		return giorni;
	}

	
	public  List<Orario> initializzaOrari() {
		
		oraArrayList = checkTurniPossibili.visualizzaOrario();
		
		return oraArrayList;
		// ora = (Orario[]) oraArrayList.toArray();

	}
}
