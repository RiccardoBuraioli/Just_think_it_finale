package entity;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EventTab {

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

    
	
	
	
	public EventTab(String NomeEvento, String NoteEvento, float PrezzoEvento,
			String nomeNegozio, float ImportoRaggiunto, int num_part, int complet, int CodiceNeg) {

		this.NomeEvento = new SimpleStringProperty(NomeEvento);
	
		this.NumPartecipanti = new SimpleIntegerProperty(num_part);
		this.PrezzoEvento = new SimpleFloatProperty(PrezzoEvento);
		
		if (complet == 1) {
			this.NoteEvento = new SimpleStringProperty("COMPLETATO");
		} else {
			this.NoteEvento = new SimpleStringProperty(NoteEvento);
		}
		
		this.NomeNegozio = new SimpleStringProperty(nomeNegozio);
		this.ImportoRaggiunto = new SimpleFloatProperty(ImportoRaggiunto);
		this.rapportoDenaro = new SimpleStringProperty(ImportoRaggiunto + "/" + PrezzoEvento);

		this.CodiceNegozio = new SimpleIntegerProperty(CodiceNeg);
		
	}

	public EventTab(String NomeEvento, String nome_caritas, String NoteEvento, float PrezzoEvento,
			float ImportoRaggiunto, int NumPartecipanti, int id_caritas, int complet) {
		this.NomeEvento = new SimpleStringProperty(NomeEvento);
		this.NomeCaritas = new SimpleStringProperty(nome_caritas);
		if (complet == 1) {
			this.NoteEvento = new SimpleStringProperty("COMPLETATO");
		} else {
			this.NoteEvento = new SimpleStringProperty(NoteEvento);
		}

		this.NumPartecipanti = new SimpleIntegerProperty(NumPartecipanti);
		this.PrezzoEvento = new SimpleFloatProperty(PrezzoEvento);
		this.ImportoRaggiunto = new SimpleFloatProperty(ImportoRaggiunto);
		this.rapportoDenaro = new SimpleStringProperty(ImportoRaggiunto + "/" + PrezzoEvento);
		this.CodiceCaritas = new SimpleIntegerProperty(id_caritas);
		this.completamento = new SimpleIntegerProperty(complet);
	}

	public String getNomeEvento() {
		return NomeEvento.get();
	}

	public void setNomeEvento(String nomeEvento) {
		NomeEvento.set(nomeEvento);
	}


	public String getNoteEvento() {
		return NoteEvento.get();
	}

	public void setNoteEvento(String noteEvento) {
		NoteEvento.set(noteEvento);
	}

	public float getPrezzoEvento() {
		return PrezzoEvento.get();
	}

	public void setPrezzoEvento(float prezzoEvento) {
		PrezzoEvento.set(prezzoEvento);
	}

	public int getNumPartecipanti() {
		return NumPartecipanti.get();
	}

	public void setNumPartecipanti(int numPartecipanti) {
		NumPartecipanti.set(numPartecipanti);
	}

	public float getImportoRaggiunto() {
		return ImportoRaggiunto.get();
	}

	public void setImportoRaggiunto(float importoRaggiunto) {
		ImportoRaggiunto.set(importoRaggiunto);
	}

	public String getNomeCaritas() {
		return NomeCaritas.get();
	}

	public void setNomeCaritas(String nomeCaritas) {
		NomeCaritas.set(nomeCaritas);
	}

	public String getRapportoDenaro() {
		return rapportoDenaro.get();
	}

	public void setRapportoDenaro(String rapportoDenaro) {
		this.rapportoDenaro.set(rapportoDenaro);
	}

	public int getId_caritas() {
		return CodiceCaritas.get();
	}

	public void setId_caritas(int id_caritas) {
		this.CodiceCaritas.set(id_caritas);
		;
	}

	public int getCompletamento() {
		return completamento.get();
	}

	public void setCompletamento(int completamento) {
		this.completamento.set(completamento);
	}

	public int getCodice_negozio() {
		return CodiceNegozio.get();
	}

	public void setCodice_negozio(int codice_negozio) {
		CodiceNegozio.set(codice_negozio);
	}

	public String getNomeNegozio() {
		return NomeNegozio.get();
	}

	public void setNomeNegozio(String nomeNegozio) {
		NomeNegozio.set(nomeNegozio);
	}

}
