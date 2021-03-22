package bean2;


import controller.DonationController;


public class DonationBoundary {
	private String indirizzo;
	private String descrizione;
	private int tipo;
	

	private DonationController controller;
	private int utente;
	private int idCar;

	public DonationBoundary() {
		controller = DonationController.getInstance();
	}
	
	
	
	public int creaDonazione(int tipo, String indirizzo,String descrizione, String idCaritas){
		//int idCar = Integer.parseInt(idCaritas);
		controller.setTipologia(this.tipo);
		controller.setIndirizzo(this.indirizzo);
		controller.setDescrizione(this.descrizione);
		controller.creaDonazione2( tipo , indirizzo, descrizione,this.utente,this.idCar);
		return 0;
	}
	



	

	public void initBoundary(int idCar, int idUte) {
		this.utente = idUte;
		this.idCar = idCar;
		controller.initController(idCar, idUte);
	}

}

