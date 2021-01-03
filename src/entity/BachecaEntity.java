package entity;

import java.util.List;

public class BachecaEntity {
	private int id_caritas;
	private List<Necessità> necessità;
	
	
	
	public BachecaEntity() {
		
	}
	
	
	
	public int getId_caritas() {
		return id_caritas;
	}
	public void setId_caritas(int id_caritas) {
		this.id_caritas = id_caritas;
	}
	public List<Necessità> getNecessità() {
		return necessità;
	}
	public void setNecessità(List<Necessità> necessità) {
		this.necessità = necessità;
	}
}
