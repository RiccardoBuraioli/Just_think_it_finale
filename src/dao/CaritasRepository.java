package dao;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import connector.Connector;
import entity.CaritasUser;
import entity.CaritasUser2;
import java.sql.*;

public class CaritasRepository {

    private final Connector connector;
    private static final String SUCCESS = "Voce modificata con successo!";
    private static final String FAILED = "Operazione non riuscita.";
    private static final Logger logger = LoggerFactory.getLogger(CaritasRepository.class);

    public CaritasRepository() {
        this.connector =  new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
    }

    public int insertCaritas(CaritasUser2 caritasUser) {

        ResultSet rs = null;
        int caritasID = 0;

        	//Registra Caritas
    	    String sql = "call registrazione_caritas(?,?,?,?,?,?,?,?)";

            try (Connection conn = connector.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            	pstmt.setString(1,caritasUser.getEmail());
            	pstmt.setString(2, caritasUser.getPassword());
                pstmt.setString(3, caritasUser.getNomeCaritas());
                pstmt.setString(4, caritasUser.getIndirizzoCaritas());
                pstmt.setString(5,caritasUser.getRecapitoTelefonico());
                pstmt.setString(6, caritasUser.getTipologia());
                pstmt.setString(7, caritasUser.getCitta());
                pstmt.setString(8, "Caritas");
                
            int rowAffected = pstmt.executeUpdate();
            if (rowAffected == 1) {

                rs = pstmt.getGeneratedKeys();
                if (rs.next())
                    caritasID = rs.getInt(1);
            }
        } catch (SQLException ex) {
            logger.debug(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
               logger.debug(e.getMessage());
            }
        }

        return caritasID;
    }


 

  public CaritasUser getCaritasByID(int id) {

        String sql = "SELECT  NomeCaritas, IndirizzoCaritas, Tipologia, RecapitoTel FROM caritas WHERE CodiceCaritas=?";
        ResultSet rs = null;
        CaritasUser carUsr = new CaritasUser();

        try (Connection conn = connector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
            	
                carUsr.setNome(rs.getString("NomeCaritas"));
                carUsr.setId(id);
                carUsr.setIndirizzo(rs.getString("IndirizzoCaritas"));
                carUsr.setTipologia(rs.getString("Tipologia"));
                carUsr.setRecapitoTel(rs.getString("RecapitoTel"));
               
            }

        } catch (SQLException ex) {
           logger.debug(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
               logger.debug(e.getMessage());
            }
        } return carUsr;
    }

   

    public void deleteCaritas(int id) {
        String sql = "DELETE FROM caritas where ID=?";
        int deletedRec;

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            deletedRec = stmt.executeUpdate();

            if (deletedRec == 1)logger.debug("Caritas ID " + id + ", rimossa con successo!");

            else logger.debug("ID non trovato.");

        } catch (SQLException ex) {
           logger.debug(ex.getMessage());
        }
    }


   

}
