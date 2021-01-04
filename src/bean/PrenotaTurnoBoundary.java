package bean;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.PrenotaTurnoController;
import dao.PrenotaDao;
import entity.Orario;
import entity.Turno;
import entity.PartecipaTurno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PrenotaTurnoBoundary {
		private int idCaritas;
		private int idVolontario;
		private List<Orario> oraArrayList;
		private String[] giorni;
		
		
		
		private PrenotaTurnoController PrenotaC;
	
	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private ChoiceBox<String> Turni;

	    @FXML
	    private ChoiceBox<String> CBoraInizio;

	    @FXML
	    private ChoiceBox<String> CBoraFine;

	    @FXML
	    private TextField CV;

	    @FXML
	    private Button indietro;

	    @FXML
	    private Button prenota;
	    
	    @FXML
	    void indietro(ActionEvent event) {

	    }
	    
	    
	    public PrenotaTurnoBoundary() {
	    	
	    }
	    
	    @FXML
	    void prenotaTurno(ActionEvent event) { 
		
	    	PrenotaC.prenotaTurno(Turni.getValue().toString(), CBoraInizio.getValue().toString(), CBoraFine.getValue().toString(), CV.getText());
	    	Stage st = (Stage) prenota.getScene().getWindow();
	    	st.close();
		}
	    
	    public boolean checker() {
	    	
	    	 
			//Controlla che non ci siano campi lasciati vuoti
	    	
				if (CV.getText().isEmpty()) {
					
					return false;
				}
			return true;
	    	
	  }
	    

	    @FXML
	    void initialize() {
	    	PrenotaC = new PrenotaTurnoController();
	    	
	    	this.giorni = new String[8];
		
	    	
	    	giorni = PrenotaC.inizializzaGiorni();
	   
	    	
	    	for(int i=0; i<8; i++) {
	    		Turni.getItems().add(giorni[i]);
	    	}
	    	
	    	
	    	oraArrayList =PrenotaC.initializzaOrari();
	    	//ora = (Orario[]) oraArrayList.toArray();
	    	
	    	int i = 0;
	    	while(i<oraArrayList.size()) {
	    
		    	CBoraInizio.getItems().add(oraArrayList.get(i).getOraFine());
		    	
		    	CBoraFine.getItems().add(oraArrayList.get(i).getOraInizio());
		    	
		    	i++;
		    	
	    	}
	    	
	    }
	    
	    public void setData(int idCar, int idUte) {
		  	PrenotaC.setDataController(idCar, idUte);
		  }
}
