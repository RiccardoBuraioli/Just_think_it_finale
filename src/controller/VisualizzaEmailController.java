package controller;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dao.EmailDao;
import entity.EmailEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class VisualizzaEmailController {

		private String email_utente;
		private EmailDao email_dao;
		private List<EmailEntity> email_e;
	
	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TextArea mess;

	    @FXML
	    private Button indietro;

	    @FXML
	    private ChoiceBox<Integer> email_m;

	    @FXML
	    private Button rispondi;

	    @FXML
	    void crea_email(ActionEvent event) {

	    }

	    @FXML
	    void indietro(ActionEvent event) {

	    }
	    
	    public VisualizzaEmailController() {
	    	
	    }
	    

	    @FXML
	    void drag_detected(MouseEvent event) {
	    	
	    	int i =email_m.getValue();
	    	mess.setText(email_e.get(i).getMessaggio());
	    	

	    }
	    
	    

	    @FXML
	    void initialize() {
	    	
	    	int i = 0;
	    	email_e = email_dao.visualizzaEmail(email_utente);
	    	
	    	while( i < email_e.size()) {
	    	
	    	email_m.getItems().add(email_e.get(i).getIdEmail());
	    	i++;
	    	}
	    	
	    	
	    	
	    	

	    
	}


}