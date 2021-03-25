package bean2;
import controller.PromuoviEventoController;


public class PromuoviEventoBoundary {


		private int idCar;
		private int idShop;

		
	    private String nome;
	    private String prezzo;
	    private String note;
	    private String tipo;
	   
	    public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getPrezzo() {
			return prezzo;
		}

		public void setPrezzo(String prezzo) {
			this.prezzo = prezzo;
		}

		public String getNote() {
			return note;
		}

		public void setNote(String note) {
			this.note = note;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
	    
	   public int confermaPressed() {
	   /* String tipo = "Vestiti";
	    if(idCibo.isSelected()) {
	    	tipo = "Cibo";
	    }*/
	    float costoEvento = Float.parseFloat(prezzo);
	    PromuoviEventoController promuoviEvento = new PromuoviEventoController();
	    promuoviEvento.loadForm(idCar, idShop);
	    promuoviEvento.creaEventoController(nome,tipo, note, costoEvento );	
	    return 0;
	    }

		public void loadFormBoundary(int idCar, int idShop) {
			this.idCar = idCar;
			this.idShop = idShop;
			
		}

	

}
