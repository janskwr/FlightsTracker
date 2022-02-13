package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField my_text;

    @FXML
    void onClick(ActionEvent event) {
        System.out.println(my_text.getText());
    }

}
