package bean;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.io.IOException;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.CercaCaritas;
import entity.CaritasUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.Image;

import javafx.scene.shape.Circle;

import javafx.stage.Stage;

public class CaritasHomeBoundary {

	private Image img1 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/DragoForestain.PNG");
	private Image img2 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/PelleDrago.PNG");
	private Image img3 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/DragoForestaIniz.PNG");
	private Image[] images = { img1, img2, img3 };
	private int currentImage = 0;
	private  static CaritasHomeBoundary instance = null;
	private static Logger logger = LoggerFactory.getLogger(CaritasHomeBoundary.class.getName());
	private String s = "errore IoException";

	private CaritasUser currentUser;
	private GestisciTurniBoundary gestTurn;
	private GestisciDonazioniBoundary gestDon;

	private BachecaPersonaleBoundary bacheca;
	@FXML
    private Button profileButton;

    @FXML
    private Button helpButton;

    @FXML
    private Button deleteAccountButton;

    @FXML
    private ImageView imagePresentation;

    @FXML
    private Button vBacheca;

    @FXML
    private Font x1;

    @FXML
    private Button eventiC;

    @FXML
    private Button turni;

    @FXML
    private Text textOverImages;

    @FXML
    private Button logoutButton;

    @FXML
    private ImageView arrowRight;

    @FXML
    private ImageView arrowLeft;

    @FXML
    private Text nomeCognome;

    @FXML
    private Button leftArrowButton;

    @FXML
    private Button rightArrowButton;

    @FXML
    private ImageView profileImage;

    @FXML
    private Button gestisciDona;

	
	
	public static CaritasHomeBoundary getInstance() {
		if (instance == null) {
			instance = new CaritasHomeBoundary();
			}
		return instance;
	}
	
	

	public CaritasHomeBoundary() {
		bacheca = new BachecaPersonaleBoundary();
		gestTurn = new GestisciTurniBoundary();
		gestDon = new GestisciDonazioniBoundary();
	}

	@FXML
	void gestisciDonazioni(ActionEvent event) {

		try {


	        FXMLLoader fxmlLoader = new FXMLLoader();
	        Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("../boundary/Gestisci_Donazioni.fxml"));       
	        gestDon = fxmlLoader.getController();
	        Stage stage = (Stage) eventiC.getScene().getWindow();
    		stage.setTitle("Gestisci Eventi");	
    		gestDon.setCaritas(this.currentUser);
    		gestDon.loadFormBoundary();  		
    		stage.setScene(new Scene(rootNode, 800, 500));
    		stage.setResizable(false);
    		stage.show();
    		
    				} catch (IOException e) {
    					logger.error(s); }
	}

	@FXML
	void gestisciEventi(ActionEvent event) {
		// handle the event here
		
		try {


	        FXMLLoader fxmlLoader = new FXMLLoader();
	        Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("../boundary/Gestisci_eventi_caritas.fxml"));       
	        GestisciEventiCaritasBoundary gestisciB = fxmlLoader.getController();
	        Stage stage = (Stage) eventiC.getScene().getWindow();
    		stage.setTitle("Gestisci Eventi");	
    		gestisciB.setCaritas(currentUser);
    		gestisciB.loadShop(currentUser.getID());    		
    		stage.setScene(new Scene(rootNode, 800, 500));
    		stage.setResizable(false);
    		stage.show();
    		
    				} catch (IOException e) {
    					logger.error(s); }
		}
		
		
		
	

	@FXML
	void gestisciTurni(ActionEvent event) {
		try {     
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/gestisci_turni_caritas.fxml"));
			Parent root = loader.load();

			Stage home = (Stage) turni.getScene().getWindow();
		
			 gestTurn = loader.getController();
    		 gestTurn.setCurrentUser(this.currentUser);
    		 gestTurn.loadFormBoundary(currentUser.getID());
    		 
			home.setScene(new Scene(root,883, 550));
			home.show();
    		
    

    		
		} catch (IOException e) {
			logger.error(s); }

	}

	
	@FXML  // dobbiamo far fare un controllo alla bacheca_controller nel quale a seconda di chi entra ( carita o altri ) il tasto indietro porta alla schermata giusta.
	void visualizzaBacheca(ActionEvent event) {
		try {     
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/Bacheca_Personale.fxml"));
			Parent root = loader.load();

			Stage home = (Stage) vBacheca.getScene().getWindow();
			home.setScene(new Scene(root,775, 500));
			home.show();
    		
    		 bacheca = loader.getController();
    		 bacheca.setCurrentUser(this.currentUser);
    		 bacheca.loadFormBoundary(currentUser.getID());

    		
		} catch (IOException e) {
			logger.error(s); }
		}
	
	

	@FXML
	void deleteAccountButtonPressed(ActionEvent event) {
		// handle the event here
	}

	@FXML
	void helpButtonPressed(ActionEvent event) {
		// handle the event here
	}

	@FXML
	void leftArrowPressed(ActionEvent event) {
		// handle the event here
	}

	@FXML
	void logoutButtonPressedCaritas(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Logout");
    	alert.setHeaderText("Dovrai accedere di nuovo se vuoi tornare alla home");
    	alert.setContentText("Sei sicuro di voler eseguire il logout?");

    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		try {
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/Login_boundary.fxml"));
    			Parent root = loader.load();
    			Stage home = (Stage) logoutButton.getScene().getWindow();
    			home.setScene(new Scene(root, 600, 385));
    			home.show();
    		} catch (IOException e) {
				logger.error(s); }
    		}
        	
    	}    					

	

	@FXML
	void profileButtonPressed(ActionEvent event) {
		// handle the event here
	}

	@FXML
	void rightArrowPressedCaritas(ActionEvent event) {
		// handle the event here
	}

	@FXML
	void leftArrowPressedCaritas(ActionEvent event) {
		// handle the event here
	}

	
	public CaritasUser getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(CaritasUser currentUser) {
		this.currentUser = currentUser;
	}

	public void initDataCaritas(CaritasUser user) {
		setCurrentUser(user);
		nomeCognome.setText(user.getNomeCaritas());
		final Circle clip = new Circle();
		clip.setCenterX(25);
		clip.setCenterY(58);
		clip.setRadius(200);
		profileImage.setClip(clip);
		long delay = 3000; // update once per 3 seconds.
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				imagePresentation.setImage(images[currentImage++]);
				if (currentImage >= images.length) {
					currentImage = 0;
				}
			}
		}, 0, delay);

	}

}
