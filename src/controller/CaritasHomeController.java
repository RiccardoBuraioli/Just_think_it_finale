package controller;

import java.io.IOException;

import bean.BachecaBoundary;
import entity.CaritasUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * Sample Skeleton for "CaritasHomePage.fxml" Controller Class You can copy and
 * paste this code into your favorite IDE
 **/

public class CaritasHomeController {

	private CaritasUser currentUser;

	public CaritasHomeController() {
	

	}

	public void Gestisci_donazioni(Window event) {
		// handle the event here
	}

	// Handler for Button[Button[id=null, styleClass=button]] onAction

	public void Gestisci_eventi(Window event) {
		// handle the event here
	}

	// Handler for Button[fx:id="CreaPacco"] onAction

	public void Gestisci_turni(Window event) {
		// handle the event here
	}


	// Handler for Button[fx:id="deleteAccountButton"] onAction

	public void deleteAccountButtonPressed(Window event) {
		// handle the event here
	}

	// Handler for Button[fx:id="helpButton"] onAction

	public void helpButtonPressed(Window event) {
		// handle the event here
	}

	public void logoutButtonPressed(Window event) {
		// handle the event here
	}

	public void profileButtonPressed(Window event) {
		// handle the event here
	}

	public CaritasUser getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(CaritasUser currentUser) {
		this.currentUser = currentUser;
	}

}
