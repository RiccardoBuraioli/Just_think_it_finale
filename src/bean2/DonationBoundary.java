package bean2;


import controller.DonationController;


public class DonationBoundary {
	private String indirizzo;
	private String descrizione;
	private int tipo;
	

	private DonationController controller;

	public DonationBoundary() {
		controller = DonationController.getInstance();
	}

	
	public int creaDonazione(int tipo, String indirizzo) {
		controller.setTipologia(this.tipo);
		controller.setIndirizzo(this.indirizzo);
		controller.setDescrizione(this.descrizione);
		controller.creaDonazione();
		return 0;
	}
	



	

	public void initBoundary(int idCar, int idUte) {
		controller.initController(idCar, idUte);
	}

}

