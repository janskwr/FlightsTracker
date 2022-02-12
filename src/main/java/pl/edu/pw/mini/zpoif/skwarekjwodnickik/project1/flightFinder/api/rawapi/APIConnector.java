package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.api.rawapi;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Ta klasa zawiera początkowy sposób łączenia z API.
 * Użyjemy jednak Retrofit'a. To można potem usunąć.
 */

public class APIConnector {
    public APIConnector() {
    }

    public static String makeRequest(String request) throws IOException {
        URL url = new URL(request);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine = in.readLine();
        StringBuffer content = new StringBuffer();
        while (inputLine != null) {
            content.append(inputLine);
            inputLine = in.readLine();
        }
        in.close();
        con.disconnect();

        return new String(content);
    }

    public class State {
        private String icao24;
        private String callsign;
        private String origin_country;
        private BigInteger time_position;
        private int last_contact;
        private float longitude;
        private float latitude;
        private float baro_altitude;
        private boolean on_ground;
        private float velocity;
        private float true_track;
        private float vertical_rate;
        private int[] sensors;
        private float geo_altitude;
        private String squawk;
        private boolean spi;
        private int position_source;

        public State(JSONArray json) {
            icao24 = json.getString(0);
            origin_country = json.getString(2);
            if (json.get(3).equals(null)) time_position = null;
            else time_position = json.getBigInteger(3);
        }

        @Override
        public String toString() {
            return "State(\n" +
                    icao24 + "\n" +
                    origin_country + "\n" +
                    time_position + "\n" +
                    ")";
        }

    }

    public void printAllStates() throws IOException {
        String json = APIConnector.makeRequest("https://opensky-network.org/api/states/all");

        JSONObject jo = new JSONObject(json);
        for(Object state : jo.getJSONArray("states")) {
            System.out.println((JSONArray) state);
            System.out.println(new State((JSONArray) state));
        }
    }
}
