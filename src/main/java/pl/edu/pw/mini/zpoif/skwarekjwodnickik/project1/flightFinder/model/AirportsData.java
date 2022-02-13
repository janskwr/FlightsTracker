package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.model;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

public class AirportsData {

    public List<Airport> CSVConverter() throws FileNotFoundException, URISyntaxException {

        URL resource = AirportsData.class.getResource("/airports.csv");
//        File file = Paths.get(resource.toURI()).toFile(); // return a file
        String filepath = Paths.get(resource.toURI()).toFile().getAbsolutePath();

//        String fileName = "/hdd/IdeaProjects/FlightFinder/src/main/resources/airports.csv";

        List<Airport> airports = new CsvToBeanBuilder<Airport>(new FileReader(filepath))
                .withType(Airport.class)
                .build()
                .parse();

//        airports.forEach(System.out::println);

        return airports;

    }

}
