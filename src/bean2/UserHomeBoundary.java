package bean2;

import java.io.IOException;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.ProfileController;
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

private int userId;
	
	private UserHomeController userController ;

	
	//Images slideshow
	private Image img1 ;
	private Image img2;
	private Image img3;
	private Image[] images = {img1, img2, img3};
	private int currentImage;
	
	public int getCurrentUser() {
		return  this.userId;
	}

	public void setCurrentUser(int id) {
		this.userId = id;
	}
	
	public static UserHomeBoundary getInstance() {
		if (instance == null) {
			instance = new UserHomeBoundary();
			}
		return instance;
	}
	
	
	public UserHomeBoundary() {
		 userController = new UserHomeController();
	
	}
   

    
 
    public void deleteAccountButtonPressed() {
    		//lo faremo presto
    	this.userController.deleteAccount(userId);
    }

   
 /*  public  void profileButtonPressed() {
    	ProfileBoundary profileBean;
    	ProfileController profileController = new ProfileController();
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/UserProfilePage.fxml"));
			Parent root = loader.load();
			profileBean = loader.getController();
			profileController.initData(userId, profileBean);
			
			Stage home = (Stage) this.profileButton.getScene().getWindow();
			home.setScene(new Scene(root, 800, 600));
			
			home.show();
		} catch (IOException e) {
			logger.error(s);
		}
    }*/

    
    void helpButtonPressed() {
    	this.userController.helpButtonPressed();
    }

 

   
   /*public void logoutButtonPressed() {    	
    	TransizionePagine pageSwitch = new TransizionePagine();
    	pageSwitch.logout(logoutButton.getScene().getWindow());

	}*/

  

  /*  @FXML
    void searchCaritasButtonPressed(ActionEvent event) throws NumberFormatException, SQLException {
    	
    	TransizionePagine switchPage = new TransizionePagine();
    	switchPage.apriMappa(this.userId, searchCaritasButton.getScene().getWindow());

   
    }*/
 

	public void initData(String nome, String cognome, int id) {
    	//this.nomeCognome.setText(nome + " "+ cognome);
        this.userId = id;
  
    }
    
    

}





