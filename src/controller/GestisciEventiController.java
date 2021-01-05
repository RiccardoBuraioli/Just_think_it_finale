package controller;

import java.util.List;

import dao.EventoDao;
import entity.eventTab;

public class GestisciEventiController {


	private EventoDao eventDao;
	
	
	
	public GestisciEventiController() {
	
		eventDao = new EventoDao();
	}
	
	
	public List<eventTab> caricaEventi(int idShop){
	
		return eventDao.cercaEventi(idShop);
		
	}
	
	public boolean eliminaEvento(String nomeEvento) {
		return eventDao.deliteEvent(nomeEvento);
	}
	
	
	public boolean modificaNoteEvento() {
		//da fare?
		return false;
		
	}
	
}
