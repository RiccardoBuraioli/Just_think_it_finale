package bean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controller.GestisciDonazioniCaritas;
import entity.CaritasUser;
import entity.DonazioneTab;
import entity.TurnoTab;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GestisciDonazioniBoundary {
	
		@FXML
	    private TableView<DonazioneTab> table;

	    @FXML
	    private TableColumn<DonazioneTab, String> tipologia;

	    @FXML
	    private TableColumn<DonazioneTab, String> descrizione;

	    @FXML
	    private TableColumn<DonazioneTab, String> indirizzo;
	    
	    @FXML
	    private TableColumn<DonazioneTab, String> stato;


	    @FXML
	    private Button ritira;

	    @FXML
	    private Button contatta;

	    @FXML
	    private Button back;
	    
	    @FXML
	    private Button Cancella;
	    
	    private List<DonazioneTab> listDon;

	    private CaritasUser caritas;
	    
	    private int idVolontario, idDono;
	    
	    private GestisciDonazioniCaritas gestDon;
	    private CaritasHomeBoundary CaritasHomeBoundary;
	   

	    @FXML
	    void CancellaDonazione(ActionEvent event) {

	    	gestDon.CancellaDonazione(this.idDono);
	    	
	    }
	    
	    @FXML
	    void backPressed(ActionEvent event) {
	   	 try {
	 			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/CaritasHomePage.fxml"));
	 			Parent root = loader.load();
	 			 CaritasHomeBoundary = CaritasHomeBoundary.getInstance();
	 			CaritasHomeBoundary = loader.getController();
	 			CaritasHomeBoundary.initData(caritas);
	 			Stage home = (Stage) back.getScene().getWindow();
	 			home.setScene(new Scene(root, 800, 600));
	 			
	 			home.show();
	 		} catch (IOException e) {
	 			e.printStackTrace();
	 		}
	    }

	    @FXML
	    void contattaVolontario(ActionEvent event) {
	    	try {

    	        FXMLLoader fxmlLoader = new FXMLLoader();
    	        Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("/boundary/Email.fxml"));
    	       
    	       // donationController = fxmlLoader.getController();
    	        EmailBoundary email = new EmailBoundary();
    	        email = fxmlLoader.getController();
    	        email.load_email(this.idVolontario, this.caritas.getID());
    	        Stage stage = new Stage();
	    		stage.setTitle("Email");
	    		
	    		
	    		stage.setScene(new Scene(rootNode, 800, 500));
	    		stage.setResizable(false);
	    		stage.show();
	    		
	    		
	    		
	    		
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
	    }

	    @FXML
	    void ritiraDonazione(ActionEvent event) {
	    	gestDon.ritiraDon(this.idDono);
	    	
	    	
	    }
	    
	    @FXML
	    void donationSelect(MouseEvent event) {
	    	this.idVolontario = table.getSelectionModel().getSelectedItem().getCodVol();
	    	this.idDono = table.getSelectionModel().getSelectedItem().getIdDon();
	    }
	        

		public void loadFormBoundary() {
		this.listDon = gestDon.visualizzaDonazioni(this.caritas.getID());
		ObservableList<DonazioneTab> data = FXCollections.observableArrayList(this.listDon);
		this.tipologia.setCellValueFactory(new PropertyValueFactory<>("tipologia"));
		this.descrizione.setCellValueFactory(new PropertyValueFactory<>("Descrizione"));
		this.indirizzo.setCellValueFactory(new PropertyValueFactory<>("indirizzo"));
		this.stato.setCellValueFactory(new PropertyValueFactory<>("stato"));
		table.setItems(data);
			
		}
		

		public GestisciDonazioniBoundary() {
			this.gestDon = new GestisciDonazioniCaritas();
			listDon = new ArrayList<DonazioneTab>();
		}
		
		public CaritasUser getCaritas() {
			return this.caritas;
		}

		public void setCaritas(CaritasUser caritas) {
			this.caritas = caritas;
		}

		
	}


