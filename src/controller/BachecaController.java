package controller;


import java.util.List;
import dao.BachecaDao;
import entity.BachecaEntity;
import entity.Necessita;


public class BachecaController  {

	private List<Necessita> necessita;

	public List<Necessita> loadForm(int idCar) {
		BachecaDao bacheca = new BachecaDao();
		BachecaEntity bachecaEntity = new BachecaEntity();
		necessita = bacheca.visualizzaNecessita(idCar);
		bachecaEntity.setNecessita(necessita);
		return bachecaEntity.getNecessità();
			
		
		}
	
	
}
