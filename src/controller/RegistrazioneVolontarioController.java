package controller;

import java.io.IOException;
import dao.VolunteerRepository;
import entity.VolunteerUser;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;


public class RegistrazioneVolontarioController {


   public VolunteerUser completaButtonPressed( String nome, String cognome, String passwordVolontario, String via, String telefono, String email, String date2, String cittadiResidenza) {

    		
        	VolunteerUser newUser = new VolunteerUser(nome, cognome, passwordVolontario, via, telefono, email, null,date2,cittadiResidenza );
        	VolunteerRepository vrep = new VolunteerRepository();
        	int id = vrep.insertVolunteer(newUser);
        	newUser.setID(id);
        	
        	return newUser;
        	//Manda alla home dopo la registrazione
        	
    	

    }





    
   

}