package controller;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ShopMenuController {
	Stage primary;
	

   public void cercaCaritas() {
    	RicercaCaritasNegozioController rcnc = new RicercaCaritasNegozioController();
    	rcnc.showStage();
    }

 
    public void gestEventi() {
    	
    	try {
    		 FXMLLoader loader = new FXMLLoader(getClass().getResource("../boundary/Gestisci_eventi.fxml"));

                // Set this class as the controller
          

                // Load the scene
                primary.setScene(new Scene(loader.load()));

                // Setup the window/stage
                primary.setTitle("Shop Menù");

            } catch (IOException e) {
                e.printStackTrace();
            }
    	
    }

  
   public void indietro() {
	   //altro back
	   
    }

   
   public void modInfo() {
	   //vedremo
    }

	
public ShopMenuController() {
	primary = new Stage();
	
	try {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("../boundary/ShopMenuBoundary.fxml"));

            // Set this class as the controller
      

            // Load the scene
            primary.setScene(new Scene(loader.load()));

            // Setup the window/stage
            primary.setTitle("Shop Menù");

        } catch (IOException e) {
            e.printStackTrace();
        }
	
	
		
}
public void showStage() {
	primary.showAndWait();
}



}
