package bean2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.ShopUser;


public class ShopHomeBoundary {
	


	private static Logger logger = LoggerFactory.getLogger(ShopHomeBoundary.class.getName());
	private static ShopHomeBoundary instance = null;
	
	private ShopUser currentUser;
	private GestisciEventiBoundary gestisciBoundary;
		public GestisciEventiBoundary getGestisciBoundary() {
		return gestisciBoundary;
	}

	public void setGestisciBoundary(GestisciEventiBoundary gestisciBoundary) {
		this.gestisciBoundary = gestisciBoundary;
	}

		public ShopUser getCurrentUser() {
			return currentUser;
		}

		public void setCurrentUser(ShopUser currentUser) {
			this.currentUser = currentUser;
		}
		
		
		public static ShopHomeBoundary getInstance() {
			if (instance == null) {
				instance = new ShopHomeBoundary();
				}
			return instance;
		}

	
   
    void cercaCaritas() {
    	//mo lo faremo, giuro
    }

  
    public void initData(ShopUser user) {
    	setCurrentUser(user);
    }
    

   


  
   public void gestisciEventi() {  		
	   		gestisciBoundary = new GestisciEventiBoundary();
    		gestisciBoundary.setShop(currentUser);
    		gestisciBoundary.loadShop(currentUser.getId());    	
    }

    
    public void helpButtonPressed() {
    	//lo faremo sicuro sicuro
    }



  




}
