package entity;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EventTab {
	
	private SimpleIntegerProperty id;
	private SimpleStringProperty NomeEvento;
	private SimpleStringProperty NoteEvento;
	private SimpleFloatProperty PrezzoEvento;
	private SimpleIntegerProperty NumPartecipanti;
	private SimpleFloatProperty ImportoRaggiunto;
	private SimpleStringProperty NomeCaritas;
	private SimpleStringProperty rapportoDenaro;
	private SimpleIntegerProperty CodiceCaritas;
	private SimpleIntegerProperty completamento;
	private SimpleIntegerProperty CodiceNegozio;
	private SimpleStringProperty NomeNegozio;
	private SimpleStringProperty StatoEvento;


    
	
	
	
	public EventTab(int id, String NomeEvento, String NoteEvento, float PrezzoEvento,
			String nomeNegozio, float ImportoRaggiunto, int numPart,  int CodiceNeg, String stato) {
		this.id = new SimpleIntegerProperty(id);
		this.StatoEvento = new SimpleStringProperty(stato);
		this.NomeEvento = new SimpleStringProperty(NomeEvento);
	
		this.NumPartecipanti = new SimpleIntegerProperty(numPart);
		this.PrezzoEvento = new SimpleFloatProperty(PrezzoEvento);
		this.NoteEvento = new SimpleStringProperty(NoteEvento);
		
		
		this.NomeNegozio = new SimpleStringProperty(nomeNegozio);
		this.ImportoRaggiunto = new SimpleFloatProperty(ImportoRaggiunto);
		this.rapportoDenaro = new SimpleStringProperty(ImportoRaggiunto + "/" + PrezzoEvento);

		this.CodiceNegozio = new SimpleIntegerProperty(CodiceNeg);
		
	}

	public EventTab(String NomeEvento, String nomeCaritas, String NoteEvento, float PrezzoEvento,
			float ImportoRaggiunto, int NumPartecipanti, int idCaritas, String complet) {
		this.NomeEvento = new SimpleStringProperty(NomeEvento);
		this.NomeCaritas = new SimpleStringProperty(nomeCaritas);
		if (complet.equalsIgnoreCase("Terminato")) {
			this.NoteEvento = new SimpleStringProperty("COMPLETATO");
		} else {
			this.NoteEvento = new SimpleStringProperty(NoteEvento);
		}

		this.NumPartecipanti = new SimpleIntegerProperty(NumPartecipanti);
		this.PrezzoEvento = new SimpleFloatProperty(PrezzoEvento);
		this.ImportoRaggiunto = new SimpleFloatProperty(ImportoRaggiunto);
		this.rapportoDenaro = new SimpleStringProperty(ImportoRaggiunto + "/" + PrezzoEvento);
		this.CodiceCaritas = new SimpleIntegerProperty(idCaritas);
		this.StatoEvento = new SimpleStringProperty(complet);
	}

	public String getNomeEvento() {
		return this.NomeEvento.get();
	}

	public void setNomeEvento(String nomeEvento) {
		this.NomeEvento.set(nomeEvento);
	}


	public String getNoteEvento() {
		return this.NoteEvento.get();
	}

	public void setNoteEvento(String noteEvento) {
		this.NoteEvento.set(noteEvento);
	}

	public float getPrezzoEvento() {
		return this.PrezzoEvento.get();
	}

	public void setPrezzoEvento(float prezzoEvento) {
		this.PrezzoEvento.set(prezzoEvento);
	}

	public int getNumPartecipanti() {
		return this.NumPartecipanti.get();
	}

	public void setNumPartecipanti(int numPartecipanti) {
		this.NumPartecipanti.set(numPartecipanti);
	}

	public float getImportoRaggiunto() {
		return this.ImportoRaggiunto.get();
	}

	public void setImportoRaggiunto(float importoRaggiunto) {
		this.ImportoRaggiunto.set(importoRaggiunto);
	}

	public String getNomeCaritas() {
		return this.NomeCaritas.get();
	}

	public void setNomeCaritas(String nomeCaritas) {
		this.NomeCaritas.set(nomeCaritas);
	}

	public String getRapportoDenaro() {
		return this.rapportoDenaro.get();
	}

	public void setRapportoDenaro(String rapportoDenaro) {
		this.rapportoDenaro.set(rapportoDenaro);
	}

	public int getIdCaritas() {
		return this.CodiceCaritas.get();
	}

	public void setIdCaritas(int idCaritas) {
		this.CodiceCaritas.set(idCaritas);
	
	}

	public int getCompletamento() {
		return this.completamento.get();
	}

	public void setCompletamento(int completamento) {
		this.completamento.set(completamento);
	}

	public int getCodiceNegozio() {
		return this.CodiceNegozio.get();
	}

	public void setCodiceNegozio(int codiceNegozio) {
		this.CodiceNegozio.set(codiceNegozio);
	}

	public String getNomeNegozio() {
		return this.NomeNegozio.get();
	}

	public void setNomeNegozio(String nomeNegozio) {
		this.NomeNegozio.set(nomeNegozio);
	}

	public String getStatoEvento() {
		return this.StatoEvento.get();
	}

	public void setStatoEvento(String statoEvento) {
		this.StatoEvento.set(statoEvento);
	}
	
	public int getId() {
		return this.id.get();
	}

	public void setId(int id) {
		this.id.set(id);
	}

}
