package controller;

import dao.DonationDao;
import entity.Donazione;


public class DonationController {

	private static DonationController instance = null;
	
	private Donazione donazione;
	private DonationDao donazione_dao;

	
	private DonationController() {
		donazione = new Donazione();
		donazione_dao = new DonationDao();
	}
	


	public static DonationController getInstance() {
		if (DonationController.instance == null)
			DonationController.instance = new DonationController();
		return instance;
	}

	
	public void initController(int id_car, int id_ut) {
		this.donazione.setId_caritas(id_car);
		this.donazione.setId_utente(id_ut);
	}

	public void setTipologia(int tipo) {
		this.donazione.setTipologia(tipo);
	}

	public Donazione getDonazione() {
		return donazione;
	}

	public void setDonazione(Donazione donazione) {
		this.donazione = donazione;
	}

	public void setIndirizzo(String texts) {
		this.donazione.setIndirizzo(texts);
	}

	public void setDescrizione(String text) {
		this.donazione.setDescrizione(text);
	}

	public int creaDonazione() {
		int error = donazione_dao.crea_donazione(donazione);
		return error;
	}

}
