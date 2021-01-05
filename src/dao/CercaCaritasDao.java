package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sothawo.mapjfx.Coordinate;
import com.sothawo.mapjfx.Marker;

import entity.MarkerID;
import connector.Connector;


public class CercaCaritasDao {
	
	private final Connector connector;
	private String lati = "latitudine";
	private String longi = "longitudine";
	
	 public CercaCaritasDao() {
		    this.connector =  new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
		}

	 
	
	public MarkerID assegnaMarker() {
		
		String sql = "Call assegna_marker()";
		ResultSet rs = null;
		int count = 0;
		MarkerID markerC = new MarkerID();

		
		try (Connection conn = connector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

        
			rs = pstmt.executeQuery();

			while (rs.next()) {
				double lati = Double.parseDouble(rs.getString(this.lati));
				double longi = Double.parseDouble(rs.getString(this.longi));
				Coordinate caritasCoordinate = new Coordinate(lati,longi);
				markerC.setMarker(count, Marker.createProvided(Marker.Provided.RED).setPosition(caritasCoordinate));
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
		
	
	public Marker[] assegnaMarkerEvento() {
		
		Marker[] markerEvento = {null,null,null,null,null,null,null};
		
		 String sql = "Call assegna_marker_evento()";
	     ResultSet rs = null;
	     int count = 0;

	     try (Connection conn = connector.getConnection();
	          PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        
	         rs = pstmt.executeQuery();

	         while (rs.next()) {
	        	 Coordinate eventoCoordinate = new Coordinate(Double.parseDouble(rs.getString(this.lati)),Double.parseDouble(rs.getString(this.longi)));
	        	 markerEvento[count] = Marker.createProvided(Marker.Provided.BLUE).setPosition(eventoCoordinate);
	        	
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
	
	
	public Marker[] assegnaMarkerDonazione() {
		
		Marker[] markerDonazione = {null,null,null,null,null,null,null};
		
		 String sql = "Call assegna_marker_donazione()";
	     ResultSet rs = null;
	     int count = 0;

	     try (Connection conn = connector.getConnection();
	          PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        
	         rs = pstmt.executeQuery();

	         while (rs.next()) {
	        	 Coordinate donazioneCoordinate = new Coordinate(Double.parseDouble(rs.getString(this.lati)),Double.parseDouble(rs.getString(this.longi)));
	        	 markerDonazione[count] = Marker.createProvided(Marker.Provided.GREEN).setPosition(donazioneCoordinate);
	        	 
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
	


