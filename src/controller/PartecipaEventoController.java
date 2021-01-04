package controller;

import entity.PartecipaEvento;

import bean.PartecipaEventoBoundary;
import dao.EventoDao;
import javafx.event.ActionEvent;


public class PartecipaEventoController {
	
	private PartecipaEvento partecipaz;


   
    public void indietro(ActionEvent event) {
    	//forse si forse no
    }
    

    public int partecipaEvento(float importo) {
    	
    	int error = 0;

    	partecipaz.setImport(importo);
    	
    	EventoDao partecipazione = new EventoDao();
    	partecipazione.creaPartecipazione(partecipaz);
    	
    	
    	return error;

    }
    
    
    public void setDataController() {
    	PartecipaEventoBoundary parteBoundary = new PartecipaEventoBoundary();
    	partecipaz =  new PartecipaEvento(parteBoundary.getIdEvento(),parteBoundary.getIdUtente());

    	

   }

    
   
    
    
    
    
}
