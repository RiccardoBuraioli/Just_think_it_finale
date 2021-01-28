package controller;


import dao.ShopRepository;
import entity.ShopUser2;
import javafx.stage.Window;

public  class RegistrationShopManagerController {





	public RegistrationShopManagerController() {
		//dai dai
	}

	public void backButtonNegPressed(Window window) {
 // ma quanti back
	
	}

	public int registraNegozioPressed( String tipo, String nome, String pass, String via, String tel,String mail, String citta) {

		ShopUser2 shop = new ShopUser2(nome, pass, via, tipo, tel, mail, citta);
		ShopRepository crep = new ShopRepository();
		int id = crep.insertShop(shop);
		shop.setId(id);

		// Manda alla home Shop
	

		return 0;
	}


}