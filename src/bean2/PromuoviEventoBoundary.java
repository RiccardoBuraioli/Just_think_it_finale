package bean2;
import controller.PromuoviEventoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
	    
	    public void confermaPressed() {
	   /* String tipo = "Vestiti";
	    if(idCibo.isSelected()) {
	    	tipo = "Cibo";
	    }*/
	    float costoEvento = Float.parseFloat(prezzo);
	    
	    PromuoviEventoController promuoviEvento = new PromuoviEventoController();
	    promuoviEvento.loadForm(idCar, idShop);
	    
	    promuoviEvento.creaEventoController(nome,tipo, note, costoEvento );	
	    }

		public void loadFormBoundary(int idCar, int idShop) {
			this.idCar = idCar;
			this.idShop = idShop;
			
		}

	

}
