package bean2;




import java.util.List;

import controller.GestioneTurniCaritas;
import entity.CaritasUser;
import entity.TurnoTab;



public class GestisciTurniBoundary {

	    
	    
	    private TurnoTab turn;
	   
		private CaritasUser caritas;
	    private GestioneTurniCaritas gestTurn;
	    private CaritasUser currentUser;
	    public CaritasUser getCurrentUser() {
			return currentUser;
		}

		private CreaTurnoBoundary caritasTurniBoundary;
	    
	    private CaritasHomeBoundary caritasHomeBoundary;
	    private boolean check;
	   
	    
	    public GestisciTurniBoundary() {
	    	this.gestTurn = new GestioneTurniCaritas();
	    	this.caritasTurniBoundary = new CreaTurnoBoundary();
	    }
	    
	   
	    public boolean cancellaTurno(String i) {
	    	if (i == null || i == "") {
	    		return false;
	    	}
	    	else {
	    		int x = Integer.parseInt(i);
	    		gestTurn.cancellaTurno(x);
	    		return true;
	    	}
	    }

	   
	   public void creaTurno() {	 		
	 		this.caritasTurniBoundary.setCaritas(caritas);	    	
	    }

	   
	   public boolean ModificaTurno(String note) {
			   if (note == null || note == "") {
				   return false;
			   }else {
		    	check = gestTurn.modificaTurno(turn.getId(),note,turn.getIdCar()); //posso mettere i numeri per farlo funzionare
		    	return true;
			   }
		    }

	   
	   public void backPressed() {
	 		caritasHomeBoundary = CaritasHomeBoundary.getInstance();
	    }

	  
	   /* void turnSelected() {
	    	this.turn= tab.getSelectionModel().getSelectedItem();

	    }*/

		public void setCurrentUser(CaritasUser currentUser) {
			this.caritas = currentUser;
			
		}

		public List<TurnoTab> loadFormBoundary(int id) {
			 List<TurnoTab> listTurni =  gestTurn.caricaTurni(id);

			/*ObservableList<TurnoTab> data = FXCollections.observableArrayList(listT);
			this.giorno.setCellValueFactory(new PropertyValueFactory<>("giorno"));
			this.orario.setCellValueFactory(new PropertyValueFactory<>("orario"));
			this.note.setCellValueFactory(new PropertyValueFactory<>("note"));
			this.numParte.setCellValueFactory(new PropertyValueFactory<>("partecipanti"));

			tab.setItems(data);*/
			return listTurni;
		}


	}


