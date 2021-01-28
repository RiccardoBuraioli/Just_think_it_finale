package bean;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.LoginController;
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
	private String s = "errore IoException";

	private LoginController loginC = new LoginController();

	private UserHomeBoundary userHomeBoundary;
	private ShopHomeBoundary shopHomeBoundary;
	private static LoginBoundary instance = null;
	private CaritasHomeBoundary caritasHomeBoundary;

	public static LoginBoundary getInstance() {
		if (instance == null) {
			instance = new LoginBoundary();

		}
		return instance;
	}

	@FXML
	private TextField usernameField;

	@FXML
	private TextField passwordField;

	@FXML
	private Button loginButton;

	@FXML
	private Button registerButton;

	@FXML
	void loginPressed(ActionEvent event) {

		Object loggedUser = loginC.loginAccess(usernameField.getText(), passwordField.getText());
		if (loggedUser.getClass() == VolunteerUser.class) {

			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/UserHomePage.fxml"));
				Parent root = loader.load();
				userHomeBoundary = userHomeBoundary.getInstance();
				userHomeBoundary = loader.getController();
				userHomeBoundary.initData((VolunteerUser) loggedUser);
				Stage home = (Stage) loginButton.getScene().getWindow();
				home.setScene(new Scene(root, 800, 600));

				home.show();
			} catch (IOException e) {
				logger.error(s);
			}

		} else if (loggedUser.getClass() == CaritasUser.class) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/CaritasHomePage.fxml"));
				Parent root = loader.load();
				caritasHomeBoundary = caritasHomeBoundary.getInstance();
				caritasHomeBoundary = loader.getController();
				caritasHomeBoundary.initDataCaritas((CaritasUser) loggedUser);
				Stage home = (Stage) loginButton.getScene().getWindow();
				home.setScene(new Scene(root, 800, 600));

				home.show();
			} catch (IOException e) {
				logger.error(s);

			}
		} else if (loggedUser.getClass() == ShopUser.class) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/ShopHomePage.fxml"));
				Parent root = loader.load();
				shopHomeBoundary = shopHomeBoundary.getInstance();
				shopHomeBoundary = loader.getController();
				shopHomeBoundary.initData((ShopUser) loggedUser);
				Stage home = (Stage) loginButton.getScene().getWindow();
				home.setScene(new Scene(root, 800, 600));

				home.show();
			} catch (IOException e) {
				logger.error(s);
			}

		}

	}

	@FXML
	void registrazionePressed(ActionEvent event) {

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/boundary/RegistrazioneMenu.fxml"));
			Stage signUp = (Stage) registerButton.getScene().getWindow();
			Scene scene = new Scene(root, 600, 400);
			signUp.setScene(scene);
			signUp.show();
			signUp.setResizable(false);
		} catch (IOException e) {
			logger.error(s);
		}

	}

}
