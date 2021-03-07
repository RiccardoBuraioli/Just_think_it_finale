package bean2;

import controller.CreaNecessitaController;


public class CreaNecessitaBoundary {
	
		private int idCaritas;
		private String richiesta;
	    private String tipologia;
	    private String urgenza;
	  
	    
	 
	    public int creaAnnuncioPressed(String tipologia,String urgenza,String richiesta) {
	    	CreaNecessitaController creaNec = new CreaNecessitaController();
	    	creaNec.inizializza(idCaritas);
	    	int i = creaNec.creaNecessita(tipologia, urgenza, richiesta);
	    	return i;
	    }

	    
	    public String getRichiesta() {
			return richiesta;
		}

		public void setRichiesta(String richiesta) {
			this.richiesta = richiesta;
		}

		public String getTipologia() {
			return tipologia;
		}

		public void setTipologia(String tipologia) {
			this.tipologia = tipologia;
		}

		public String getUrgenza() {
			return urgenza;
		}

		public void setUrgenza(String urgenza) {
			this.urgenza = urgenza;
		}

	

		  
	    public void setCaritas(int idCar) {
	    	this.idCaritas = idCar;
	    }
	    
	    
	

}
