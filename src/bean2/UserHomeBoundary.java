package bean2;



import java.sql.SQLException;

import controller.UserHomeController;



public class UserHomeBoundary{



/**
	 * 
	 */

private static UserHomeBoundary instance = null;

private int userId;
	
	private UserHomeController userController ;

	
	
	
	public static UserHomeBoundary getInstance() {
		if (instance == null) {
			instance = new UserHomeBoundary();
			}
		return instance;
	}
	
	
	public UserHomeBoundary() {
		 userController = new UserHomeController();
	
	}
   


    
 
    public void deleteAccountButtonPressed() {
    		//lo faremo presto
    	this.userController.deleteAccount(userId);
    }

   
 /*  public  void profileButtonPressed() {
    	ProfileBoundary profileBean;
    	ProfileController profileController = new ProfileController();
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/UserProfilePage.fxml"));
			Parent root = loader.load();
			profileBean = loader.getController();
			profileController.initData(userId, profileBean);
			
			Stage home = (Stage) this.profileButton.getScene().getWindow();
			home.setScene(new Scene(root, 800, 600));
			
			home.show();
		} catch (IOException e) {
			logger.error(s);
		}
    }*/

    
    void helpButtonPressed() {
    	this.userController.helpButtonPressed();
    }

 

   
   /*public void logoutButtonPressed() {    	
    	TransizionePagine pageSwitch = new TransizionePagine();
    	pageSwitch.logout(logoutButton.getScene().getWindow());

	}*/

  


    public int  searchCaritasButtonPressed() throws NumberFormatException, SQLException {
    	TransizionePagine switchPage = new TransizionePagine();
    	switchPage.apriMappa(this.userId);
    	return 0;
    }
 

	public void initData(String nome, String cognome, int id) {
    	//this.nomeCognome.setText(nome + " "+ cognome);
        this.userId = id;
  
    }
}





