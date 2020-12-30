package controller;

import java.io.IOException;
import dao.CaritasRepository;
import dao.ShopRepository;
import dao.VolunteerRepository;
import dao.Login_dao;
import entity.CaritasUser;
import entity.ShopUser;
import entity.VolunteerUser;
import javafx.stage.Window;

public class Login_Controller {
	private Login_dao login;
	private VolunteerRepository vrep;
	
	public Login_Controller() {
		this.login = new Login_dao();
		this.vrep = new VolunteerRepository();
	}
	
   public Object LoginAccess(String user, String pass) {
    	
    
    	
    	String loginResult = login.checkLogin(user,pass);
    	if (loginResult!= null) {
    		
    		
    		//OK MANDA ALLA HOME CORRETTA
    		System.out.println("Login succesfull");
    		System.out.println(login.getTableUser());
    	
    		//Volontario
    		if (login.getTableUser().equals("Volontario") == true) {
    			
    		
    			
    			int userID = login.returnID(user, 1);
    			System.out.println(userID);
    			if (userID == -1) {
    				System.out.println("Errore nel ritornare l'ID");
    			}
    			
    			VolunteerUser loggedUser = vrep.getVolunteerByID(userID);
    			System.out.println(loggedUser.getCognome());
    			loggedUser.setID(userID);
    			
    			return loggedUser;
    			
    		
    			//Manda alla home user
    	
    		}
    		
    		//Caritas
    		else if (login.getTableUser().equals("Negozio") == true) {
    			
    			ShopRepository srep = new ShopRepository(); 

    			int userID = login.returnID(user, 1);
    			System.out.println(userID);
    			if (userID == -1) {
    				System.out.println("Errore nel ritornare l'ID");
    			}
    			
    			ShopUser loggedShop = srep.getShopByID(userID);
    			System.out.println(loggedShop.getNomeShop());
    			loggedShop.setId(userID);
    			
    			return loggedShop;
    			
    		
    		}
    		
    		//Negozio
    		else if (login.getTableUser().equals("Caritas") == true) {
     			CaritasRepository srep = new CaritasRepository(); 

    			int userID = login.returnID(user, 1);
    			System.out.println(userID);
    			if (userID == -1) {
    				System.out.println("Errore nel ritornare l'ID");
    			}
    			
    			CaritasUser loggedCaritas = srep.getCaritasByID(userID);
    			System.out.println(loggedCaritas.getNomeCaritas());
    			loggedCaritas.setId(userID);

    			return loggedCaritas;
    	
    		}
    		
    		
    		    		
    	
    	else  {
    		System.out.println("Login Error");
    	}	

    	}
		return loginResult;
    }

  
  

	public void aprimenu(String cdc) {
		// TODO Auto-generated method stub
		
	}

	
}
