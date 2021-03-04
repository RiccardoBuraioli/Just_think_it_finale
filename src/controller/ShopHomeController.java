package controller;



import bean.ShopHomeBoundary;
import dao.ShopRepository;
import entity.ShopUser;
import javafx.stage.Window;

public class ShopHomeController {

	

	private ShopUser currentUser;

	public ShopUser getCurrentUser() {
		return currentUser;
	}
	
	public void setCurrentUser(ShopUser currentUser) {
		this.currentUser = currentUser;
	}


	public void deleteAccountButtonPressed(Window event) {
		//funzionera
	}

	public void initDataShop(int id, ShopHomeBoundary shopBean) {
		ShopRepository sd = new ShopRepository();
		currentUser = sd.getShopByID(id);
		shopBean.initData(currentUser.getId(), currentUser.getNome());
		
	}


}
