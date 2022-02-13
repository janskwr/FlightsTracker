package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi.model.Flight;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class RetrofitClient implements Callback<List<Flight>> {

    static final String BASE_URL = "https://opensky-network.org/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APIService apiService = retrofit.create(APIService.class);

        Call<List<Flight>> call = apiService.getFlights(1517227200, 1517230800);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Flight>> call, Response<List<Flight>> response) {
        if(response.isSuccessful()) {
            List<Flight> changesList = response.body();
            changesList.forEach(System.out::println);
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Flight>> call, Throwable t) {
        t.printStackTrace();
    }

}
