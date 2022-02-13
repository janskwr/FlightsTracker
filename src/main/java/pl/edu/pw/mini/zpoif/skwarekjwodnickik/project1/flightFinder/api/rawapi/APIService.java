package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi;

import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi.model.Flight;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface APIService {

    @GET("api/flights/all")
    Call<List<Flight>> getFlights(
            @Query("begin") int begin,
            @Query("end") int end
    );

    @GET("api/flights/aircraft")
    Call<List<Flight>> getFlightsByAircraft(
            @Query("icao24") String icao24,
            @Query("begin") int begin,
            @Query("end") int end
    );

    @GET("api/flights/arrival")
    Call<List<Flight>> getFlightsByArrival(
            @Query("airport") String airport,
            @Query("begin") int begin,
            @Query("end") int end
    );

    @GET("api/flights/departure")
    Call<List<Flight>> getFlightsByDeparture(
            @Query("airport") String airport,
            @Query("begin") int begin,
            @Query("end") int end
    );

}
