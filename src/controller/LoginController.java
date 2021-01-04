package controller;

import dao.CaritasRepository;
import dao.ShopRepository;
import dao.VolunteerRepository;
import dao.LoginDao;
import entity.CaritasUser;
import entity.ShopUser;
import entity.VolunteerUser;

public class LoginController {
	private LoginDao login;
	private VolunteerRepository vrep;
	
	public LoginController() {
		this.login = new LoginDao();
		this.vrep = new VolunteerRepository();
	}
	
   public Object loginAccess(String user, String pass) {
    	
    
    	
    	String loginResult = login.checkLogin(user,pass);
    	if (loginResult!= null) {
    		
    		
    		//OK MANDA ALLA HOME CORRETTA
    	
    	
    		//Volontario
    		if (login.getTableUser().equals("Volontario")) {
    			
    		
    			
    			int userID = login.returnID(user);
    			if (userID == -1) {
    				System.out.println("Errore nel ritornare l'ID");
    			}
    			
    			VolunteerUser loggedUser = vrep.getVolunteerByID(userID);
    			loggedUser.setID(userID);
    			
    			return loggedUser;
    			
    		
    			//Manda alla home user
    	
    		}
    		
    		//Caritas
    		else if (login.getTableUser().equals("Negozio")) {
    			
    			ShopRepository srep = new ShopRepository(); 

    			int userID = login.returnID(user);
    			if (userID == -1) {
    				System.out.println("Errore nel ritornare l'ID");
    			}
    			
    			ShopUser loggedShop = srep.getShopByID(userID);
    			loggedShop.setId(userID);
    			
    			return loggedShop;
    			
    		
    		}
    		
    		//Negozio
    		else if (login.getTableUser().equals("Caritas")) {
     			CaritasRepository srep = new CaritasRepository(); 

    			int userID = login.returnID(user);
    			if (userID == -1) {
    				System.out.println("Errore nel ritornare l'ID");
    			}
    			
    			CaritasUser loggedCaritas = srep.getCaritasByID(userID);
    			loggedCaritas.setId(userID);

    			return loggedCaritas;
    	
    		}
    		
    		
    		    		
    	
    	else  {
    		System.out.println("Login Error");
    	}	

    	}
		return loginResult;
    }

 
	
}
