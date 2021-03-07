package bean2;


import java.util.List;
import controller.BachecaController;
import entity.Necessita;


public class BachecaBoundary {
	private int idCar;
	private int idUte;

	

	public void creaDonazione() {
			DonationBoundary donationBoundary = new DonationBoundary();
			//donationBoundary.initBoundary(idCar, idUte);
	}


	public void creaEmail() {
		EmailBoundary emailBoundary = new EmailBoundary();
			emailBoundary.loadEmail(idCar, idUte);
		}

/*	public void loadFormBoundary(int idCar, int idUte) {
		this.idCar = idCar;
		this.idUte = idUte;
		BachecaController bachecaController = new BachecaController();
		List<Necessita> necessita = bachecaController.loadForm(idCar);

		for (int i = 0; i < necessita.size(); i++) {
			Necessita tmp = necessita.get(i);

			switch (tmp.getTipologia()) {
			case "Vestiti":
				vestiti.setText(tmp.getDescrizione());
				break;

			case "Cibo":
				cibo.setText(tmp.getDescrizione());
				break;
			case "Varie":
				varie.setText(tmp.getDescrizione());
				break;

			default:
				break;

			}

		}

	}*/

}
