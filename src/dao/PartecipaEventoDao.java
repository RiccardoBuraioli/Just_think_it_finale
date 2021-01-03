package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connector.Connector;

import entity.PartecipantiEvento;


public class PartecipaEventoDao {
	 private final Connector connector;
	 private PartecipantiEvento partecipanti;
		
	public PartecipaEventoDao() {
    	connector = new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
    	partecipanti = new PartecipantiEvento();
	}

	public PartecipantiEvento conta_partecipanti(int id_evento) {
		
		
	   	String sql = "call visualizza_tuoi_eventi(?) ";
	   
		ResultSet res = null;
		try (Connection conn = connector.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, id_evento );
	            res = stmt.executeQuery();
	
	           while (res.next()) {
	        	 
	        	   partecipanti.setCount(res.getInt("count"));
	        	   partecipanti.setImportoTotale(res.getFloat("importoTotale"));
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
    	
    	
    	
    	
		
		
		return partecipanti;
		
	}
	
}