package bean;

import java.io.IOException;
import java.util.List;

import controller.BachecaController;
import controller.Bacheca_Personale_Controller;
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
	private List<Necessit‡> necessit‡_l;
	private int id_car;
	private Bacheca_Personale_Controller bacheca_controller;
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
	private Button necessit‡;


	@FXML
	private Button elimina;

	@FXML
	private Button back;

	@FXML
	void backPressed(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/CaritasHomePage.fxml"));
			Parent root = loader.load();
			CaritasHomeBoundary home_c = loader.getController();
			home_c.setCurrentUser(caritas);
			
			Stage home = (Stage) back.getScene().getWindow();
			home.setScene(new Scene(root,  800, 600));

			home.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	
	
	@FXML
	void crea_necessit‡(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/Crea_Necessit‡.fxml"));
			Parent root = loader.load();
			CreaNecessit‡Boundary crea_nec = loader.getController();
			crea_nec.set_caritas(id_car);
			Stage home = (Stage) necessit‡.getScene().getWindow();
			home.setScene(new Scene(root, 600, 500));

			home.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void elimina_necessit‡(ActionEvent event) {
		nec = bacheca.getSelectionModel().getSelectedItem();
		bacheca_controller.elimina_annuncio(nec.getId_nece());
	}



	public void loadFormBoundary(int id_car) {
		this.id_car = id_car;

		bacheca_controller = new Bacheca_Personale_Controller();
		necessit‡_l = bacheca_controller.loadForm(id_car);
		ObservableList<Necessit‡> data = FXCollections.observableArrayList(necessit‡_l);

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
