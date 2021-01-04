package bean;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import controller.ShopHomeController;
import entity.ShopUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShopHomeBoundary {
	


	private Image img1;
	private Image img2;
	private Image img3;
	private Image[] images = {img1, img2, img3};
	private int currentImage;
	private static ShopHomeBoundary instance = null;
	
	private ShopUser currentUser;
	 
		public ShopUser getCurrentUser() {
			return currentUser;
		}

		public void setCurrentUser(ShopUser currentUser) {
			this.currentUser = currentUser;
		}
		
		
		public static ShopHomeBoundary getInstance() {
			if (instance == null) {
				instance = new ShopHomeBoundary();
				}
			return instance;
		}

	public ShopHomeBoundary() {
		img1 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/DragoForestain.PNG");
		img2 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/PelleDrago.PNG");
		img3 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/DragoForestaIniz.PNG");
		this.currentImage = 0;
	}
		
    @FXML
    private Button gestEvent;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;



    @FXML
    private ImageView arrowLeft;

    @FXML
    private ImageView arrowRight;

    @FXML
    private Button deleteAccountButton;

    @FXML
    private Button helpButton;

    @FXML
    private ImageView imagePresentation;

    @FXML
    private Button leftArrowButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Text nomeCognome;

    @FXML
    private Button profileButton;

    @FXML
    private ImageView profileImage;

    @FXML
    private Button rightArrowButton;

    @FXML
    private Button searchCaritasButton;

    @FXML
    private Text textOverImages;


    @FXML
    void cercaCaritas(ActionEvent event) {
    	//mo lo faremo, giuro
    }

  
    public void initData(ShopUser user) {
    	setCurrentUser(user);
    	nomeCognome.setText(user.getNomeShop());
    	final Circle clip = new Circle();
    	clip.setCenterX(25);
    	clip.setCenterY(58);
    	clip.setRadius(200);
        profileImage.setClip(clip);
    	long delay = 3000; //update once per 3 seconds.
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
    void deleteAccountButtonPressed(ActionEvent event) {
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Logout");
    	alert.setHeaderText("Se cancelli il tuo account verrano cancellati anche le tue attivit� in corso e potresti ricevere delle sanzioni");
    	alert.setContentText("Sei sicuro di voler cancellare il tuo account?");
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		System.out.println("sei morto");
    	}
    }

    @FXML
    void gestisciEventi(ActionEvent event) {
    	try {


	        FXMLLoader fxmlLoader = new FXMLLoader();
	        Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("/boundary/Eventi2.fxml"));
	       
	        GestisciEventiBoundary gestisciBoundary = fxmlLoader.getController();
	        
			Stage stage = (Stage) gestEvent.getScene().getWindow();

    		stage.setTitle("Gestisci Eventi");
    		
    		
    		gestisciBoundary.setShop(currentUser);
    		gestisciBoundary.loadShop(currentUser.getID());
    		
    		stage.setScene(new Scene(rootNode, 800, 500));
    		stage.setResizable(false);
    		stage.show();
    		
    		
    				} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void helpButtonPressed(ActionEvent event) {
    	//lo faremo sicuro sicuro
    }

    @FXML
   void leftArrowPressed(ActionEvent event) {
    	
    	//Se � la prima riparti dall'ultima
    	if (currentImage == 0) {
    		currentImage = 2;
    		imagePresentation.setImage(images[currentImage]);
    	} else {
    		currentImage--;
    		imagePresentation.setImage(images[currentImage]);
    	}
    }

    @FXML
 void logoutButtonPressed(ActionEvent event) {
    	
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
				e.printStackTrace();
			}
        	
    	} 
    	
	}


    @FXML
    void profileButtonPressed(ActionEvent event) {
 	 //questo forse no
    }

    @FXML
    void rightArrowPressed(ActionEvent event) {
    	
    	//Se � l'ultima riparti dalla prima
    	if (currentImage == 2) {
    		currentImage = 0;
    		imagePresentation.setImage(images[currentImage]);
    	} else {
    		currentImage++;
    		imagePresentation.setImage(images[currentImage]);
    	}
    }




}
