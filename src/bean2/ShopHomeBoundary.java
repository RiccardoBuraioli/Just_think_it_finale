package bean2;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sothawo.mapjfx.Projection;

import entity.ShopUser;


public class ShopHomeBoundary {
	

	private static Logger logger = LoggerFactory.getLogger(ShopHomeBoundary.class.getName());
	private String s = "error IoException";
	private int idShop;
	private GestisciEventiBoundary gestisciBoundary;
	
	private static ShopHomeBoundary instance = null;
	
	private ShopUser currentUser;
	 
		public ShopUser getCurrentUser() {
			return currentUser;
		}

		public void setCurrentUser(ShopUser user) {
			this.currentUser = user;
		}
		
		
		public static ShopHomeBoundary getInstance() {
			if (instance == null) {
				instance = new ShopHomeBoundary();
				}
			return instance;
		}
	


 /*   @FXML
    void cercaCaritas(ActionEvent event) {
    	TransizionePagine switchPage = new TransizionePagine();
    	switchPage.apriMappa(this.idShop, searchCaritasButton.getScene().getWindow());

    }
*/

		
  /*  void deleteAccountButtonPressed() {
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Logout");
    	alert.setHeaderText("Se cancelli il tuo account verrano cancellati anche le tue attività in corso e potresti ricevere delle sanzioni");
    	alert.setContentText("Sei sicuro di voler cancellare il tuo account?");
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		logger.trace("sei morto");
    	}
    }*/


    public void gestisciEventi() {
    		gestisciBoundary = new GestisciEventiBoundary();
    		gestisciBoundary.setShop(currentUser);
    		gestisciBoundary.loadShop(currentUser.getId());   	
    }

  
    void helpButtonPressed() {
    	//lo faremo sicuro sicuro
    }

  

   
 /*void logoutButtonPressed(ActionEvent event) {
    	
     	
    	TransizionePagine pageSwitch = new TransizionePagine();
    	pageSwitch.logout(logoutButton.getScene().getWindow());
	}
	*/

	public void initData(int id, String nome) {
		this.idShop = id;
    	//nomeCognome.setText(nome);
	}





}
