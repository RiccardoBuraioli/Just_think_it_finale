package controller;

import java.util.List;

import bean.GestisciEventiBoundary;
import dao.EventoDao;
import entity.EventTab;
import entity.Evento;

public class GestisciEventiController {
	private GestisciEventiBoundary gestisciEventiB;
	private List<EventTab> listaEv;
	private EventoDao eventDao;
	
	
	
	public GestisciEventiController() {
	
		eventDao = new EventoDao();
	}
	
	
	public List<EventTab> caricaEventi(int idShop){
		
		listaEv = eventDao.cercaEventi(idShop);
		
		
		return listaEv;
		
	}
	
	public boolean eliminaEvento(String nomeEvento) {
		return eventDao.deliteEvent(nomeEvento);
	}
	
	
	public boolean modificaNoteEvento(String noteEvento) {
		return false;
		
	}
	
}
