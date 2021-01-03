package bean;

import java.io.IOException;
import java.util.List;
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

	    private List<TurnoTab> listT;
	    
	    private TurnoTab turn;
	    
		private int idCaritas;
		
		private CaritasUser caritas;

	    private GestioneTurniCaritas gestTurn;
	    
	    private CreaTurnoBoundary CaritasTurniBoundary;
	    
	    private CaritasHomeBoundary CaritasHomeBoundary;
	    
	    private boolean check;
	    
	    public GestisciTurniBoundary() {
	    	this.gestTurn = new GestioneTurniCaritas();
	    	this.CaritasTurniBoundary = new CreaTurnoBoundary();
	    }
	    
	    @FXML
	    void CancellaTurno(ActionEvent event) {
	    	check = gestTurn.cancella_turno(turn.getId());
	    }

	    @FXML
	    void CreaTurno(ActionEvent event) {
	    		
	   	 try {
	 			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/CreaTurno.fxml"));
	 			Parent root = loader.load();
	 		
	 			this.CaritasTurniBoundary = loader.getController();
	 			this.CaritasTurniBoundary.setCaritas(caritas);
	 			Stage home = (Stage) creaTurn.getScene().getWindow();
	 			home.setScene(new Scene(root, 770, 500));
	 			
	 			home.show();
	 		} catch (IOException e) {
	 			e.printStackTrace();
	 		}
	    	
	    	
	    	
	    }

	    @FXML
	    void ModificaTurno(ActionEvent event) {
	    	check = gestTurn.modificaTurno(turn.getId(), newNote.getText(), turn.getIdCar());
	    	if(check == true) {
	    		System.out.println("dajeru");
	    	}
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
	    void turnSelected(MouseEvent event) {
	    	this.turn= tab.getSelectionModel().getSelectedItem();

	    }

		public void set_currentUser(CaritasUser currentUser) {
			this.caritas = currentUser;
			
		}

		public void loadFormBoundary(int id) {
			this.idCaritas = id;
			this.listT = gestTurn.carica_turni(this.idCaritas);

			ObservableList<TurnoTab> data = FXCollections.observableArrayList(this.listT);
			this.giorno.setCellValueFactory(new PropertyValueFactory<>("giorno"));
			this.orario.setCellValueFactory(new PropertyValueFactory<>("orario"));
			this.note.setCellValueFactory(new PropertyValueFactory<>("note"));
			this.numParte.setCellValueFactory(new PropertyValueFactory<>("partecipanti"));

			tab.setItems(data);
		
		}


	}


