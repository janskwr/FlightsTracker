package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.gui;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.model.Converters;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

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
    }

    @FXML
    void search(ActionEvent event) {
        String originValue = origin.getSelectionModel().getSelectedItem();
        String destinationValue = destination.getSelectionModel().getSelectedItem();

        resultList.getItems().clear();
        resultList.getItems().addAll(originValue, destinationValue);
    }

}
