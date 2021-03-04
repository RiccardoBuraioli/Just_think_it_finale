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

	public String loginAccess(String user, String pass) {

		String loginResult = login.checkLogin(user, pass);
		
	
		return loginResult;
	}

	public int trovaID(String user) {
		int userID = login.returnID(user);
		return userID;
	}

}
