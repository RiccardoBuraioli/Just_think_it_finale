package entity;

public class ShopUser extends User{
	private String Tipologia;
	
	public ShopUser() {}
	
	public ShopUser( String nome, String tipo, String password, String indirizzo, String recapitoTel, String email, String citta) {	
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
