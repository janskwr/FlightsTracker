package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.services;

import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi.RetrofitServiceGenerator;
import pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi.model.Flight;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class FlightsServices implements Callback<List<Flight>> {

    public void getFlightsFromBeginToEnd(int begin, int end) {

        RetrofitServiceGenerator retrofitServiceGenerator = new RetrofitServiceGenerator();
        Call<List<Flight>> call = retrofitServiceGenerator.generate().getFlights(begin, end);
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<List<Flight>> call, Response<List<Flight>> response) {
        if (response.isSuccessful()) {
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
