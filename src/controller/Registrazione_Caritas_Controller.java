package controller;

import entity.CaritasUser;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import bean.Caritas_Home_Boundary;
import dao.CaritasRepository;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Registrazione_Caritas_Controller implements Initializable {

	private Caritas_Home_Boundary CaritasHomeBoundary;
	private CaritasUser newUser;
	int tipo;

	public Registrazione_Caritas_Controller() {
		CaritasHomeBoundary = new Caritas_Home_Boundary();
	}

	public void backButtonPressed(Window event) {

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/boundary/RegistrazioneMenu.fxml"));
			Stage signUp = (Stage) event.getScene().getWindow();
			Scene scene = new Scene(root, 600, 400);
			signUp.setScene(scene);
			signUp.show();
			signUp.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void completaButtonPressed(Window event, String nomeCaritas, String passwordCaritas, String via, int tipo,
		
		String telefono, String email, String cittądiResidenza) throws SQLException {
	
			newUser = new CaritasUser(nomeCaritas, passwordCaritas, via, tipo, telefono, email, cittądiResidenza);
	
			CaritasRepository crep = new CaritasRepository();
			int id = crep.insertCaritas(newUser);
			newUser.setId(id);
	
			// Manda alla home Caritas
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/CaritasHomePage.fxml"));
				Parent root = loader.load();
				CaritasHomeBoundary = loader.getController();
	
				Stage home = (Stage) event.getScene().getWindow();
				home.setScene(new Scene(root, 800, 600));
	
				home.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
