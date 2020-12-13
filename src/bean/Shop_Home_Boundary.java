package bean;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import controller.Shop_home_controller;
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

public class Shop_Home_Boundary implements Initializable {
	
	private Shop_home_controller Shop_c;
	private Gestisci_eventi_Boundary gestisci_b;
	private Image img1;
	private Image img2;
	private Image img3;
	private Image[] images = {img1, img2, img3};
	private int currentImage;
	
	
	private ShopUser currentUser;
	 
		public ShopUser getCurrentUser() {
			return currentUser;
		}

		public void setCurrentUser(ShopUser currentUser) {
			this.currentUser = currentUser;
		}
	 

	public Shop_Home_Boundary() {
		img1 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/DragoForestain.PNG");
		img2 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/PelleDrago.PNG");
		img3 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/DragoForestaIniz.PNG");
		currentImage = 0;
		Shop_c = new Shop_home_controller();
	}
		
    @FXML
    private Button gest_event;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button CreaPacco;

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
    void cerca_caritas(ActionEvent event) {
    }

    @FXML
    void crea_donazioni(ActionEvent event) {
    	   	      	try {
    	    			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/donation.fxml"));
    	    			Parent root = loader.load();
    	    			Stage home = (Stage) CreaPacco.getScene().getWindow();
    	    			home.setScene(new Scene(root,825, 550));
    	    			home.show();
    	    		} catch (IOException e) {
    	    			e.printStackTrace();
    	    		}

    	    
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
    }

    @FXML
    void gestisci_eventi(ActionEvent event) {
    	Shop_c.setCurrentUser(currentUser);
     
    	Shop_c.gestisci_eventi(gest_event.getScene().getWindow());
    }

    @FXML
    void helpButtonPressed(ActionEvent event) {
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
    		Shop_c.logoutButtonPressed(logoutButton.getScene().getWindow());
        	
    	} else {
    	    //nothing
    	}
    	
	}


    @FXML
    void profileButtonPressed(ActionEvent event) {
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

    @FXML
    void initialize() {
        assert CreaPacco != null : "fx:id=\"CreaPacco\" was not injected: check your FXML file 'ShopHomePage.fxml'.";
        assert arrowLeft != null : "fx:id=\"arrowLeft\" was not injected: check your FXML file 'ShopHomePage.fxml'.";
        assert arrowRight != null : "fx:id=\"arrowRight\" was not injected: check your FXML file 'ShopHomePage.fxml'.";
        assert deleteAccountButton != null : "fx:id=\"deleteAccountButton\" was not injected: check your FXML file 'ShopHomePage.fxml'.";
        assert helpButton != null : "fx:id=\"helpButton\" was not injected: check your FXML file 'ShopHomePage.fxml'.";
        assert imagePresentation != null : "fx:id=\"imagePresentation\" was not injected: check your FXML file 'ShopHomePage.fxml'.";
        assert leftArrowButton != null : "fx:id=\"leftArrowButton\" was not injected: check your FXML file 'ShopHomePage.fxml'.";
        assert logoutButton != null : "fx:id=\"logoutButton\" was not injected: check your FXML file 'ShopHomePage.fxml'.";
        assert nomeCognome != null : "fx:id=\"nomeCognome\" was not injected: check your FXML file 'ShopHomePage.fxml'.";
        assert profileButton != null : "fx:id=\"profileButton\" was not injected: check your FXML file 'ShopHomePage.fxml'.";
        assert profileImage != null : "fx:id=\"profileImage\" was not injected: check your FXML file 'ShopHomePage.fxml'.";
        assert rightArrowButton != null : "fx:id=\"rightArrowButton\" was not injected: check your FXML file 'ShopHomePage.fxml'.";
        assert searchCaritasButton != null : "fx:id=\"searchCaritasButton\" was not injected: check your FXML file 'ShopHomePage.fxml'.";
        assert textOverImages != null : "fx:id=\"textOverImages\" was not injected: check your FXML file 'ShopHomePage.fxml'.";


    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}


}
