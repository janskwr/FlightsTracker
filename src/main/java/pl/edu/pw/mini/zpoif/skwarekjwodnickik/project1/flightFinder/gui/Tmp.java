package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Tmp {
    public static ObservableList<String> getCodes() {
        return FXCollections.observableArrayList("AAA", "ABC", "PQR");
    }

    public static ArrayList<String> getList(Controller c) {
        ArrayList<String> res = new ArrayList<String>();
        res.add(c.origin.getValue());
        res.add(c.destination.getValue());
        res.add(String.valueOf(c.dateStart.getValue()));
        res.add(String.valueOf(c.dateEnd.getValue()));
        return res;
    }

}
