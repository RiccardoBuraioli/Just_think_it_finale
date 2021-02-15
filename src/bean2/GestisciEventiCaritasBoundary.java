package bean2;
import java.io.IOException;
import java.util.List;

import controller.GestisciEventiCaritasController;
import entity.CaritasUser;
import entity.EventTab;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GestisciEventiCaritasBoundary {


		private GestisciEventiCaritasController gestEventC;
		private int idCar;
		
		private EventTab event;
		private CaritasUser caritas;
		private CaritasHomeBoundary caritasHomeBoundary;
	
		
		
		    public boolean cancellaEvent() {
		    	return gestEventC.eliminaEvento(this.event.getNomeEvento());

		    }

		   
		    public void modificaEvent() {
		    		gestEventC.modificaEvento(this.event.getId());
		    }

		    
		    public void backtomenu() {
		 			caritasHomeBoundary = caritasHomeBoundary.getInstance();
		    }

		   
		    public void contattaShop() {
		    	
	    	  
	    	       
	    	        EmailBoundary email = null;
	    	        //email = fxmlLoader.getController();
	    	        email.loadEmail(this.event.getCodiceNegozio(), idCar);
	    	      
		    		
		    		
		    		
		    	
		    }

		   /* @FXML
		    void eventClicked(MouseEvent event) {
		    	this.event = tab.getSelectionModel().getSelectedItem();
		    	
		    }*/


		public CaritasUser getCaritas() {
			return caritas;
		}

		public void setCaritas(CaritasUser caritas) {
			this.caritas = caritas;
		}

		
		
		public List<EventTab> loadShop(int idCar) {
			this.idCar = idCar;
			 List<EventTab> listEv = gestEventC.caricaEventi(this.idCar);
			return listEv;	
		}

		
		
		public GestisciEventiCaritasBoundary(){
			gestEventC = new GestisciEventiCaritasController();
		}
		
		
		
	}


