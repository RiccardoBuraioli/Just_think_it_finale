package bean;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.CreaNecessitaController;
import entity.CaritasUser;
import entity.CaritasUser2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class CreaNecessitaBoundary {
	private CaritasUser caritas;
	private Logger logger = LoggerFactory.getLogger(CreaNecessitaBoundary.class.getName());
	private String[] tipo = { "Vestiti", "Cibo" };
	private String[] urg = { "Alta", "Normale", "Bassa" };

	@FXML
	private TextArea descrizione;

	@FXML
	private ChoiceBox<String> tipologia;

	@FXML
	private ChoiceBox<String> urgenza;

	@FXML
	private Button creaAnnuncio;

	@FXML
	private Button back;

	private int idCaritas;

	@FXML
	void backPressed(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/Bacheca_Personale.fxml"));
			Parent root = loader.load();

			Stage home = (Stage) back.getScene().getWindow();
			home.setScene(new Scene(root, 775, 500));
			home.show();

			BachecaPersonaleBoundary bacheca = loader.getController();
			bacheca.setCurrentUser(this.caritas);
			bacheca.loadFormBoundary(caritas.getId());

		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	@FXML
	void creaAnnuncioPressed(ActionEvent event) {

		CreaNecessitaController creaNec = new CreaNecessitaController();
		creaNec.inizializza(idCaritas);
		int i = creaNec.creaNecessita(tipologia.getValue().toString(), urgenza.getValue().toString(),
				descrizione.getText());
		if (i == 0) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/Bacheca_Personale.fxml"));
				Parent root = loader.load();

				Stage home = (Stage) back.getScene().getWindow();
				home.setScene(new Scene(root, 775, 500));
				home.show();

				BachecaPersonaleBoundary bacheca = loader.getController();
				bacheca.setCurrentUser(this.caritas);
				bacheca.loadFormBoundary(caritas.getId());

			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		} else
			logger.trace("errore nella creazione dell'annuncio");
	}

	@FXML
	void initialize() {
		tipologia.getItems().addAll(tipo);
		urgenza.getItems().addAll(urg);

	}

	public void setCaritas(CaritasUser caritas2) {
		this.idCaritas = caritas2.getId();
		this.caritas = caritas2;
		
	}

}
