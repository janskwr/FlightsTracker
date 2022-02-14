package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
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

    @FXML
    private void initialize() throws FileNotFoundException, URISyntaxException {
        ObservableList<Airport> airports = FXCollections.observableList(AirportsData.CSVConverter());
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
                System.out.println("clicked on " + resultList.getSelectionModel().getSelectedItem());
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

        Stage tmp = new Stage();
        tmp.setTitle("Popup");
        tmp.setScene(new Scene(new Group()));
        tmp.show();
    }

}
