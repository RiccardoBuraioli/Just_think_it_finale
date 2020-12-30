package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import bean.DonationBoundary;
import bean.GestisciEventiBoundary;
import entity.ShopUser;
import entity.VolunteerUser;
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
import javafx.stage.Window;

public class Shop_home_controller implements Initializable {

	private GestisciEventiBoundary gestisci_b;

	private ShopUser currentUser;

	public ShopUser getCurrentUser() {
		return currentUser;
	}
	
	public void setCurrentUser(ShopUser currentUser) {
		this.currentUser = currentUser;
	}

	public Shop_home_controller() {
		gestisci_b = new GestisciEventiBoundary();
	}

	public void cerca_caritas(Window event) {
	}

	public void crea_donazioni(Window event) {
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
	}



	

	public void profileButtonPressed(Window event) {
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
