package sample.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import sample.Main;
import sample.Scenes;
import sample.files.FileClass;
import sample.lang.Error;
import sample.peoples.Manager;



public class DeleteDriverPage {

    @FXML
    TextField txtDriverNumber;

    private Scenes scenes = new Scenes();

    public void btnBack(ActionEvent actionEvent) throws Exception {
        scenes.btnAll(actionEvent, "ManagerPage.fxml", "sample.gui.DeleteDriverPage");
    }

    public void btnDeleteDriver(ActionEvent actionEvent) {
        FileClass fc;
        Manager manager = new Manager();
        int in = manager.deleteDriver(txtDriverNumber.getText(), Main.driverList);
        if(in == -1){
            Error.error(Alert.AlertType.ERROR,"Error", "Driver not deleted", "It looks like " +
                    "there's no driver " +
                    "with this id or there's no other driver to be assigned to his trip.");
        }else {
            System.out.println("Driver has been removed");
            fc = new FileClass("C:/Users/User/driver.txt");
            fc.writeDrivers(Main.driverList, 0, 0);
            Error.error(Alert.AlertType.INFORMATION, "Information", "Suuccess", "Driver has been deleted.");
        }
    }
}
