package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connector.Connector;
import entity.EventTab;
import entity.Evento;
import entity.Necessità;
import entity.partecipa_evento;

public class EventoDao {

	private static final String SUCCESS = "Voce modificata con successo!";
    private static final String FAILED = "Operazione non riuscita.";
    private List<EventTab> listEv;


    private final Connector connector;
	
	
    public EventoDao() {
    	connector = new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
    	listEv = new ArrayList<EventTab>();
    }
	
    
    public List<EventTab> cerca_eventi(int id_shop){

	   	String sql = "call visualizza_tuoi_eventi(?) ";
	   	int i = 0;
		ResultSet res = null;
		try (Connection conn = connector.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, id_shop );
	            res = stmt.executeQuery();
	
	           while (res.next()) {
	        	   listEv.add(new EventTab(res.getString("NomeEvento"),res.getString("NomeCaritas"), res.getString("NoteEvento"), res.getFloat("PrezzoEvento"),res.getFloat("Importo"), res.getInt("numPartecipanti"), res.getInt("CodiceCaritas"), res.getInt("Completato")));
	        	  
	           }
	       } catch (SQLException ex) {
	           System.out.println(ex.getMessage());
	       } finally {
	           try {
	               if (res != null) res.close();
	           } catch (SQLException e) {
	               System.out.println(e.getMessage());
	           }
	       }
    	
    	
    	
    	
    	return listEv;
    	
    }
	
    
    public List<EventTab> cercaEventiCaritas(int idCar){

	   	String sql = "call visualizza_eventi_caritas(?) ";
	   	int i = 0;
		ResultSet res = null;
		try (Connection conn = connector.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, idCar );
	            res = stmt.executeQuery();
	
	           while (res.next()) {
	        	   listEv.add(new EventTab(res.getString("NomeEvento"), res.getString("NoteEvento"), res.getFloat("PrezzoEvento"),res.getString("NomeNegozio"), res.getFloat("Importo"), res.getInt("numPartecipanti"), res.getInt("Completato"), res.getInt("CodiceNegozio")));
	        	  
	           }
	       } catch (SQLException ex) {
	           System.out.println(ex.getMessage());
	       } finally {
	           try {
	               if (res != null) res.close();
	           } catch (SQLException e) {
	               System.out.println(e.getMessage());
	           }
	       }
    	
    	
    	
    	
    	return listEv;
    	
    }
    
    
    
    public Evento crea_evento(Evento event) {
		
    	
    	int rowAffected;
   		ResultSet rs = null;

      	//Registra Caritas
  	    String sql = "call crea_evento(?,?,?,?,?,?)";

          try (Connection conn = connector.getConnection();
              PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        	  pstmt.setInt(1, event.getNeg());
        	  pstmt.setString(2, event.getNomeEvento());
        	  pstmt.setString(2, event.getNote());
        	  pstmt.setString(4, event.getTipo());
        	  pstmt.setFloat(5,event.getPrezzo());
        	  pstmt.setString(6, event.getCoord());
          	
           
          
              rowAffected = pstmt.executeUpdate();

              if (rowAffected == 1) {
                  System.out.println(SUCCESS);
              } else System.out.println(FAILED);


          } catch (SQLException ex) {
              System.out.println((ex.getMessage()));
          }
		    	
    	
    	return event;
    	
    }
    
   public partecipa_evento Crea_partecipazione(partecipa_evento partepaEvento) {
	   int rowAffected;
  		ResultSet rs = null;

     	//Registra Caritas
 	    String sql = "call partecipa_evento(?,?,?)";

         try (Connection conn = connector.getConnection();
              PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	       	  pstmt.setInt(1, partepaEvento.getcodice());
	       	  pstmt.setInt(2, partepaEvento.getVolo());
	       	  pstmt.setFloat(3,partepaEvento.getImporto());
	       
	         	
          
         
             rowAffected = pstmt.executeUpdate();

             if (rowAffected == 1) {
                 System.out.println(SUCCESS);
             } else System.out.println(FAILED);


         } catch (SQLException ex) {
             System.out.println((ex.getMessage()));
         }
		    	
   	
   	return partepaEvento;
	   
   }
    
   
   public boolean deliteEvent(String evento) {
	   
	   int rowAffected;
 		ResultSet rs = null;

    	//Registra Caritas
	    String sql = "call cancella_evento(?)";

        try (Connection conn = connector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	       	  pstmt.setString(1, evento);
      
            rowAffected = pstmt.executeUpdate();

            if (rowAffected == 1) {
                System.out.println(SUCCESS);
            } else { System.out.println(FAILED); return false;}


        } catch (SQLException ex) {
            System.out.println((ex.getMessage()));
        }
		    	
        return true;
        
   }
   
   
}
