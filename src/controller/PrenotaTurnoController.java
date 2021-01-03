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

	private int id_utente;

	private int id_caritas;

	private String[] giorni;

	private Turno turno;

	private PrenotaDao check_turni_possibili;

	private PartecipaTurno partecipazione;

	private List<Orario> oraArrayList;

	
	public void indietro(ActionEvent event) {

	}

	public PrenotaTurnoController() {

	}

	public boolean prenota_turno(String giorno, String ora_in, String ora_fin, String cv) {
		boolean error;

		int id_turno = 0;

		turno = new Turno(giorno ,ora_in, ora_fin);

		id_turno = check_turni_possibili.trova_turno(turno);

		partecipazione = new PartecipaTurno(id_utente, id_turno, id_caritas, cv);

		error = check_turni_possibili.partecipazione_turno(partecipazione);

		return error;

	}
	
	

	public void setData_controller(int id_car, int id_ute) {
		this.id_caritas = id_car;
		this.id_utente = id_ute;
	}

	public String[] inizializza_giorni() {
		this.giorni = new String[8];

		check_turni_possibili = new PrenotaDao();
		giorni = check_turni_possibili.visualizza_giorni();
		return giorni;
	}

	
	public  List<Orario> initializza_orari() {
		
		oraArrayList = check_turni_possibili.visualizza_orario2();
		
		return oraArrayList;
		// ora = (Orario[]) oraArrayList.toArray();

	}
}
