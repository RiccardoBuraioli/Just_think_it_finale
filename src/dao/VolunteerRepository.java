package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connector.Connector;
import entity.VolunteerUser;

//CRUD create read update delete

public class VolunteerRepository {

    private final Connector connector;
    private static final String SUCCESS = "Voce modificata con successo!";
    private static final String FAILED = "Operazione non riuscita.";



    public VolunteerRepository() {
    	 this.connector= new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
    }

    public List<VolunteerUser> getAllVolunteers() {
        List<VolunteerUser> vUsers = new ArrayList<>();

        String sql = "SELECT * FROM volontari";

        try (Connection conn = connector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                String nome = rs.getString("nome");
                String cognome = rs.getString("cognome");
                String password = rs.getString("password");
                String indirizzo = rs.getString("indirizzo");
                String recapitoTel = rs.getString("recapitoTel");
                String email = rs.getString("email");
                String cartaDiCredito = rs.getString("cartaDiCredito");
                String nascita = rs.getString("DataNascita");
                String citta = rs.getString("città");
                VolunteerUser vUser = new VolunteerUser( nome, cognome,  password, indirizzo, recapitoTel, email, cartaDiCredito, nascita, citta);
                vUser.setID(rs.getInt("ID"));
                vUsers.add(vUser);
            }
            return vUsers;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new IllegalStateException("error fetching users", ex);
        }
    }


    public VolunteerUser getVolunteerByID(int id) {

        String sql = "SELECT  Nome, Cognome, Indirizzo, RecapitoTel, CartaDiCredito FROM volontari WHERE ID=?";
        ResultSet rs = null;
        VolunteerUser vUser = new VolunteerUser();

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                vUser.setNome(rs.getString("Nome"));
                vUser.setCognome(rs.getString("Cognome"));
                vUser.setIndirizzo(rs.getString("Indirizzo"));
             
                vUser.setRecapitoTel(rs.getString("RecapitoTel"));
                vUser.setCartaDiCredito(rs.getString("CartaDiCredito"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } return vUser;
    }
    



	public int insertVolunteer(VolunteerUser volunteerUser) {

        ResultSet rs = null;
        int volunteerID = 0;

        String sql = "call registrazione_volontario(?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = connector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        	pstmt.setString(1, volunteerUser.getEmail());
        	pstmt.setString(2, volunteerUser.getPassword());
        	pstmt.setInt(3, 1);
        	pstmt.setString(4,  volunteerUser.getNascita());
        	pstmt.setString(5, volunteerUser.getCognome());
        	pstmt.setString(6, volunteerUser.getRecapitoTel());
        	pstmt.setString(7, volunteerUser.getIndirizzo());
        	pstmt.setString(8, volunteerUser.getCartaDiCredito());
        	pstmt.setString(9,volunteerUser.getCitta());
        	pstmt.setString(10, volunteerUser.getNome());
          
          
   
            int rowAffected = pstmt.executeUpdate();
            if (rowAffected == 1) {

                rs = pstmt.getGeneratedKeys();
                if (rs.next())
                    volunteerID = rs.getInt(1);
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

        return volunteerID;
    }


    public void updateFirstName(int id, String firstName) {
        String sql = "UPDATE volontari SET Nome = ? WHERE ID= ?";
        int rowAffected;
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, firstName);
            stmt.setInt(2, id);
            rowAffected = stmt.executeUpdate();

            if (rowAffected == 1) {
                System.out.println(SUCCESS);
            }else System.out.println(FAILED);


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateLastName(int id, String lastName) {
        String sql = "UPDATE volontari SET Cognome = ? WHERE ID = ?";
        int rowAffected;

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, lastName);
            stmt.setInt(2, id);
            rowAffected = stmt.executeUpdate();

            if (rowAffected == 1) {
                System.out.println(SUCCESS);
            }else System.out.println(FAILED);


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateEmail(int id, String email) {
        String sql = "UPDATE volontari SET Email = ? WHERE id = ?";
        int rowAffected;
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setInt(2, id);
            rowAffected = stmt.executeUpdate();

            if (rowAffected == 1) {
                System.out.println(SUCCESS);
            }else System.out.println(FAILED);


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updatePhoneNum(int id, String phoneNum) {
        String sql = "UPDATE volontari SET RecapitoTel = ? WHERE id = ?";
        int rowAffected;
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, phoneNum);
            stmt.setInt(2, id);
            rowAffected = stmt.executeUpdate();

            if (rowAffected == 1) {
                System.out.println(SUCCESS);
            }else System.out.println(FAILED);


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateAddress(int id, String address) {
        String sql = "UPDATE volontari SET Indirizzo = ? WHERE id = ?";
        int rowAffected;
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, address);
            stmt.setInt(2, id);
            rowAffected = stmt.executeUpdate();

            if (rowAffected == 1) {
                System.out.println(SUCCESS);
            } else System.out.println(FAILED);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void deleteVolunteer(int id) {
        String sql = "DELETE FROM volontari where ID=?";
        int deletedRec;

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            deletedRec = stmt.executeUpdate();

            if (deletedRec == 1) System.out.println("Volontario ID " + id + ", rimosso con successo!");

            else System.out.println("ID non trovato.");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteAll() {
        String sql = "DELETE FROM volontari";
        int delRecs;
        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            delRecs = stmt.executeUpdate();
            if (delRecs >= 1) System.out.println("\t ***** Volontari rimossi con successo! *****");
            resetID();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void resetID() {
        String sql = "ALTER TABLE volontari AUTO_INCREMENT = 1";

        try (Connection conn = connector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.executeUpdate();
            System.out.println("\t ***** ID Values resetted successfully! *****");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

//carta di credito? 


    public void printVolInTab(List<VolunteerUser> vUsers){
        String s1 = "ID";
        String s2 = "Nome";
        String s3 = "Cognome";
        String s4 = "Password";
        String s5 = "Indirizzo";
        String s6 = "RecapitoTel";
        String s7 =  "Email";
        String s8 = "CartaDiCredito";


        System.out.printf("%n %-22s %-22s %-22s %-22s %-22s %-22s %-22s %-22s %n", s1, s2, s3, s4, s5, s6, s7, s8);
        for(VolunteerUser vUsr:vUsers){
            System.out.printf("%-22s %-22s %-22s %-22s %-22s %-22s %-22s %-22s %n", vUsr.getID(), vUsr.getNome(), vUsr.getCognome(),
                    vUsr.getPassword(), vUsr.getIndirizzo(), vUsr.getRecapitoTel(), vUsr.getEmail(), vUsr.getCartaDiCredito());
        }
    }



}
