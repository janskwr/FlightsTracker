package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi.model.Flight;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.services.FlightsServices;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.model.Airport;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.model.AirportsData;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.model.Converters;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Controller class responsible for GUI control.
 */
public class Controller {

    @FXML
    private ListView<Airport> destination;

    @FXML
    private ListView<Airport> origin;

    @FXML
    private TextField destinationSearch;

    @FXML
    private TextField originSearch;

    @FXML
    private DatePicker dateEnd;

    @FXML
    private DatePicker dateStart;

    @FXML
    private ListView<Flight> resultList;

    private static ObservableList<Airport> airports;

    @FXML
    private void initialize() throws FileNotFoundException, URISyntaxException {
        airports = FXCollections.observableList(AirportsData.CSVConverter());
        FilteredList<Airport> filteredAirportsO = new FilteredList<>(airports, s -> true);
        FilteredList<Airport> filteredAirportsD = new FilteredList<>(airports, s -> true);

        Callback<ListView<Airport>, ListCell<Airport>> tooltipFunction =
                cell -> new ListCell<>() {
                    final Tooltip tooltip = new Tooltip();

                    @Override
                    protected void updateItem(Airport item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                            setTooltip(null);
                        } else {
                            setText(item.getIcao());
                            try {
                                tooltip.setText(item.getName());
                            } catch (Exception e) {
                                tooltip.setText(null);
                            }
                            setTooltip(tooltip);
                        }
                    }
                };

        originSearch.textProperty().addListener(obs -> {
            String filter = originSearch.getText().toUpperCase();
            if (filter.length() == 0) {
                filteredAirportsO.setPredicate(s -> true);
            } else {
                filteredAirportsO.setPredicate(s -> s.getIcao().contains(filter) || s.getName().toUpperCase().contains(filter));
            }
        });
        origin.setItems(filteredAirportsO);
        origin.setCellFactory(tooltipFunction);

        destinationSearch.textProperty().addListener(obs -> {
            String filter = destinationSearch.getText().toUpperCase();
            if (filter.length() == 0) {
                filteredAirportsD.setPredicate(s -> true);
            } else {
                filteredAirportsD.setPredicate(s -> s.getIcao().contains(filter) || s.getName().toUpperCase().contains(filter));
            }
        });
        destination.setItems(filteredAirportsD);
        destination.setCellFactory(tooltipFunction);

        resultList.setCellFactory(cell -> new ListCell<>() {
            final Tooltip tooltip = new Tooltip();

            @Override
            protected void updateItem(Flight flight, boolean empty) {
                super.updateItem(flight, empty);

                if (flight == null || empty) {
                    setText(null);
                    setTooltip(null);
                } else {
                    setText("Flight " +
                            flight.getIcao24() +
                            " from " +
                            flight.getEstDepartureAirport() +
                            " to " +
                            flight.getEstArrivalAirport());

                    try {
                        tooltip.setText(

                                "Flight: " + flight.getIcao24() +
                                        "\n" +
                                        "From: " + Converters.IcaoToName(flight.getEstDepartureAirport()) +
                                        "\n" +
                                        "To: " + Converters.IcaoToName(flight.getEstArrivalAirport()) +
                                        "\n" +
                                        "First seen: " + Converters.UnixToRoman(flight.getFirstSeen()) +
                                        "\n" +
                                        "Last seen: " + Converters.UnixToRoman(flight.getLastSeen())

                        );
                    } catch (FileNotFoundException | URISyntaxException e) {
                        e.printStackTrace();
                    }
                    setTooltip(tooltip);
                }
            }
        });
        resultList.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Flight flight = resultList.getSelectionModel().getSelectedItem();
                Airport departureairport = airports.stream()
                        .filter(airport -> flight.getEstDepartureAirport().equals(airport.getIcao()))
                        .findAny()
                        .orElse(null);
                Airport arrivalairport = airports.stream()
                        .filter(airport -> flight.getEstArrivalAirport().equals(airport.getIcao()))
                        .findAny()
                        .orElse(null);
                String text;
                try {
                    assert departureairport != null;
                    text = "Flight data: " +
                            "\n" +
                            "ICAO number: " + flight.getIcao24() +
                            "\n" +
                            "Callsign: " + flight.getCallsign() +
                            "\n" +
                            "From: " + Converters.IcaoToName(flight.getEstDepartureAirport()) +
                            "\n" +
                            "To: " + Converters.IcaoToName(flight.getEstArrivalAirport()) +
                            "\n" +
                            "First seen: " + Converters.UnixToRoman(flight.getFirstSeen()) +
                            "\n" +
                            "Last seen: " + Converters.UnixToRoman(flight.getLastSeen()) +
                            "\n" +
                            "\n" +
                            "Departure airport data: " +
                            "\n" +
                            "Name: " + departureairport.getName() +
                            "\n" +
                            "City: " + departureairport.getCity() +
                            "\n" +
                            "Country: " + departureairport.getCountry() +
                            "\n" +
                            "Latitude: " + departureairport.getLatitude() +
                            "\n" +
                            "Longitude: " + departureairport.getLongitude() +
                            "\n" +
                            "IATA number: " + departureairport.getIata() +
                            "\n" +
                            "ICAO number: " + departureairport.getIcao() +
                            "\n" +
                            "\n" +
                            "Arrival airport data: " +
                            "\n" +
                            "Name: " + arrivalairport.getName() +
                            "\n" +
                            "City: " + arrivalairport.getCity() +
                            "\n" +
                            "Country: " + arrivalairport.getCountry() +
                            "\n" +
                            "Latitude: " + arrivalairport.getLatitude() +
                            "\n" +
                            "Longitude: " + arrivalairport.getLongitude() +
                            "\n" +
                            "IATA number: " + arrivalairport.getIata() +
                            "\n" +
                            "ICAO number: " + arrivalairport.getIcao()
                    ;
                } catch (Exception e) {
                    text = "";
                }
                Stage tmp = new Stage();
                tmp.setTitle("Selected flight details");
                tmp.setScene(new Scene(new Label(text)));
                tmp.show();
            }
        });
    }

    @FXML
    void search(ActionEvent event) {
        ArrayList<Flight> flights;
        try {
            flights = FlightsServices.
                    getFlightsFromBeginToEndByDepartureAndArrival(origin.getSelectionModel().getSelectedItem().getIcao(),
                            destination.getSelectionModel().getSelectedItem().getIcao(),
                            Converters.RomanToUnix(Converters.localDatetoDate(dateStart.getValue())),
                            Converters.RomanToUnix(Converters.localDatetoDate(dateEnd.getValue())));
        } catch (IOException e) {
            flights = new ArrayList<>();
        }

        resultList.getItems().clear();
        resultList.getItems().addAll(flights);
    }

}
