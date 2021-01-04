package controller;


import java.io.IOException;
import java.util.List;
import dao.BachecaDao;
import entity.BachecaEntity;
import entity.Necessita;


public class BachecaController  {

	private List<Necessita> necessita;

	public List<Necessita> loadForm(int idCar, int idUte) {
		BachecaDao bacheca = new BachecaDao();
		BachecaEntity bacheca_entity = new BachecaEntity();
		necessita = bacheca.visualizzaNecessita(idCar);
		bacheca_entity.setNecessita(necessita);
		return bacheca_entity.getNecessità();
			
		
		}
	
	
}
