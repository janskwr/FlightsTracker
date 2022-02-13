package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.model;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

public class Converters {

    public Date UnixToRoman(int unixdate){

        Date time = new Date((long)unixdate*1000);
        return time;

    }

    public int RomanToUnix(Date romandate){

        int time = (int) (romandate.getTime() / 1000);
        return time;

    }

    public String IcaoToName(String icao) throws FileNotFoundException, URISyntaxException {

        AirportsData airportsData = new AirportsData();
        List<Airport> airports = airportsData.CSVConverter();
        for(Airport airport : airports) {
            if(airport.getIcao().equals(icao)){
                return airport.getName();
            }
        }
        return null;
    }

    public String NameToIcao(String name) throws FileNotFoundException, URISyntaxException {

        AirportsData airportsData = new AirportsData();
        List<Airport> airports = airportsData.CSVConverter();
        for(Airport airport : airports) {
            if(airport.getName().equals(name)){
                return airport.getIcao();
            }
        }
        return null;
    }

    public String[] IcaoToCoordinates(String icao) throws FileNotFoundException, URISyntaxException {

        AirportsData airportsData = new AirportsData();
        List<Airport> airports = airportsData.CSVConverter();
        for(Airport airport : airports) {
            if(airport.getIcao().equals(icao)){
                String[] coordinates = new String[] {airport.getLatitude(), airport.getLongitude()};
                return coordinates;
            }
        }
        return null;
    }

    public String[] NameToCoordinates(String name) throws FileNotFoundException, URISyntaxException {

        AirportsData airportsData = new AirportsData();
        List<Airport> airports = airportsData.CSVConverter();
        for(Airport airport : airports) {
            if(airport.getName().equals(name)){
                String[] coordinates = new String[] {airport.getLatitude(), airport.getLongitude()};
                return coordinates;
            }
        }
        return null;
    }

}
