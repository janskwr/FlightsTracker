module FlightFinder {
    requires org.json;
    requires retrofit2.converter.gson;
    requires retrofit2;
    requires okhttp3;
    requires com.google.gson;
    requires okhttp3.logging;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi.model to com.google.gson;
    opens pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.GUI to javafx.graphics, javafx.fxml;
}