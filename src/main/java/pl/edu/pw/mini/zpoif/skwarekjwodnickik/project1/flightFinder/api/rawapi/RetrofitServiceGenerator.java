package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceGenerator {

    public final String BASE_URL = "https://opensky-network.org/";

    public APIService generate() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APIService apiService = retrofit.create(APIService.class);
        return apiService;

//        Call<List<Flight>> call = apiService.getFlights(1517227200, 1517230800);
//        call.enqueue(this);
    }

}
