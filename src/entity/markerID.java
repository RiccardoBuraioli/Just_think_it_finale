package entity;




import com.sothawo.mapjfx.Marker;




public class markerID{
	private Marker[] markerCarita = {null,null,null,null,null,null,null};
	private int id[] = {0,0,0,0,0,0,0,0};
	
	
	public markerID(Marker[] caritas, int idCaritas[]) {
		this.markerCarita = caritas;
		this.id = idCaritas;
				
	}

	public markerID() {
		
	}

	public  int[] idMarker() {
		
		return this.id;
	}
	
	public Marker  getMarker(int i) {
		return this.markerCarita[i];
	}
	
	
   public void setMarker(int i, Marker nuovo) {
		this.markerCarita[i] = nuovo;
	}

  public  void setID(int i, int nuovoi) {
	  this.id[i]= nuovoi;
  }   
}


