package bean2;


import controller.CreaNecessitaController;
import entity.CaritasUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class CreaNecessitaBoundary {
	
	   private BachecaPersonaleBoundary bachPersonale;
	
		
		public BachecaPersonaleBoundary getBachPersonale() {
		return bachPersonale;
	}

	public void setBachPersonale(BachecaPersonaleBoundary bachPersonale) {
		this.bachPersonale = bachPersonale;
	}



		private int idCaritas;
		private CaritasUser caritas;
	   
	  

	    public CaritasUser getCaritas() {
			return caritas;
		}



		private String richiesta;
	    private String tipologia;
	    private String urgenza;
	  
	    
		
	   public void backPressed() {
		   bachPersonale.setCurrentUser(caritas);
	    }
	 
	    public int creaAnnuncioPressed(String tipologia,String urgenza,String richiesta) {
	    	CreaNecessitaController creaNec = new CreaNecessitaController();
	    	creaNec.inizializza(idCaritas);
	    	int i = creaNec.creaNecessita(tipologia, urgenza, richiesta);
	    	return i;
	    }

	    
	    public String getRichiesta() {
			return richiesta;
		}

		public void setRichiesta(String richiesta) {
			this.richiesta = richiesta;
		}

		public String getTipologia() {
			return tipologia;
		}

		public void setTipologia(String tipologia) {
			this.tipologia = tipologia;
		}

		public String getUrgenza() {
			return urgenza;
		}

		public void setUrgenza(String urgenza) {
			this.urgenza = urgenza;
		}

	

		  
	    public void setCaritas(int idCar) {
	    	this.idCaritas = idCar;
	    }
	    
	    
	

}
