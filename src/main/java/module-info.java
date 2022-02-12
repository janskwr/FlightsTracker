module FlightFinder {
    requires org.json;
    requires retrofit2.converter.gson;
    requires retrofit2;
    requires okhttp3;
    requires com.google.gson;
    requires okhttp3.logging;

    opens pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi.model to com.google.gson;
}