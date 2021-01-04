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

	public CaritasUser getCurrentUser() {
		return this.currentUser;
	}

	public void setCurrentUser(CaritasUser currentUser) {
		this.currentUser = currentUser;
	}

}
