package bean2;

import java.io.IOException;
import java.util.List;

import controller.BachecaPersonaleController;
import entity.CaritasUser;
import entity.Necessita;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BachecaPersonaleBoundary {
	
	private int idCar;
	private BachecaPersonaleController bachecaController;
	private CaritasHomeBoundary caritasHomeBoundary;
	private CreaNecessitaBoundary creaNec;
	private CaritasUser caritas;
	private Necessita nec;
	private int i;
	
	public int getI() {
		return i;
	}



	public void setI(int i) {
		this.i = i;
	}



	public Necessita getNec() {
		return nec;
	}



	public void setNec(Necessita nec) {
		this.nec = nec;
	}



	public CaritasUser getCaritas() {
		return caritas;
	}



	public void setCaritas(CaritasUser caritas) {
		this.caritas = caritas;
	}

	
	
	public CreaNecessitaBoundary getCreaNec() {
		return creaNec;
	}



	public void setCreaNec(CreaNecessitaBoundary creaNec) {
		this.creaNec = creaNec;
	}



	public CaritasHomeBoundary getCaritasHomeBoundary() {
		return caritasHomeBoundary;
	}



	public void setCaritasHomeBoundary(CaritasHomeBoundary caritasHomeBoundary) {
		this.caritasHomeBoundary = caritasHomeBoundary;
	}


	

	
	public void backPressed() {
		caritasHomeBoundary = caritasHomeBoundary.getInstance();	
	}

	
	
	
	public void creaNecessita() {
			 creaNec.setCaritas(idCar);
	}

	
	public boolean eliminaNecessita(String i){
		bachecaController = new BachecaPersonaleController();
		if (i == null || i.equals("")) {
			return false;
		}
		else {
			int x = Integer.parseInt(i);
			bachecaController.eliminaAnnuncio(x);
			return true;
		}
	}

	private CaritasUser currentUser;

	public CaritasUser getCurrentUser() {
		return currentUser;
	}



	public List<Necessita> loadFormBoundary(int id) {
		bachecaController = new BachecaPersonaleController();
		List<Necessita> necessitaList = bachecaController.loadForm(id);
		return necessitaList;	
	}
	
	
	public void setCurrentUser(CaritasUser user) {
		this.caritas = user;
	}
	
	public CaritasUser getcaritas() {
		return this.caritas;
	}
	

}
