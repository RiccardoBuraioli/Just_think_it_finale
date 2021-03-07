package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import dao.LoginDao;

public class LoginController {
	private LoginDao login;

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);


	public LoginController() {
		this.login = new LoginDao();

		
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
