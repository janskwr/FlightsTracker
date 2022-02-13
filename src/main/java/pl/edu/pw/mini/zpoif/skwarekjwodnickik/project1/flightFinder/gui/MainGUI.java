package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.File;

public class MainGUI extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        TitledPane mainPane = (TitledPane) FXMLLoader.load(new File("src/main/resources/MainPage.fxml").toURI().toURL());
        stage.setScene(new Scene(mainPane));
        stage.show();
    }
}
