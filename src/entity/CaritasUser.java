package entity;

public class CaritasUser extends User {
	private String Tipologia;
	
	public CaritasUser() {}
	
	public CaritasUser(String nome, String tipo, String password, String indirizzo, String recapitoTel, String email, String citta) {	
		super(nome, password, indirizzo, recapitoTel, email,  citta);
		this.Tipologia = tipo;
		
	}

	public String getTipologia() {
		return Tipologia;
	}

	public void setTipologia(String tipologia) {
		Tipologia = tipologia;
	}
	
	
	
}
