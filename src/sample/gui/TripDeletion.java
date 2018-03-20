package sample.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import sample.Scenes;
import sample.lang.Error;
import sample.Main;
import sample.files.FileClass;
import sample.peoples.Manager;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class TripDeletion {

    Scenes scenes = new Scenes();

    @FXML
    TextField txtTripNumber;
    @FXML
    ListView<String> lv;

    ObservableList<String> ol = FXCollections.observableArrayList(Main.list);


    public void btnDeleteTrip(ActionEvent actionEvent) {
        Manager manager = new Manager();
        int n = Integer.parseInt(txtTripNumber.getText());
        int t = manager.deleteTrip(n,Main.list);
        if(t==-1){
            Error.error("Error", "Trip Not Deleted",
                    "It looks like there is no trip with this number.");
        }
        FileClass fileClass = new FileClass("C:/Users/User/trips.txt");
        fileClass.writeToFile(Main.list);
        ol=FXCollections.observableArrayList(Main.list);
        lv.setItems(ol);
        FileClass fileClass1 = new FileClass("C:/Users/User/bus.txt");
        int in = manager.searchBus(t, Main.busList);
        Main.busList.remove(in);
        fileClass1.writeToFile(Main.busList,0);
    }

    public void btnLoadTrips(ActionEvent actionEvent) {
        lv.setItems(ol);
    }

    public void btnBack(ActionEvent actionEvent) throws Exception {
        scenes.btnAll(actionEvent, "ManagerPage.fxml", "sample.gui.TripDeletion");
    }
}
