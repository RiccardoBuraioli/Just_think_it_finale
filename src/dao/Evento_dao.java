package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connector.Connector;
import entity.Evento;
import entity.partecipa_evento;

public class Evento_dao {

	private static final String SUCCESS = "Voce modificata con successo!";
    private static final String FAILED = "Operazione non riuscita.";


    private final Connector connector;
	
	
    public Evento_dao() {
    	connector = new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
    }
	
	
    
    public Evento crea_evento(Evento event) {
		
    	
    	int rowAffected;
   		ResultSet rs = null;

      	//Registra Caritas
  	    String sql = "call crea_evento(?,?,?,?,?,?)";

          try (Connection conn = connector.getConnection();
               PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        	  pstmt.setInt(1, event.getNeg());
        	  pstmt.setString(2, event.getNome());
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
    
}
