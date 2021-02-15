package bean2;

import java.io.IOException;

import controller.CreaTurnoController;
import entity.CaritasUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreaTurnoBoundary {

	private String note;
	private String oraInizio;
	private String oraFine;
	private String nome_giorno;
	private String numMaxParte;

	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public String getOraInizio() {
		return oraInizio;
	}


	public void setOraInizio(String oraInizio) {
		this.oraInizio = oraInizio;
	}


	public String getOraFine() {
		return oraFine;
	}


	public void setOraFine(String oraFine) {
		this.oraFine = oraFine;
	}


	public String getNome_giorno() {
		return nome_giorno;
	}


	public void setNome_giorno(String nome_giorno) {
		this.nome_giorno = nome_giorno;
	}


	public String getNumMaxParte() {
		return numMaxParte;
	}


	public void setNumMaxParte(String numMaxParte) {
		this.numMaxParte = numMaxParte;
	}

	private CaritasUser caritas;

	

	
	public boolean creaTurnoPressed(String nome_giorno, String oraInizio, String oraFine, String  numMaxParte, String note) {
		if (nome_giorno == null || nome_giorno == "" || oraInizio == null || oraInizio == "" || oraFine == "" || oraFine == null || numMaxParte == "" || numMaxParte == null || note == null || note == "") {
			return false;
		}else {			
			CreaTurnoController creaTurno = new CreaTurnoController();
			creaTurno.creaEvento(caritas.getID(), nome_giorno,oraInizio, oraFine,Integer.parseInt( numMaxParte), note);
		return true;
		}
	}


	public void setCaritas(CaritasUser caritas) {
		this.caritas = caritas;
	}

}
