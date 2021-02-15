package bean2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import entity.CaritasUser;


public class CaritasHomeBoundary {


	private  static CaritasHomeBoundary instance = null;
	private static Logger logger = LoggerFactory.getLogger(CaritasHomeBoundary.class.getName());
	private CaritasUser currentUser;
	private GestisciTurniBoundary gestTurn;
	private GestisciDonazioniBoundary gestDon;
	private GestisciEventiBoundary gestisciB;
	private BachecaPersonaleBoundary bacheca;


	
	
	public GestisciTurniBoundary getGestTurn() {
		return gestTurn;
	}



	public void setGestTurn(GestisciTurniBoundary gestTurn) {
		this.gestTurn = gestTurn;
	}



	public GestisciDonazioniBoundary getGestDon() {
		return gestDon;
	}



	public void setGestDon(GestisciDonazioniBoundary gestDon) {
		this.gestDon = gestDon;
	}



	public GestisciEventiBoundary getGestisciB() {
		return gestisciB;
	}



	public void setGestisciB(GestisciEventiBoundary gestisciB) {
		this.gestisciB = gestisciB;
	}



	public BachecaPersonaleBoundary getBacheca() {
		return bacheca;
	}



	public void setBacheca(BachecaPersonaleBoundary bacheca) {
		this.bacheca = bacheca;
	}



	public static CaritasHomeBoundary getInstance() {
		if (instance == null) {
			instance = new CaritasHomeBoundary();
			}
		return instance;
	}
	
	
	 public void gestisciDonazioni() {
		 	gestDon = new GestisciDonazioniBoundary();
    		gestDon.setCaritas(this.currentUser);
    		gestDon.loadFormBoundary(currentUser.getId());  		
	 	}


	 public void gestisciEventi() {
		// handle the event here
		 	gestisciB = new GestisciEventiBoundary();
    		gestisciB.setCaritas(currentUser);
    		gestisciB.loadShop(currentUser.getId());    			
	}

	
	public void gestisciTurni() {
			 gestTurn = new GestisciTurniBoundary();
    		 gestTurn.setCurrentUser(this.currentUser);
    		 gestTurn.loadFormBoundary(currentUser.getId());
	}

	
	 // dobbiamo far fare un controllo alla bacheca_controller nel quale a seconda di chi entra ( carita o altri ) il tasto indietro porta alla schermata giusta.
	public void visualizzaBacheca() {
		     bacheca= new BachecaPersonaleBoundary();
    		 bacheca.setCurrentUser(this.currentUser);
    		 bacheca.loadFormBoundary(currentUser.getId());
	}
	

	/*@FXML
	void deleteAccountButtonPressed(ActionEvent event) {
		 handle the event here
	}

	@FXML
	void helpButtonPressed(ActionEvent event) {
		// handle the event here
	}

	@FXML
	void leftArrowPressed(ActionEvent event) {
		// handle the event here
	}

	
	@FXML
	void profileButtonPressed(ActionEvent event) {
		// handle the event here
	}

	@FXML
	void rightArrowPressed(ActionEvent event) {
		// handle the event here
	}*/

	public CaritasUser getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(CaritasUser currentUser) {
		this.currentUser = currentUser;
	}

	public void initData(CaritasUser user) {
		setCurrentUser(user);
		//nomeCognome.setText(user.getNomeCaritas());
		}

}
