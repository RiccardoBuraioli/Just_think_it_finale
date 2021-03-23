package controller;

import java.sql.SQLException;
import java.util.List;


import dao.CercaCaritasDao;
import dao.CoordinateDao;
import dao.UserDao;
import entity.CoordinateMap;
import entity.MarkerID;


public class CercaCaritasController {
	
	private CercaCaritasDao cercaCaritasD;
	private CoordinateDao coord;
	
	
	
	public CercaCaritasController() {
		coord = new CoordinateDao();
		cercaCaritasD = new CercaCaritasDao();

	}

	public void initMap2(int id, String lati, String longi) {
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
	
	public List<CoordinateMap> initMarkerCar(){
		return cercaCaritasD.getCoordinateCaritas();
	}
	
	public List<CoordinateMap> initMarkerEvent(){
		return cercaCaritasD.getCoordinateEvento();
	}
	
	public List<CoordinateMap> initMarkerDonation(){
		return cercaCaritasD.getCoordinateDonazione();
	}
	
	public void initUser(int idUser, Object cercaBean) throws NumberFormatException, SQLException {
		UserDao v = new UserDao();
		String ruoloUser = v.trovaTipoUtente(idUser);
		if(cercaBean.getClass() == bean.CercaCaritas.class) {
			((bean.CercaCaritas) cercaBean).setUser(idUser, ruoloUser);
		}
		else if (cercaBean.getClass() == bean2.CercaCaritas.class) {
			((bean2.CercaCaritas) cercaBean).getInstance().setUser(idUser, ruoloUser);
		}
	}
	
	


}
