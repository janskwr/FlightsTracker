package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.model;

import com.opencsv.bean.CsvBindByName;

/**
 * Airport class for data received from csv file handled by opencsv.
 * Contains getters and setters for every field.
 * Constructors and toString() also provided.
 */
public class Airport {

    public Airport() {
    }

    public Airport(String name, String city, String country, String iata, String icao, String latitude,
                   String longitude) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.iata = iata;
        this.icao = icao;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @CsvBindByName(column = "Name")
    private String name;

    @CsvBindByName(column = "City")
    private String city;

    @CsvBindByName(column = "Country")
    private String country;

    @CsvBindByName(column = "IATA")
    private String iata;

    @CsvBindByName(column = "icao")
    private String icao;

    @CsvBindByName(column = "Latitude")
    private String latitude;

    @CsvBindByName(column = "Longitude")
    private String longitude;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", iata='" + iata + '\'' +
                ", icao='" + icao + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
