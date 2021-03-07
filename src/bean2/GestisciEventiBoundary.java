package bean2;


import java.util.List;

import controller.GestisciEventiController;
import entity.CaritasUser;
import entity.EventTab;
import entity.ShopUser;


public class GestisciEventiBoundary {

	private GestisciEventiController gestEventC;
	private int idShop;
	
	private EventTab event;
	private ShopUser shop;
	private ShopHomeBoundary shopHomeBoundary;
	


	
	    public void backButtonPressed() {
	    	shopHomeBoundary = shopHomeBoundary.getInstance();
	    }

	   
	   public void contattaCaritas() {
    	        EmailBoundary email = new EmailBoundary();
    	        email.loadEmail(this.idShop, this.event.getIdCaritas());  	
	    }

	    
	   public boolean eliminaEvento(String i) {
		   if (i == null || i.equals("")) {
			   return true;
		   }
		   else {
			   return gestEventC.eliminaEvento(i); 
		   }
	    }

	    
	    void modificaEvento() {
	    	//non si sa se è da fare o no
	    }

	  /*  @FXML
	    void prendiEvento(MouseEvent e) {
	    	this.event = table.getSelectionModel().getSelectedItem();	
	    }*/


	public GestisciEventiBoundary() {

		gestEventC = new GestisciEventiController();

	}

	public GestisciEventiBoundary(int i) {
		gestEventC = new GestisciEventiController();
		this.idShop = i;

	}
	
	
	

	public List<EventTab> loadShop(int idShop) {
		this.idShop = idShop;
		List<EventTab> listEv = gestEventC.caricaEventi(this.idShop);
		return listEv;
	}
	

	public ShopUser getShop() {
		return shop;
	}

	public void setShop(ShopUser shop) {
		this.shop = shop;
	}

	public void setCaritas(CaritasUser currentUser) {
		// TODO Auto-generated method stub
		
	}

}