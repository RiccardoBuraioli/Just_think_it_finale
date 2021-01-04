package bean;

import java.io.IOException;

import controller.CreaTurnoController;
import controller.PrenotaTurnoController;
import entity.CaritasUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreaTurnoBoundary {

	@FXML
	private Button back;

	@FXML
	private Button creaTurno;

	@FXML
	private TextArea note;

	@FXML
	private TextField orain;

	@FXML
	private TextField oraFin;

	@FXML
	private ChoiceBox<String> giorni;

	@FXML
	private TextField numParte;

	private CaritasUser caritas;

	@FXML
	void backPressed(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/gestisci_turni_caritas.fxml"));
			Parent root = loader.load();

			Stage home = (Stage) back.getScene().getWindow();
			GestisciTurniBoundary gestTurn = new GestisciTurniBoundary();
			gestTurn = loader.getController();
			gestTurn.setCurrentUser(this.caritas);
			gestTurn.loadFormBoundary(this.caritas.getID());
			home.setScene(new Scene(root, 883, 550));
			home.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void creaTurnoPressed(ActionEvent event) {
		CreaTurnoController creaTurno = new CreaTurnoController();
		creaTurno.creaEvento(caritas.getID(), giorni.getValue().toString(), orain.getText(), oraFin.getText(),Integer.parseInt(numParte.getText()), note.getText());
		
		
		
	}

	public void setCaritas(CaritasUser caritas) {
		this.caritas = caritas;
	}

	@FXML
	void initialize() {

		String[] days = { "Lunedi", "Martedì", "Mercoledi", "Giovedi", "Venerdi", "Sabato", "Domenica" };

		for (int i = 0; i < 7; i++) {

			giorni.getItems().add(days[i]);

		}

	}

}
