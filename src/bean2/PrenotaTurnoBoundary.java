package bean2;



import controller.PrenotaTurnoController;
import entity.Orario;


public class PrenotaTurnoBoundary {

	private PrenotaTurnoController prenotaC;


    public void prenotaTurno() {

		//prenotaC.prenotaTurno(turni, cbOraInizio, OraFine, cv);
	}

	public boolean checker() {
		return false;
		
		// Controlla che non ci siano campi lasciati vuoti

		/*if (cv.getText().isEmpty()) {
			logger.debug("riprova");
			return false;
		} else {
			return true;
		}*/
	}

/*	@FXML
	void initialize() {
		prenotaC = new PrenotaTurnoController();

		String[] giorni;

		giorni = prenotaC.inizializzaGiorni();

		for (int i = 0; i < 8; i++) {
			turni.getItems().add(giorni[i]);
		}

		List<Orario> oraArrayList = prenotaC.initializzaOrari();

		int i = 0;
		while (i < oraArrayList.size()) {

			cbOraInizio.getItems().add(oraArrayList.get(i).getOraFine());

			cbOraFine.getItems().add(oraArrayList.get(i).getOraInizio());

			i++;

		}

	}*/

	public void setData(int idCar, int idUte) {
		prenotaC.setDataController(idCar, idUte);
	}
}

