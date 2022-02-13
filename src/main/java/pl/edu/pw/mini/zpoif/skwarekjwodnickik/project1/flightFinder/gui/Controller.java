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
    public ChoiceBox<String> destination;

    @FXML
    public ChoiceBox<String> origin;

    @FXML
    public DatePicker dateEnd;

    @FXML
    public DatePicker dateStart;

    @FXML
    private ListView<String> resultList;

    @FXML
    private void initialize() throws FileNotFoundException, URISyntaxException {
//        Converters converters = new Converters();
//        ObservableList<String> airports = Converters.allIcaos();

//        origin.setItems(airports);
//        destination.setItems(airports);
    }

    @FXML
    void search(ActionEvent event) {
        resultList.getItems().clear();
        resultList.getItems().addAll(Tmp.getList(this));
    }

}
