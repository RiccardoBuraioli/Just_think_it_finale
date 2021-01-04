package controller;

import java.util.List;

import dao.EventoDao;
import entity.EventTab;

public class GestisciEventiCaritasController {
	private List<EventTab> listaEv;
	private EventoDao eventDao;
	
	
	
public List<EventTab> caricaEventi(int idCaritas){
		
		this.listaEv = this.eventDao.cercaEventiCaritas(idCaritas);
		
		
		return listaEv;
		
	}
	

public boolean modificaEvento(int idEve) {
	return eventDao.modificaEvento(idEve);
	
}
	
public GestisciEventiCaritasController() {
	eventDao = new EventoDao();
}
	
public boolean eliminaEvento(String nomeEvento) {
	return eventDao.deliteEvent(nomeEvento);
}
}
