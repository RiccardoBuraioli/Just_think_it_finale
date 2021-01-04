package controller;

import java.util.List;

import dao.BachecaDao;
import entity.BachecaEntity;
import entity.Necessita;

public class BachecaPersonaleController {
	
	private BachecaDao bacheca;

	private List<Necessita> necessita;

	
	
	
	
	
	
	
	public boolean eliminaAnnuncio(int nece) {
	
		return	bacheca.eliminaNecessita(nece); 
		
		
	}
	
	
	
	public List<Necessita> loadForm(int idCar) {
		
		bacheca = new BachecaDao();
		BachecaEntity bachecaE = new BachecaEntity();
		necessita = bacheca.visualizzaNecessita(idCar);
		bachecaE.setNecessita(necessita);
	
		return necessita;
	}
	
}
