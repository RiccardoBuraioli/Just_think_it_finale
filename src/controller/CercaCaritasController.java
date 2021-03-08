package controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bean.CercaCaritas;
import dao.CercaCaritasDao;
import dao.CoordinateDao;
import dao.UserDao;
import entity.MarkerID;


public class CercaCaritasController {
	
	private CercaCaritasDao cercaCaritasD;
	private CoordinateDao coord;
	
	private static final Logger logger = LoggerFactory.getLogger(CercaCaritasController.class);
	
	
	public CercaCaritasController() {
		coord = new CoordinateDao();
		cercaCaritasD = new CercaCaritasDao();

	}

	public void initMap2(int id, String lati, String longi) {
		// logger.trace(c.getCoordinate().toString());
		coord.setCoordinate(id,lati,longi);
	}
	
	

	
	public List<MarkerID> initMarkersCaritas(){
		return cercaCaritasD.getCaritasMarkers();

	}
	public List<MarkerID> initMarkersDonazione(){
		return cercaCaritasD.assegnaMarkerDonazione();

	}
	public List<MarkerID> initMarkersEvento(){
		return cercaCaritasD.assegnaMarkerEvento();

	}

	public void initUser(int idUser, CercaCaritas cercaBean) {
		UserDao v = new UserDao();
		String ruoloUser = v.trovaTipoUtente(idUser);
		cercaBean.setUser(idUser, ruoloUser);
		
		
	}

}
