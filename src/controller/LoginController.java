package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import dao.LoginDao;

public class LoginController {
	private LoginDao login;



	public LoginController() {
		this.login = new LoginDao();

		
	}

	public String loginAccess(String user, String pass) {
		return login.checkLogin(user, pass);
	}

	public int trovaID(String user) {
		return  login.returnID(user);
	}

}
