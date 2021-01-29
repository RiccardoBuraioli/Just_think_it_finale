package controller;

import com.sothawo.mapjfx.*;
import com.sothawo.mapjfx.event.MapLabelEvent;
import com.sothawo.mapjfx.event.MapViewEvent;
import com.sothawo.mapjfx.event.MarkerEvent;

import bean.BachecaBoundary;
import bean.DonationBoundary;
import bean.PartecipaEventoBoundary;
import bean.PrenotaTurnoBoundary;
import bean.PromuoviEventoBoundary;
import bean.ShopHomeBoundary;
import bean.UserHomeBoundary;
import dao.CercaCaritasDao;
import dao.CoordinateDao;
import entity.CaritasUser;
import entity.MarkerID;
import entity.ShopUser;
import entity.User;
import entity.VolunteerUser;
import javafx.animation.Transition;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CercaCaritas {

	public enum MarkerType {
		CARITAS, EVENTO, DONAZIONE, MAP
	}

	private int idCaritas;
	private int idEvento;

	private User loggedUser;
	
	/** logger for the class. */
	private static final Logger logger = LoggerFactory.getLogger(CercaCaritas.class);

	/* some coordinates from around town. Da cambiare con una chiamata sql */
	private static final Coordinate coordKarlsruheCastle = new Coordinate(49.013517, 8.404435);
	private static final Coordinate RomaCentro = new Coordinate(41.900412, 12.494619);
	private static final Coordinate coordKarlsruheStation = new Coordinate(48.993284, 8.402186);
	private static final Coordinate coordKarlsruheSoccer = new Coordinate(49.020035, 8.412975);
	private static final Coordinate coordKarlsruheUniversity = new Coordinate(49.011809, 8.413639);


	private static final Coordinate coordGermanyNorth = new Coordinate(41.987167, 12.477502);
	private static final Coordinate coordGermanySouth = new Coordinate(41.794755, 12.511766);
	private static final Coordinate coordGermanyWest = new Coordinate(41.886165, 12.371194);
	private static final Coordinate coordGermanyEast = new Coordinate(41.905271, 12.617460);


	private static Coordinate posMarker = null;

	/** default zoom value. */
	private static final int ZOOMDEFAULT = 14;

	/** the markers. */


	private List<MarkerID> markerCaritas;
	private List<MarkerID> markerEventi;
	private List<MarkerID> markerDonazioni;

	private int[] idCaritaList;



	private Marker markerClick;

	/** the labels. */

	

	// a circle around the castle

	@FXML
	/** button to set the map's zoom. */
	private Button buttonZoom;

	/** the MapView containing the map */
	@FXML
	private MapView mapView;

	/**
	 * the box containing the top controls, must be enabled when mapView is
	 * initialized
	 */
	@FXML
	private HBox topControls;

	/** Slider to change the zoom value */
	@FXML
	private Slider sliderZoom;

	/** Accordion for all the different options */
	@FXML
	private Accordion leftControls;

	/** section containing the location button */
	@FXML
	private TitledPane optionsLocations;

	/** button to set the map's center */
	@FXML
	private Button buttonDonazione;

	/** button to set the map's center */
	@FXML
	private Button buttonTurnoVolontariato;

	/** button to set the map's center */
	@FXML
	private Button buttonEvento;

	/** button to set the map's center */
	@FXML
	private Button buttonBacheca;

	/** button to set the map's extent. */
	@FXML
	private Button buttonAllLocations;

	@FXML
	private Button buttonBack;
	
	@FXML
	private Button buttonPromuoviEvento;

	/** for editing the animation duration */
	@FXML
	private TextField animationDuration;

	/** Label to display the current center */
	@FXML
	private Label labelCenter;

	/** Label to display the current extent */
	@FXML
	private Label labelExtent;

	/** Label to display the current zoom */
	@FXML
	private Label labelZoom;

	/** label to display the last event. */
	@FXML
	private Label labelEvent;

	/** RadioButton for MapStyle OSM */
	@FXML
	private RadioButton radioMsOSM;

	
	/** RadioButton for MapStyle WMS. */
	@FXML
	private RadioButton radioMsWMS;

	/** RadioButton for MapStyle XYZ */
	@FXML
	private RadioButton radioMsXYZ;

	/** ToggleGroup for the MapStyle radios */
	@FXML
	private ToggleGroup mapTypeGroup;

	/** Check button for harbour marker */
	@FXML
	private CheckBox checkEventoMarker;

	/** Check button for castle marker */
	@FXML
	private CheckBox checkCaritasMarker;

	/** Check button for harbour marker */
	@FXML
	private CheckBox checkDonazioneMarker;

	

	/** Check button for click marker */
	@FXML
	private CheckBox checkClickMarker;



	/** params for the WMS server. */
	private WMSParam wmsParam = new WMSParam().setUrl("http://ows.terrestris.de/osm/service?").addParam("layers",
			"OSM-WMS");

	private XYZParam xyzParams = new XYZParam()
			.withUrl("https://server.arcgisonline.com/ArcGIS/rest/services/World_Topo_Map/MapServer/tile/{z}/{y}/{x})")
			.withAttributions(
					"'Tiles &copy; <a href=\"https://services.arcgisonline.com/ArcGIS/rest/services/World_Topo_Map/MapServer\">ArcGIS</a>'");

	private ObservableList<Node> listaBottoni;
	private ObservableList<Node> listaBottoniOld;
	
	

	private void indietro(User loggedUser) {
	if (loggedUser.getClass() == VolunteerUser.class) {
		 try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/UserHomePage.fxml"));
				Parent root = loader.load();
				UserHomeBoundary userHomeBoundary;
				userHomeBoundary = loader.getController();
				userHomeBoundary.initData((VolunteerUser)loggedUser);
				Stage home = (Stage) buttonBack.getScene().getWindow();
				home.setScene(new Scene(root, 800, 600));
				
				home.show();
			} catch (IOException e) {
				logger.error("errore IoException");
			}

	
		
	}
	
	else if(loggedUser.getClass() == ShopUser.class) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/ShopHomePage.fxml"));
			Parent root = loader.load();
			ShopHomeBoundary shopHomeBoundary;
			shopHomeBoundary = loader.getController();
			shopHomeBoundary.setCurrentUser((ShopUser) loggedUser);
			Stage home = (Stage) buttonBack.getScene().getWindow();
			home.setScene(new Scene(root, 800, 600));
			
			home.show();
			
		} catch (IOException e) {
			logger.error("errore IoException");
		}
	}

	}

	
	
	
	private void promuoviEvento(int idCar, int idShop) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();

			Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("/boundary/PromuoviEvento.fxml"));

			Stage stage = new Stage();
			stage.setTitle("Promuovi Evento");

			stage.setScene(new Scene(rootNode, 700, 450));
			stage.setResizable(false);

			PromuoviEventoBoundary promEvento = fxmlLoader.getController();

			promEvento.loadFormBoundary(idCar, idShop);

			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	private void vediNecessita(int idCar, int idUt) {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader();

			Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("/boundary/Bacheca.fxml"));

			Stage stage = new Stage();
			stage.setTitle("Bacheca");

			stage.setScene(new Scene(rootNode, 700, 450));
			stage.setResizable(false);

			BachecaBoundary bacheca = fxmlLoader.getController();

			bacheca.loadFormBoundary(idCar, idUt);

			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void apriDonazione(int idCar, int idUt) {
		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("/boundary/Donation.fxml"));

			DonationBoundary donationBoundary = fxmlLoader.getController();

			Stage stage = new Stage();
			stage.setTitle("Donazione");

			donationBoundary.initBoundary(idCar, idUt);

			stage.setScene(new Scene(rootNode, 800, 500));
			stage.setResizable(false);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void prenotaTurno(int idCar, int idUt) {
		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			Parent rootNode = fxmlLoader
					.load(getClass().getResourceAsStream("/boundary/Prenota_turno_volontariato.fxml"));

			PrenotaTurnoBoundary prenotaController = fxmlLoader.getController();

			Stage stage = new Stage();
			stage.setTitle("Prenota Turno");
			prenotaController.setData(idCar, idUt);
			stage.setScene(new Scene(rootNode, 630, 400));
			stage.setResizable(false);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void partecipaEvento(int idEvent, int idUt) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("/boundary/Partecipa_evento.fxml"));

			PartecipaEventoBoundary partecipaEvent = fxmlLoader.getController();

			Stage stage = new Stage();
			stage.setTitle("Prenota Turno");
			partecipaEvent.setData(idEvent, idUt);
			stage.setScene(new Scene(rootNode, 700, 450));
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// molto da cambiare

	public CercaCaritas() throws NumberFormatException, SQLException {

		CercaCaritasDao cercaCaritasDao = new CercaCaritasDao();

		initMarkers(cercaCaritasDao);


	}

	public void initLabels() {
		// camvbiare cooordinate di tutte le label
		
		MapLabel labelDonazione = new MapLabel("university").setPosition(coordKarlsruheUniversity).setVisible(true);
		// the attached labels, custom style
		MapLabel labelCaritas = new MapLabel("castle", 10, -10).setVisible(false).setCssClass("green-label");
		MapLabel labelEvento = new MapLabel("station", 10, -10).setVisible(false).setCssClass("red-label");
		MapLabel labelClick = new MapLabel("click!", 10, -10).setVisible(false).setCssClass("orange-label");

	
	}

	public void initMarkers(CercaCaritasDao cercaCaritasDao) {
		markerEventi = cercaCaritasDao.assegnaMarkerEvento();
		for (MarkerID markerE : markerEventi) {
			markerE.getMarker().setVisible(false);
		}

		markerDonazioni = cercaCaritasDao.assegnaMarkerDonazione();
		for (MarkerID markerD : markerDonazioni) {
			markerD.getMarker().setVisible(false);
		}

		markerClick = Marker.createProvided(Marker.Provided.ORANGE).setVisible(true);

		markerCaritas = cercaCaritasDao.getCaritasMarkers();

		for (MarkerID markerC : markerCaritas) {
			markerC.getMarker().setVisible(true);
		}
	}

	/**
	 * called after the fxml is loaded and all objects are created. This is not
	 * called initialize any more, because we need to pass in the projection before
	 * initializing.
	 *
	 * @param projection the projection to use in the map.
	 * @author Riccardo
	 */
	public void initMapAndControls(Projection projection) {

	
		logger.trace("begin initialize");

//	     
		mapView.setCustomMapviewCssURL(getClass().getResource("/custom_mapview.css"));

		leftControls.setExpandedPane(optionsLocations);

	
		setControlsDisable(false);

		VBox obj = ((VBox) optionsLocations.getContent());
		listaBottoni = obj.getChildren();
		listaBottoniOld = FXCollections.observableArrayList();

		// wire up the location buttons
		buttonBack.setOnAction(event -> indietro(loggedUser));
		buttonBacheca.setOnAction(event -> vediNecessita(idCaritas, loggedUser.getId()));
		buttonPromuoviEvento.setOnAction(event -> promuoviEvento(idCaritas, loggedUser.getId()));
		buttonTurnoVolontariato.setOnAction(event -> prenotaTurno(idCaritas, loggedUser.getId()));
		buttonEvento.setOnAction(event -> partecipaEvento(idEvento, loggedUser.getId()));
		buttonDonazione.setOnAction(event -> apriDonazione(idCaritas, loggedUser.getId()));
		buttonAllLocations.setOnAction(event -> {
			CoordinateDao c = new CoordinateDao();
			// logger.trace(c.getCoordinate().toString());
			c.setCoordinate(loggedUser.getId(), markerClick.getPosition().getLatitude().toString(),
					markerClick.getPosition().getLongitude().toString());

		});
		logger.trace("location buttons done");

		buttonDonazione.setVisible(false);
		buttonTurnoVolontariato.setVisible(false);
		buttonBacheca.setVisible(false);
		buttonEvento.setVisible(false);
		buttonAllLocations.setVisible(false);
		buttonPromuoviEvento.setVisible(false);
		// wire the zoom button and connect the slider to the map's zoom
		buttonZoom.setOnAction(event -> mapView.setZoom(ZOOMDEFAULT));
		sliderZoom.valueProperty().bindBidirectional(mapView.zoomProperty());

		labelCenter.textProperty().bind(Bindings.format("center: %s", mapView.centerProperty()));
		labelZoom.textProperty().bind(Bindings.format("zoom: %.0f", mapView.zoomProperty()));
		logger.trace("options and labels done");

		// watch the MapView's initialized property to finish initialization
		mapView.initializedProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue) {
				afterMapIsInitialized();
			}
		});

		// observe the map type radiobuttons
		mapTypeGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
			logger.debug("map type toggled to {}", newValue.toString());
			MapType mapType = MapType.OSM;
			if (newValue == radioMsOSM) {
				mapType = MapType.OSM;
		
			} else if (newValue == radioMsWMS) {
				mapView.setWMSParam(wmsParam);
				mapType = MapType.WMS;
			} else if (newValue == radioMsXYZ) {
				mapView.setXYZParam(xyzParams);
				mapType = MapType.XYZ;
			}
			// mapView.setBingMapsApiKey(bingMapsApiKey.getText());
			mapView.setMapType(mapType);
		});
		mapTypeGroup.selectToggle(radioMsOSM);

		setupEventHandlers();

		if (loggedUser.getClass() == VolunteerUser.class) {
			for (MarkerID markerEvento : markerEventi) {
				checkEventoMarker.setGraphic(new ImageView(
						new Image(markerEvento.getMarker().getImageURL().toExternalForm(), 16.0, 16.0, true, true)));
				checkEventoMarker.selectedProperty().bindBidirectional(markerEvento.getMarker().visibleProperty());
			}

			for (MarkerID markerCaritas : markerCaritas) {
				checkCaritasMarker.setGraphic(new ImageView(
						new Image(markerCaritas.getMarker().getImageURL().toExternalForm(), 16.0, 16.0, true, true)));
				checkCaritasMarker.selectedProperty().bindBidirectional(markerCaritas.getMarker().visibleProperty());
			}
			for (MarkerID markerDonazione : markerDonazioni) {
				checkDonazioneMarker.setGraphic(new ImageView(
						new Image(markerDonazione.getMarker().getImageURL().toExternalForm(), 16.0, 16.0, true, true)));
				checkDonazioneMarker.selectedProperty()
						.bindBidirectional(markerDonazione.getMarker().visibleProperty());

			}

			checkClickMarker.setGraphic(
					new ImageView(new Image(markerClick.getImageURL().toExternalForm(), 16.0, 16.0, true, true)));
			checkClickMarker.selectedProperty().bindBidirectional(markerClick.visibleProperty());

		}
		if (loggedUser.getClass() == ShopUser.class) {
			// add the graphics to the checkboxes
			for (MarkerID markerCaritas : markerCaritas) {
				checkCaritasMarker.setGraphic(new ImageView(
						new Image(markerCaritas.getMarker().getImageURL().toExternalForm(), 16.0, 16.0, true, true)));
				checkCaritasMarker.selectedProperty().bindBidirectional(markerCaritas.getMarker().visibleProperty());
			}

			checkClickMarker.setGraphic(
					new ImageView(new Image(markerClick.getImageURL().toExternalForm(), 16.0, 16.0, true, true)));
			checkClickMarker.selectedProperty().bindBidirectional(markerClick.visibleProperty());
		} else {

			for (MarkerID markerEvento : markerEventi) {
				checkEventoMarker.setGraphic(new ImageView(
						new Image(markerEvento.getMarker().getImageURL().toExternalForm(), 16.0, 16.0, true, true)));
				checkEventoMarker.selectedProperty().bindBidirectional(markerEvento.getMarker().visibleProperty());
			}

			for (MarkerID markerCaritastemp : markerCaritas) {
				checkCaritasMarker.setGraphic(new ImageView(
						new Image(markerCaritastemp.getMarker().getImageURL().toExternalForm(), 16.0, 16.0, true, true)));
				checkCaritasMarker.selectedProperty().bindBidirectional(markerCaritastemp.getMarker().visibleProperty());
			}
			for (MarkerID markerDonazione : markerDonazioni) {
				checkDonazioneMarker.setGraphic(new ImageView(
						new Image(markerDonazione.getMarker().getImageURL().toExternalForm(), 16.0, 16.0, true, true)));
				checkDonazioneMarker.selectedProperty()
						.bindBidirectional(markerDonazione.getMarker().visibleProperty());

			}

			checkClickMarker.setGraphic(
					new ImageView(new Image(markerClick.getImageURL().toExternalForm(), 16.0, 16.0, true, true)));
			checkClickMarker.selectedProperty().bindBidirectional(markerClick.visibleProperty());

		}

		logger.trace("marker checks done");

		
		// finally initialize the map view
		logger.trace("start map initialization");
		mapView.initialize(Configuration.builder().projection(projection).showZoomControls(false).build());
		logger.debug("initialization finished");

		// long animationStart = System.nanoTime();
		/*
		 * new AnimationTimer() {
		 * 
		 * @Override public void handle(long nanoSecondsNow) { if
		 * (markerKaSoccer.getVisible()) { // every 100ms, increase the rotation of the
		 * markerKaSoccer by 9 degrees, make a turn in 4 seconds long milliSecondsDelta
		 * = (nanoSecondsNow - animationStart) / 1_000_000;33 long numSteps =
		 * milliSecondsDelta / 100; int angle = (int) ((numSteps * 9) % 360); if
		 * (markerKaSoccer.getRotation() != angle) { markerKaSoccer.setRotation(angle);
		 * } } } }.start();
		 */
	}



	/**
	 * initializes the event handlers.
	 */
	private void setupEventHandlers() {

		markerClick.setPosition(coordGermanyEast);

		mapView.addEventHandler(MapViewEvent.MAP_CLICKED, event -> {
			event.consume();
			final Coordinate newPosition = event.getCoordinate().normalize();
			labelEvent.setText("Event: map clicked at: " + newPosition);

			if (markerClick.getVisible()) {
				final Coordinate oldPosition = markerClick.getPosition();

				animateClickMarker(oldPosition, newPosition);

				markerClick.setPosition(newPosition);
				// adding can only be done after coordinate is set
				mapView.addMarker(markerClick);

			}
			for (Node node : listaBottoni) {
				node.setVisible(false);
				buttonBack.setVisible(true);
			}

		});

		// add an event handler for MapViewEvent#MAP_EXTENT and set the extent in the
		// map
		mapView.addEventHandler(MapViewEvent.MAP_EXTENT, event -> {
			event.consume();
			mapView.setExtent(event.getExtent());
		});

		// add an event handler for extent changes and display them in the status label
		mapView.addEventHandler(MapViewEvent.MAP_BOUNDING_EXTENT, event -> {
			event.consume();
			labelExtent.setText(event.getExtent().toString());
		});

		

		mapView.addEventHandler(MarkerEvent.MARKER_CLICKED, event -> {

			event.consume();
			Marker marker = event.getMarker();
			posMarker = marker.getPosition();

			for (MarkerID markerC : markerCaritas) {
				if (marker.getId().equals(markerC.getMarker().getId())) {
					logger.debug("HAi cliccato sul castello.");
					updateButtonsBox(MarkerType.CARITAS);
					idCaritas = markerC.getId();
				}
			}

			for (MarkerID markerE : markerEventi) {
				if (marker.getId().equals(markerE.getMarker().getId())) {
					logger.debug("hai cliccato un evento");
					updateButtonsBox(MarkerType.EVENTO);
					idEvento = markerE.getId();
				}
			}

			if (marker.equals(markerClick)) {
				updateButtonsBox(MarkerType.MAP);
			}
			labelEvent.setText("Event: marker clicked: " + marker.getId());
		});
		mapView.addEventHandler(MarkerEvent.MARKER_RIGHTCLICKED, event -> {
			event.consume();
			labelEvent.setText("Event: marker right clicked: " + event.getMarker().getId());

		});
		mapView.addEventHandler(MapLabelEvent.MAPLABEL_CLICKED, event -> {
			event.consume();
			labelEvent.setText("Event: label clicked: " + event.getMapLabel().getText());
		});
		mapView.addEventHandler(MapLabelEvent.MAPLABEL_RIGHTCLICKED, event -> {
			event.consume();
			labelEvent.setText("Event: label right clicked: " + event.getMapLabel().getText());
		});

		mapView.addEventHandler(MapViewEvent.MAP_POINTER_MOVED, event -> {
			logger.debug("pointer moved to " + event.getCoordinate());
		});

		logger.trace("map handlers initialized");
	}

	public void updateButtonsBox(MarkerType markerType) {
		for (Node n : listaBottoniOld) {
			if (!listaBottoni.contains(n)) {
				listaBottoni.add(n);
			}
		}

		ObservableList<Node> lista = listaBottoni;/* FXCollections.observableArrayList(listaBottoni); */
		List<Node> listaBottoniDaRimuovere = new ArrayList<>();
		searchButtonsToRemoveByUser(loggedUser, markerType, lista, listaBottoniDaRimuovere);
		removeButtons(lista, listaBottoniDaRimuovere);
		showButtons(lista, listaBottoniDaRimuovere);
		listaBottoniOld.addAll(listaBottoniDaRimuovere);
	}

	public void showButtons(ObservableList<Node> lista, List<Node> listaBottoniDaRimuovere) {
		// Mostra tutti i bottoni in ordine
		for (Node node : lista) {
			Button btn = (Button) node;
			if (!listaBottoniDaRimuovere.contains(btn))
				btn.setVisible(true);
		}
	}

	public void removeButtons(ObservableList<Node> lista, List<Node> listaBottoniDaRimuovere) {
		for (Node node : listaBottoniDaRimuovere) {
			lista.remove(node);
		}
	}

	public void searchButtonsToRemoveByUser(User user, MarkerType type, ObservableList<Node> lista,
			List<Node> listaBottoniDaRimuovere) {
		if (type.equals(MarkerType.CARITAS)) {
			for (Node node : lista) {
				Button btn = (Button) node;
				if (user.getClass() == VolunteerUser.class) {
					switch (btn.getId()) {
					case "buttonEvento":
					case "buttonPromuoviEvento":
					case "buttonAllLocations":

						listaBottoniDaRimuovere.add(btn);
					default:
					}
				}

				if (user.getClass() == CaritasUser.class) {
					switch (btn.getId()) {
					case "buttonEvento":
					case "buttonPromuoviEvento":
					case "buttonTurnoVolontariato":
					case "buttonAllLocations":

						listaBottoniDaRimuovere.add(btn);
					default:
					}
				}

				if (user.getClass() == ShopUser.class) {
					switch (btn.getId()) {
					case "buttonEvento":
					case "buttonTurnoVolontariato":
					case "buttonAllLocations":

						listaBottoniDaRimuovere.add(btn);
					default:
					}
				}
			}
		}
		if (type.equals(MarkerType.EVENTO)) {
			for (Node node : lista) {
				Button btn = (Button) node;
				if (user.getClass() == VolunteerUser.class) {
					switch (btn.getId()) {
					case "buttonPromuoviEvento":
					case "buttonBacheca":
					case "buttonTurnoVolontariato":
					case "buttonAllLocations":
					case "buttonDonazione":
						listaBottoniDaRimuovere.add(btn);
					default:
					}
				} else {
					switch (btn.getId()) {
					case "buttonEvento":
					case "buttonPromuoviEvento":
					case "buttonTurnoVolontariato":
					case "buttonAllLocations":
					case "buttonBacheca":
					case "buttonDonazione":
						listaBottoniDaRimuovere.add(btn);
					default:
					}
					

				}
			}
		}
		if (type.equals(MarkerType.MAP)) {
			for (Node node : lista) {
				Button btn = (Button) node;
				switch (btn.getId()) {
				case "buttonPromuoviEvento":
				case "buttonBacheca":
				case "buttonTurnoVolontariato":
				case "buttonEvento":
				case "buttonDonazione":
					listaBottoniDaRimuovere.add(btn);
					default:
				}
			}
		}

	}

	private void animateClickMarker(Coordinate oldPosition, Coordinate newPosition) { // animate the marker to the new
																						// position final Transition
		Transition transition = new Transition() {
			private final Double oldPositionLongitude = oldPosition.getLongitude();
			private final Double oldPositionLatitude = oldPosition.getLatitude();
			private final double deltaLatitude = newPosition.getLatitude() - oldPositionLatitude;
			private final double deltaLongitude = newPosition.getLongitude() - oldPositionLongitude;

			{
				setCycleDuration(Duration.seconds(1.0));
				setOnFinished(evt -> markerClick.setPosition(newPosition));
			}

			@Override
			protected void interpolate(double v) {
				final double latitude = oldPosition.getLatitude() + v * deltaLatitude;
				final double longitude = oldPosition.getLongitude() + v * deltaLongitude;
				markerClick.setPosition(new Coordinate(latitude, longitude));
			}
		};
		transition.play();
	}

	/**
	 * shows a new polygon with the coordinate from the added.
	 *
	 * @param event event with coordinates
	 */

	/**
	 * enables / disables the different controls
	 *
	 * @param flag if true the controls are disabled
	 */
	private void setControlsDisable(boolean flag) {
		topControls.setDisable(flag);
		leftControls.setDisable(flag);
	}

	/**
	 * finishes setup after the mpa is initialzed
	 */
	private void afterMapIsInitialized() {
		logger.trace("map intialized");
		logger.debug("setting center and enabling controls...");
		// start at the harbour with default zoom
		mapView.setZoom(ZOOMDEFAULT);
		mapView.setCenter(RomaCentro);
		// add the markers to the map - they are still invisible

		for (int i = 0; i < markerEventi.size(); i++) {
			mapView.addMarker(markerEventi.get(i).getMarker());
		}
		for (int i = 0; i < markerCaritas.size(); i++) {
			mapView.addMarker(markerCaritas.get(i).getMarker());
		}

		for (int i = 0; i < markerDonazioni.size(); i++) {
			mapView.addMarker(markerDonazioni.get(i).getMarker());
		}

		setControlsDisable(false);
	}



	public void setUser(User user) {
		this.loggedUser = user;

	}
}
