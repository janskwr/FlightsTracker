package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.services;

import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi.RetrofitServiceGenerator;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi.model.Flight;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlightsServices {

    public List<Flight> getFlightsFromBeginToEnd(int begin, int end) throws IOException {

        RetrofitServiceGenerator retrofitServiceGenerator = new RetrofitServiceGenerator();
        Call<List<Flight>> call = retrofitServiceGenerator.generate().getFlights(begin, end);
        List<Flight> flights = call.execute().body();
        return flights;
    }

    public List<Flight> getFlightsFromBeginToEndByAircraft(String icao24, int begin, int end) throws IOException {

        RetrofitServiceGenerator retrofitServiceGenerator = new RetrofitServiceGenerator();
        Call<List<Flight>> call = retrofitServiceGenerator.generate().getFlightsByAircraft(icao24, begin, end);
        List<Flight> flights = call.execute().body();
        return flights;

    }

    public List<Flight> getFlightsFromBeginToEndByArrival(String airport, int begin, int end) throws IOException {

        RetrofitServiceGenerator retrofitServiceGenerator = new RetrofitServiceGenerator();
        Call<List<Flight>> call = retrofitServiceGenerator.generate().getFlightsByArrival(airport, begin, end);
        List<Flight> flights = call.execute().body();
        return flights;

    }

    public List<Flight> getFlightsFromBeginToEndByDeparture(String airport, int begin, int end) throws IOException {

        RetrofitServiceGenerator retrofitServiceGenerator = new RetrofitServiceGenerator();
        Call<List<Flight>> call = retrofitServiceGenerator.generate().getFlightsByDeparture(airport, begin, end);
        List<Flight> flights = call.execute().body();
        return flights;

    }


//    @Override
//    public void onResponse(Call<List<Flight>> call, Response<List<Flight>> response) {
//        if (response.isSuccessful()) {
//            List<Flight> flightsList = response.body();
//
////            flightsList.forEach(System.out::println);
//        } else {
//            System.out.println(response.errorBody());
//        }
//    }
//
//    @Override
//    public void onFailure(Call<List<Flight>> call, Throwable t) {
//        t.printStackTrace();
//    }

}
