package bean;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	private static Logger logger = LoggerFactory.getLogger(GestisciEventiCaritasBoundary.class.getName());

		private GestisciEventiCaritasController gestEventC;
		private int idCar;
		private String s = "errore IoException";
		private EventTab event;
		private CaritasUser caritas;
		private CaritasHomeBoundary caritasHomeBoundary;
	
		 @FXML
		    private TableView<EventTab> tab;

		    @FXML
		    private TableColumn<EventTab, String> nomeEvento;

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
		    private Button cancellaEvento;

		    @FXML
		    private Button modificaEvento;

		    @FXML
		    private Button contattaNegozio;

		    @FXML
		    private Button back;

		    @FXML
		    boolean cancellaEvent(ActionEvent event) {
		    	return gestEventC.eliminaEvento(this.event.getNomeEvento());

		    }

		    @FXML
		    void modificaEvent(ActionEvent event) {
		    		gestEventC.modificaEvento(this.event.getId());
		    }

		    @FXML
		    void backtomenu(ActionEvent event) {
		   	 try {
		 			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/CaritasHomePage.fxml"));
		 			Parent root = loader.load();
		 			 caritasHomeBoundary = caritasHomeBoundary.getInstance();
		 			caritasHomeBoundary = loader.getController();
		 			caritasHomeBoundary.initData(caritas);
		 			Stage home = (Stage) back.getScene().getWindow();
		 			home.setScene(new Scene(root, 800, 600));
		 			
		 			home.show();
		 		} catch (IOException e) {
					logger.error(s); }

		    	
		    }

		    @FXML
		    void contattaShop(ActionEvent event) {
		    	try {

	    	        FXMLLoader fxmlLoader = new FXMLLoader();
	    	        Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("/boundary/Email.fxml"));
	    	       
	    	        EmailBoundary email;
	    	        email = fxmlLoader.getController();
	    	        email.loadEmail(this.event.getCodiceNegozio(), idCar);
	    	        Stage stage = new Stage();
		    		stage.setTitle("Email");
		    		
		    		
		    		stage.setScene(new Scene(rootNode, 800, 500));
		    		stage.setResizable(false);
		    		stage.show();
		    		
		    		
		    		
		    		
	    		} catch (IOException e) {
					logger.error(s); }

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

		
		
		public void loadShop(int idCar) {
			this.idCar = idCar;
			 List<EventTab> listEv = gestEventC.caricaEventi(this.idCar);

			ObservableList<EventTab> data = FXCollections.observableArrayList(listEv);
			nomeEvento.setCellValueFactory(new PropertyValueFactory<>("NomeEvento"));
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


