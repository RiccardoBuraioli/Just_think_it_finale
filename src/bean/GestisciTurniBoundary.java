package bean;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.GestioneTurniCaritas;
import entity.CaritasUser;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class GestisciTurniBoundary {
	private static Logger logger = LoggerFactory.getLogger(GestisciTurniBoundary.class.getName());
	private String s = "errore IoException";
		@FXML
		private TextArea newNote;
  
		@FXML
		private TableView<TurnoTab> tab;
		
		@FXML
		private Button cancTurn;

		@FXML
		private Button modTurn;

		@FXML
		private Button creaTurn;

		@FXML
	    private TableColumn<TurnoTab, String> giorno;

	    @FXML
	    private TableColumn<TurnoTab, String> orario;

	    @FXML
	    private TableColumn<TurnoTab, String> numParte;

	    @FXML
	    private TableColumn<TurnoTab, String> note;
	    
	    @FXML
	    private Button richieste;
    
	    @FXML
	    private Button back;

	    
	    
	    private TurnoTab turn;
	    
	
		
		private CaritasUser caritas;

	    private GestioneTurniCaritas gestTurn;
	    
	    private CreaTurnoBoundary caritasTurniBoundary;
	    
	    private CaritasHomeBoundary caritasHomeBoundary;
	    
	   
	    
	    public GestisciTurniBoundary() {
	    	this.gestTurn = new GestioneTurniCaritas();
	    	this.caritasTurniBoundary = new CreaTurnoBoundary();
	    }
	    
	    @FXML
	    void cancellaTurno(ActionEvent event) {
	    	gestTurn.cancellaTurno(turn.getId());
	    }

	    @FXML
	    void creaTurno(ActionEvent event) {
	    		
	   	 try {
	 			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/CreaTurno.fxml"));
	 			Parent root = loader.load();
	 		
	 			this.caritasTurniBoundary = loader.getController();
	 			this.caritasTurniBoundary.setCaritas(caritas);
	 			Stage home = (Stage) creaTurn.getScene().getWindow();
	 			home.setScene(new Scene(root, 770, 500));
	 			
	 			home.show();
	 		} catch (IOException e) {
				logger.error(s); }

	    	
	    	
	    	
	    }

	    @FXML
	    void modificaTurno(ActionEvent event) {
	    	gestTurn.modificaTurno(turn.getId(), newNote.getText(), turn.getIdCar());
	    
	    }

	    @FXML
	    void backPressed(ActionEvent event) {
	   	 try {
	 			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/CaritasHomePage.fxml"));
	 			Parent root = loader.load();
	 			 caritasHomeBoundary = caritasHomeBoundary.getInstance();
	 			caritasHomeBoundary = loader.getController();
	 			caritasHomeBoundary.initDataCaritas(caritas);
	 			Stage home = (Stage) back.getScene().getWindow();
	 			home.setScene(new Scene(root, 800, 600));
	 			
	 			home.show();
	 		} catch (IOException e) {
				logger.error(s); }

	    	
	    }

	    @FXML
	    void turnSelected(MouseEvent event) {
	    	this.turn= tab.getSelectionModel().getSelectedItem();

	    }

		public void setCurrentUser(CaritasUser currentUser) {
			this.caritas = currentUser;
			
		}

		public void loadFormBoundary(int id) {
			
			 List<TurnoTab> listT = gestTurn.caricaTurni(id);

			ObservableList<TurnoTab> data = FXCollections.observableArrayList(listT);
			this.giorno.setCellValueFactory(new PropertyValueFactory<>("giorno"));
			this.orario.setCellValueFactory(new PropertyValueFactory<>("orario"));
			this.note.setCellValueFactory(new PropertyValueFactory<>("note"));
			this.numParte.setCellValueFactory(new PropertyValueFactory<>("partecipanti"));

			tab.setItems(data);
		
		}


	}


