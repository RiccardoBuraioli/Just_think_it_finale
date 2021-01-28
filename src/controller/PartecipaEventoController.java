package controller;

import entity.PartecipaEvento;

import bean.PartecipaEventoBoundary;
import dao.EventoDao;
import javafx.event.ActionEvent;

public class PartecipaEventoController {

	private PartecipaEvento partecipaz;


	public boolean partecipaEvento(float importo) {
	
		partecipaz.setImport(importo);

		EventoDao partecipazione = new EventoDao();

		return partecipazione.creaPartecipazione(partecipaz);

	}

	public void setDataController(int idEv, int idVol) {
		
		partecipaz = new PartecipaEvento(idEv, idVol);

	}

}
