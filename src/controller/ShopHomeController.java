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


	public void deleteAccountButtonPressed(Window event) {
		//funzionera
	}




}
