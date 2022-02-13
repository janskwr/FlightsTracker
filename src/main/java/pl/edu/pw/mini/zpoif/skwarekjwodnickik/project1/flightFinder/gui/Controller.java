package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.gui;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.model.Converters;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class Controller {

    @FXML
    private ChoiceBox<String> destination;

    @FXML
    private ChoiceBox<String> origin;

    @FXML
    private DatePicker dateEnd;

    @FXML
    private DatePicker dateStart;

    @FXML
    private ListView<String> resultList;

    @FXML
    private void initialize() throws FileNotFoundException, URISyntaxException {
        ObservableList<String> airports = Converters.allIcaos();

        origin.setItems(airports);
        destination.setItems(airports);
    }

    @FXML
    void search(ActionEvent event) {
        resultList.getItems().clear();
        resultList.getItems().addAll(origin.getValue(), destination.getValue());
    }

}
