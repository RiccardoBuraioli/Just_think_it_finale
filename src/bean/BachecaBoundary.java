package bean;


import java.util.List;
import controller.Bacheca_Controller;
import entity.Necessit�;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;


public class BachecaBoundary {


	@FXML
	private Text nomeCaritas;

	@FXML
	private TextArea cibo;

	@FXML
	private TextArea varie;

	@FXML
	private TextArea vestiti;

	private Bacheca_Controller bacheca_controller;
	
	private List<Necessit�> necessit�;
	
	public BachecaBoundary() {
		
	}
	
	@FXML
	void crea_donazione(ActionEvent event) {
		bacheca_controller.crea_donazione();
	}

	@FXML
	void crea_email(ActionEvent event) {
		bacheca_controller.crea_email();
		
		
	}

	@FXML
	void indietro(ActionEvent event) {

	}

	@FXML
	void initialize() {
	

		
	}
	
	public void loadFormBoundary(int id_car, int id_ute) {
		bacheca_controller = new Bacheca_Controller();
		necessit� =bacheca_controller.loadForm(id_car, id_ute);
		
		for (int i = 0; i < necessit�.size(); i++) {
			Necessit� tmp = necessit�.get(i);
			
			switch (tmp.getTipologia()) {
				case "Vestiti":
					vestiti.setText(tmp.getDescrizione());
					break;
	
				case "Cibo":
					cibo.setText(tmp.getDescrizione());
	
				case "Varie":
					varie.setText(tmp.getDescrizione());
					break;
	
				default:
					break;

			}

		}

	}

}
