package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sothawo.mapjfx.Coordinate;
import com.sothawo.mapjfx.Marker;

import entity.marker_id;
import connector.Connector;


public class CercaCaritasDao {
	
//	private static final Marker[]  = null;
	private final Connector connector;
	 
	 public CercaCaritasDao() {
		    this.connector =  new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");;
		}

	 
	
	public marker_id assegna_marker() {
		
		//Marker[] markerCaritas = {null,null,null,null,null,null,null};
		// id[] = {0,0,0,0,0,0,0,0};
		String sql = "Call assegna_marker()";
		ResultSet rs = null;
		int count = 0;
		marker_id markerC = new marker_id();

		
		try (Connection conn = connector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

        
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Coordinate caritas_coordinate = new Coordinate(Double.parseDouble(rs.getString("latitudine")),Double.parseDouble(rs.getString("longitudine")));
				markerC.setMarker(count, Marker.createProvided(Marker.Provided.RED).setPosition(caritas_coordinate));
				markerC.setID(count,  rs.getInt("CodiceCaritas"));
				count++;
        	 
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
		
		return markerC;
		}
		
	
	public Marker[] assegna_marker_evento() {
		
		Marker[] markerEvento = {null,null,null,null,null,null,null};
		
		 String sql = "Call assegna_marker_evento()";
	     ResultSet rs = null;
	     int count = 0;

	     try (Connection conn = connector.getConnection();
	          PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        
	         rs = pstmt.executeQuery();

	         while (rs.next()) {
	        	 Coordinate evento_coordinate = new Coordinate(Double.parseDouble(rs.getString("latitudine")),Double.parseDouble(rs.getString("longitudine")));
	        	 markerEvento[count] = Marker.createProvided(Marker.Provided.BLUE).setPosition(evento_coordinate);
	        	
	        	 count++;
	        	 
	         } 

	     } catch (SQLException ex) {
	         System.out.println(ex.getMessage());
	     } finally {
	         try {
	             if (rs != null) rs.close();
	         } catch (SQLException e) {
	             System.out.println(e.getMessage());
	         }
	     } return markerEvento;
		}
	
	
	public Marker[] assegna_marker_donazione() {
		
		Marker[] markerDonazione = {null,null,null,null,null,null,null};
		
		 String sql = "Call assegna_marker_donazione()";
	     ResultSet rs = null;
	     int count = 0;

	     try (Connection conn = connector.getConnection();
	          PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        
	         rs = pstmt.executeQuery();

	         while (rs.next()) {
	        	 Coordinate donazione_coordinate = new Coordinate(Double.parseDouble(rs.getString("latitudine")),Double.parseDouble(rs.getString("longitudine")));
	        	 markerDonazione[count] = Marker.createProvided(Marker.Provided.GREEN).setPosition(donazione_coordinate);
	        	 
	        	 count++;
	        	 
	         } 

	     } catch (SQLException ex) {
	         System.out.println(ex.getMessage());
	     } finally {
	         try {
	             if (rs != null) rs.close();
	         } catch (SQLException e) {
	             System.out.println(e.getMessage());
	         }
	     } return markerDonazione;
		}
}
	


