package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi.model.RawFlight;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class RetrofitClient implements Callback<List<RawFlight>> {

    static final String BASE_URL = "https://opensky-network.org/api/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APIService apiService = retrofit.create(APIService.class);

        Call<List<RawFlight>> call = apiService.getFlights();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<RawFlight>> call, Response<List<RawFlight>> response) {
        if(response.isSuccessful()) {
            List<RawFlight> changesList = response.body();
            changesList.forEach(change -> System.out.println(change.getEstArrivalAirport()));
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<RawFlight>> call, Throwable t) {
        t.printStackTrace();
    }

}
