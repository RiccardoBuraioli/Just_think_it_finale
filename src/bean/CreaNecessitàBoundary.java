package bean;
import java.util.List;

import controller.CreaNecessit‡Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class CreaNecessit‡Boundary {

	
		private String[] tipo= { "Vestiti", "Cibo" };
		private String[] urg = {"Alta", "Normale", "Bassa"};

	    @FXML
	    private TextArea descrizione;

	    @FXML
	    private ChoiceBox<String> tipologia;

	    @FXML
	    private ChoiceBox<String> Urgenza;

	    @FXML
	    private Button creaAnnuncio;

	    @FXML
	    private Button back;
	    
		private int idCaritas;

	    @FXML
	    void backPressed(ActionEvent event) {

	    }

	    @FXML
	    void creaAnnuncioPressed(ActionEvent event) {
	    	CreaNecessit‡Controller creaNec = new CreaNecessit‡Controller();
	    	creaNec.inizializza(idCaritas);
	    	int i = creaNec.creaNecessit‡(tipologia.getValue().toString(), Urgenza.getValue().toString(), descrizione.getText());
	    	if ( i == 0) {
	    		Stage st = (Stage) creaAnnuncio.getScene().getWindow();
	    		st.close();
	    	}
	    	else System.out.println("errore nella creazione dell'annuncio");
	    }

	    
	    @FXML
	    void initialize() {
	    	tipologia.getItems().addAll(tipo);
	    	Urgenza.getItems().addAll(urg);
	    
	    
	    }
	    
	    public void setCaritas(int idCar) {
	    	this.idCaritas = idCar;
	    }
	    
	

}
