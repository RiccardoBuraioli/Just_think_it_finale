package bean;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class TransizionePagine {

	private User currentUser;
	
	
	public TransizionePagine() {
		//default
	}
	
	public TransizionePagine(User user) {
		this.currentUser = user;
	}
	
	
	
	public void visualizzaPagina(String pagina, Window stage){
		 Logger logger = LoggerFactory.getLogger(TransizionePagine.class.getName());

		   try {
				Parent root = FXMLLoader.load(getClass().getResource(pagina));
				Stage signUp = (Stage)  stage;
				Scene scene = new Scene(root,600,425);
				signUp.setScene(scene);
				signUp.show();
				signUp.setResizable(false);
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		
		
	}
}
