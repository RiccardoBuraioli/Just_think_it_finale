package controller;

import entity.CaritasUser2;
import java.sql.SQLException;
import dao.CaritasRepository;


public class RegistrazioneCaritasController  {
	
	int tipo;

	public RegistrazioneCaritasController() {
	}


	public void completaButtonPressed( String nomeCaritas, String passwordCaritas, String via, String tipo,
		
		String telefono, String email, String cittadiResidenza) throws SQLException {
	
		CaritasUser2 newUser = new CaritasUser2(nomeCaritas, passwordCaritas, via, tipo, telefono, email, cittadiResidenza);
	
			CaritasRepository crep = new CaritasRepository();
			int id = crep.insertCaritas(newUser);
			newUser.setId(id);
            

			// Manda alla home Caritas
		

	}



}
