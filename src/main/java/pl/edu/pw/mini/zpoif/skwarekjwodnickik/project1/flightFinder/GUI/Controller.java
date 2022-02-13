package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.GUI;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;

public class Controller {

    private ObservableList<String> airports;

    @FXML
    private ChoiceBox<String> destination;

    @FXML
    private ChoiceBox<String> origin;

    @FXML
    private DatePicker dateSelector;

    @FXML
    private ListView<String> resultList;

    @FXML
    private void initialize() {
        airports = Tmp.getCodes();
        origin.setItems(airports);
        destination.setItems(airports);
    }

    @FXML
    void search(ActionEvent event) {
        resultList.getItems().clear();
        resultList.getItems().addAll(Tmp.getList(origin.getValue(), destination.getValue()));
    }

}
