package controller;

import java.util.List;

import dao.EventoDao;
import entity.EventTab;

public class Gestisci_Eventi_Caritas_Controller {
	private List<EventTab> listaEv;
	private EventoDao eventDao;
	
	
	
public List<EventTab> carica_eventi(int id_caritas){
		
		this.listaEv = this.eventDao.cercaEventiCaritas(id_caritas);
		
		
		return listaEv;
		
	}
	

public boolean modificaEvento(int idEve) {
	return eventDao.modificaEvento(idEve);
	
}
	
public Gestisci_Eventi_Caritas_Controller() {
	eventDao = new EventoDao();
}
	
public boolean elimina_evento(String nomeEvento) {
	return eventDao.deliteEvent(nomeEvento);
}
}
