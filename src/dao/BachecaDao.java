package dao;

import connector.Connector;
import entity.Necessità;
import entity.Orario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BachecaDao {
	Connector connector;
	
	List<Necessità> necessità;
	
	public BachecaDao() {
		
		
    	connector = new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
    	necessità = new ArrayList();
	}
	
	
	
	public List<Necessità> visualizza_necessità(int id_caritas) {
		
	   	String sql = "call visualizza_necessità(?) ";
	   	int i = 0;
		ResultSet res = null;
		try (Connection conn = connector.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, id_caritas );
	            res = stmt.executeQuery();
	
	           while (res.next()) {
	        	   necessità.add(new Necessità(res.getInt("id_necessità"), res.getString("tipologia"),res.getString("richiesta"), res.getString("urgenza")));
	        	  
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
		
	return necessità;
		
		
		
	}
	
	public int crea_necessità(Necessità necessità, int cod_caritas) {
		 ResultSet rs = null;
	        int NecID = 0;

	        String sql = "call crea_necessità(?,?,?,?)";

	        try (Connection conn = connector.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	           
	        	pstmt.setString(1,necessità.getTipologia());
	        	pstmt.setString(2, necessità.getUrgenza());        	
	        	pstmt.setString(3, necessità.getDescrizione());
	        	pstmt.setInt(4, cod_caritas);

	            int rowAffected = pstmt.executeUpdate();
	            if (rowAffected == 1) {

	                rs = pstmt.getGeneratedKeys();
	                if (rs.next())
	                    NecID = rs.getInt(1);
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        } finally {
	            try {
	                if (rs != null) rs.close();
	            } catch (SQLException e) {
	                System.out.println(e.getMessage());
	            }
	        }
	        return NecID;
	}
	
	
	public boolean elimina_necessità(int nece) {
		 ResultSet rs = null;
		  
		   int rowAffected;
	        String sql = "call elimina_necessità(?)";

	        try (Connection conn = connector.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	           
	        	pstmt.setInt(1,nece);
	        	

	            rowAffected = pstmt.executeUpdate();

	            if (rowAffected == 1) {
	                System.out.println("SUCCESS!");
	            } else { System.out.println("FAIlED"); return false;}


	        } catch (SQLException ex) {
	            System.out.println((ex.getMessage()));
	        }
			    	
	        return true;
	        
	}
	
}
