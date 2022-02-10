package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.utils;

import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi.APIConnector;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        APIConnector api = new APIConnector();
        api.printAllStates();
    }
}
