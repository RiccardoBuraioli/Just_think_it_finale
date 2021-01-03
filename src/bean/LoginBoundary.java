package bean;

import java.io.IOException;
import java.io.Serializable;

import controller.LoginController;
import entity.CaritasUser;
import entity.ShopUser;
import entity.VolunteerUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginBoundary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginController loginC = new LoginController();
	private Object loggedUser;
	private UserHomeBoundary UserHomeBoundary;
	private ShopHomeBoundary ShopHomeBoundary;
	private static LoginBoundary instance = null;
	private CaritasHomeBoundary CaritasHomeBoundary;
	
	public static LoginBoundary getInstance() {
		if(instance == null) {
			instance = new LoginBoundary();
			
		}
		return instance;
	}
	
	
	@FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;
    
    @FXML
    void loginPressed(ActionEvent event) {
    
    loggedUser=	loginC.LoginAccess(usernameField.getText(), passwordField.getText());
   	if(loggedUser.getClass()==VolunteerUser.class) {
   		
   		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/UserHomePage.fxml"));
			Parent root = loader.load();
			UserHomeBoundary = UserHomeBoundary.getInstance();
			UserHomeBoundary = loader.getController();
			UserHomeBoundary.initData((VolunteerUser)loggedUser);
			Stage home = (Stage) loginButton.getScene().getWindow();
			home.setScene(new Scene(root, 800, 600));
			
			home.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
   	}else if(loggedUser.getClass()==CaritasUser.class) {
   		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/CaritasHomePage.fxml"));
			Parent root = loader.load();
			CaritasHomeBoundary = CaritasHomeBoundary.getInstance();
			CaritasHomeBoundary = loader.getController();
			CaritasHomeBoundary.initData((CaritasUser)loggedUser);
			Stage home = (Stage) loginButton.getScene().getWindow();
			home.setScene(new Scene(root, 800, 600));
			
			home.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
   	}else if(loggedUser.getClass()==ShopUser.class) {
   		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/ShopHomePage.fxml"));
			Parent root = loader.load();
			ShopHomeBoundary = ShopHomeBoundary.getInstance(); 
			ShopHomeBoundary = loader.getController();
			ShopHomeBoundary.initData((ShopUser)loggedUser);
			Stage home = (Stage) loginButton.getScene().getWindow();
			home.setScene(new Scene(root, 800, 600));
			
			home.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
   	}
    	
    	
    }
    
    @FXML
    void registrazionePressed(ActionEvent event) {
    	
     	try {
			Parent root = FXMLLoader.load(getClass().getResource("/boundary/RegistrazioneMenu.fxml"));
			Stage signUp = (Stage) registerButton.getScene().getWindow();
			Scene scene = new Scene(root,600,400);
			signUp.setScene(scene);
			signUp.show();
			signUp.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
	

}
