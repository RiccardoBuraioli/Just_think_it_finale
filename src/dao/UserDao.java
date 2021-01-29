package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import connector.Connector;

public class UserDao {

	private Connector connector;
    private static final Logger logger = LoggerFactory.getLogger(VolunteerRepository.class);

	
	public UserDao() {
		 this.connector= new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
	}
	
	

    public void deleteVolunteer(int id) {
        String sql = "call elimina_utente(?)";
        int deletedRec;

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            deletedRec = stmt.executeUpdate();

            if (deletedRec == 1) logger.debug("Utente  " + id + ", rimosso con successo!");

            else logger.debug("ID non trovato.");

        } catch (SQLException ex) {
            logger.debug(ex.getMessage());
        }
    }
	
}
