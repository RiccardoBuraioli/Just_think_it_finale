package bean;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.Gestisci_eventi_Controller;
import entity.CaritasUser;
import entity.EventTab;
import entity.Evento;
import entity.Necessità;
import entity.Partecipanti_evento;
import entity.ShopUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GestisciEventiBoundary {

	private Gestisci_eventi_Controller gestEventC;
	private int idShop;
	private List<EventTab> listEv;
	private EventTab event;
	private ShopUser shop;
	
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button caritas;

	@FXML
	private TableView<EventTab> table;

	@FXML
	private TableColumn<EventTab, String> nomeEvento;

	@FXML
	private TableColumn<EventTab, String> nomeCaritas;
	 @FXML
	 private TableColumn<EventTab, Integer> noteEvento;

	@FXML
	private TableColumn<EventTab, Integer> numPartecipanti;
	@FXML
	private TableColumn<EventTab, Float> importo;
	  @FXML
	    private Button modificaE;

	    @FXML
	    private Button EliminaE;

	    @FXML
	    private Button back;

	    @FXML
	    void backButtonPressed(ActionEvent event) {
	    	 try {
	 			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/ShopHomePage.fxml"));
	 			Parent root = loader.load();
	 			Shop_Home_Boundary ShopHomeBoundary = Shop_Home_Boundary.getInstance();
	 			ShopHomeBoundary = loader.getController();
	 			ShopHomeBoundary.initData(shop);
	 			Stage home = (Stage) back.getScene().getWindow();
	 			home.setScene(new Scene(root, 800, 600));
	 			
	 			home.show();
	 		} catch (IOException e) {
	 			e.printStackTrace();
	 		}
	    	
	    	
	    }

	    @FXML
	    void contattaCaritas(ActionEvent event) {
	    	try {

    	        FXMLLoader fxmlLoader = new FXMLLoader();
    	        Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("/boundary/Email.fxml"));
    	       
    	       // donationController = fxmlLoader.getController();
    	        EmailBoundary email = new EmailBoundary();
    	        email = fxmlLoader.getController();
    	        email.load_email(this.idShop, this.event.getId_caritas());
    	        Stage stage = new Stage();
	    		stage.setTitle("Email");
	    		
	    		
	    		stage.setScene(new Scene(rootNode, 800, 500));
	    		stage.setResizable(false);
	    		stage.show();
	    		
	    		
	    		
	    		
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
	    	
	    }

	    @FXML
	    boolean eliminaEvento(ActionEvent event) {
	    	return gestEventC.elimina_evento(this.event.getNomeEvento());
	    }

	    @FXML
	    void modificaEvento(ActionEvent event) {
	
	    }

	    @FXML
	    void prendiEvento(MouseEvent e) {
	    	this.event = table.getSelectionModel().getSelectedItem();
	    	System.out.println(event.getNomeEvento());
	    }


	public GestisciEventiBoundary() {

		gestEventC = new Gestisci_eventi_Controller();

	}

	public GestisciEventiBoundary(int i) {

		gestEventC = new Gestisci_eventi_Controller();
		this.idShop = i;

	}
	
	
	

	public void load_shop(int id_shop) {
		this.idShop = id_shop;
		this.listEv = gestEventC.carica_eventi(this.idShop);
		System.out.println(listEv.get(0).getNomeEvento());

		ObservableList<EventTab> data = FXCollections.observableArrayList(listEv);
		nomeEvento.setCellValueFactory(new PropertyValueFactory<>("NomeEvento"));
		importo.setCellValueFactory(new PropertyValueFactory<>("rapportoDenaro"));
		nomeCaritas.setCellValueFactory(new PropertyValueFactory<>("NomeCaritas"));
		noteEvento.setCellValueFactory(new PropertyValueFactory<>("NoteEvento"));
		numPartecipanti.setCellValueFactory(new PropertyValueFactory<>("NumPartecipanti"));
	
		
		
		table.setItems(data);
		// table.getColumns().addAll(nome_evento);

		/*
		 * for (int i = 0; i < list_ev.size(); i++) { Evento tmp = list_ev.get(i);
		 * System.out.println(tmp.getNome());
		 * 
		 * // Id_evento.setCellValueFactory(new PropertyValueFactory<>("NomeEvento"));
		 * // table.setItems(data); //Id_evento.setCellFactory( new
		 * PropertyValueFactory<Evento,Integer>(tmp.getNome() ));
		 * 
		 * //id_caritas.setText(Integer.toString(tmp.getId_caritas()));
		 * 
		 * // initialize(); }
		 */

	}

	public ShopUser getShop() {
		return shop;
	}

	public void setShop(ShopUser shop) {
		this.shop = shop;
	}

}