package bean2;

import java.sql.SQLException;

import controller.RegistrazioneCaritasController;



public class RegistraCaritasBoundary  {

	private RegistrazioneCaritasController regController;

	  private String Tipologia;
	  private String Città;
	  private String NomeCaritas;
	  private String IndirizzoCaritas;
	  private String Password;
	  private String confermaPassword;
	  private String RecapitoTel;
	  private String Email;

	

	public String getTipologia() {
		return Tipologia;
	}

	public void setTipologia(String tipologia) {
		Tipologia = tipologia;
	}

	public String getCittà() {
		return Città;
	}

	public void setCittà(String città) {
		Città = città;
	}

	public String getNomeCaritas() {
		return NomeCaritas;
	}

	public void setNomeCaritas(String nomeCaritas) {
		NomeCaritas = nomeCaritas;
	}

	public String getIndirizzoCaritas() {
		return IndirizzoCaritas;
	}

	public void setIndirizzoCaritas(String indirizzoCaritas) {
		IndirizzoCaritas = indirizzoCaritas;
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

	public RegistraCaritasBoundary() {
		regController = new RegistrazioneCaritasController();
	}

	

	public boolean completaButtonPressed(String NomeCaritas, String Password, String IndirizzoCaritas, String Tipologia, String RecapitoTel, String Email, String Città ) throws SQLException{
		 if (NomeCaritas == null || NomeCaritas.equals("") || Password == null || Password.equals("") || IndirizzoCaritas == null || IndirizzoCaritas.equals("")|| RecapitoTel == null || RecapitoTel.equals("") || Email.equals("") || Email == null || Città == null || Città.equals("")) {
			 return false;
		}
		 else{
				 regController.completaButtonPressed(NomeCaritas,Password,IndirizzoCaritas,Tipologia,RecapitoTel,Email,Città);	
			 }
	     return true;
	}

}