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
    requires opencsv;
    requires java.sql;
    requires annotations;

    opens pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi.model to com.google.gson;
    opens pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.gui to javafx.graphics, javafx.fxml;
    opens pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.model to opencsv, java.sql;
    opens pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.services to javafx.fxml;
}