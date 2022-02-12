package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi;

import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi.model.RawFlight;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface APIService {

    @GET("/flights/all")
    Call<List<RawFlight>> getFlights();

//    @GET("/flights/")
//
//    @GET("/getProductsByName/{name}")
//    Call<Product> getProduct(@Path("name") String name);
//
//    @POST("/addProduct")
//    Call<Void> addProduct(@Body Product product);


}
