package bean2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.RegistrazioneVolontarioController;
import entity.VolunteerUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegistrazioneVolontarioBoundary{
	private RegistrazioneVolontarioController regC;

    private String Nome;	 
    private String Cognome;	  
    private String Password;
    private String confermaPassword;
	private String Via; 
    private String RecapitoTel;	 
    private String Email;	    
    private String DataNascita;
    private String Città;




	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String cognome) {
		Cognome = cognome;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getConfermaPassword() {
		return confermaPassword;
	}

	public void setConfermaPassword(String confermaPassword) {
		this.confermaPassword = confermaPassword;
	}

	public String getVia() {
		return Via;
	}

	public void setVia(String via) {
		Via = via;
	}

	public String getRecapitoTel() {
		return RecapitoTel;
	}

	public void setRecapitoTel(String recapitoTel) {
		RecapitoTel = recapitoTel;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getDataNascita() {
		return DataNascita;
	}

	public void setDataNascita(String dataNascita) {
		DataNascita = dataNascita;
	}

	public String getCittà() {
		return Città;
	}

	public void setCittà(String città) {
		Città = città;
	}

	
	
	
	public RegistrazioneVolontarioBoundary() {
		regC = new RegistrazioneVolontarioController();
	}

	
	public boolean registraVolontarioPressed(String Nome, String Cognome, String Password, String confermaPassword, String Via, String RecapitoTel, String Email, String DataNascita, String Città) {	
			 if (Nome == null || Nome ==  "" || Cognome == null || Cognome == "" || Password == null || Password == "" || Via == null || Via == "" || RecapitoTel == null || RecapitoTel == "" || Email == "" || Email == null || DataNascita == null || DataNascita == "" || Città == null || Città == ""){
				 return false;
		 }
			 else {
					regC.completaButtonPressed( Nome, Cognome,Password, Via, RecapitoTel, Email, DataNascita,Città);
				 return true;
			 }
		}

}