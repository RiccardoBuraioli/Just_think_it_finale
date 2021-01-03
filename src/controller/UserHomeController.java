package controller;

import java.io.IOException;
import com.sothawo.mapjfx.Projection;

import bean.ProfileBoundary;
//import com.sothawo.mapjfxdemo.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import entity.VolunteerUser;


public  class UserHomeController{
	
	
	
	private VolunteerUser currentUser;
	
	
	private int idUtente;
	

	
	public VolunteerUser getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(VolunteerUser currentUser) {
		this.currentUser = currentUser;
	}
	
	
	
	public UserHomeController() {
		
	}
	
	
    public void deleteAccountButtonPressed(Window event) {

    }

   
   public void profileButtonPressed(Window event) {
    	
    

    }

    
   public void helpButtonPressed(Window event) {

    }

 
    
    public void logoutButtonPressed(Window event) {
    	
    

	}


  
    public void searchCaritasButtonPressed(Window event) {
    	
   
   
    }
 


    public void creadonazione(Window event) {
    	

    
    }
    


	public void setIdUtente(int id_utente) {
		this.idUtente = id_utente;
		
	}

}
