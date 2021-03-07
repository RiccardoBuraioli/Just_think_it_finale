package bean2;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.PrenotaTurnoController;
import entity.Orario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PrenotaTurnoBoundary {

	private PrenotaTurnoController prenotaC;


    public void prenotaTurno() {

		//prenotaC.prenotaTurno(turni, cbOraInizio, OraFine, cv);
	}

	public boolean checker() {
		Logger logger = LoggerFactory.getLogger(PrenotaTurnoBoundary.class.getName());
		return false;
		
		// Controlla che non ci siano campi lasciati vuoti

		/*if (cv.getText().isEmpty()) {
			logger.debug("riprova");
			return false;
		} else {
			return true;
		}*/
	}

	@FXML
	void initialize() {
		prenotaC = new PrenotaTurnoController();

		String[] giorni;

		giorni = prenotaC.inizializzaGiorni();

		for (int i = 0; i < 8; i++) {
			turni.getItems().add(giorni[i]);
		}

		List<Orario> oraArrayList = prenotaC.initializzaOrari();

		int i = 0;
		while (i < oraArrayList.size()) {

			cbOraInizio.getItems().add(oraArrayList.get(i).getOraFine());

			cbOraFine.getItems().add(oraArrayList.get(i).getOraInizio());

			i++;

		}

	}

	public void setData(int idCar, int idUte) {
		prenotaC.setDataController(idCar, idUte);
	}
}

