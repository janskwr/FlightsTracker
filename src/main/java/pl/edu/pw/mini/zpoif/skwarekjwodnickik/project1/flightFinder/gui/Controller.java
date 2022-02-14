package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.gui;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
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
        String originValue = origin.getSelectionModel().getSelectedItem();
        String destinationValue = destination.getSelectionModel().getSelectedItem();

        resultList.getItems().clear();
        resultList.getItems().addAll();
    }

}
