package sample.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import sample.lang.Error;
import sample.Main;
import sample.files.FileClass;
import sample.peoples.Manager;

import java.util.ArrayList;

public class TripDeletion {

    @FXML
    TextField txtTripNumber;
    @FXML
    ListView<String> lv;

    ObservableList<String> ol = FXCollections.observableArrayList(Main.list);


    public void btnDeleteTrip(ActionEvent actionEvent) {
        ArrayList<String> list = Main.list;
        Manager manager = new Manager();
        int n = Integer.parseInt(txtTripNumber.getText());
        int t = manager.deleteTrip(n,list);
        if(t==0){
            Error.error("Error", "Trip Not Deleted",
                    "It looks like there is no trip with this number.");
        }
        FileClass fileClass = new FileClass("C:/Users/User/trips.txt");
        fileClass.writeToFile(list);
        Main.list = list;
        ol=FXCollections.observableArrayList(Main.list);
        lv.setItems(ol);
    }

    public void btnLoadTrips(ActionEvent actionEvent) {
        lv.setItems(ol);
    }
}
