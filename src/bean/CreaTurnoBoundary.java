package bean;

import java.io.IOException;

import controller.Prenota_turno_controller;
import entity.CaritasUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class CreaTurnoBoundary {
		
		
		
	    @FXML
	    private Button back;

	    @FXML
	    private Button creaTurno;

	    @FXML
	    private TextArea note;

	    @FXML
	    private TextField orain;

	    @FXML
	    private TextField oraFin;

	    @FXML
	    private ChoiceBox<String> giorni;

	    @FXML
	    private TextField numParte;
	    
	    private CaritasUser caritas;

	    @FXML
	    void backPressed(ActionEvent event) {
	   	 try {
	 			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/CaritasHomePage.fxml"));
	 			Parent root = loader.load();
	 			Caritas_Home_Boundary CaritasHomeBoundary = Caritas_Home_Boundary.getInstance();
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
	    void creaTurnoPressed(ActionEvent event) {

	    }

	    
	    
	    private void setCaritas(CaritasUser caritas) {
	    	this.caritas = caritas;
	    }
	    
	    

	    @FXML
	    void initialize() {
	    	
	    	String[] days = {"Lunedi","Martedì","Mercoledi", "Giovedi", "Venerdi", "Sabato","Domenica"};	    	
	    
	    	for (int i = 0; i<8; i++) {
	    	giorni.setItems(FXCollections.observableArrayList(
	    		  days[i])
	    		);}
	    	
	    
	    	
	    }
	    
	    
	    
}

	

