package controller;

import java.io.IOException;
import entity.ShopUser;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class ShopHomeController {

	

	private ShopUser currentUser;

	public ShopUser getCurrentUser() {
		return currentUser;
	}
	
	public void setCurrentUser(ShopUser currentUser) {
		this.currentUser = currentUser;
	}

	public void cercaCaritas(Window event) {
		
		//questo per forza
	}

	public void creaDonazioni(Window event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/donation.fxml"));
			Parent root = loader.load();
			Stage home = (Stage) event.getScene().getWindow();
			home.setScene(new Scene(root, 825, 550));
			home.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void deleteAccountButtonPressed(Window event) {
		//funzionera
	}



	

	public void profileButtonPressed(Window event) {
		// a sto punto pure questo
	}


}
