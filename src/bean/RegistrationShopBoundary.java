package bean;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.RegistrationShopManagerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegistrationShopBoundary implements Initializable{
	private RegistrationShopManagerController regNeg;
	private static Logger logger = LoggerFactory.getLogger(RegistrationShopBoundary.class.getName());
	private String s = "error IoException";
	private TextField[] textFields;	
	private String tipo;
	
    @FXML
    private TextField cittaResNeg;

    @FXML
    private TextField viaNeg;

    @FXML
    private TextField civicoNeg;

    @FXML
    private TextField telNeg;

    @FXML
    private TextField nomeNegzio;

    @FXML
    private TextField mailNeg;

    @FXML
    private CheckBox typeCiboNeg;

    @FXML
    private CheckBox typeVestNeg;

    @FXML
    private TextField nomeNeg;

    @FXML
    private TextField cognomeNeg;

    @FXML
    private Button registraNegozio;

    @FXML
    private TextField codiceFiscNeg;

    @FXML
    private Button backButtonNeg;

    @FXML
    private PasswordField passwordNeg;

    @FXML
    private PasswordField confermaPassNeg;

    @FXML
    private Text passwordMatch;
    
    
    
    public RegistrationShopBoundary() {
    	this.regNeg = new RegistrationShopManagerController();
    }
    

    @FXML
    void backButtonNegPressed(ActionEvent event) {
    	
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/boundary/RegistrazioneMenu.fxml"));
			Stage signUp = (Stage) backButtonNeg.getScene().getWindow();
			Scene scene = new Scene(root, 600, 400);
			signUp.setScene(scene);
			signUp.show();
			signUp.setResizable(false);
		} catch (IOException e) {
			logger.error(s);
		}

    }

    @FXML
    void registraNegozioPressed(ActionEvent event) {
    	int i = checker();
    	
 
    	if ( i == -1) {
    		System.out.println("errore fratello");
    	}
    
    	regNeg.registraNegozioPressed( tipo , nomeNeg.getText(), passwordNeg.getText(), viaNeg.getText() + " "+civicoNeg.getText() , telNeg.getText(), mailNeg.getText(), cittaResNeg.getText());
 
    	try {
    		
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/ShopHomePage.fxml"));
			Parent root = loader.load();
			Stage home = (Stage) registraNegozio.getScene().getWindow();
			home.setScene(new Scene(root, 800, 600));

			home.show();
		} catch (IOException e) {
			logger.error(s);
		}
    }
    
    
   public int checker() {
	   
	   
    	
    	//Controlla che non ci siano campi lasciati vuoti
    	for (int i = 0; i < textFields.length; i++) {
			if (textFields[i].getText().isEmpty()) {
				passwordMatch.setText("Alcuni campi sono vuoti");
				passwordMatch.setVisible(true);
				return -1;
			}
			else if(typeCiboNeg.isSelected()) {
				 tipo = "Vestiti";
	    		 //Almeno uno dei tipi deve essere selezionato
	    		
	    		
			}else if(typeVestNeg.isSelected()) {
				tipo = "Cibo";
				
				 //Almeno uno dei tipi deve essere selezionato
			}else {
				passwordMatch.setText("Alcuni campi sono vuoti 2");
				passwordMatch.setVisible(true);
				return -1;
			}
  
		}
    	
    	
    	//Valida che i campi password e conferma password siano uguali
    	
    	if (passwordNeg.getText().equalsIgnoreCase(confermaPassNeg.getText())) {
    		System.out.println("Password confirmed");
    		return 0;
    	}
    	else {
    		passwordMatch.setText("Le password non corrispondono");
    		passwordMatch.setVisible(true);
    		return -1;
    	}
    }
    
   @Override
   public void initialize(URL location, ResourceBundle resources) {
		
		passwordMatch.setVisible(false);
		textFields = new TextField[] {cittaResNeg,viaNeg,civicoNeg,telNeg,nomeNegzio,mailNeg,nomeNeg,cognomeNeg};
		

	}
    

}
