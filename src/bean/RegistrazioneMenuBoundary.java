package bean;

import java.io.IOException;

import controller.RegistrazioneMenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RegistrazioneMenuBoundary {
	
	
	private RegistrazioneMenuController reg;

    @FXML
    private Button caritasButton;

    @FXML
    private Button volontarioButton;

    @FXML
    private Button negozioButton;

    @FXML
    private Button backButton;

    @FXML
    private Button dettagliCaritas;

    @FXML
    private Button dettagliVolontario;

    @FXML
    private Button dettagliNegozio;

    @FXML
    void backButtonPressed(ActionEvent event) {
    	
	    try {
			Parent root = FXMLLoader.load(getClass().getResource("../boundary/Login_boundary.fxml"));
			Stage signUp = (Stage) backButton.getScene().getWindow();
			Scene scene = new Scene(root,600,380);
			signUp.setScene(scene);
			signUp.show();
			signUp.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void caritasButtonPressed(ActionEvent event) {
    	
	    try {
			Parent root = FXMLLoader.load(getClass().getResource("/boundary/RegistrazioneCaritas.fxml"));
			Stage signUp = (Stage) caritasButton.getScene().getWindow();
			Scene scene = new Scene(root,600,450);
			signUp.setScene(scene);
			signUp.show();
			signUp.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
			}
    	
	    }

    @FXML
    void dettagliCaritasPressed(ActionEvent event) {
    	   try {
   			Parent root = FXMLLoader.load(getClass().getResource("/buondary/Details.fxml"));
   			Stage signUp = (Stage) caritasButton.getScene().getWindow();
   			Scene scene = new Scene(root,600,400);
   			signUp.setScene(scene);
   			signUp.show();
   			signUp.setResizable(false);
   			} catch (IOException e) {
   				e.printStackTrace();
   				}     
    	}

    @FXML
    void dettagliNegozioPressed(ActionEvent event) {
        try {
    			Parent root = FXMLLoader.load(getClass().getResource("/boundary/Details.fxml"));
    			Stage signUp = (Stage) dettagliNegozio.getScene().getWindow();
    			Scene scene = new Scene(root,600,400);
    			signUp.setScene(scene);
    			signUp.show();
    			signUp.setResizable(false);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    }

    @FXML
    void dettagliVolontarioPressed(ActionEvent event) {
    	  try {
  			Parent root = FXMLLoader.load(getClass().getResource("/boundary/Details.fxml"));
  			Stage signUp = (Stage) dettagliVolontario.getScene().getWindow();
  			Scene scene = new Scene(root,600,400);
  			signUp.setScene(scene);
  			signUp.show();
  			signUp.setResizable(false);
  		} catch (IOException e) {
  			e.printStackTrace();
  		}

      
    }

    @FXML
    void negozioButtonPressed(ActionEvent event) {
    	  try {
  			Parent root = FXMLLoader.load(getClass().getResource("/boundary/RegistrazioneShopManager.fxml"));
  			Stage signUp = (Stage) negozioButton.getScene().getWindow();
  			Scene scene = new Scene(root,600,450);
  			signUp.setScene(scene);
  			signUp.show();
  			signUp.setResizable(false);
  		} catch (IOException e) {
  			e.printStackTrace();
  		}
    }

    @FXML
    void volontarioButtonPressed(ActionEvent event) {
    	 try {
 			Parent root = FXMLLoader.load(getClass().getResource("/boundary/RegistrazioneVolontario.fxml"));
 			Stage signUp = (Stage) volontarioButton.getScene().getWindow();
 			Scene scene = new Scene(root,600,450);
 			signUp.setScene(scene);
 			signUp.show();
 			signUp.setResizable(false);
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
    }
    
    public RegistrazioneMenuBoundary() {
    	 reg = new RegistrazioneMenuController();
    }
    

}
