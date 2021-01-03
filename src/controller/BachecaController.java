package controller;


import java.io.IOException;
import java.util.List;

import bean.DonationBoundary;
import bean.EmailBoundary;
import dao.BachecaDao;
import entity.BachecaEntity;
import entity.Necessità;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BachecaController  {

	private int id_caritas;
	private int id_utente;
	private List<Necessità> necessità;
	private BachecaDao bacheca;
	
	private BachecaEntity bacheca_entity;
	

	
	public BachecaController() {
	}
	

	
	public void crea_donazione() {
	
	}

	public void crea_email() {
    
		
	}




	
	public List<Necessità> loadForm(int id_car, int id_ute) {
		bacheca = new BachecaDao();
		bacheca_entity = new BachecaEntity();
		necessità = bacheca.visualizza_necessità(id_car);
		bacheca_entity.setNecessità(necessità);
		this.id_caritas = id_car;
		this.id_utente = id_ute;
		return bacheca_entity.getNecessità();
			
		
		}
	
	
}
