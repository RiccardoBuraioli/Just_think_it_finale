package entity;

import java.util.List;

public class BachecaEntity {
	private int idCaritas;
	private List<Necessita> necessita;
	
	
	public int getIdCaritas() {
		return idCaritas;
	}
	public void setIdCaritas(int id_caritas) {
		this.idCaritas = id_caritas;
	}
	public List<Necessita> getNecessità() {
		return necessita;
	}
	public void setNecessita(List<Necessita> necessita) {
		this.necessita = necessita;
	}
}
