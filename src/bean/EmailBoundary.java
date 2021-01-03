package bean;

import controller.EmailController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EmailBoundary {
	
	private String[] mit_dest;
	
	private EmailController email_c;

	@FXML
	private Stage stage;
	
	@FXML
    private TextArea messaggio;

    @FXML
    private TextField oggetto;

    @FXML
    private TextField destinatario;

    @FXML
    private TextField mittente;

    @FXML
    private Button invia;

    @FXML
    public int send_message(ActionEvent event) {
    	int i = 0;
    	
   	i =email_c.send_message_controller(mittente.getText(), destinatario.getText(), messaggio.getText(), oggetto.getText());

    Stage st = (Stage) invia.getScene().getWindow();
    st.close();
  	return i;
    	
    }
    
	@FXML
	void initialize() {
	
		email_c = new EmailController();
		
	}
	
	
	public EmailBoundary() {
		
	}
	
	
	
	public void load_email(int id_destinatario, int id_mittente) {
		this.mit_dest = email_c.load_mittente_destinatario_c(id_destinatario, id_mittente);
		this.mittente.setText(mit_dest[0]);
		this.destinatario.setText(mit_dest[1]);
		
	}
	
}
