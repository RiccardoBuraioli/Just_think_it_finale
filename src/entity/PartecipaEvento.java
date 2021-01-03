package entity;

public class PartecipaEvento {
	private int codice_part;
	private int codice_evento;
	private int codice_volontario;
	private float importo;
	
	
	
	
	public PartecipaEvento(int codice_part,int codice_evento,int codice_volontario,	float importo) {
		this.codice_part = codice_part;
		this.codice_evento = codice_evento;
		this.codice_volontario = codice_volontario;
		this.importo = importo;
		
		
		
		
	}
	public PartecipaEvento(int codice_evento, int codice_volontario) {
		this.codice_evento = codice_evento;
		this.codice_volontario = codice_volontario;
	}
	

	
	public int getEvento() {
		return this.codice_evento;
	}
	public int getVolo() {
		return this.codice_volontario;
	}
	
	public float getImporto() {
		return this.importo;
	}


	public int getcodice() {
		return this.codice_evento;
	}
	
	
	
	public void setCodcie(int evento) {
		this.codice_evento = evento;
	}
	
	public void setCodVol(int vol) {
		this.codice_volontario = vol;
	}
	
	public void setImport(float importo) {
		this.importo = importo;
	}
}
