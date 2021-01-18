package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	 
	public List<MarkerID> getCaritasMarkers() {
		List<MarkerID> lista = new ArrayList<>();
		String sql = "Call assegna_marker()";
		ResultSet rs = null;
		
		try (Connection conn = connector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			rs = pstmt.executeQuery();

			while (rs.next()) {
				double lati = Double.parseDouble(rs.getString(this.lati));
				double longi = Double.parseDouble(rs.getString(this.longi));
				int codiceCaritas = rs.getInt("CodiceCaritas");
				
				Coordinate caritasCoordinate = new Coordinate(lati,longi);
				Marker m = Marker.createProvided(Marker.Provided.RED).setPosition(caritasCoordinate);
				MarkerID mc = new MarkerID(m, codiceCaritas);
		
				lista.add(mc);
				
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
		return lista;
		}
		
	
	public List<MarkerID> assegnaMarkerEvento() {
		
		List<MarkerID> markerEvento =new ArrayList<>();
		
		 String sql = "Call assegna_marker_evento()";
	     ResultSet rs = null;
	 
	     try (Connection conn = connector.getConnection();
	          PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        
	         rs = pstmt.executeQuery();

	         while (rs.next()) {
	        	 int codiceEvento = rs.getInt("codiceEv");
	        	 
	        	 Coordinate eventoCoordinate = new Coordinate(Double.parseDouble(rs.getString(this.lati)),Double.parseDouble(rs.getString(this.longi)));
	        	 Marker m = Marker.createProvided(Marker.Provided.BLUE).setPosition(eventoCoordinate);
	        	 MarkerID mc = new MarkerID(m, codiceEvento);
	        		
	        	 markerEvento.add(mc);
					
	        	
	        	 
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
	
	
	public List<MarkerID> assegnaMarkerDonazione() {
		
		List<MarkerID> markerDonazione =new ArrayList<>();
		
		 String sql = "Call assegna_marker_donazione()";
	     ResultSet rs = null;
	     int count = 0;

	     try (Connection conn = connector.getConnection();
	          PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        
	         rs = pstmt.executeQuery();

	         while (rs.next()) {
	        	 int codiceDono = rs.getInt("codiceDono");
	        	 Coordinate donazioneCoordinate = new Coordinate(Double.parseDouble(rs.getString(this.lati)),Double.parseDouble(rs.getString(this.longi)));
	        	 Marker m = Marker.createProvided(Marker.Provided.GREEN).setPosition(donazioneCoordinate);
	        	 MarkerID mc = new MarkerID(m, codiceDono);	        	 
	        	 markerDonazione.add(mc);
	        	 
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
	


