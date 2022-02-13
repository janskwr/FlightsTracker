package pl.edu.pw.mini.zpoif.skwarekjwodnickik.project1.flightFinder.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Tmp {
    public static ObservableList<String> getCodes() {
        return FXCollections.observableArrayList("AAA", "ABC", "PQR");
    }

    public static ArrayList<String> getList(String a1, String a2) {
        ArrayList<String> res = new ArrayList<String>();
        res.add("From "+a1+" to "+a2+".");
        res.add(a1);
        res.add(a2);
        return res;
    }

}
