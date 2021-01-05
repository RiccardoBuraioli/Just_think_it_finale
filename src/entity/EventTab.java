package entity;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EventTab {
	
	private SimpleIntegerProperty id;
	private SimpleStringProperty nomeEvento;
	private SimpleStringProperty noteEvento;
	private SimpleFloatProperty prezzoEvento;
	private SimpleIntegerProperty numPartecipanti;
	private SimpleFloatProperty importoRaggiunto;
	private SimpleStringProperty nomeCaritas;
	private SimpleStringProperty rapportoDenaro;
	private SimpleIntegerProperty codiceCaritas;
	private SimpleIntegerProperty completamento;
	private SimpleIntegerProperty codiceNegozio;
	private SimpleStringProperty nomeNegozio;
	private SimpleStringProperty statoEvento;


    
	
	
	
	public EventTab(int id, String nomeEvento, String noteEvento, float prezzoEvento,
			String nomeNegozio, float importoRaggiunto, int numPart,  int codiceNeg, String stato) {
		this.id = new SimpleIntegerProperty(id);
		this.statoEvento = new SimpleStringProperty(stato);
		this.nomeEvento = new SimpleStringProperty(nomeEvento);
	
		this.numPartecipanti = new SimpleIntegerProperty(numPart);
		this.prezzoEvento = new SimpleFloatProperty(prezzoEvento);
		this.noteEvento = new SimpleStringProperty(noteEvento);
		
		
		this.nomeNegozio = new SimpleStringProperty(nomeNegozio);
		this.importoRaggiunto = new SimpleFloatProperty(importoRaggiunto);
		this.rapportoDenaro = new SimpleStringProperty(importoRaggiunto + "/" + prezzoEvento);

		this.codiceNegozio = new SimpleIntegerProperty(codiceNeg);
		
	}

	public EventTab(String nomeEvento, String nomeCaritas, String noteEvento, float prezzoEvento,
			float importoRaggiunto, int numPartecipanti, int idCaritas, String complet) {
		this.nomeEvento = new SimpleStringProperty(nomeEvento);
		this.nomeCaritas = new SimpleStringProperty(nomeCaritas);
		if (complet.equalsIgnoreCase("Terminato")) {
			this.noteEvento = new SimpleStringProperty("COMPLETATO");
		} else {
			this.noteEvento = new SimpleStringProperty(noteEvento);
		}

		this.numPartecipanti = new SimpleIntegerProperty(numPartecipanti);
		this.prezzoEvento = new SimpleFloatProperty(prezzoEvento);
		this.importoRaggiunto = new SimpleFloatProperty(importoRaggiunto);
		this.rapportoDenaro = new SimpleStringProperty(importoRaggiunto + "/" + prezzoEvento);
		this.codiceCaritas = new SimpleIntegerProperty(idCaritas);
		this.statoEvento = new SimpleStringProperty(complet);
	}

	public String getNomeEvento() {
		return this.nomeEvento.get();
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento.set(nomeEvento);
	}


	public String getNoteEvento() {
		return this.noteEvento.get();
	}

	public void setNoteEvento(String noteEvento) {
		this.noteEvento.set(noteEvento);
	}

	public float getPrezzoEvento() {
		return this.prezzoEvento.get();
	}

	public void setPrezzoEvento(float prezzoEvento) {
		this.prezzoEvento.set(prezzoEvento);
	}

	public int getNumPartecipanti() {
		return this.numPartecipanti.get();
	}

	public void setNumPartecipanti(int numPartecipanti) {
		this.numPartecipanti.set(numPartecipanti);
	}

	public float getImportoRaggiunto() {
		return this.importoRaggiunto.get();
	}

	public void setImportoRaggiunto(float importoRaggiunto) {
		this.importoRaggiunto.set(importoRaggiunto);
	}

	public String getNomeCaritas() {
		return this.nomeCaritas.get();
	}

	public void setNomeCaritas(String nomeCaritas) {
		this.nomeCaritas.set(nomeCaritas);
	}

	public String getRapportoDenaro() {
		return this.rapportoDenaro.get();
	}

	public void setRapportoDenaro(String rapportoDenaro) {
		this.rapportoDenaro.set(rapportoDenaro);
	}

	public int getIdCaritas() {
		return this.codiceCaritas.get();
	}

	public void setIdCaritas(int idCaritas) {
		this.codiceCaritas.set(idCaritas);
	
	}

	public int getCompletamento() {
		return this.completamento.get();
	}

	public void setCompletamento(int completamento) {
		this.completamento.set(completamento);
	}

	public int getCodiceNegozio() {
		return this.codiceNegozio.get();
	}

	public void setCodiceNegozio(int codiceNegozio) {
		this.codiceNegozio.set(codiceNegozio);
	}

	public String getNomeNegozio() {
		return this.nomeNegozio.get();
	}

	public void setNomeNegozio(String nomeNegozio) {
		this.nomeNegozio.set(nomeNegozio);
	}

	public String getStatoEvento() {
		return this.statoEvento.get();
	}

	public void setStatoEvento(String statoEvento) {
		this.statoEvento.set(statoEvento);
	}
	
	public int getId() {
		return this.id.get();
	}

	public void setId(int id) {
		this.id.set(id);
	}

}
