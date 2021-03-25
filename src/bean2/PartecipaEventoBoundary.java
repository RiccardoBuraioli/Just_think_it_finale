package bean2;

import java.util.ResourceBundle;

import controller.DonationController;
import controller.PartecipaEventoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PartecipaEventoBoundary {

	private int idUtente;
	private int idEvento;
	private PartecipaEventoController parteCon;
	private String importo;

	private static PartecipaEventoBoundary instance = null;
	 
	public static PartecipaEventoBoundary getInstance() {
		if(instance == null) {
			instance = new PartecipaEventoBoundary();
		}
		return instance;
		}
	
	public PartecipaEventoBoundary() {
		parteCon = PartecipaEventoController.getInstance();
	}


	public int partecipaEvento() {
		PartecipaEventoController parteCon = new PartecipaEventoController();
		parteCon.setDataController(idEvento, idUtente);
		parteCon.partecipaEvento(Float.parseFloat(importo));
		return 0;
	}

	

	
	public void setData(int idEvento, int idVolontario) {
		this.idEvento = idEvento;
		this.idUtente = idVolontario;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public int getIdEvento() {
		return idEvento;
	}

}
