package bean2;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.CaritasHomeController;
import entity.CaritasUser;



public class CaritasHomeBoundary {

	
	private int idCar;
	
	private static CaritasHomeBoundary instance = null;
	private static Logger logger = LoggerFactory.getLogger(CaritasHomeBoundary.class.getName());
	private String s = "errore IoException";

	private CaritasHomeController caritasHomeC;
	private GestisciTurniBoundary gestTurn;
	private GestisciDonazioniBoundary gestDon;
	private GestisciEventiCaritasBoundary gestisciB;
	
	private BachecaPersonaleBoundary bacheca;



	public static CaritasHomeBoundary getInstance() {
		if (instance == null) {
			instance = new CaritasHomeBoundary();
		}
		return instance;
	}

	public CaritasHomeBoundary() {
		bacheca = new BachecaPersonaleBoundary();
		gestTurn = new GestisciTurniBoundary();
		gestDon = new GestisciDonazioniBoundary();
		gestisciB = new GestisciEventiCaritasBoundary();
	}

	public void gestisciDonazioni() {		
		gestDon.loadFormBoundary(idCar);
	}

	
	public void gestisciEventi() {			
			gestisciB.loadShop(idCar);
	}

	
	public void gestisciTurni() {
			gestTurn.loadFormBoundary(idCar);
	}

	// dobbiamo far fare un controllo alla bacheca_controller nel quale a seconda di
			// chi entra ( carita o altri ) il tasto indietro porta alla schermata giusta.
	public void visualizzaBacheca() {		
			bacheca.loadFormBoundary(idCar);
	}

	void deleteAccountButtonPressed() {
		// handle the event here
	}

	void helpButtonPressed() {
		// handle the event here
	}


	
	/*void logoutButtonPressedCaritas() {
	 	
    	TransizionePagine pageSwitch = new TransizionePagine();
    	pageSwitch.logout(logoutButton.getScene().getWindow());
    	

	}*/

	public void initDataC(int id, String nome) {
		this.idCar = id;
		//nomeCognome.setText(nome);
	}

}