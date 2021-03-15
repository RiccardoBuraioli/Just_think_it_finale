package bean2;

import java.sql.SQLException;
import java.util.List;

import com.sothawo.mapjfx.Marker;

import controller.CercaCaritasController;
import controller.ShopHomeController;
import controller.UserHomeController;
import entity.MarkerID;

public class a {
	private String ruolo;
	private String v = "Volontario";
	private String c = "Caritas";
	private String n = "Negozio";
	private int idUser;
	private CercaCaritasController cercaController;
	private List<MarkerID> markerCaritas;
	private List<MarkerID> markerEventi;
	private List<MarkerID> markerDonazioni;
	
	
	public int indietro() {
	if (ruolo.equals(v)) {				
				UserHomeBoundary userHomeBoundary = new UserHomeBoundary();
				UserHomeController userHomeController = new UserHomeController();
				userHomeController.initDataCont(this.idUser,userHomeBoundary);
				return 2;
	}
	else if(ruolo.equalsIgnoreCase(n)) {
			ShopHomeBoundary shopHomeBoundary = new ShopHomeBoundary();
			ShopHomeController shopHomeC = new ShopHomeController();
			shopHomeC.initDataShop(this.idUser, shopHomeBoundary);
			return 4;
	}
	
	else{
		return 3;
	}
	}
	
	
	public void promuoviEvento(int idCar, int idShop) {
			PromuoviEventoBoundary promEvento = new PromuoviEventoBoundary();
			promEvento.loadFormBoundary(idCar, idShop);
		}


	public void vediNecessita(int idCar, int idUt) {
			BachecaBoundary bacheca =  new BachecaBoundary();
			bacheca.loadFormBoundary(idCar, idUt);
	}

	public void apriDonazione(int idCar, int idUt) {
			DonationBoundary donationBoundary = new DonationBoundary();
			donationBoundary.initBoundary(idCar, idUt);
	}

	public void prenotaTurno(int idCar, int idUt) {
			PrenotaTurnoBoundary prenotaController = new PrenotaTurnoBoundary() ;
			prenotaController.setData(idCar, idUt);		
	}
	

	public void partecipaEvento(int idEvent, int idUt) {
			PartecipaEventoBoundary partecipaEvent = new PartecipaEventoBoundary();
			partecipaEvent.setData(idEvent, idUt);
		}
	

	public void CercaCaritas() throws NumberFormatException, SQLException {
		cercaController = new CercaCaritasController();
		initMarkers();
	}

	public void initMarkers() {
		markerEventi =	cercaController.initMarkersEvento();
		for (MarkerID markerE : markerEventi) {
			markerE.getMarker().setVisible(false);
		}

		markerDonazioni =	cercaController.initMarkersDonazione();
		for (MarkerID markerD : markerDonazioni) {
			markerD.getMarker().setVisible(false);
		}

		//markerClick = Marker.createProvided(Marker.Provided.ORANGE).setVisible(true);

		markerCaritas = cercaController.initMarkersCaritas();

		for (MarkerID markerC : markerCaritas) {
			markerC.getMarker().setVisible(true);
		}
	}
	
	public void setUser(int id, String ruolo) {
		this.idUser = id;
		this.ruolo = ruolo;
	}
			
}
