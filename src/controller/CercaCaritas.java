package controller;


	
	import com.mysql.cj.protocol.Resultset;

/*
	 Copyright 2015-2020 Peter-Josef Meisch (pj.meisch@sothawo.com)

	   Licensed under the Apache License, Version 2.0 (the "License");
	   you may not use this file except in compliance with the License.
	   You may obtain a copy of the License at

	       http://www.apache.org/licenses/LICENSE-2.0

	   Unless required by applicable law or agreed to in writing, software
	   distributed under the License is distributed on an "AS IS" BASIS,
	   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	   See the License for the specific language governing permissions and
	   limitations under the License.
	*/
	

	import com.sothawo.mapjfx.*;
	import com.sothawo.mapjfx.event.MapLabelEvent;
	import com.sothawo.mapjfx.event.MapViewEvent;
	import com.sothawo.mapjfx.event.MarkerEvent;
	import com.sothawo.mapjfx.offline.OfflineCache;

import bean.BachecaBoundary;
import bean.DonationBoundary;
import bean.PartecipaEventoBoundary;
import bean.PrenotaTurnoBoundary;
//import connector.Connector;
import dao.CercaCaritasDao;
import dao.CoordinateDao;
import entity.markerID;
//import javafx.animation.AnimationTimer;
//	import javafx.animation.Transition;
	import javafx.beans.binding.Bindings;
//	import javafx.beans.value.ChangeListener;
	import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
//	import javafx.scene.paint.Color;
import javafx.stage.Stage;
//import javafx.util.Duration;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.net.URL;
	import java.nio.charset.StandardCharsets;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
	//import java.util.List;
	import java.util.Optional;
	import java.util.stream.Collectors;
	import java.util.stream.Stream;

//import javax.swing.text.Position;

	/**
	 * Controller for the FXML defined code.
	 *
	 * @author P.J. Meisch (pj.meisch@sothawo.com).
	 */
	public class CercaCaritas {
		
		private int idUtente;
		private int idCaritas;
		private int idEvento;
		private PrenotaTurnoBoundary prenotaController;
		private PartecipaEventoBoundary partecipaEvent;
		private BachecaBoundary bacheca;
		private int countCaritas;
		private int countEvent;
		private int countDonation;
		

	    /** logger for the class. */
	    private static final Logger logger = LoggerFactory.getLogger(CercaCaritas.class);

	    /* some coordinates from around town.   Da cambiare con una chiamata sql*/
	   private static final Coordinate coordKarlsruheCastle = new Coordinate(49.013517, 8.404435);
	   private static final Coordinate RomaCentro = new Coordinate(41.900412, 12.494619);
	    private static final Coordinate coordKarlsruheStation = new Coordinate(48.993284, 8.402186);
	    private static final Coordinate coordKarlsruheSoccer = new Coordinate(49.020035, 8.412975);
	    private static final Coordinate coordKarlsruheUniversity = new Coordinate(49.011809, 8.413639);
	    private static final Extent extentAllLocations = Extent.forCoordinates(coordKarlsruheCastle, RomaCentro, coordKarlsruheStation, coordKarlsruheSoccer);
	

	    private static final Coordinate coordGermanyNorth = new Coordinate(41.987167, 12.477502);
	    private static final Coordinate coordGermanySouth = new Coordinate(41.794755, 12.511766);
	    private static final Coordinate coordGermanyWest = new Coordinate(41.886165, 12.371194 );
	    private static final Coordinate coordGermanyEast = new Coordinate(41.905271, 12.617460);
	    private static final Extent extentGermany = Extent.forCoordinates(coordGermanyNorth, coordGermanySouth, coordGermanyWest, coordGermanyEast);

	    private static Coordinate posMarker = null;
	    
	    /** default zoom value. */
	    private static final int ZOOMDEFAULT = 14;

	    /** the markers. */
	    
	    markerID markerC = new markerID();
	    
	    public Marker[] markerCaritas = {null,null,null,null,null,null,null};
	    int[] IdCaritaList;
	    

	    
	    
	    public  Marker[] markerEvento={null,null,null,null,null,null,null};
	    private Marker[] markerDonazione = {null,null,null,null,null,null,null};
	 
	    private final Marker markerClick;

	    /** the labels. */
	    private final MapLabel labelCaritas;
	    private final MapLabel labelEvento;
	    private final MapLabel labelDonazione;
	    private final MapLabel labelClick;

	    // a circle around the castle
	    private final MapCircle circleCastle;

	    @FXML
	    /** button to set the map's zoom. */
	    private Button buttonZoom;

	    /** the MapView containing the map */
	    @FXML
	    private MapView mapView;

	    /** the box containing the top controls, must be enabled when mapView is initialized */
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

	    /** for editing the animation duration */
	    @FXML
	    private TextField animationDuration;

	    /** the BIng Maps API Key. */
	 //   @FXML
	 //   private TextField bingMapsApiKey;

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

	    /** RadioButton for MapStyle Stamen Watercolor */
	    @FXML
	    private RadioButton radioMsSTW;

	    /** RadioButton for MapStyle Bing Roads */
	    @FXML
	    private RadioButton radioMsBR;

	    /** RadioButton for MapStyle Bing Roads - dark */
	    @FXML
	    private RadioButton radioMsCd;

	    /** RadioButton for MapStyle Bing Roads - grayscale */
	    @FXML
	    private RadioButton radioMsCg;

	    /** RadioButton for MapStyle Bing Roads - light */
	    @FXML
	    private RadioButton radioMsCl;

	    /** RadioButton for MapStyle Bing Aerial */
	    @FXML
	    private RadioButton radioMsBA;

	    /** RadioButton for MapStyle Bing Aerial with Label */
	    @FXML
	    private RadioButton radioMsBAwL;

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

	    /** Check button for soccer marker */
	    @FXML
	    private CheckBox checkKaSoccerMarker;

	    /** Check button for click marker */
	    @FXML
	    private CheckBox checkClickMarker;
	    
	    
	    private Marker markerSelected;

	    /** the first CoordinateLine */
	 //   private CoordinateLine trackMagenta;
	    /** Check button for first track */
	//    @FXML
	 //   private CheckBox checkTrackMagenta;

	    /** the second CoordinateLine */
	  //  private CoordinateLine trackCyan;
	    /** Check button for first track */
	 //   @FXML
	   // private CheckBox checkTrackCyan;

	    /** Coordinateline for polygon drawing. */
	  //  private CoordinateLine polygonLine;
	    /** Check Button for polygon drawing mode. */
	//    @FXML
	  //  private CheckBox checkDrawPolygon;

	    /** Check Button for constraining th extent. */
	//    @FXML
	   // private CheckBox checkConstrainGermany;

	    /** params for the WMS server. */
	    private WMSParam wmsParam = new WMSParam()
	        .setUrl("http://ows.terrestris.de/osm/service?")
	        .addParam("layers", "OSM-WMS");

	    private XYZParam xyzParams = new XYZParam()
	        .withUrl("https://server.arcgisonline.com/ArcGIS/rest/services/World_Topo_Map/MapServer/tile/{z}/{y}/{x})")
	        .withAttributions(
	            "'Tiles &copy; <a href=\"https://services.arcgisonline.com/ArcGIS/rest/services/World_Topo_Map/MapServer\">ArcGIS</a>'");

	    
	    
	    
	    
	    
	    
	    private void vediNecessità(int idCar, int idUt){
	    	try {     
		        FXMLLoader fxmlLoader = new FXMLLoader();

		  
		       
		       
		        
		        Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("/boundary/Bacheca.fxml"));
	
		        
		        Stage stage = new Stage();
	    		stage.setTitle("Bacheca");
	    		
	    		stage.setScene(new Scene(rootNode, 700, 450));
	    		stage.setResizable(false);
	    	
	    		
	    		 bacheca = fxmlLoader.getController();
	
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
    	       
    	       // donationController = fxmlLoader.getController();
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
    	        Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("/boundary/Prenota_turno_volontariato.fxml"));
    	       
    	        prenotaController = fxmlLoader.getController();
    	        
    	        Stage stage = new Stage();
	    		stage.setTitle("Prenota Turno");
	    		prenotaController.setData(idCar, idUt);
	    		stage.setScene(new Scene(rootNode, 630,400));
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
    	       
    	        partecipaEvent = fxmlLoader.getController();
    	        
    	        Stage stage = new Stage();
	    		stage.setTitle("Prenota Turno");
	    		partecipaEvent.setData(idEvent, idUt);
	    		stage.setScene(new Scene(rootNode, 700,450));
	    		stage.setResizable(false);
	    		stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    	
	    }
	    
	    
	    // molto da cambiare
	    
	    public CercaCaritas() throws NumberFormatException, SQLException {
	        // a couple of markers using the provided ones
	    	 
	    	CercaCaritasDao marker = new CercaCaritasDao();

			 countCaritas=0;
			 countEvent=0;
			 countDonation=0;
	    	
	       
			
	        markerEvento=marker.assegnaMarkerEvento();
	        while(markerEvento[countEvent]!= null) {
	        markerEvento[countEvent].setVisible(false);
	           
	        countEvent++;
	        };
	        //chiamata sql per coordinante donazioni
	        
	        markerDonazione= marker.assegnaMarkerDonazione();
	        while(markerDonazione[countDonation]!=null) {
	        markerDonazione[countDonation].setVisible(false);
	        countDonation++;
	        };
	        // no position for click marker yet
	        markerClick = Marker.createProvided(Marker.Provided.ORANGE).setVisible(false);

	        // chiamata sql per coordinate Caritas
	        
	        
	        
	       CercaCaritasDao prova = new CercaCaritasDao();
	       markerC = prova.assegnaMarker();
	       int i = 0;
	     
	       
	       while(markerC.getMarker(i)!=null) {
	       IdCaritaList =  markerC.idMarker(i);//.marker.assegna_marker();
	       markerCaritas[i] = markerC.getMarker(i);
	       i++;
	       }
	        while(markerCaritas[countCaritas]!=null) {
	        	markerCaritas[countCaritas].setVisible(true);
	        	countCaritas++;
	        };

	        
	        // camvbiare cooordinate di tutte le label.
	        
	        
	        
	        labelDonazione = new MapLabel("university").setPosition(coordKarlsruheUniversity).setVisible(true);
	        // the attached labels, custom style
	        labelCaritas = new MapLabel("castle", 10, -10).setVisible(false).setCssClass("green-label");
	        labelEvento = new MapLabel("station", 10, -10).setVisible(false).setCssClass("red-label");
	        labelClick = new MapLabel("click!", 10, -10).setVisible(false).setCssClass("orange-label");

	       // markerDonazione.attachLabel(labelDonazione);
	        //markerCaritas.attachLabel(labelCaritas);
	        markerClick.attachLabel(labelClick);

	        circleCastle = new MapCircle(coordKarlsruheStation, 1_000).setVisible(true);
	    }

	    /**
	     * called after the fxml is loaded and all objects are created. This is not called initialize any more,
	     * because we need to pass in the projection before initializing.
	     *
	     * @param projection
	     *     the projection to use in the map.
	     */
	    public void initMapAndControls(Projection projection) {
	        logger.trace("begin initialize");

	        // init MapView-Cache
	        final OfflineCache offlineCache = mapView.getOfflineCache();
	        final String cacheDir = System.getProperty("java.io.tmpdir") + "/mapjfx-cache";
//	        logger.info("using dir for cache: " + cacheDir);
//	        try {
//	            Files.createDirectories(Paths.get(cacheDir));
//	            offlineCache.setCacheDirectory(cacheDir);
//	            offlineCache.setActive(true);
//	        } catch (IOException e) {
//	            logger.warn("could not activate offline cache", e);
//	        }

	        // set the custom css file for the MapView
	        mapView.setCustomMapviewCssURL(getClass().getResource("/custom_mapview.css"));

	        leftControls.setExpandedPane(optionsLocations);

	        // set the controls to disabled, this will be changed when the MapView is intialized
	        setControlsDisable(true);

	        
	        
	        
	        
	        //Bottoni
	        
	        
	        
	        // wire up the location buttons
	        buttonDonazione.setOnAction(event -> apriDonazione(idCaritas,idUtente ));
	        buttonTurnoVolontariato.setOnAction(event ->prenotaTurno(idCaritas,idUtente ));
	        buttonBacheca.setOnAction(event -> vediNecessità(idCaritas,idUtente));
	        buttonEvento.setOnAction(event -> partecipaEvento(idEvento, idUtente));

	        buttonAllLocations.setOnAction(event -> {
	        	CoordinateDao c = new CoordinateDao(idUtente);
	        	logger.trace(c.getCoordinate().toString());
	        });
	        logger.trace("location buttons done");
	      
	        
	        

	        buttonDonazione.setVisible(false);
	        buttonTurnoVolontariato.setVisible(false);
	        buttonBacheca.setVisible(false);
	        buttonEvento.setVisible(false);
	        buttonAllLocations.setVisible(false);
	        // wire the zoom button and connect the slider to the map's zoom
	        buttonZoom.setOnAction(event -> mapView.setZoom(ZOOMDEFAULT));
	        sliderZoom.valueProperty().bindBidirectional(mapView.zoomProperty());

	        // add a listener to the animationDuration field and make sure we only accept int values
	    /*    animationDuration.textProperty().addListener((observable, oldValue, newValue) -> {
	            if (newValue.isEmpty()) {
	                mapView.setAnimationDuration(0);
	            } else {
	                try {
	                    mapView.setAnimationDuration(Integer.parseInt(newValue));
	                } catch (NumberFormatException e) {
	                    animationDuration.setText(oldValue);
	                }
	            }
	        });
	        animationDuration.setText("500");*/

	        // bind the map's center and zoom properties to the corresponding labels and format them
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
	            } else if (newValue == radioMsBR) {
	                mapType = MapType.BINGMAPS_ROAD;
	            } else if (newValue == radioMsCd) {
	                mapType = MapType.BINGMAPS_CANVAS_DARK;
	            } else if (newValue == radioMsCg) {
	                mapType = MapType.BINGMAPS_CANVAS_GRAY;
	            } else if (newValue == radioMsCl) {
	                mapType = MapType.BINGMAPS_CANVAS_LIGHT;
	            } else if (newValue == radioMsBA) {
	                mapType = MapType.BINGMAPS_AERIAL;
	            } else if (newValue == radioMsBAwL) {
	                mapType = MapType.BINGMAPS_AERIAL_WITH_LABELS;
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

	        // add the graphics to the checkboxes
	       for (int i =0;i<countEvent;i++) {
	        checkEventoMarker.setGraphic(
	            new ImageView(new Image(markerEvento[i].getImageURL().toExternalForm(), 16.0, 16.0, true, true)));
	       }
	        for(int i = 0; i<countCaritas; i++) {
	        checkCaritasMarker.setGraphic(
	            new ImageView(new Image(markerCaritas[i].getImageURL().toExternalForm(), 16.0, 16.0, true, true)));
	        
	        checkCaritasMarker.selectedProperty().bindBidirectional(markerCaritas[i].visibleProperty());
	        }
	        for(int i=0; i<countDonation; i++) {
	        checkDonazioneMarker.setGraphic(
	            new ImageView(new Image(markerDonazione[i].getImageURL().toExternalForm(), 16.0, 16.0, true, true)));
	        }
	        checkClickMarker.setGraphic(
	            new ImageView(new Image(markerClick.getImageURL().toExternalForm(), 16.0, 16.0, true, true)));

	        // bind the checkboxes to the markers visibility
	        for (int i =0;i<countEvent;i++) {
	        checkEventoMarker.selectedProperty().bindBidirectional(markerEvento[i].visibleProperty());
	        }
	        for (int i =0;i<countDonation;i++) {
	        checkDonazioneMarker.selectedProperty().bindBidirectional(markerDonazione[i].visibleProperty());
	        }
	        checkClickMarker.selectedProperty().bindBidirectional(markerClick.visibleProperty());
	        logger.trace("marker checks done");
	        

	        // load two coordinate lines
	/*     trackMagenta = loadCoordinateLine(getClass().getResource("/M1.csv")).orElse(new CoordinateLine
	           ()).setColor(Color.MAGENTA);
	       trackCyan = loadCoordinateLine(getClass().getResource("/M2.csv")).orElse(new CoordinateLine
	           ()).setColor(Color.CYAN).setWidth(7);
	        logger.trace("tracks loaded");
	        checkTrackMagenta.selectedProperty().bindBidirectional(trackMagenta.visibleProperty());
	        checkTrackCyan.selectedProperty().bindBidirectional(trackCyan.visibleProperty());
	      logger.trace("tracks checks done");
	        // get the extent of both tracks
	        Extent tracksExtent = Extent.forCoordinates(
	           Stream.concat(trackMagenta.getCoordinateStream(), trackCyan.getCoordinateStream())
	            .collect(Collectors.toList()));
	      ChangeListener<Boolean> trackVisibleListener =
	            (observable, oldValue, newValue) -> mapView.setExtent(tracksExtent);
	        trackMagenta.visibleProperty().addListener(trackVisibleListener);
	        trackCyan.visibleProperty().addListener(trackVisibleListener); 
*/
	        // add the polygon check handler
	    /*    ChangeListener<Boolean> polygonListener =
	            (observable, oldValue, newValue) -> {
	                if (!newValue && polygonLine != null) {
	                    mapView.removeCoordinateLine(polygonLine);
	                    polygonLine = null;
	                }
	            };
	      // checkDrawPolygon.selectedProperty().addListener(polygonListener);

*/
	        // add the constrain listener
	     /*   checkConstrainGermany.selectedProperty().addListener(((observable, oldValue, newValue) -> {
	            if (newValue) {
	                mapView.constrainExtent(extentGermany);
	            } else {
	                mapView.clearConstrainExtent();
	            }
	        }));*/

	        // finally initialize the map view
	        logger.trace("start map initialization");
	        mapView.initialize(Configuration.builder()
	            .projection(projection)
	            .showZoomControls(false)
	            .build());
	        logger.debug("initialization finished");

	       // long animationStart = System.nanoTime();
	       /* new AnimationTimer() {
	            @Override
	            public void handle(long nanoSecondsNow) {
	                if (markerKaSoccer.getVisible()) {
	                    // every 100ms, increase the rotation of the markerKaSoccer by 9 degrees, make a turn in 4 seconds
	                    long milliSecondsDelta = (nanoSecondsNow - animationStart) / 1_000_000;33
	                    long numSteps = milliSecondsDelta / 100;
	                    int angle = (int) ((numSteps * 9) % 360);
	                    if (markerKaSoccer.getRotation() != angle) {
	                        markerKaSoccer.setRotation(angle);
	                    }
	                }
	            }
	        }.start(); */
	    }

	    /**
	     * initializes the event handlers.
	     */
	    private void setupEventHandlers() {
	        // add an event handler for singleclicks, set the click marker to the new position when it's visible
	        mapView.addEventHandler(MapViewEvent.MAP_CLICKED, event -> {
	            event.consume();
	            final Coordinate newPosition = event.getCoordinate().normalize();
	            labelEvent.setText("Event: map clicked at: " + newPosition);
	           /* if (checkDrawPolygon.isSelected()) {
	                handlePolygonClick(event);
	            }*/
	            if (markerClick.getVisible()) {
	                final Coordinate oldPosition = markerClick.getPosition();
	                if (oldPosition != null) {
	                    //animateClickMarker(oldPosition, newPosition);
	                 
	                    markerClick.setPosition(newPosition);
	                    // adding can only be done after coordinate is set
	                    mapView.addMarker(markerClick);
	                
	                }
	            }
	           
	        });

	        // add an event handler for MapViewEvent#MAP_EXTENT and set the extent in the map
	        mapView.addEventHandler(MapViewEvent.MAP_EXTENT, event -> {
	            event.consume();
	            mapView.setExtent(event.getExtent());
	        });

	        // add an event handler for extent changes and display them in the status label
	        mapView.addEventHandler(MapViewEvent.MAP_BOUNDING_EXTENT, event -> {
	            event.consume();
	            labelExtent.setText(event.getExtent().toString());
	        });

	        mapView.addEventHandler(MapViewEvent.MAP_CLICKED, event -> {
	            event.consume();
	            labelEvent.setText("Event: map right clicked at: " + event.getCoordinate());
	            buttonDonazione.setVisible(false);
     	        buttonTurnoVolontariato.setVisible(false);
     	        buttonBacheca.setVisible(false);
     	        buttonEvento.setVisible(false);
     	        buttonAllLocations.setVisible(false);
     	      
     	       
     	     
     	       
	        });
	        
	        mapView.addEventHandler(MarkerEvent.MARKER_CLICKED, event -> {
	            event.consume();
	            Marker marker = event.getMarker();
	            posMarker = marker.getPosition();
	            for(int i = 0; i<countCaritas; i++) {
	            if ( marker.getId().equals(markerCaritas[i].getId()) ){
	            	 logger.debug("HAi cliccato sul castello.");
	            	 buttonDonazione.setVisible(true);
	            	 buttonTurnoVolontariato.setVisible(true);
	            	 buttonBacheca.setVisible(true);
	            	 buttonAllLocations.setVisible(true);
	            	 buttonEvento.setVisible(false);

	            	 idCaritas = IdCaritaList[i];
	     	      
	            }
	            }
	            for(int i = 0; i<countEvent; i++) {
	            	if ( marker.getId().equals(markerEvento[i].getId())) {
	            		logger.debug("hai cliccato un evento");
	            		buttonEvento.setVisible(true);
	            		buttonDonazione.setVisible(false);
	            		buttonTurnoVolontariato.setVisible(false);
	            		buttonBacheca.setVisible(false);
	            		buttonAllLocations.setVisible(false);
	            	}
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

	/*    private void animateClickMarker(Coordinate oldPosition, Coordinate newPosition) {
	        // animate the marker to the new position
	        final Transition transition = new Transition() {
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
	    }*/

	    /**
	     * shows a new polygon with the coordinate from the added.
	     *
	     * @param event
	     *     event with coordinates
	     */
	 

	    /**
	     * enables / disables the different controls
	     *
	     * @param flag
	     *     if true the controls are disabled
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
	       
	        for (int i =0;i<countEvent;i++) {
	        mapView.addMarker(markerEvento[i]);
	        }
	        for (int i = 0; i< countCaritas;i++) {
	        mapView.addMarker(markerCaritas[i]);
	        }
	        
	        for (int i =0;i<countDonation;i++) {
	        mapView.addMarker(markerDonazione[i]);
	        }
	        // can't add the markerClick at this moment, it has no position, so it would not be added to the map

	        // add the fix label, the other's are attached to markers.
	        mapView.addLabel(labelCaritas);

	        // add the tracks
	       // mapView.addCoordinateLine(trackMagenta);
	      //  mapView.addCoordinateLine(trackCyan);

	        // add the circle
	        mapView.addMapCircle(circleCastle);

	        // now enable the controls
	        setControlsDisable(false);
	    }

	    /**
	     * load a coordinateLine from the given uri in lat;lon csv format
	     *
	     * @param url
	     *     url where to load from
	     * @return optional CoordinateLine object
	     * @throws java.lang.NullPointerException
	     *     if uri is null
	     */
	    private Optional<CoordinateLine> loadCoordinateLine(URL url) {
	        try (
	            Stream<String> lines = new BufferedReader(
	                new InputStreamReader(url.openStream(), StandardCharsets.UTF_8)).lines()
	        ) {
	            return Optional.of(new CoordinateLine(
	                lines.map(line -> line.split(";")).filter(array -> array.length == 2)
	                    .map(values -> new Coordinate(Double.valueOf(values[0]), Double.valueOf(values[1])))
	                    .collect(Collectors.toList())));
	        } catch (IOException | NumberFormatException e) {
	            logger.error("load {}", url, e);
	        }
	        return Optional.empty();
	    }



		public void setIdUtente(int idUtente) {
			this.idUtente = idUtente;
			
		}
	}

	

