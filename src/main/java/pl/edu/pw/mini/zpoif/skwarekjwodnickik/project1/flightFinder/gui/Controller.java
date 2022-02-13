package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.services.FlightsServicesStandard;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.model.Converters;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class Controller {

    @FXML
    private ListView<String> destination;

    @FXML
    private ListView<String> origin;

    @FXML
    private DatePicker dateEnd;

    @FXML
    private DatePicker dateStart;

    @FXML
    private ListView<String> resultList;

    @FXML
    private void initialize() throws FileNotFoundException, URISyntaxException {
        ObservableList<String> airports = Converters.allIcaos();

        origin.getItems().clear();
        origin.getItems().addAll(airports);

        destination.getItems().clear();
        destination.getItems().addAll(airports);
    }

    @FXML
    void search(ActionEvent event) {
        resultList.getItems().clear();
        FlightsServicesStandard fss = new FlightsServicesStandard();
        fss.getFlightsFromBeginToEnd(Converters.RomanToUnix(Converters.localDatetoDate(dateStart.getValue())),
                Converters.RomanToUnix(Converters.localDatetoDate(dateEnd.getValue())));
    }

}
