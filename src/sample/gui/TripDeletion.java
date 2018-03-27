package sample.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import sample.Scenes;
import sample.lang.Error;
import sample.Main;
import sample.files.FileClass;
import sample.peoples.Manager;

public class TripDeletion {

    private Scenes scenes = new Scenes();

    @FXML
    TextField txtTripNumber;
    @FXML
    ListView<String> lv;

    private ObservableList<String> ol = FXCollections.observableArrayList(Main.list);

    @FXML
    public void initialize(){
        lv.setItems(ol);
    }


    public void btnDeleteTrip(ActionEvent actionEvent) {
        Manager manager = new Manager();
        int n = Integer.parseInt(txtTripNumber.getText());
        int t = manager.deleteTrip(n,Main.list);
        if(t==-1){
            Error.error(Alert.AlertType.ERROR,"Error", "Trip Not Deleted",
                    "It looks like there is no trip with this number.");
            return;
        }
        FileClass fileClass = new FileClass("C:/Users/User/trips.txt");
        fileClass.writeToFile(Main.list);
        ol=FXCollections.observableArrayList(Main.list);
        lv.setItems(ol);
        Error.error(Alert.AlertType.INFORMATION, "Information","Success","Trip is deleted.");
    }

    public void btnBack(ActionEvent actionEvent) throws Exception {
        scenes.btnAll(actionEvent, "ManagerPage.fxml", "sample.gui.TripDeletion");
    }
}
