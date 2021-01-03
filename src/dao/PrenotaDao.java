package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ch.qos.logback.classic.Logger;
import connector.Connector;
import entity.PartecipaTurno;
import entity.Orario;
import entity.Turno;
import entity.TurnoTab;

public class PrenotaDao {

    private final Connector connector;
    private static final String SUCCESS = "Voce modificata con successo!";
    private static final String FAILED = "Operazione non riuscita.";

    private List<TurnoTab> listTurn;
	private String[] resGiorno = {null, null, null, null, null, null, null, null};
	private Orario[] ora;
	private List<Orario> oraArrayList;
	public PrenotaDao() {
		
        this.connector =  new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");;
        
	}
	
		
		
	
	
	public String[] visualizza_giorni() {
		
		
	   	String sql = "Select * from giorni order by num_giorno ";
	   	int i = 0;
		ResultSet res = null;
		try (Connection conn = connector.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
	
	           res = stmt.executeQuery();
	           
	
	           
	           while (res.next()) {
	        	   resGiorno[i] = res.getString("Nome");
	        	   i++;
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
		return resGiorno;
		
		
		
	}
	
	
	

	public List<Orario> visualizza_orario2() {
		this.oraArrayList = new ArrayList<Orario>();
		ResultSet res = null;
		String sql = "Select ora_inizio, ora_fine from orari ";
		
		try (Connection conn = connector.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
	
			
			res = stmt.executeQuery();

			while (res.next()) {
				oraArrayList.add(new Orario(res.getString("ora_inizio"), res.getString("ora_fine")));
			
			 } } catch (SQLException ex) {
		            System.out.println(ex.getMessage());
		        } finally {
		            try {
		                if (res != null) res.close();
		            } catch (SQLException e) {
		                System.out.println(e.getMessage());
		            }
		        }
		
		return oraArrayList;

	}
	
	
	
	public boolean partecipazione_turno(PartecipaTurno turno) {
	
    	int rowAffected;
   		ResultSet rs = null;
   		
      	//Registra Caritas
  	    String sql = "call prenota_turno(?,?,?, ?)";

          try (Connection conn = connector.getConnection();
               PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        	  pstmt.setInt(3, turno.getCodice_caritas());
        	  pstmt.setInt(1, turno.getCodice_volontario());
        	  pstmt.setInt(2, turno.getCodice_Turno());
        	  pstmt.setString(4, turno.getCurriculum());
           
          
              rowAffected = pstmt.executeUpdate();

              if (rowAffected == 1) {
                  System.out.println(SUCCESS);
              } else System.out.println(FAILED);


          } catch (SQLException ex) {
              System.out.println((ex.getMessage()));
          }
		    	
   
    	return true;
    	
	}
	
	
	public int trova_turno(Turno turno ) {
		String sql;
		
		int ID = 0;
		
	   	sql = "call trova_id_turno(?,?,?)";
	
		ResultSet res = null;
		try (Connection conn = connector.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
	
	           stmt.setString(1, turno.getGiorno());
	           stmt.setString(2, turno.getOrai());
	           stmt.setString(3, turno.getOraf());
	           res = stmt.executeQuery();
	
	           while (res.next()) {
	        	  ID = res.getInt("id_turno");
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

		return ID;
		
	}





	public List<TurnoTab> visualizzaTurni(int idCaritas) {
		String 	sql = "call Visualizza_turno_caritas(?)";
		ResultSet res = null;
		listTurn = new ArrayList<TurnoTab>();
		try (Connection conn = connector.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
	
	           stmt.setInt(1,idCaritas);
	       
	           res = stmt.executeQuery();
	
	           while (res.next()) {
	        	   this.listTurn.add(new TurnoTab(res.getInt("numMaxParte"), res.getInt("id_turno") ,res.getInt("codCar"),res.getString("Giorno"), res.getString("OraInizio"),res.getString("OraFine"),  res.getString("Note"),  res.getInt("Partecipanti")));
	        	 
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
		return listTurn;
	}
	
	
	
	public boolean cancellaTurno(int idTurn) {
		   int rowAffected;
	 		ResultSet rs = null;

	    	//Registra Caritas
		    String sql = "call cancella_turno(?)";

	        try (Connection conn = connector.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
		       	  pstmt.setInt(1, idTurn);
	      
	            rowAffected = pstmt.executeUpdate();

	            if (rowAffected == 1) {
	                System.out.println(SUCCESS);
	            } else { System.out.println(FAILED); return false;}


	        } catch (SQLException ex) {
	            System.out.println((ex.getMessage()));
	        }
			    	
	        return true;
	
	}
	
	
	
	public boolean creaTurno(int codCar,String nomGiorn, String newNote,String oraIniz, String oraFin, int numParte) {
		  int rowAffected;
	 		ResultSet rs = null;

	    	//Registra Caritas
		    String sql = "call crea_turno(?,?,?,?,?,?)";

	        try (Connection conn = connector.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
		       	  pstmt.setInt(1, codCar);
		       	  pstmt.setString(2, newNote);
		       	  pstmt.setString(3, oraIniz);
		       	  pstmt.setString(4, oraFin);
		       	  pstmt.setInt(5, numParte);
		       	  pstmt.setString(6, nomGiorn);


	            rowAffected = pstmt.executeUpdate();

	            if (rowAffected == 1) {
	                System.out.println(SUCCESS);
	            } else { System.out.println(FAILED); return false;}


	        } catch (SQLException ex) {
	            System.out.println((ex.getMessage()));
	        }
		return false;
		
	}
	
	
	public boolean modificaTurno(int idTurn, String newNote, int codCar) {
		
		   int rowAffected;
	 		ResultSet rs = null;

	    	//Registra Caritas
		    String sql = "call modifica_turno(?,?,?)";

	        try (Connection conn = connector.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
		       	  pstmt.setInt(1, idTurn);
		       	  pstmt.setInt(2, codCar);
		       	  pstmt.setString(3, newNote);
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