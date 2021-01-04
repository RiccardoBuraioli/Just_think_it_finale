package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sothawo.mapjfx.Coordinate;

import connector.Connector;

public class CoordinateDao {

	private Connector connector;
	private int idUtente;
	
    
    public CoordinateDao(int idUtente) {
    	
    	 // a couple of markers using the provided ones
    	this.connector = new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
    	
    	this.idUtente = idUtente;
    }
	
 
    
    public Coordinate getCoordinate() {

    	String sql;
    	String lat=""; 
    	String lon ="";
    	
       	sql = "call get_coordinate(?)";
    
    	ResultSet res = null;
    	try (Connection conn = connector.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

               stmt.setInt(1, idUtente);
               res = stmt.executeQuery();

               while (res.next()) {
            	  
            	   lat = res.getString("latitudine");
            	   lon = res.getString("longitudine");
            	   
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
    
    		Coordinate coordinate = new Coordinate(Double.parseDouble(lat), Double.parseDouble(lon));
    		System.out.print( " COORDINATE VOLONTARIO " + coordinate.getLatitude() + " " +coordinate.getLongitude() );
    		return coordinate;
    	
    }
    
    public void close() {
    	try {
			connector.getConnection().close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    }
	
}
