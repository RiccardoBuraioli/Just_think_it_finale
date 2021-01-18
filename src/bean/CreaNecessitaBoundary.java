package bean;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.CreaNecessitaController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class CreaNecessitaBoundary {

	private static Logger logger = LoggerFactory.getLogger(CreaNecessitaBoundary.class.getName());

		private String[] tipo= { "Vestiti", "Cibo" };
		private String[] urg = {"Alta", "Normale", "Bassa"};

	    @FXML
	    private TextArea descrizione;

	    @FXML
	    private ChoiceBox<String> tipologia;

	    @FXML
	    private ChoiceBox<String> urgenza;

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
	    	CreaNecessitaController creaNec = new CreaNecessitaController();
	    	creaNec.inizializza(idCaritas);
	    	int i = creaNec.creaNecessita(tipologia.getValue().toString(), urgenza.getValue().toString(), descrizione.getText());
	    	if ( i == 0) {
	    		Stage st = (Stage) creaAnnuncio.getScene().getWindow();
	    		st.close();
	    	}
	    	else logger.trace("errore nella creazione dell'annuncio");
	    }

	    
	    @FXML
	    void initialize() {
	    	tipologia.getItems().addAll(tipo);
	    	urgenza.getItems().addAll(urg);
	    
	    
	    }
	    
	    public void setCaritas(int idCar) {
	    	this.idCaritas = idCar;
	    }
	    
	

}
