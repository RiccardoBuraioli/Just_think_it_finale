package bean;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Partecipa_evento_controller;
import dao.EventoDao;
import entity.partecipa_evento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Partecipa_eventoBoundary {
	
		private int id_utente;
		private int id_evento;
		
		private Partecipa_evento_controller Parte_c;

		private TextField[] textFields;
		
		@FXML
	    private ResourceBundle resources;

	    @FXML
	    private TextField importo;

	    @FXML
	    private TextField cdc;

	    @FXML
	    private ImageView imgEvento;

	    @FXML
	    private Button partecipa;

	    @FXML
	    private Button indietro;

	    
	    
	    @FXML
	   void partecipa_evento(ActionEvent event) {
	    	Parte_c = new Partecipa_evento_controller();
	    	Parte_c.partecipa_evento(Float.parseFloat(importo.getText()));
	    	Stage st = (Stage) partecipa.getScene().getWindow();
	    	st.close();

	    }
	    
	    
	    
	    public int checker() {
	      	
	      	//Controlla che non ci siano campi lasciati vuoti
	      	for (int i = 0; i < textFields.length; i++) {
	  			if (textFields[i].getText().isEmpty()) {
	  				
	  				return -1;
	  			}
	  	
	  		}
	  		return 0;
	      	
	    }
	    
	    
		public void initialize(URL location, ResourceBundle resources) {
			
			
			textFields = new TextField[] {importo, cdc};
			
			
		}
		
		 
	    
	    public void setData(int id_evento, int id_volontario) {
	    	this.id_evento = id_evento;
	    	this.id_utente= id_volontario;
	   }



		public int getId_utente() {
			return id_utente;
		}



		public int getId_evento() {
			return id_evento;
		}

    

}
