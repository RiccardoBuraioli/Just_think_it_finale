package bean;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.io.IOException;

import java.util.Timer;
import java.util.TimerTask;

import entity.CaritasUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.Image;

import javafx.scene.shape.Circle;

import javafx.stage.Stage;

public class Caritas_Home_Boundary {

	private Image img1 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/DragoForestain.PNG");
	private Image img2 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/PelleDrago.PNG");
	private Image img3 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/DragoForestaIniz.PNG");
	private Image[] images = { img1, img2, img3 };
	private int currentImage = 0;
	private  static Caritas_Home_Boundary instance = null;

	private CaritasUser currentUser;
	private Gestisci_Turni_Boundary gestTurn;

	private Bacheca_Personale_Boundary bacheca;
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
    private Button Turni;

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

	
	
	public static Caritas_Home_Boundary getInstance() {
		if (instance == null) {
			instance = new Caritas_Home_Boundary();
			}
		return instance;
	}
	
	

	public Caritas_Home_Boundary() {
		bacheca = new Bacheca_Personale_Boundary();
		gestTurn = new Gestisci_Turni_Boundary();
	}

	@FXML
	void GestisciDonazioni(ActionEvent event) {
		// handle the event here
	}

	@FXML
	void GestisciEventi(ActionEvent event) {
		// handle the event here
		
		try {


	        FXMLLoader fxmlLoader = new FXMLLoader();
	        Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("../boundary/Gestisci_eventi_caritas.fxml"));       
	        Gestisci_Eventi_Caritas_Boundary gestisci_b = fxmlLoader.getController();
	        Stage stage = (Stage) eventiC.getScene().getWindow();
    		stage.setTitle("Gestisci Eventi");	
    		gestisci_b.setCaritas(currentUser);
    		gestisci_b.load_shop(currentUser.getID());    		
    		stage.setScene(new Scene(rootNode, 800, 500));
    		stage.setResizable(false);
    		stage.show();
    		
    				} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

	@FXML
	void GestisciTurni(ActionEvent event) {
		try {     
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/gestisci_turni_caritas.fxml"));
			Parent root = loader.load();

			Stage home = (Stage) Turni.getScene().getWindow();
		
			 gestTurn = loader.getController();
    		 gestTurn.set_currentUser(this.currentUser);
    		 gestTurn.loadFormBoundary(currentUser.getID());
    		 
			home.setScene(new Scene(root,883, 550));
			home.show();
    		
    

    		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@FXML  // dobbiamo far fare un controllo alla bacheca_controller nel quale a seconda di chi entra ( carita o altri ) il tasto indietro porta alla schermata giusta.
	void VisualizzaBacheca(ActionEvent event) {
		try {     
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/Bacheca_Personale.fxml"));
			Parent root = loader.load();

			Stage home = (Stage) vBacheca.getScene().getWindow();
			home.setScene(new Scene(root,775, 500));
			home.show();
    		
    		 bacheca = loader.getController();
    		 bacheca.set_currentUser(this.currentUser);
    		 bacheca.loadFormBoundary(currentUser.getID());

    		
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	void logoutButtonPressed(ActionEvent event) {
		// handle the event here
	}

	@FXML
	void profileButtonPressed(ActionEvent event) {
		// handle the event here
	}

	@FXML
	void rightArrowPressed(ActionEvent event) {
		// handle the event here
	}

	public CaritasUser getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(CaritasUser currentUser) {
		this.currentUser = currentUser;
	}

	public void initData(CaritasUser user) {
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

	@FXML
	void initialize() {

	}

}
