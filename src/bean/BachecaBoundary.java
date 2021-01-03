package bean;


import java.io.IOException;
import java.util.List;
import controller.BachecaController;
import entity.Necessità;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class BachecaBoundary {

	private int id_car, id_ute;
	
	@FXML
	private Text nomeCaritas;

	@FXML
	private TextArea cibo;

	@FXML
	private TextArea varie;

	@FXML
	private TextArea vestiti;

	private BachecaController bacheca_controller;
	
	private List<Necessità> necessità;
	
	public BachecaBoundary() {
		
	}
	
	@FXML
	void crea_donazione(ActionEvent event) {
		try {
			
			DonationBoundary donationBoundary = new DonationBoundary();

	        FXMLLoader fxmlLoader = new FXMLLoader();
	        Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("/boundary/Donation.fxml"));
	       
	        donationBoundary = fxmlLoader.getController();
	        
	        Stage stage = new Stage();
    		stage.setTitle("Donazione");
    		donationBoundary.initBoundary(id_car, id_ute);
    		stage.setScene(new Scene(rootNode, 800, 500));
    		stage.setResizable(false);
    		stage.show();
    		
    		
    		
    		
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void crea_email(ActionEvent event) {
		
		EmailBoundary email_c;

		try {     
			
	        FXMLLoader fxmlLoader = new FXMLLoader();

	        Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("/boundary/Email.fxml"));
	        
	        email_c = fxmlLoader.getController();
	        
	        Stage stage = new Stage();
    		stage.setTitle("Email");
    		
    		stage.setScene(new Scene(rootNode, 800, 500));
    		stage.setResizable(false);
    	
    		email_c.load_email(id_car, id_ute);
    		
    		 
    		stage.show();
    		
    		
    		
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}


	@FXML
	void initialize() {
	

		
	}
	
	public void loadFormBoundary(int id_car, int id_ute) {
		this.id_car = id_car;
		this.id_ute = id_ute;
		bacheca_controller = new BachecaController();
		necessità = bacheca_controller.loadForm(id_car, id_ute);
		
		
		for (int i = 0; i < necessità.size(); i++) {
			Necessità tmp = necessità.get(i);
			
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
