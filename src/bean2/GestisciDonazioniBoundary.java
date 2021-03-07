package bean2;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.GestisciDonazioniCaritas;
import entity.CaritasUser;
import entity.DonazioneTab;




public class GestisciDonazioniBoundary {
	private int caritas;

	private int idVolontario;
	private int idDono;

	private GestisciDonazioniCaritas gestDon;
	public boolean cancellaDonazione(String i) {
		    	gestDon = new  GestisciDonazioniCaritas();
		    	if (i == null || i.equals("") ) {
		    		return false;
		    	}
		    	else {
		    		int x = Integer.parseInt(i);
		    		gestDon.cancellaDonazione(x);
		    		return true;
		    	}
		    }
		    

	   public void backPressed() {
	 		CaritasHomeBoundary.getInstance();	 		
	    }



	public void contattaVolontario() {
			EmailBoundary email = new EmailBoundary();
			email.loadEmail(this.idVolontario, caritas);
		

	}

	
	public void ritiraDonazione() {
		gestDon.ritiraDon(this.idDono);
	}


	public List<DonazioneTab> loadFormBoundary(int idCar) {
			this.caritas = idCar;
			return gestDon.visualizzaDonazioni(caritas);	
	}

	public GestisciDonazioniBoundary() {
		this.gestDon = new GestisciDonazioniCaritas();
		new ArrayList<>();
	}



}
