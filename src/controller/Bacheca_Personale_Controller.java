package controller;

import java.util.List;

import dao.BachecaDao;
import entity.BachecaEntity;
import entity.Necessit�;

public class Bacheca_Personale_Controller {
	
	private BachecaDao bacheca;
	private int id_caritas;
	private BachecaEntity bacheca_e;
	private List<Necessit�> necessit�;

	
	
	
	
	
	
	
	public boolean elimina_annuncio(int nece) {
	
		return	bacheca.elimina_necessit�(nece); 
		
		
	}
	
	
	
	public List<Necessit�> loadForm(int id_car) {
		this.id_caritas = id_car;
		bacheca = new BachecaDao();
		bacheca_e = new BachecaEntity();
		necessit� = bacheca.visualizza_necessit�(id_car);
		bacheca_e.setNecessit�(necessit�);
	
		return necessit�;
	}
	
}
