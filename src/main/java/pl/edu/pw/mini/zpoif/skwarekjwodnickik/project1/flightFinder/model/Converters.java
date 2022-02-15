package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class contains various converters used in a project.
 * Time conversion.
 * Data conversion.
 * Search for other fields of the same object.
 */
public class Converters {

    public static Date localDatetoDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

    public static Date UnixToRoman(int unixdate) {

        Date time = new Date((long) unixdate * 1000);
        return time;

    }

    public static int RomanToUnix(Date romandate) {

        int time = (int) (romandate.getTime() / 1000);
        return time;

    }

    public static String IcaoToName(String icao) throws FileNotFoundException, URISyntaxException {

        AirportsData airportsData = new AirportsData();
        List<Airport> airports = airportsData.CSVConverter();
        for (Airport airport : airports) {
            if (airport.getIcao().equals(icao)) {
                return airport.getName();
            }
        }
        return null;
    }

    public static String NameToIcao(String name) throws FileNotFoundException, URISyntaxException {

        AirportsData airportsData = new AirportsData();
        List<Airport> airports = airportsData.CSVConverter();
        for (Airport airport : airports) {
            if (airport.getName().equals(name)) {
                return airport.getIcao();
            }
        }
        return null;
    }

    public static String[] IcaoToCoordinates(String icao) throws FileNotFoundException, URISyntaxException {

        AirportsData airportsData = new AirportsData();
        List<Airport> airports = airportsData.CSVConverter();
        for (Airport airport : airports) {
            if (airport.getIcao().equals(icao)) {
                String[] coordinates = new String[]{airport.getLatitude(), airport.getLongitude()};
                return coordinates;
            }
        }
        return null;
    }

    public static String[] NameToCoordinates(String name) throws FileNotFoundException, URISyntaxException {

        AirportsData airportsData = new AirportsData();
        List<Airport> airports = airportsData.CSVConverter();
        for (Airport airport : airports) {
            if (airport.getName().equals(name)) {
                String[] coordinates = new String[]{airport.getLatitude(), airport.getLongitude()};
                return coordinates;
            }
        }
        return null;
    }

    public static ObservableList<String> allIcaos() throws FileNotFoundException, URISyntaxException {

        AirportsData airportsData = new AirportsData();
        List<Airport> airports = airportsData.CSVConverter();
        ArrayList<String> result = new ArrayList<>();
        for (Airport airport : airports) {
            result.add(airport.getIcao());
        }
        return FXCollections.observableList(result);

    }

}
