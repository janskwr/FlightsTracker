package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.gui;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi.model.Flight;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.services.FlightsServices;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.model.Converters;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Controller {

    @FXML
    private ListView<String> destination;

    @FXML
    private ListView<String> origin;

    @FXML
    private TextField destinationSearch;

    @FXML
    private TextField originSearch;

    @FXML
    private DatePicker dateEnd;

    @FXML
    private DatePicker dateStart;

    @FXML
    private ListView<String> resultList;

    @FXML
    private void initialize() throws FileNotFoundException, URISyntaxException {
        ObservableList<String> airports = Converters.allIcaos();
        FilteredList<String> filteredAirportsO = new FilteredList<>(airports, s->true);
        FilteredList<String> filteredAirportsD = new FilteredList<>(airports, s->true);

        Callback<ListView<String>, ListCell<String>> tooltipFunction =
                cell -> new ListCell<>() {
                    final Tooltip tooltip = new Tooltip();
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                            setTooltip(null);
                        } else {
                            setText(item);
                            try {
                                tooltip.setText(Converters.IcaoToName(item));
                            } catch (Exception e) {
                                tooltip.setText(null);
                            }
                            setTooltip(tooltip);
                        }
                    }
                };

        originSearch.textProperty().addListener(obs->{
            String filter = originSearch.getText().toUpperCase();
            if(filter.length() == 0) {
                filteredAirportsO.setPredicate(s -> true);
            }
            else {
                filteredAirportsO.setPredicate(s -> s.contains(filter));
            }
        });
        origin.setItems(filteredAirportsO);
        origin.setCellFactory(tooltipFunction);

        destinationSearch.textProperty().addListener(obs->{
            String filter = destinationSearch.getText().toUpperCase();
            if(filter.length() == 0) {
                filteredAirportsD.setPredicate(s -> true);
            }
            else {
                filteredAirportsD.setPredicate(s -> s.contains(filter));
            }
        });
        destination.setItems(filteredAirportsD);
        destination.setCellFactory(tooltipFunction);
    }

    @FXML
    void search(ActionEvent event) {
        ArrayList<Flight> flights;
        try {
            flights = FlightsServices.
                    getFlightsFromBeginToEndByDepartureAndArrival(origin.getSelectionModel().getSelectedItem(),
                            destination.getSelectionModel().getSelectedItem(),
                            Converters.RomanToUnix(Converters.localDatetoDate(dateStart.getValue())),
                            Converters.RomanToUnix(Converters.localDatetoDate(dateEnd.getValue())));
        } catch (IOException e) {
            flights = new ArrayList<>();
        }

        ArrayList<String> res = new ArrayList<>();
        for (Flight flight : flights) {
            res.add(String.valueOf(flight));
        }
        //
        resultList.getItems().clear();
        resultList.getItems().addAll("zaczęło się");
        resultList.getItems().addAll(res);
        resultList.getItems().addAll("udało się");
    }

}
