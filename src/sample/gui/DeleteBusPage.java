package sample.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.Main;
import sample.Scenes;
import sample.files.FileClass;
import sample.lang.Error;

public class DeleteBusPage {

    Scenes scenes = new Scenes();

    @FXML
    TextField txtBusNumber;

    public void btnDeleteBus(ActionEvent actionEvent) {
        for (int i = 0; i < Main.busList.size(); i++){
            if(Integer.parseInt(txtBusNumber.getText()) == Main.busList.get(i).getNumber()){
                if(Main.busList.get(i).isAvailable()){
                    Main.busList.remove(i);
                }
                else {
                    Error.error("Error", "Bus not deleted", "It looks like the bus is assigned to a trip." +
                            "Delete the trip first.");
                }
            }
        }
        FileClass fileClass = new FileClass("C:/Users/User/bus.txt");
        fileClass.writeToFile(Main.busList, 0);
    }

    public void btnBack(ActionEvent actionEvent) throws Exception {
        scenes.btnAll(actionEvent, "ManagerPage.fxml", "sample.gui.DeleteBusPage");
    }
}


