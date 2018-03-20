package sample.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.Main;
import sample.Scenes;
import sample.files.FileClass;
import sample.lang.Error;
import sample.peoples.Driver;
import sample.peoples.Manager;

public class AddDriverPage {

    Scenes scenes = new Scenes();

    @FXML
    TextField txtDriverNumber;

    public void btnAddDriver(ActionEvent actionEvent) {
        Manager manager = new Manager();
        Driver d = new Driver();
        String s = txtDriverNumber.getText();
        d.setID(s);
        d.setAvaialble(true);
        int in = manager.searchDriver(d.getID(), Main.driverList);
        if(in == -1){
            Main.driverList.add(d);
            FileClass fileClass = new FileClass("C:/Users/User/driver.txt");
            fileClass.writeDrivers(Main.driverList, 0,0);
        }else {
            Error.error("Error", "Driver not Added", "It looks like there's another driver" +
                    " with the same ID");
        }
    }

    public void btnBack(ActionEvent actionEvent) throws Exception {
        scenes.btnAll(actionEvent, "ManagerPage.fxml", "sample.gui.AddDriverPage");
    }
}
