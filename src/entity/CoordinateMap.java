package entity;

public class CoordinateMap {
	private double  longitudine;
	private double  latitudine;
	private int evento;
	public int getEvento() {
		return evento;
	}
	public void setEvento(int evento) {
		this.evento = evento;
	}
	private int idUtente;
	
	public double getLongitudine() {
		return longitudine;
	}
	public void setLongitudine(double longitudine) {
		this.longitudine = longitudine;
	}
	public double getLatitudine() {
		return latitudine;
	}
	public void setLatitudine(double latitudine) {
		this.latitudine = latitudine;
	}
	
	public CoordinateMap(double longi, double lati, int id, int ev){
		this.longitudine = longi;
		this.latitudine = lati;		
		this.setEvento(ev);
		this.setIdUtente(id);
	}
	public int getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	
}
