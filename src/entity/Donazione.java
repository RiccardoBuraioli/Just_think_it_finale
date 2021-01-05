package entity;

import com.sothawo.mapjfx.Coordinate;

public class Donazione {
	private String descrizione;
	private String indirizzo;
	private int idUtente;
	private int idCaritas;
	private Coordinate coordDonazione;
	private int tipologia;
	

	public Donazione( String descrizione, String indirizzo,int idUtente, int idCaritas, Coordinate coordDonazione, int tipologia) {
		this.descrizione = descrizione;
		this.indirizzo = indirizzo;
		this.idCaritas = idCaritas;
		this.idUtente = idUtente;
		this.coordDonazione = coordDonazione;
		this.tipologia = tipologia;
	}

	public Donazione() {
		this.descrizione = "";
		this.indirizzo= "";
		this.idUtente= 0;
		this.idCaritas= 0;
		this.coordDonazione= null;
		this.tipologia= 0;
		
	}
	

	public String getCoord() {
		
		return ""+ this.coordDonazione + "";
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setId_utente(int idUtente) {
		this.idUtente = idUtente;
	}

	public int getIdCaritas() {
		return idCaritas;
	}

	public void setIdCaritas(int idCaritas) {
		this.idCaritas = idCaritas;
	}

	public Coordinate getCoordDonazione() {
		return coordDonazione;
	}

	public void setCoordDonazione(Coordinate coordDonazione) {
		this.coordDonazione = coordDonazione;
	}

	public int getTipologia() {
		return tipologia;
	}

	public void setTipologia(int tipologia) {
		this.tipologia = tipologia;
	}
	

	
	
}
