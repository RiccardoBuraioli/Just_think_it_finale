package controller;

import entity.PartecipaEvento;

import bean.PartecipaEventoBoundary;
import dao.EventoDao;
import javafx.event.ActionEvent;

public class PartecipaEventoController {

	private PartecipaEvento partecipaz;

	public void indietro(ActionEvent event) {
		// forse si forse no
	}

	public boolean partecipaEvento(float importo) {

		int error = 0;

		partecipaz.setImport(importo);

		EventoDao partecipazione = new EventoDao();

		return partecipazione.creaPartecipazione(partecipaz);

	}

	public void setDataController() {
		PartecipaEventoBoundary parteBoundary = new PartecipaEventoBoundary();
		partecipaz = new PartecipaEvento(parteBoundary.getIdEvento(), parteBoundary.getIdUtente());

	}

}
