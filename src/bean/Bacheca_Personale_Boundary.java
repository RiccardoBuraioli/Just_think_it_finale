package bean;

import java.io.IOException;
import java.util.List;

import controller.Bacheca_Controller;
import controller.Bacheca_Personale_Controller;
import entity.EventTab;
import entity.NecessitÓ;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Bacheca_Personale_Boundary {
	private List<NecessitÓ> necessitÓ_l;
	private int id_car;
	private Bacheca_Personale_Controller bacheca_controller;

	@FXML
	private TableView<NecessitÓ> bacheca;

	@FXML
	private TableColumn<NecessitÓ, String> tipologia;

	@FXML
	private TableColumn<NecessitÓ, String> descrizione;

	@FXML
	private TableColumn<NecessitÓ, String> urgenza;

	@FXML
	private Button necessitÓ;


	@FXML
	private Button elimina;

	@FXML
	private Button back;

	@FXML
	void backPressed(ActionEvent event) {

	}

	@FXML
	void crea_necessitÓ(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/Crea_NecessitÓ.fxml"));
			Parent root = loader.load();
			Crea_NecessitÓ_Boundary crea_nec = loader.getController();
			crea_nec.set_caritas(id_car);
			Stage home = (Stage) necessitÓ.getScene().getWindow();
			home.setScene(new Scene(root, 800, 600));

			home.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void elimina_necessitÓ(ActionEvent event) {

	}



	public void loadFormBoundary(int id_car) {
		this.id_car = id_car;

		bacheca_controller = new Bacheca_Personale_Controller();
		necessitÓ_l = bacheca_controller.loadForm(id_car);
		ObservableList<NecessitÓ> data = FXCollections.observableArrayList(necessitÓ_l);

		descrizione.setCellValueFactory(new PropertyValueFactory<>("Descrizione"));

		tipologia.setCellValueFactory(new PropertyValueFactory<>("Tipologia"));

		urgenza.setCellValueFactory(new PropertyValueFactory<>("Urgenza"));

		bacheca.setItems(data);

	}

}
