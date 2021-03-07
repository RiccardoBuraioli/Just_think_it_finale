package bean2;

import java.util.List;
import controller.GestisciEventiCaritasController;
import entity.EventTab;

public class GestisciEventiCaritasBoundary {


		private GestisciEventiCaritasController gestEventC;
		private int idCar;
		
		private EventTab event;
	
		
		
		public boolean cancellaEvent() {
	    	return gestEventC.eliminaEvento(this.event.getNomeEvento());

		 }

		   
		    public void modificaEvent() {
		    		gestEventC.modificaEvento(this.event.getId());
		    }

		  
		   
		    public void contattaShop() {	  
	    	        EmailBoundary email = new EmailBoundary();
	    	        email.loadEmail(this.event.getCodiceNegozio(), idCar);		    	
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


