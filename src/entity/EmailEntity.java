package entity;

public class EmailEntity {
	private int id_email;
	public int getId_email() {
		return id_email;
	}

	public void setId_email(int id_email) {
		this.id_email = id_email;
	}


	private String email_mittente;
	private String email_destinatario;
	private String messaggio;
	private String oggetto;
	
	
	public EmailEntity(String id_c, String id_u, String mes, String ogg) {
		this.email_mittente = id_c;
		this.email_destinatario = id_u;
		this.messaggio = mes;
		this.oggetto = ogg;
		this.id_email = 0;
	}
	
	public EmailEntity(int id_email, String messaggio, String oggetto) {
		this.id_email = id_email;
		this.messaggio = messaggio;
		this.oggetto = oggetto;
	}


	public String getId_mittente() {
		return email_mittente;
	}


	public void setId_mittente(String id_caritas) {
		this.email_mittente = id_caritas;
	}


	public String getId_destinatario() {
		return email_destinatario;
	}


	public void setId_destinatario(String id_utente) {
		this.email_destinatario = id_utente;
	}


	public String getMessaggio() {
		return messaggio;
	}


	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}


	public String getOggetto() {
		return oggetto;
	}


	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

}
