package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.utils;

import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.services.FlightsServices;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.services.FlightsServicesStandard;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        //APIConnector api = new APIConnector();
        //api.printAllStates();

//        APIService service = RetrofitClient.createService(APIService.class);
//        Response<List<RawFlight>> response = service.getFlights().execute();
//        List<RawFlight> rawFlights = response.body();
//        assert rawFlights != null;
//        rawFlights.stream().forEach(System.out::println);

        FlightsServices flightsServicesStandard = new FlightsServicesStandard();
//        flightsServices.getFlightsFromBeginToEnd(1517227200, 1517230800);
        flightsServicesStandard.getFlightsFromBeginToEndByAircraft("40721b", 1517227200, 1517230800);
    }

    ;
}

