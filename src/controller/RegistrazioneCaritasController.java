package controller;

import entity.CaritasUser;
import java.io.IOException;
import java.sql.SQLException;
import bean.CaritasHomeBoundary;
import dao.CaritasRepository;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class RegistrazioneCaritasController  {

	private CaritasHomeBoundary caritasHomeBoundary;
	
	int tipo;

	public RegistrazioneCaritasController() {
		caritasHomeBoundary = new CaritasHomeBoundary();
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

	public void completaButtonPressed( String nomeCaritas, String passwordCaritas, String via, String tipo,
		
		String telefono, String email, String cittadiResidenza) throws SQLException {
	
		CaritasUser newUser = new CaritasUser(nomeCaritas, passwordCaritas, via, tipo, telefono, email, cittadiResidenza);
	
			CaritasRepository crep = new CaritasRepository();
			int id = crep.insertCaritas(newUser);
			newUser.setId(id);
            

			// Manda alla home Caritas
		

	}



}
