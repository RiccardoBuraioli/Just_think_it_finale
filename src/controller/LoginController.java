package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.CaritasRepository;
import dao.ShopRepository;
import dao.VolunteerRepository;
import dao.LoginDao;
import entity.User;

public class LoginController {
	private LoginDao login;
	private VolunteerRepository vrep;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    private User loggedUser;

	public LoginController() {
		this.login = new LoginDao();
		this.vrep = new VolunteerRepository();
		
	}

	public User loginAccess(String user, String pass) {

		String loginResult = login.checkLogin(user, pass);
		
		if (loginResult != null) {
			int userID = login.returnID(user);
			if (userID == -1) {
				logger.debug("Errore nel ritornare l'ID");
			}

			// Volontario
			if (login.getTableUser().equals("Volontario")) {
				loggedUser = vrep.getVolunteerByID(userID);				
				
			}
			// Caritas
			else if (login.getTableUser().equals("Negozio")) {

				ShopRepository srep = new ShopRepository();
				loggedUser = srep.getShopByID(userID);
			}
			// Negozio
			else if (login.getTableUser().equals("Caritas")) {
				CaritasRepository srep = new CaritasRepository();
				loggedUser = srep.getCaritasByID(userID);
			}
			else {
				logger.debug("Login Error");
			}
			

		}
		return loggedUser;
	}

}
