package controller;

import dao.BachecaDao;
import entity.Necessit‡;

public class CreaNecessit‡Controller {
	private BachecaDao crea_n;
	private Necessit‡ necessit‡;
	private int id_caritas;
	
	public CreaNecessit‡Controller() {
		crea_n = new BachecaDao();
		
	}
	
	public int crea_necessit‡(String tipo, String urg, String desc) {
		
		necessit‡ = new Necessit‡(tipo, desc, urg);
		
		
		crea_n.crea_necessit‡(necessit‡, id_caritas);
		return 0;
		
	}
	
	
	
	public void inizializza(int cod_car) {
		this.id_caritas = cod_car;
	}
	
}
