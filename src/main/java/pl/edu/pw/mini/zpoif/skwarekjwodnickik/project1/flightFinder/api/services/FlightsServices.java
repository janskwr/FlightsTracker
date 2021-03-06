package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.services;

import org.jetbrains.annotations.NotNull;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi.RetrofitServiceGenerator;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi.model.Flight;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Class contains synchronous calls that pull data from REST API.
 */
public class FlightsServices {

    public static ArrayList<Flight> getFlightsFromBeginToEnd(int begin, int end) throws IOException {

        RetrofitServiceGenerator retrofitServiceGenerator = new RetrofitServiceGenerator();
        Call<ArrayList<Flight>> call = retrofitServiceGenerator.generate().getFlights(begin, end);
        ArrayList<Flight> flights = call.execute().body();
        return flights;
    }

    public static ArrayList<Flight> getFlightsFromBeginToEndByAircraft(String icao24, int begin, int end) throws IOException {

        RetrofitServiceGenerator retrofitServiceGenerator = new RetrofitServiceGenerator();
        Call<ArrayList<Flight>> call = retrofitServiceGenerator.generate().getFlightsByAircraft(icao24, begin, end);
        ArrayList<Flight> flights = call.execute().body();
        return flights;

    }

    public static ArrayList<Flight> getFlightsFromBeginToEndByArrival(String airport, int begin, int end) throws IOException {

        RetrofitServiceGenerator retrofitServiceGenerator = new RetrofitServiceGenerator();
        Call<ArrayList<Flight>> call = retrofitServiceGenerator.generate().getFlightsByArrival(airport, begin, end);
        ArrayList<Flight> flights = call.execute().body();
        return flights;

    }

    public static ArrayList<Flight> getFlightsFromBeginToEndByDeparture(String airport, int begin, int end) throws IOException {

        RetrofitServiceGenerator retrofitServiceGenerator = new RetrofitServiceGenerator();
        Call<ArrayList<Flight>> call = retrofitServiceGenerator.generate().getFlightsByDeparture(airport, begin, end);
        ArrayList<Flight> flights = call.execute().body();
        return flights;

    }

    public static ArrayList<Flight> getFlightsFromBeginToEndByDepartureAndArrival(String depairport, String arrairport,
                                                                                  int begin, int end) throws IOException {
        ArrayList<Flight> resultlist = new ArrayList<Flight>();
        ArrayList<Flight> templist = getFlightsFromBeginToEndByDeparture(depairport, begin, end);
        if (templist == null){
            return resultlist;
        }
        for (Flight flight : templist){
            if(flight.getEstArrivalAirport().equals(arrairport)){
                resultlist.add(flight);
            }
        }
        return resultlist;
    }
}
