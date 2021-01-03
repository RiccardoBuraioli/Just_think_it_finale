package controller;

import java.util.List;

import dao.BachecaDao;
import entity.BachecaEntity;
import entity.NecessitÓ;

public class Bacheca_Personale_Controller {
	
	private BachecaDao bacheca;
	private int id_caritas;
	private BachecaEntity bacheca_e;
	private List<NecessitÓ> necessitÓ;

	
	
	
	
	
	
	
	public boolean elimina_annuncio(int nece) {
	
		return	bacheca.elimina_necessitÓ(nece); 
		
		
	}
	
	
	
	public List<NecessitÓ> loadForm(int id_car) {
		this.id_caritas = id_car;
		bacheca = new BachecaDao();
		bacheca_e = new BachecaEntity();
		necessitÓ = bacheca.visualizza_necessitÓ(id_car);
		bacheca_e.setNecessitÓ(necessitÓ);
	
		return necessitÓ;
	}
	
}
