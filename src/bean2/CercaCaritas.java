package bean2;




import controller.CercaCaritasController;
import controller.ShopHomeController;
import controller.UserHomeController;
import entity.CoordinateMap;
import entity.MarkerID;


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
	private static final String eve = "buttonEvento";
	private static final String pro = "buttonPromuoviEvento";
	private static final String all = "buttonAllLocations";
	private static final String don = "buttonDonazione";
	private static final String tur = "buttonTurnoVolontariato";
	private static final String bac = "buttonBacheca";
	private int idCaritas;
	private int idEvento;

	private String ruolo;
	private int idUser;
	private String v = "Volontario";
	private String c = "Caritas";
	private String n = "Negozio";
	
	/** logger for the class. */
	private static final Logger logger = LoggerFactory.getLogger(CercaCaritas.class);

	
	



	/** default zoom value. */
	private static final int ZOOMDEFAULT = 14;

	/** the markers. */
	private CercaCaritasController cercaController;

	private List<CoordinateMap> markerCaritas;
	private List<CoordinateMap> markerEventi;
	private List<CoordinateMap> markerDonazioni;


	
	public int indietro() {
	if (ruolo.equals(v)) {				
				UserHomeBoundary userHomeBoundary = new UserHomeBoundary();
				UserHomeController userHomeController = new UserHomeController();
				userHomeController.initDataCont(this.idUser,userHomeBoundary);
				return 3;
	}
	else if(ruolo.equalsIgnoreCase(n)) {
			ShopHomeBoundary shopHomeBoundary = new ShopHomeBoundary();
			ShopHomeController shopHomeC = new ShopHomeController();
			shopHomeC.initDataShop(this.idUser, shopHomeBoundary);
			return 9;
		}
	else {
		return 2;
	}
	}
	public void promuoviEvento(int idCar) {
			PromuoviEventoBoundary promEvento = new PromuoviEventoBoundary();
			promEvento.loadFormBoundary(idCar, this.idUser);
		}


	public  void vediNecessita(int idCar) {
			BachecaBoundary bacheca =  new BachecaBoundary();
			bacheca.loadFormBoundary(idCar, this.idUser);
	}

	public void creaDonazione(int idCar) {
			DonationBoundary donationBoundary = new DonationBoundary();
			System.out.println("Sono io, su cercaCaritas!!" +idCar);
			donationBoundary.initBoundary(idCar, this.idUser);
	}

	public void prenotaTurno(int idCar) {
			PrenotaTurnoBoundary prenotaController = new PrenotaTurnoBoundary() ;
			prenotaController.setData(idCar, this.idUser);		
	}
	

	public void partecipaEvento(int idEvent) {
			PartecipaEventoBoundary partecipaEvent = new PartecipaEventoBoundary();
			partecipaEvent.setData(idEvent, this.idUser);
		}

	// molto da cambiare

	public CercaCaritas() throws NumberFormatException, SQLException {
		cercaController = new CercaCaritasController();
		initMarkersCaritas();
	}

	

	public List<CoordinateMap> initMarkersCaritas() {
		return cercaController.initMarkerCar();
	}

	public List<CoordinateMap> initMarkersEvento() {
		return cercaController.initMarkerEvent();
	}
	
	public List<CoordinateMap> initMarkersDonazione() {
		return cercaController.initMarkerDonation();
	}
	
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	
	public int getIdUte() {
		return this.idUser;
	}
	
	
/*	public void initMapAndControls() {
		// wire up the location buttons
		buttonBack.setOnAction(event -> indietro());
		buttonBacheca.setOnAction(event -> vediNecessita(idCaritas, idUser));
		buttonPromuoviEvento.setOnAction(event -> promuoviEvento(idCaritas, idUser));
		buttonTurnoVolontariato.setOnAction(event -> prenotaTurno(idCaritas, idUser));
		buttonEvento.setOnAction(event -> partecipaEvento(idEvento, idUser));
		buttonDonazione.setOnAction(event -> apriDonazione(idCaritas, idUser)); //non dovrebbe servirmi perche nminando i bottoi collego direttamente al metodo
		buttonAllLocations.setOnAction(event -> {
			CercaCaritasController c = new CercaCaritasController();
			c.initMap2(idUser, markerClick.getPosition().getLatitude().toString(), markerClick.getPosition().getLongitude().toString());
			

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
			mapView.setMapType(mapType);
		});
		mapTypeGroup.selectToggle(radioMsOSM);

		setupEventHandlers();

		if (this.ruolo.equalsIgnoreCase(v)) {
			for (MarkerID markerEvento : markerEventi) {
				checkEventoMarker.setGraphic(new ImageView(
						new Image(markerEvento.getMarker().getImageURL().toExternalForm(), 16.0, 16.0, true, true)));
				checkEventoMarker.selectedProperty().bindBidirectional(markerEvento.getMarker().visibleProperty());
			}

			for (MarkerID markerCaritas2 : markerCaritas) {
				checkCaritasMarker.setGraphic(new ImageView(
						new Image(markerCaritas2.getMarker().getImageURL().toExternalForm(), 16.0, 16.0, true, true)));
				checkCaritasMarker.selectedProperty().bindBidirectional(markerCaritas2.getMarker().visibleProperty());
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
		if (this.ruolo.equalsIgnoreCase(n)) {
			// add the graphics to the checkboxes
			for (MarkerID markerCaritas2 : markerCaritas) {
				checkCaritasMarker.setGraphic(new ImageView(
						new Image(markerCaritas2.getMarker().getImageURL().toExternalForm(), 16.0, 16.0, true, true)));
				checkCaritasMarker.selectedProperty().bindBidirectional(markerCaritas2.getMarker().visibleProperty());
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

	}


/*	/**
	 * initializes the event handlers.
	 */
/*	private void setupEventHandlers() {

		markerClick.setPosition(RomaCentro);

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

		mapView.addEventHandler(MapViewEvent.MAP_POINTER_MOVED, event -> 
			logger.debug("pointer moved to " + event.getCoordinate())
		);

		logger.trace("map handlers initialized");
	}
*/
/*	public void updateButtonsBox(MarkerType markerType) {
		for (Node n : listaBottoniOld) {
			if (!listaBottoni.contains(n)) {
				listaBottoni.add(n);
			}
		}

		ObservableList<Node> lista = listaBottoni;
		List<Node> listaBottoniDaRimuovere = new ArrayList<>();
		searchButtonsToRemoveByUser(this.ruolo, markerType, lista, listaBottoniDaRimuovere);
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
	}*/

/*	public void searchButtonsToRemoveByUser(String ruolo, MarkerType type, List<Node> listaBottoniDaRimuovere) {
	
	
		
		if (type.equals(MarkerType.CARITAS)) {
			for (Node node : lista) {
				Button btn = (Button) node;
				if (ruolo.equalsIgnoreCase(v)) {
					switch (btn.getId()) {
					case eve:
					case pro:
					case all:

						listaBottoniDaRimuovere.add(btn);
					default:
					}
				}

				if (ruolo.equalsIgnoreCase(c)) {
					switch (btn.getId()) {
					case eve:
					case pro:
					case tur:
					case all:

						listaBottoniDaRimuovere.add(btn);
					default:
					}
				}

				if (ruolo.equalsIgnoreCase(n)) {
					switch (btn.getId()) {
					case eve:
					case tur:
					case all:

						listaBottoniDaRimuovere.add(btn);
					default:
					}
				}
			}
		}
		if (type.equals(MarkerType.EVENTO)) {
			for (Node node : lista) {
				Button btn = (Button) node;
				if (ruolo.equalsIgnoreCase(v)) {
					switch (btn.getId()) {
					case pro:
					case bac:
					case tur:
					case all:
					case don:
						listaBottoniDaRimuovere.add(btn);
					default:
					}
				} else {
					switch (btn.getId()) {
					case eve:
					case pro:
					case tur:
					case all:
					case bac:
					case don:
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
				case pro:
				case bac:
				case tur:
				case eve:
				case don:
					listaBottoniDaRimuovere.add(btn);
					default:
				}
			}
		}

	}*/

/*	private void animateClickMarker(Coordinate oldPosition, Coordinate newPosition) { // animate the marker to the new
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
*/
	



	/*private void afterMapIsInitialized() {
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

*/

	public void setUser(int id, String ruolo) {
		this.idUser = id;
		this.ruolo = ruolo;
		

	}
	public int getIdCaritas() {
		return idCaritas;
	}
	public void setIdCaritas(int idCaritas) {
		this.idCaritas = idCaritas;
	}
}
