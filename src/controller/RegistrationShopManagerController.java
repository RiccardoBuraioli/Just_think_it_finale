package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import bean.ShopHomeBoundary;
import dao.ShopRepository;
import entity.ShopUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

public  class RegistrationShopManagerController implements Initializable {

	private ShopUser shop;
	private ShopRepository crep;


	public RegistrationShopManagerController() {
		
	}

	public void backButtonNegPressed(Window window) {

	
	}

	public int registraNegozioPressed( String tipo, String nome, String pass, String via, String tel,String mail, String città) {

		shop = new ShopUser(nome, pass, via, tipo, tel, mail, città);
		crep = new ShopRepository();
		int id = crep.insertShop(shop);
		shop.setId(id);

		// Manda alla home Shop
	

		return 0;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}