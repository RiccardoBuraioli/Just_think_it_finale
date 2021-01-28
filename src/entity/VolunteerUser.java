package entity;

public class VolunteerUser extends User {
	private String cognome;

	public VolunteerUser() {}
	
	public VolunteerUser( String nome, String cognome, String password, String indirizzo, String recapitoTel, String email, String cartaDiCredito,String nascita, String citta) {	
		super(nome, password, indirizzo, recapitoTel, email, cartaDiCredito, nascita, citta);
		this.cognome = cognome;
	 }

	public String getCognome() {
		
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
		
	}
}
