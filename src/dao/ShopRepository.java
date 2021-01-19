package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import connector.Connector;
import entity.ShopUser;

public class ShopRepository {

    private final Connector connector;
    private static final String SUCCESS = "Voce modificata con successo!";
    private static final String FAILED = "Operazione non riuscita.";
    private String p = "Password";
    private static final Logger logger = LoggerFactory.getLogger(ShopRepository.class);

    
    public ShopRepository() {
        this.connector =  new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
    }



    public int insertShop(ShopUser shopUser) {

        ResultSet rs = null;
        int shopID = 0;

        String sql = "call registrazione_negozio(?,?,?,?,?,?,?,?)";

        try (Connection conn = connector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
           
        	pstmt.setString(1,shopUser.getEmail());
        	pstmt.setString(2, shopUser.getPassword());        	
        	pstmt.setString(3, shopUser.getNomeShop());
        	pstmt.setString(4, shopUser.getIndirizzoShop());
        	pstmt.setString(5, shopUser.getcitta());
            pstmt.setString(6,shopUser.getTipologia());
            pstmt.setString(7,"Negozio");
            pstmt.setString(8,shopUser.getRecapitoTelefonico());
       


            int rowAffected = pstmt.executeUpdate();
            if (rowAffected == 1) {

                rs = pstmt.getGeneratedKeys();
                if (rs.next())
                    shopID = rs.getInt(1);
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
        return shopID;
    }

  
    public List<ShopUser> getAllShops() {
        List<ShopUser> shopUsers = new ArrayList<>();

        String sql = "SELECT * FROM negozi";

        try (Connection conn = connector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                String nomeShop = rs.getString("NomeNegozio");
                String password = rs.getString(this.p);
                String indirizzoNegozio = rs.getString("IndirizzoNegozio");
                String tipologia = rs.getString("Tipologia");
                String recapitoTel = rs.getString("RecapitoTel");
                String email = rs.getString("Email");
                String citta = rs.getString("città");

                ShopUser shopUser = new ShopUser(nomeShop, password, indirizzoNegozio, tipologia, recapitoTel, email, citta);
                shopUser.setId(rs.getInt("ID"));
                shopUsers.add(shopUser);
            }
            return shopUsers;
        } catch (SQLException ex) {
            logger.debug(ex.getMessage());
            throw new IllegalStateException("error fetching users", ex);
        }
    }


    public ShopUser getShopByID(int id) {

        String sql = "SELECT NomeNegozio, IndirizzoNeg, Tipologia, RecapitoTel FROM negozi WHERE ID=?";
        ResultSet rs = null;
        ShopUser shopUser = new ShopUser();

        try (Connection conn = connector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
            	shopUser.setId(id);
                shopUser.setNomeShop(rs.getString("NomeNegozio"));
              
                shopUser.setIndirizzoShop(rs.getString("IndirizzoNeg"));
                shopUser.setTipologia(rs.getString("Tipologia"));
                shopUser.setRecapitoTelefonico(rs.getString("RecapitoTel"));
            
            }

        } catch (SQLException ex) {
            logger.debug(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                logger.debug(e.getMessage());
            }
        } return shopUser;
    }


   
    public void deleteNegozio(int id) {
        String sql = "DELETE FROM negozi where ID=?";
        int deletedRec;

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            deletedRec = stmt.executeUpdate();

            if (deletedRec == 1) logger.debug("Negozio ID " + id + ", rimosso con successo!");

            else logger.debug("ID non trovato.");

        } catch (SQLException ex) {
            logger.debug(ex.getMessage());
        }
    }

 
}
