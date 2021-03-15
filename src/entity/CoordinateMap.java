package entity;

public class CoordinateMap {
	private double  longitudine;
	private double  latitudine;
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
	
	public CoordinateMap(double longi, double lati, int id){
		this.longitudine = longi;
		this.latitudine = lati;		
		this.setIdUtente(id);
	}
	public int getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	
}
