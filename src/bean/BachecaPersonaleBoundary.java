package bean;

import java.io.IOException;
import java.util.List;

import controller.BachecaController;
import controller.BachecaPersonaleController;
import entity.CaritasUser;
import entity.EventTab;
import entity.Necessit‡;
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

public class BachecaPersonaleBoundary {
	private List<Necessit‡> necessitaList;
	private int idCar;
	private BachecaPersonaleController bachecaController;
	private Necessit‡ nec;
	private CaritasUser caritas;

	@FXML
	private TableView<Necessit‡> bacheca;

	@FXML
	private TableColumn<Necessit‡, String> tipologia;

	@FXML
	private TableColumn<Necessit‡, String> descrizione;

	@FXML
	private TableColumn<Necessit‡, String> urgenza;

	@FXML
	private Button necessita;


	@FXML
	private Button elimina;

	@FXML
	private Button back;

	@FXML
	void backPressed(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/CaritasHomePage.fxml"));
			Parent root = loader.load();
			CaritasHomeBoundary homeC = loader.getController();
			homeC.setCurrentUser(caritas);
			
			Stage home = (Stage) back.getScene().getWindow();
			home.setScene(new Scene(root,  800, 600));

			home.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	
	
	@FXML
	void creaNecessita(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/Crea_Necessit‡.fxml"));
			Parent root = loader.load();
			CreaNecessit‡Boundary creaNec = loader.getController();
			creaNec.setCaritas(idCar);
			Stage home = (Stage) necessita.getScene().getWindow();
			home.setScene(new Scene(root, 600, 500));

			home.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void eliminaNecessita(ActionEvent event) {
		nec = bacheca.getSelectionModel().getSelectedItem();
		bachecaController.elimina_annuncio(nec.getId_nece());
	}



	public void loadFormBoundary(int id_car) {
		this.idCar = id_car;

		bachecaController = new BachecaPersonaleController();
		necessitaList = bachecaController.loadForm(id_car);
		ObservableList<Necessit‡> data = FXCollections.observableArrayList(necessitaList);

		descrizione.setCellValueFactory(new PropertyValueFactory<>("Descrizione"));

		tipologia.setCellValueFactory(new PropertyValueFactory<>("Tipologia"));

		urgenza.setCellValueFactory(new PropertyValueFactory<>("Urgenza"));

		bacheca.setItems(data);

	}
	
	
	public void set_currentUser(CaritasUser user) {
		this.caritas = user;
	}
	
	public CaritasUser getcaritas() {
		return this.caritas;
	}
	

}
