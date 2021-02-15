package bean2;

import java.io.IOException;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.UserHomeController;
import dao.VolunteerRepository;
import entity.User;
import entity.VolunteerUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class UserHomeBoundary{
/**
	 * 
	 */
private static Logger logger = LoggerFactory.getLogger(UserHomeBoundary.class.getName());
private String s = "error IoException";

private static UserHomeBoundary instance = null;

private VolunteerUser currentUser;
	
	private UserHomeController userController ;

	

	
	public User getCurrentUser() {
		return  this.currentUser;
	}

	public void setCurrentUser(VolunteerUser id) {
		this.currentUser = id;
	}
	
	public static UserHomeBoundary getInstance() {
		if (instance == null) {
			instance = new UserHomeBoundary();
			}
		return instance;
	}
	
	
	public UserHomeBoundary() {
		//img1 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/DragoForestain.PNG");
		
		// currentImage = 0;
		 userController = new UserHomeController();
	
	}
	
    

   public  void deleteAccountButtonPressed() {
    		//lo faremo presto
    	this.userController.deleteAccount(currentUser.getId());
    }

  
    

 
    public void helpButtonPressed() {
    	this.userController.helpButtonPressed();
    }

 

   

  

  /*  @FXML
    void searchCaritasButtonPressed(ActionEvent event) throws NumberFormatException, SQLException {
    	
    	TransizionePagine switchPage = new TransizionePagine();
    	switchPage.apriMappa(this.currentUser, searchCaritasButton.getScene().getWindow());
    }*/
 

	public void initData(User user) {
    	VolunteerUser vol;
    	VolunteerRepository volunteer = new VolunteerRepository();
    	vol =volunteer.getVolunteerByID(user.getId());
    	this.setCurrentUser(vol);
  
    	
    	
    	this.userController.setCurrentUser(user);
    }
    
    

}


