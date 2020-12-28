package bean;

import java.io.IOException;
import java.util.List;

import controller.Bacheca_Controller;
import controller.Bacheca_Personale_Controller;
import entity.CaritasUser;
import entity.EventTab;
import entity.Necessità;
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
	private List<Necessità> necessità_l;
	private int id_car;
	private Bacheca_Personale_Controller bacheca_controller;
	private Necessità nec;
	private CaritasUser caritas;

	@FXML
	private TableView<Necessità> bacheca;

	@FXML
	private TableColumn<Necessità, String> tipologia;

	@FXML
	private TableColumn<Necessità, String> descrizione;

	@FXML
	private TableColumn<Necessità, String> urgenza;

	@FXML
	private Button necessità;


	@FXML
	private Button elimina;

	@FXML
	private Button back;

	@FXML
	void backPressed(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/CaritasHomePage.fxml"));
			Parent root = loader.load();
			Caritas_Home_Boundary home_c = loader.getController();
			home_c.setCurrentUser(caritas);
			
			Stage home = (Stage) back.getScene().getWindow();
			home.setScene(new Scene(root,  800, 600));

			home.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	
	
	@FXML
	void crea_necessità(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/Crea_Necessità.fxml"));
			Parent root = loader.load();
			Crea_Necessità_Boundary crea_nec = loader.getController();
			crea_nec.set_caritas(id_car);
			Stage home = (Stage) necessità.getScene().getWindow();
			home.setScene(new Scene(root, 600, 500));

			home.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void elimina_necessità(ActionEvent event) {
		nec = bacheca.getSelectionModel().getSelectedItem();
		bacheca_controller.elimina_annuncio(nec.getId_nece());
	}



	public void loadFormBoundary(int id_car) {
		this.id_car = id_car;

		bacheca_controller = new Bacheca_Personale_Controller();
		necessità_l = bacheca_controller.loadForm(id_car);
		ObservableList<Necessità> data = FXCollections.observableArrayList(necessità_l);

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
