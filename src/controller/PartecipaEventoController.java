package controller;

import entity.PartecipaEvento;


import java.net.URL;
import java.util.ResourceBundle;
import bean.PartecipaEventoBoundary;
import dao.EventoDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class PartecipaEventoController {
	
	private PartecipaEvento partecipaz;
	private PartecipaEventoBoundary parteBoundary;
	
	
  
    
    public PartecipaEventoController() {
    	
    }
    
    
   
    public void indietro(ActionEvent event) {

    }
    

    public int partecipaEvento(float importo) {
    	
    	int error = 0;

    	partecipaz.setImport(importo);
    	
    	EventoDao partecipazione = new EventoDao();
    	partecipazione.CreaPartecipazione(partecipaz);
    	
    	
    	return error;

    }
    
    
    public void setDataController() {
    	parteBoundary = new PartecipaEventoBoundary();
    	partecipaz =  new PartecipaEvento(parteBoundary.getIdEvento(),parteBoundary.getIdUtente());

    	

   }

    
   
    
    
    
    
}
