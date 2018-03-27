package sample.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import sample.Main;
import sample.Scenes;
import sample.files.FileClass;
import sample.lang.Error;
import sample.vehicles.Vehicle;

import java.util.ArrayList;

public class DeleteBusPage {

    private Scenes scenes = new Scenes();

    @FXML
    TextField txtBusNumber;
    @FXML
    CheckBox chkBxBus;
    @FXML
    CheckBox chkBxMini;
    @FXML
    CheckBox chkBxLimo;

    public void btnDeleteBus(ActionEvent actionEvent) {
        ArrayList<Vehicle> vehicles=null;
        int flag1=0,flag2=0,flag3=0;
        if(chkBxBus.isSelected()){
            vehicles=Main.busList;
            flag1=1;
        }else if(chkBxMini.isSelected()){
            vehicles=Main.miniList;
            flag2=1;
        }else if(chkBxLimo.isSelected()){
            vehicles = Main.limoList;
            flag3=1;
        }
        assert vehicles != null;
        for (int i = 0; i < vehicles.size(); i++){
            if(Integer.parseInt(txtBusNumber.getText()) == vehicles.get(i).getNumber()){
                if(vehicles.get(i).isAvailable()){
                    vehicles.remove(i);
                    FileClass fc=null;
                    if(flag1==1){
                        fc = new FileClass("C:/Users/User/bus.txt");
                        Main.busList=vehicles;
                    }
                    else if(flag2==1){
                        fc = new FileClass("C:/Users/User/minibus.txt");
                        Main.miniList=vehicles;
                    }
                    else if(flag3==1){
                        fc = new FileClass("C:/Users/User/limo.txt");
                        Main.limoList=vehicles;
                    }
                    fc.writeToFile(vehicles, 0);
                    Error.error(Alert.AlertType.INFORMATION, "Information", "Success", "Congratulations, " +
                            "vehicle is deleted.");
                }
                else {
                    Error.error(Alert.AlertType.ERROR,"Error", "Vehicle not deleted", "It looks like the " +
                            "vehicle" +
                            " is assigned to a trip." +
                            "Delete the trip first.");
                }
            }
        }


    }

    public void btnBack(ActionEvent actionEvent) throws Exception {
        scenes.btnAll(actionEvent, "ManagerPage.fxml", "sample.gui.DeleteBusPage");
    }
}


