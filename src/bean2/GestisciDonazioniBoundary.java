package bean2;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.GestisciDonazioniCaritas;
import entity.CaritasUser;
import entity.DonazioneTab;




public class GestisciDonazioniBoundary {
	private static Logger logger = LoggerFactory.getLogger(GestisciDonazioniBoundary.class.getName());

	private String s = "errore IOException";


	private List<DonazioneTab> listDon;

	private CaritasUser caritas;

	private int idVolontario;
	private int idDono;

	private GestisciDonazioniCaritas gestDon;
	private CaritasHomeBoundary caritasHomeBoundary;


	public boolean cancellaDonazione(String i) {
		    	gestDon = new  GestisciDonazioniCaritas();
		    	if (i == null || i == "" ) {
		    		return false;
		    	}
		    	else {
		    		int x = Integer.parseInt(i);
		    		gestDon.cancellaDonazione(x);
		    		return true;
		    	}
		    }
		    

	   public void backPressed() {
	 		caritasHomeBoundary = CaritasHomeBoundary.getInstance();	 		
	    }



	public void contattaVolontario() {
			EmailBoundary email = null;
			//email = fxmlLoader.getController();
			email.loadEmail(this.idVolontario, this.caritas.getId());
		

	}

	/*@FXML
	void ritiraDonazione(ActionEvent event) {
		gestDon.ritiraDon(this.idDono);

	}*/


	public List<DonazioneTab> loadFormBoundary(int id) {
			return this.listDon = gestDon.visualizzaDonazioni(this.caritas.getId());	
	}

	public GestisciDonazioniBoundary() {
		this.gestDon = new GestisciDonazioniCaritas();
		listDon = new ArrayList<>();
	}

	public CaritasUser getCaritas() {
		return this.caritas;
	}

	public void setCaritas(CaritasUser currentUser) {
		this.caritas = currentUser;
	}

}
