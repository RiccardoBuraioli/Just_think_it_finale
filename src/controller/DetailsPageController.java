package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

public class DetailsPageController {
	
    
    public DetailsPageController() {
    	
    }
    
    
    
  
    public void backButtonDettagliPressed_c(Window window) {
    	
	    try {
			Parent root = FXMLLoader.load(getClass().getResource("/boundary/RegistrazioneMenu.fxml"));
			Stage signUp = (Stage) window.getScene().getWindow();
			Scene scene = new Scene(root,600,400);
			signUp.setScene(scene);
			signUp.show();
			signUp.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}

    }


}
