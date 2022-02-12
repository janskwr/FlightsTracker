package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi;

import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi.model.RawFlight;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface APIService {

    @GET("api/flights/all")
    Call<List<RawFlight>> getFlights(
            @Query("begin") int begin,
            @Query("end") int end
    );

//    @GET("/flights/")
//
//    @GET("/getProductsByName/{name}")
//    Call<Product> getProduct(@Path("name") String name);
//
//    @POST("/addProduct")
//    Call<Void> addProduct(@Body Product product);


}
