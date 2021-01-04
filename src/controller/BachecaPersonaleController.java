package controller;

import java.util.List;

import dao.BachecaDao;
import entity.BachecaEntity;
import entity.Necessità;

public class BachecaPersonaleController {
	
	private BachecaDao bacheca;
	private int id_caritas;
	private BachecaEntity bacheca_e;
	private List<Necessità> necessità;

	
	
	
	
	
	
	
	public boolean elimina_annuncio(int nece) {
	
		return	bacheca.eliminaNecessita(nece); 
		
		
	}
	
	
	
	public List<Necessità> loadForm(int id_car) {
		this.id_caritas = id_car;
		bacheca = new BachecaDao();
		bacheca_e = new BachecaEntity();
		necessità = bacheca.visualizza_necessità(id_car);
		bacheca_e.setNecessità(necessità);
	
		return necessità;
	}
	
}
