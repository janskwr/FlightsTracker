package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.utils;

import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi.model.Flight;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.services.FlightsServices;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.services.FlightsServicesStandard;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.model.Airport;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.model.AirportsData;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.model.Converters;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {

        FlightsServices flightsServices = new FlightsServicesStandard();
//        List<Flight> flights = flightsServices.getFlightsFromBeginToEnd(1517227200, 1517230800);
        List<Flight> flights = flightsServices.getFlightsFromBeginToEnd(1517227200, 1517230800);
        for(Flight flight : flights){
            System.out.println(flight);
        }
    }


}

