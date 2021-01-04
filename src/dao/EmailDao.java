package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import connector.Connector;
import entity.EmailEntity;

public class EmailDao {
	Connector connector;
	private static final String SUCCESS = "Voce modificata con successo!";
    private static final String FAILED = "Operazione non riuscita.";
    private List<EmailEntity> emailList;

	
	public EmailDao() {
    	this.connector = new Connector("jdbc:mysql://127.0.0.1:3306/Justthinkit", "root", "password");
	}
	
	
	public int inviaEmail(EmailEntity email) {

   		int rowAffected;
   		ResultSet rs = null;

      	//Registra Caritas
  	    String sql = "call inserisci_email(?,?,?,?)";

          try (Connection conn = connector.getConnection();
               PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        	  pstmt.setString(1, email.getIdMittente() );
        	  pstmt.setString(2, email.getIdDestinatario());
        	  pstmt.setString(3, email.getMessaggio());
        	  pstmt.setString(4,email.getOggetto());
        	
          	
          
              rowAffected = pstmt.executeUpdate();

              if (rowAffected == 1) {
                  System.out.println(SUCCESS);
              } else System.out.println(FAILED);


          } catch (SQLException ex) {
              System.out.println((ex.getMessage()));
          }
		
          
          return 0;
         
      
		
		
	}
	
	
	
	
	public List<EmailEntity> visualizzaEmail(String idUtente){
	
	 	String sql = "call visuallizza_email(?) ";
	   	int i = 0;
		ResultSet res = null;
		try (Connection conn = connector.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setString(1,idUtente );

	           res = stmt.executeQuery();
	           
	
	           
	           while (res.next()) {
	        	   emailList.add( new EmailEntity(res.getInt("id_email"), res.getString("messaggio"), res.getString("oggetto")));
	        	   i++;
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
	
		
		
		
		
		return emailList;
		
		
		
	}
	
	
	public String[] visualizzaMittenteDestinatario(int idDest, int idMit) {
		
		String sql = "call visualizza_mittente_destinatario(?,?,?,?) ";
	   	int i = 0;
	   	String[] EmailMD = {"",""};
		ResultSet res = null;
		try (Connection conn = connector.getConnection();
	            CallableStatement stmt = conn.prepareCall((sql))) {
				stmt.setInt(1, idMit );
				stmt.setInt(2, idDest );
				stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
				stmt.registerOutParameter(4, java.sql.Types.VARCHAR);

	          res = stmt.executeQuery(); 
	         
	           
	           /* while (res.next()) {
	        	
	        	
	           }*/
	            EmailMD[0] = stmt.getString("email_m");
	            EmailMD[1] = stmt.getString("email_d");
	            
	            
	       } catch (SQLException ex) {
	           System.out.println(ex.getMessage());
	       } finally {
	           try {
	               if (res != null) res.close();
	           } catch (SQLException e) {
	               System.out.println(e.getMessage());
	           }
	       }
	
		
	
		return EmailMD;
	}
	
	
	
}
