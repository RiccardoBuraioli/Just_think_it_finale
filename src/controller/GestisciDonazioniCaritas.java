package controller;

import java.util.List;

import dao.Donation_dao;
import entity.DonazioneTab;

public class GestisciDonazioniCaritas {
	private List<DonazioneTab> listDon;
	private Donation_dao donDao;
	
	
	
	
	public GestisciDonazioniCaritas() {
		this.donDao = new Donation_dao();
		
	}
	
	public boolean CancellaDonazione(int idDon) {
		return donDao.CancellaDonazione(idDon);
	}
	
	
	public boolean ritiraDon(int idDon) {
		return donDao.modificaDonazione(idDon);
	}
	
	
	public List<DonazioneTab> visualizzaDonazioni(int idCar){
		this.listDon= donDao.visualizzaDonazioni(idCar);
		return listDon;
	}
	
	
	
}
