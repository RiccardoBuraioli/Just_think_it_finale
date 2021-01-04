package controller;


import dao.EmailDao;
import entity.EmailEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EmailController {

	private EmailDao emailDao;
	private EmailEntity emailEntity;
	private String[] emailList;
	
    public int sendMessageController(String mit, String dest, String mess, String ogg) {
    	
    	int i=0;
    	emailEntity = new EmailEntity(mit, dest, mess, ogg);

    	emailDao = new EmailDao();
    	i = emailDao.inviaEmail(emailEntity);
    	return i;
    	
    }
    
    public String[] loadMittenteDestinatario(int idDest, int idMit) {
    	emailDao = new EmailDao();
    	emailList = emailDao.visualizzaMittenteDestinatario(idDest, idMit);
    	return emailList;
    	
    }
    
    
    
}
	
