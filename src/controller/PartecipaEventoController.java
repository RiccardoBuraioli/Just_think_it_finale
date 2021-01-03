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
	private PartecipaEventoBoundary parte_b;
	
	
  
    
    public PartecipaEventoController() {
    	
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
    	parte_b = new PartecipaEventoBoundary();
    	partecipaz =  new PartecipaEvento(parte_b.getId_evento(),parte_b.getId_utente());

    	

   }

    
   
    
    
    
    
}
