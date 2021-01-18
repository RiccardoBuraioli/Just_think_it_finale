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

    private String getPassword(ShopUser shopUser){
        String sql = "SELECT Password FROM negozi WHERE ID = ?";
        ResultSet res = null;
        String password = "";

        try(Connection conn = connector.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, shopUser.getID());
            res = pstmt.executeQuery();

            while (res.next()){
                password = res.getString(this.p);
            }
        } catch (SQLException ex){
            logger.debug(ex.getMessage());
        }finally {
            try {
                if (res != null) res.close();
            } catch (SQLException e) {
                logger.debug(e.getMessage());
            }
        }
        if(password.equals("")) return "";

        else return password;


    }


    public void updatePassword(ShopUser shopUser, String newPass, String oldPassword){
        String actPassword = getPassword(shopUser);
        String sql = "UPDATE negozi SET Password = ? WHERE ID = ?";
        int rowAffected;

        if(actPassword.equals(oldPassword)) {
            try (Connection conn = connector.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, newPass);
                pstmt.setInt(2, shopUser.getID());
                rowAffected = pstmt.executeUpdate();

                if (rowAffected == 1) {
                    logger.debug(SUCCESS);
                } else logger.debug(FAILED);


            } catch (SQLException ex) {
                logger.debug((ex.getMessage()));
            }
        }else logger.debug(FAILED);

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


    public void updateShopName(int id, String shopName) {
        String sql = "UPDATE negozi SET NomeNegozio = ? WHERE ID= ?";
        int rowAffected;
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, shopName);
            stmt.setInt(2, id);
            rowAffected = stmt.executeUpdate();

            if (rowAffected == 1) {
                logger.debug(SUCCESS);
            }else logger.debug(FAILED);


        } catch (SQLException ex) {
            logger.debug(ex.getMessage());
        }
    }

    public void updateType(int id, String type) {
        String sql = "UPDATE negozi SET Tipologia = ? WHERE ID = ?";
        int rowAffected;

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, type);
            stmt.setInt(2, id);
            rowAffected = stmt.executeUpdate();

            if (rowAffected == 1) {
                logger.debug(SUCCESS);
            }else logger.debug(FAILED);


        } catch (SQLException ex) {
            logger.debug(ex.getMessage());
        }
    }

    public void updateEmail(int id, String email) {
        String sql = "UPDATE negozi SET Email = ? WHERE ID = ?";
        int rowAffected;
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setInt(2, id);
            rowAffected = stmt.executeUpdate();

            if (rowAffected == 1) {
                logger.debug(SUCCESS);
            }else logger.debug(FAILED);


        } catch (SQLException ex) {
            logger.debug(ex.getMessage());
        }
    }

    public void updatePhoneNum(int id, String phoneNum) {
        String sql = "UPDATE negozi SET RecapitoTel = ? WHERE ID = ?";
        int rowAffected;
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, phoneNum);
            stmt.setInt(2, id);
            rowAffected = stmt.executeUpdate();

            if (rowAffected == 1) {
                logger.debug(SUCCESS);
            }else logger.debug(FAILED);


        } catch (SQLException ex) {
            logger.debug(ex.getMessage());
        }
    }

    public void updateAddress(int id, String address) {
        String sql = "UPDATE negozi SET IndirizzoNegozio = ? WHERE ID = ?";
        int rowAffected;
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, address);
            stmt.setInt(2, id);
            rowAffected = stmt.executeUpdate();

            if (rowAffected == 1) {
                logger.debug(SUCCESS);
            } else logger.debug(FAILED);
        } catch (SQLException ex) {
            logger.debug(ex.getMessage());
        }
    }

    public void deleteCaritas(int id) {
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

    public void deleteAll() {
        String sql = "DELETE FROM negozi";
        int delRecs;
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            delRecs = stmt.executeUpdate();
            if (delRecs >= 1) logger.debug("\t ***** Voci Negozi rimosse con successo! *****");
            resetID();

        } catch (SQLException ex) {
            logger.debug(ex.getMessage());
        }
    }

    private void resetID() {
        String sql = "ALTER TABLE negozi AUTO_INCREMENT = 1";

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.executeUpdate();
            logger.debug("\t ***** ID Values resetted successfully! *****");
        } catch (SQLException ex) {
            logger.debug(ex.getMessage());
        }
    }

    public void printShopsInTab(List<ShopUser> shopUsers){
        String s1 = "ID";
        String s2 = "Nome Negozio";
        String s3 = "Password";
        String s4 = "Indirizzo Negozio";
        String s5 = "Tipologia";
        String s6 = "RecapitoTel";
        String s7 =  "Email";



        System.out.printf("%n %-22s %-22s %-22s %-22s %-22s %-22s %-22s %n", s1, s2, s3, s4, s5, s6, s7);
        for(ShopUser shop:shopUsers){
            System.out.printf("%-22s %-22s %-22s %-22s %-22s %-22s %-22s %n", shop.getID(), shop.getNomeShop(), shop.getPassword(),
                    shop.getIndirizzoShop(), shop.getTipologia(), shop.getRecapitoTelefonico(), shop.getEmail());
        }
    }

}
