package controller;

import java.util.List;

import bean.GestisciEventiBoundary;
import dao.EventoDao;
import entity.EventTab;
import entity.Evento;

public class Gestisci_eventi_Controller {
	private GestisciEventiBoundary gestisci_eventi_b;
	private List<EventTab> lista_ev;
	private EventoDao event_dao;
	
	
	
	public Gestisci_eventi_Controller() {
	
		event_dao = new EventoDao();
	}
	
	
	public List<EventTab> carica_eventi(int id_shop){
		
		lista_ev = event_dao.cerca_eventi(id_shop);
		
		
		return lista_ev;
		
	}
	
	public boolean elimina_evento(String nomeEvento) {
		return event_dao.deliteEvent(nomeEvento);
	}
	
	
	public boolean modifica_note_evento(String noteEvento) {
		return false;
		
	}
	
}
