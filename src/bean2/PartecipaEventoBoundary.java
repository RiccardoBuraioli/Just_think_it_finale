package bean2;

import controller.PartecipaEventoController;

public class PartecipaEventoBoundary {

	private int idUtente;
	private int idEvento;
	private String importo;
	private String carta;
	private PartecipaEventoController partecipaC;
	private static PartecipaEventoBoundary instance = null;
	 
	public static PartecipaEventoBoundary getInstance() {
		if(instance == null) {
			instance = new PartecipaEventoBoundary();
		}
		return instance;
		}
	
	public PartecipaEventoBoundary() {
		partecipaC = PartecipaEventoController.getInstance();
	}


	public void partecipaEvento(String importo, String carta) {
		partecipaC.setDataController(idEvento, idUtente);
		partecipaC.partecipaEvento(Float.parseFloat(importo));
	}

	
	public void setData(int idEvento, int idVolontario) {
		this.idEvento = idEvento;
		this.idUtente = idVolontario;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public int getIdEvento() {
		return idEvento;
	}
	public String getImporto() {
		return importo;
	}

	public void setImporto(String importo) {
		this.importo = importo;
	}

	public String getCarta() {
		return carta;
	}

	public void setCarta(String carta) {
		this.carta = carta;
	}


}
