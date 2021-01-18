package bean;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.VolunteerUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ProfileBoundary{
	private static Logger logger = LoggerFactory.getLogger(ProfileBoundary.class.getName());

	
	private VolunteerUser currentUser;
	
	@FXML
    private ImageView profileImageEdit;

    @FXML
    private Button backHomeButton;

    @FXML
    private Button editButton;

    @FXML
    private ImageView donazioniImage;

    @FXML
    private ImageView eventiImage;

    @FXML
    private Text nomeCognomeEdit;

    @FXML
    private Text emailEdit;

    @FXML
    private Text cittaEdit;

    @FXML
    private Text telefonoEdit;
    

@FXML  
 void backHomeButtonPressed(ActionEvent event) {
	 try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/UserHomePage.fxml"));
			Parent root = loader.load();
			UserHomeBoundary userHomeBoundary;
			userHomeBoundary = loader.getController();
			userHomeBoundary.initData(getCurrentUser());
			Stage home = (Stage) this.backHomeButton.getScene().getWindow();
			home.setScene(new Scene(root, 800, 600));
			
			home.show();
		} catch (IOException e) {
			logger.error("errore IoException");
		}


    }

 @FXML
 void editButtonPressed(ActionEvent event) {
	 //perche si
 }

 public VolunteerUser getCurrentUser() {
		return this.currentUser;
	}

	public void setCurrentUser(VolunteerUser currentUser) {
		this.currentUser = currentUser;
	}
 
 public void initData(VolunteerUser user) {
 	setCurrentUser(user);
 	this.cittaEdit.setText(user.getIndirizzo());
 	this.telefonoEdit.setText(user.getRecapitoTel());
 	this.nomeCognomeEdit.setText(user.getNome() + " " + user.getCognome());
 }



 
}
