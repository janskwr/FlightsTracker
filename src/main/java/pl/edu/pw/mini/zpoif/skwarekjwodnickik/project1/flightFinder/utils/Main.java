package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.utils;

import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi.APIService;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi.RetrofitClient;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi.model.RawFlight;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        //APIConnector api = new APIConnector();
        //api.printAllStates();
        APIService service = RetrofitClient.createService(APIService.class);
        Response<List<RawFlight>> response = service.getFlights().execute();
        List<RawFlight> rawFlights = response.body();
        assert rawFlights != null;
        rawFlights.stream().forEach(System.out::println);
    }
}
