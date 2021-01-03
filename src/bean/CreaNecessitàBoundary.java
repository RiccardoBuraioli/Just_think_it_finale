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
	    private Button crea_annuncio;

	    @FXML
	    private Button back;
	    
		private int id_caritas;

	    @FXML
	    void backPressed(ActionEvent event) {

	    }

	    @FXML
	    void crea_annuncio_pressed(ActionEvent event) {
	    	CreaNecessit‡Controller crea_nec_c = new CreaNecessit‡Controller();
	    	crea_nec_c.inizializza(id_caritas);
	    	int i = crea_nec_c.crea_necessit‡(tipologia.getValue().toString(), Urgenza.getValue().toString(), descrizione.getText());
	    	if ( i == 0) {
	    		Stage st = (Stage) crea_annuncio.getScene().getWindow();
	    		st.close();
	    	}
	    	else System.out.println("errore nella creazione dell'annuncio");
	    }

	    
	    @FXML
	    void initialize() {
	    	tipologia.getItems().addAll(tipo);
	    	Urgenza.getItems().addAll(urg);
	    
	    
	    }
	    
	    public void set_caritas(int id_car) {
	    	this.id_caritas = id_car;
	    }
	    
	

}
