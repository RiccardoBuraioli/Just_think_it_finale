package controller;

import java.io.IOException;

import bean.Caritas_Home_Boundary;
import bean.Shop_Home_Boundary;
import bean.User_Home_Boundary;
import dao.CaritasRepository;
import dao.ShopRepository;
import dao.VolunteerRepository;
import dao.Login_dao;
import entity.CaritasUser;
import entity.Login;
import entity.ShopUser;
import entity.VolunteerUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Login_Controller {
	private Login_dao login;
	private VolunteerRepository vrep;
	
	public Login_Controller() {
		this.login = new Login_dao();
		this.vrep = new VolunteerRepository();
	}
	
   public void LoginAccess(Window window, String user, String pass) {
    	
    
    	
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
    			
    			try {
        			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/UserHomePage.fxml"));
        			Parent root = loader.load();
        			User_Home_Boundary UserHomeBoundary = loader.getController();
        			UserHomeBoundary.initData(loggedUser);
        			Stage home = (Stage) window.getScene().getWindow();
        			home.setScene(new Scene(root, 800, 600));
        			
        			home.show();
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
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
    			try {
        			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/ShopHomePage.fxml"));
        			Parent root = loader.load();
        			Shop_Home_Boundary ShopHomeBoundary = loader.getController();
        			ShopHomeBoundary.initData(loggedShop);
        			Stage home = (Stage) window.getScene().getWindow();
        			home.setScene(new Scene(root, 800, 600));
        			
        			home.show();
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
    			
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

    			try {
        			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/CaritasHomePage.fxml"));
        			Parent root = loader.load();
        			Caritas_Home_Boundary CaritasHomeController = loader.getController();
        			CaritasHomeController.initData(loggedCaritas);
        			Stage home = (Stage) window.getScene().getWindow();
        			home.setScene(new Scene(root, 800, 600));
        			
        			home.show();
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
    			
    		}
    		
    		
    		    		
    	
    	else  {
    		System.out.println("Login Error");
    	}	

    	}
    }

  
    public void registrazionePressed(Window window) {
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/boundary/RegistrazioneMenu.fxml"));
			Stage signUp = (Stage) window.getScene().getWindow();
			Scene scene = new Scene(root,600,400);
			signUp.setScene(scene);
			signUp.show();
			signUp.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

	public void aprimenu(String cdc) {
		// TODO Auto-generated method stub
		
	}

	
}
