package bean;
import java.io.IOException;
import java.util.List;

import controller.GestisciEventiCaritasController;
import entity.CaritasUser;
import entity.EventTab;
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

public class GestisciEventiCaritasBoundary {


		private GestisciEventiCaritasController gestEventC;
		private int idCar;
		private List<EventTab> listEv;
		private EventTab event;
		private CaritasUser caritas;
		private CaritasHomeBoundary CaritasHomeBoundary;
	
		 @FXML
		    private TableView<EventTab> tab;

		    @FXML
		    private TableColumn<EventTab, String> NomeEvento;

		    @FXML
		    private TableColumn<EventTab, String> nomeNegozio;

		    @FXML
		    private TableColumn<EventTab, String> noteEvento;

		    @FXML
		    private TableColumn<EventTab, Float> importo;

		    @FXML
		    private TableColumn<EventTab, Integer> numPartecipanti;
		    
		    @FXML
		    private TableColumn<EventTab, String> stato;

		    @FXML
		    private Button CancellaEvento;

		    @FXML
		    private Button ModificaEvento;

		    @FXML
		    private Button ContattaNegozio;

		    @FXML
		    private Button back;

		    @FXML
		    boolean CancellaEvent(ActionEvent event) {
		    	return gestEventC.eliminaEvento(this.event.getNomeEvento());

		    }

		    @FXML
		    void ModificaEvent(ActionEvent event) {
		    		gestEventC.modificaEvento(this.event.getId());
		    }

		    @FXML
		    void backtomenu(ActionEvent event) {
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
		    void contattaShop(ActionEvent event) {
		    	try {

	    	        FXMLLoader fxmlLoader = new FXMLLoader();
	    	        Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("/boundary/Email.fxml"));
	    	       
	    	       // donationController = fxmlLoader.getController();
	    	        EmailBoundary email = new EmailBoundary();
	    	        email = fxmlLoader.getController();
	    	        System.out.println(this.event.getCodiceNegozio());
	    	        email.loadEmail(this.event.getCodiceNegozio(), idCar);
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
		    void eventClicked(MouseEvent event) {
		    	this.event = tab.getSelectionModel().getSelectedItem();
		    	
		    }


		public CaritasUser getCaritas() {
			return caritas;
		}

		public void setCaritas(CaritasUser caritas) {
			this.caritas = caritas;
		}

		
		
		public void load_shop(int idCar) {
			this.idCar = idCar;
			this.listEv = gestEventC.caricaEventi(this.idCar);
			System.out.println(listEv.get(0).getNomeEvento());

			ObservableList<EventTab> data = FXCollections.observableArrayList(listEv);
			NomeEvento.setCellValueFactory(new PropertyValueFactory<>("NomeEvento"));
			importo.setCellValueFactory(new PropertyValueFactory<>("rapportoDenaro"));
			nomeNegozio.setCellValueFactory(new PropertyValueFactory<>("NomeNegozio"));
			noteEvento.setCellValueFactory(new PropertyValueFactory<>("NoteEvento"));
			numPartecipanti.setCellValueFactory(new PropertyValueFactory<>("NumPartecipanti"));
			stato.setCellValueFactory(new PropertyValueFactory<>("StatoEvento"));
			
			
			tab.setItems(data);
	
		}

		
		
		public GestisciEventiCaritasBoundary(){
			gestEventC = new GestisciEventiCaritasController();
		}
		
		
		
	}


