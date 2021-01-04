package controller;

import dao.BachecaDao;
import entity.Necessit‡;

public class CreaNecessit‡Controller {
	private BachecaDao creaBachecaDao;
	private Necessit‡ necessita;
	private int idCaritas;
	
	public CreaNecessit‡Controller() {
		creaBachecaDao = new BachecaDao();
		
	}
	
	public int creaNecessit‡(String tipo, String urg, String desc) {
		
		necessita = new Necessit‡(tipo, desc, urg);
		
		
		creaBachecaDao.creaNecessita(necessita, idCaritas);
		return 0;
		
	}
	
	
	
	public void inizializza(int codCar) {
		this.idCaritas = codCar;
	}
	
}
