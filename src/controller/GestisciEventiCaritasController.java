package controller;

import java.util.List;

import dao.EventoDao;
import entity.eventTab;

public class GestisciEventiCaritasController {

	private EventoDao eventDao;
	
	
	
public List<eventTab> caricaEventi(int idCaritas){
		
	List<eventTab> listaEv = this.eventDao.cercaEventiCaritas(idCaritas);
		
		
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
