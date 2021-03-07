package bean2;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.CaritasHomeController;
import controller.LoginController;
import controller.ShopHomeController;
import controller.UserHomeController;
import entity.CaritasUser;
import entity.ShopUser;
import entity.VolunteerUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginBoundary {

	private static Logger logger = LoggerFactory.getLogger(LoginBoundary.class.getName());
	//può essere tolta la stringa
	private String s = "errore IoException";

	private LoginController loginC = new LoginController();

	private bean2.UserHomeBoundary userHomeBoundary;
	private UserHomeController userHomeController;
	private bean2.ShopHomeBoundary shopHomeBoundary;
	private static LoginBoundary instance = null;
	private bean2.CaritasHomeBoundary caritasHomeBoundary;

	/*public static LoginBoundary getInstance() {
		if (instance == null) {
			instance = new LoginBoundary();

		}
		return instance;
	}*/
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String loginPressed(String username, String password) {
		int idUser = loginC.trovaID(username);
		String loggedUser = loginC.loginAccess(username, password);
		if (loggedUser.equalsIgnoreCase("Volontario")) {
			userHomeBoundary = userHomeBoundary.getInstance();				
			userHomeController = new UserHomeController();
			userHomeController.initDataCont(idUser, userHomeBoundary);
				
				/*
				userHomeController.load();
				String nome = userHomeController.getNome();
				String cognome = userHomeController.getCognome();
				*/
		} else if (loggedUser.equalsIgnoreCase("Caritas")) {
			caritasHomeBoundary = caritasHomeBoundary.getInstance();
			CaritasHomeController caritasHomeController = new CaritasHomeController();
			caritasHomeController.initDataCaritas(idUser, caritasHomeBoundary);
				
		} else if (loggedUser.equalsIgnoreCase("Negozio")) {
				shopHomeBoundary = shopHomeBoundary.getInstance();
				ShopHomeController shopHomeC = new ShopHomeController();
				shopHomeC.initDataShop(idUser, shopHomeBoundary);
		}
		return loggedUser;

	}
}


