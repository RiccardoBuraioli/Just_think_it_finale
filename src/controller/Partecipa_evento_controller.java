package controller;

import entity.partecipa_evento;


import java.net.URL;
import java.util.ResourceBundle;
import bean.Partecipa_eventoBoundary;
import dao.EventoDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class Partecipa_evento_controller {
	
	private partecipa_evento partecipaz;
	private Partecipa_eventoBoundary parte_b;
	
	
  
    
    public Partecipa_evento_controller() {
    	
    }
    
    
   
    public void indietro(ActionEvent event) {

    }
    

    public int partecipa_evento(float importo) {
    	
    	int error = 0;

    	partecipaz.setImport(importo);
    	
    	EventoDao partecipazione = new EventoDao();
    	partecipazione.Crea_partecipazione(partecipaz);
    	
    	
    	return error;

    }
    
    
    public void setData_controller() {
    	parte_b = new Partecipa_eventoBoundary();
    	partecipaz =  new partecipa_evento(parte_b.getId_evento(),parte_b.getId_utente());

    	

   }

    
   
    
    
    
    
}
