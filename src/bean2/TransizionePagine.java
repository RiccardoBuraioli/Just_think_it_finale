package bean2;


import java.sql.SQLException;
import controller.CaritasHomeController;
import controller.CercaCaritasController;


public class TransizionePagine {


	public TransizionePagine() {
		//default
	}
				
	
	public void apriMappa(int idUser) throws NumberFormatException, SQLException {
	        CercaCaritas cercaCaritasBean = new CercaCaritas();
	        CercaCaritasController controller = new CercaCaritasController(); 
	        controller.initUser(idUser, cercaCaritasBean);
	        //final Projection projection = Projection.WEB_MERCATOR;	      
	        //cercaCaritasBean.initMapAndControls(projection);
	}
	
	
	public void backToMenuCaritas(int idUser) {
			CaritasHomeBoundary caritasHomeBoundary = new CaritasHomeBoundary();
			CaritasHomeController caritasHomeC = new CaritasHomeController();
			caritasHomeC.initDataCaritas(idUser, caritasHomeBoundary);
	}
	

/*	public boolean checkerText(TextField[] text) {
		for (int i = 0; i < text.length; i++) {
			if (text[i].getText().isEmpty()) {
				
				return true;
			}
		}
				
		return false;
	}*/
	
	
	
	
}
