package entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DonazioneTab {
	private SimpleIntegerProperty idDon;
	private SimpleIntegerProperty codVol;
	private SimpleStringProperty tipologia;
	private SimpleStringProperty Descrizione;
	private SimpleStringProperty indirizzo;
	private SimpleStringProperty stato;

	
	
	
	public DonazioneTab(int id, int codVol, String tipo, String desc, String ind, String stato) {
		this.idDon = new SimpleIntegerProperty(id);
		this.tipologia = new SimpleStringProperty(tipo);
		this.Descrizione = new SimpleStringProperty(desc);
		this.indirizzo = new SimpleStringProperty(ind);
		this.codVol = new SimpleIntegerProperty(codVol);
		this.stato = new SimpleStringProperty(stato);
	}
	
	
	
	
	public String getTipologia() {
		return this.tipologia.get();
	}
	public void setTipologia(String tipologia) {
		this.tipologia.set(tipologia);
	}
	public String getDescrizione() {
		return this.Descrizione.get();
	}
	public void setDescrizione(String descrizione) {
		this.Descrizione.set(descrizione);
	}
	public String getIndirizzo() {
		return this.indirizzo.get();
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo.set(indirizzo);
	}

	public int getCodVol() {
		return this.codVol.get();
	}

	public void setCodVol(int codVol) {
		this.codVol.set(codVol);
	}

	public int getIdDon() {
		return this.idDon.get();
	}

	public void setIdDon(int idDon) {
		this.idDon.set(idDon);
	}
	
	public String getStato() {
		return this.stato.get();
	}

	public void setStato(String stato) {
		this.stato.set(stato);
	}
	
	
	
	
	
	

}
