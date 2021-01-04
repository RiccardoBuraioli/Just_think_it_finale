package bean;


import java.net.URL;
import java.util.ResourceBundle;

import controller.DonationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DonationBoundary implements Initializable {

	@FXML
	private RadioButton vestiti;

	@FXML
	private RadioButton cibo;

	@FXML
	private Button donazione;

	@FXML
	private Button indietro;

	@FXML
	private TextField indirizzo;

	@FXML
	private TextArea descrizione;

	private TextField[] textFields;

	private DonationController controller;

	public DonationBoundary() {
		controller = DonationController.getInstance();
	}
	
	
	
	@FXML
	void Back(MouseEvent event) {

	}

	@FXML
	public void creaDonazione(ActionEvent event) {

		checker();		
		controller.setIndirizzo(this.indirizzo.getText());
		controller.setDescrizione(this.descrizione.getText());
		int error = controller.creaDonazione();
		Stage st = (Stage) donazione.getScene().getWindow();
		st.close();
		
		

	}
	

	public void initialize(URL location, ResourceBundle resources) {
		textFields = new TextField[] { indirizzo };
		
	}
	
	
public int checker() {
    	
    	//Controlla che non ci siano campi lasciati vuoti
    	for (int i = 0; i < textFields.length; i++) {
			if (textFields[i].getText().isEmpty()) {
				
				return -1;
			}
		//	else if (type.isSelected() || type2.isSelected()) {
			else if(cibo.isSelected()) {
				controller.setTipologia(2);
	    		//Almeno uno dei tipi deve essere selezionato
			}else if(vestiti.isSelected()) {
				controller.setTipologia(1);
				//Almeno uno dei tipi deve essere selezionato
			}else {
		
			}
		}
		return 0;
    	
  }

	public void initBoundary(int idCar, int idUte) {
		controller.initController(idCar, idUte);
	}




}
