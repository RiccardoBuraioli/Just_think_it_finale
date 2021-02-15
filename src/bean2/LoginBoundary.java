package bean2;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bean.UserHomeBoundary;
import controller.LoginController;
import entity.CaritasUser;
import entity.ShopUser;
import entity.VolunteerUser;

public class LoginBoundary  {

	private LoginController loginC = new LoginController();

	private UserHomeBoundary userHomeBoundary;
	private ShopHomeBoundary shopHomeBoundary;
	private Object loggedUser;
	
	private CaritasHomeBoundary caritasHomeBoundary;
	private static Logger logger = LoggerFactory.getLogger(LoginBoundary.class.getName());
	private String s = "errore IoException";
	private static LoginBoundary instance = null;
	public static LoginBoundary getInstance() {
		if(instance == null) {
			instance = new LoginBoundary();
			
		}
		return instance;
	}
	
	
    private String username;
    private String password;
    
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String loginPressed(String username, String password) throws IOException {
    loggedUser=loginC.loginAccess(username,password);
   	if(loggedUser.getClass()==VolunteerUser.class) {
   	userHomeBoundary = UserHomeBoundary.getInstance();
	userHomeBoundary.initData((VolunteerUser)loggedUser);
	return "Volontario";
   	}
   	else if(loggedUser.getClass()==CaritasUser.class) {
  		caritasHomeBoundary = CaritasHomeBoundary.getInstance();
		caritasHomeBoundary.initData((CaritasUser)loggedUser);
		return "Caritas";
		}
	else if(loggedUser.getClass()==ShopUser.class) {
			shopHomeBoundary = ShopHomeBoundary.getInstance(); 
			shopHomeBoundary.initData((ShopUser)loggedUser);
		return "Negozio";
		}
    return loggedUser.getClass().toString();
		}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		LoginBoundary.logger = logger;
	}


}
