package bean;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import controller.RegistrazioneCaritasController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegistraCaritasBoundary implements Initializable {

	private RegistrazioneCaritasController regController;

	private TextField[] textFields;

	private String tipo;

	@FXML
	private TextField cittadiResidenza;

	@FXML
	private TextField via;

	@FXML
	private TextField civico;

	@FXML
	private TextField telefono;

	@FXML
	private Button backButton;

	@FXML
	private TextField nomeCaritas;

	@FXML
	private TextField email;

	@FXML
	private CheckBox type;

	@FXML
	private CheckBox type2;

	@FXML
	private TextField nomeResp;

	@FXML
	private TextField cognomeResp;

	@FXML
	private Button completaButton;

	@FXML
	private TextField codiceFiscaleResp;

	@FXML
	private PasswordField passwordCaritas;

	@FXML
	private Text passwordMatch;

	@FXML
	private PasswordField confermaPassCaritas;

	public RegistraCaritasBoundary() {
		regController = new RegistrazioneCaritasController();
	}

	@FXML
	void backButtonPressed(ActionEvent event) {
		regController.backButtonPressed(backButton.getScene().getWindow());

	}

	@FXML
	public void completaButtonPressed(ActionEvent event) throws SQLException {
		int resCheck = checker();
		if (resCheck == 0) {
			regController.completaButtonPressed( nomeCaritas.getText(),
					passwordCaritas.getText(), via.getText(), tipo, telefono.getText(), email.getText(),
					cittadiResidenza.getText());
		}
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/CaritasHomePage.fxml"));
			Parent root = loader.load();
			Stage home = (Stage) completaButton.getScene().getWindow();
			home.setScene(new Scene(root, 800, 600));

			home.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int checker() {

		// Controlla che non ci siano campi lasciati vuoti
		for (int i = 0; i < textFields.length; i++) {
			if (textFields[i].getText().isEmpty()) {
				passwordMatch.setText("Alcuni campi sono vuoti");
				passwordMatch.setVisible(true);
				return -1;
			}
			else if (type.isSelected()) {
				tipo = "Vestiti";
				return 0; // Almeno uno dei tipi deve essere selezionato

			} else if (type2.isSelected()) {
				tipo = "Cibo";
				passwordMatch.setText("Alcuni campi sono vuoti 2");
				passwordMatch.setVisible(true);
				return 0; // Almeno uno dei tipi deve essere selezionato
			}
		}

		// Valida che i campi password e conferma password siano uguali

		if (passwordCaritas.getText().equals(confermaPassCaritas.getText())) {
			passwordMatch.setVisible(false);
			return 0;
		} else {
			passwordMatch.setText("Le password non corrispondono");
			passwordMatch.setVisible(true);
			return -1;
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		passwordMatch.setVisible(false);
		textFields = new TextField[] { cittadiResidenza, via, civico, telefono, nomeCaritas, email, nomeResp,
				cognomeResp, codiceFiscaleResp };

	}

}