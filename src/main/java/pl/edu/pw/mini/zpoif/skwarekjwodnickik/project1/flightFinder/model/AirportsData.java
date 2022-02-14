package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.model;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for converting data from csv file to java.util.ArrayList of Airport objects.
 * Uses opencsv as a converter.
 * Csv files in the project resources directory.
 */
public class AirportsData {

    public static ArrayList<Airport> CSVConverter() throws FileNotFoundException, URISyntaxException {

        URL resource = AirportsData.class.getResource("/airports.csv");
//        File file = Paths.get(resource.toURI()).toFile(); // return a file
        String filepath = Paths.get(resource.toURI()).toFile().getAbsolutePath();

        ArrayList<Airport> airports = (ArrayList<Airport>) new CsvToBeanBuilder<Airport>(new FileReader(filepath))
                .withType(Airport.class)
                .build()
                .parse();

        return airports;

    }
}
