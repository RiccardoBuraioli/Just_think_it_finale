package bean2;

import java.util.List;
import controller.BachecaPersonaleController;
import entity.Necessita;

public class BachecaPersonaleBoundary {
	
	private int idCar;
	private BachecaPersonaleController bachecaController;
	private CaritasHomeBoundary caritasHomeBoundary;
	private CreaNecessitaBoundary creaNec;
	private Necessita nec;
	private int i;
	
	public int getI() {
		return i;
	}



	public void setI(int i) {
		this.i = i;
	}



	public Necessita getNec() {
		return nec;
	}



	public void setNec(Necessita nec) {
		this.nec = nec;
	}

	
	public CreaNecessitaBoundary getCreaNec() {
		return creaNec;
	}



	public void setCreaNec(CreaNecessitaBoundary creaNec) {
		this.creaNec = creaNec;
	}



	public CaritasHomeBoundary getCaritasHomeBoundary() {
		return caritasHomeBoundary;
	}



	public void setCaritasHomeBoundary(CaritasHomeBoundary caritasHomeBoundary) {
		this.caritasHomeBoundary = caritasHomeBoundary;
	}


	public void creaNecessita() {
			 creaNec.setCaritas(idCar);
	}

	
	public boolean eliminaNecessita(String i){
		bachecaController = new BachecaPersonaleController();
		if (i == null || i.equals("")) {
			return false;
		}
		else {
			int x = Integer.parseInt(i);
			bachecaController.eliminaAnnuncio(x);
			return true;
		}
	}

	
	public List<Necessita> loadFormBoundary(int id) {
		bachecaController = new BachecaPersonaleController();
		List<Necessita> necessitaList = bachecaController.loadForm(id);
		return necessitaList;	
	}
	


}
