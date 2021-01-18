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
	
	int tipo;

	public RegistrazioneCaritasController() {
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
