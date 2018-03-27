package sample.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import sample.Main;
import sample.Scenes;
import sample.files.FileClass;
import sample.lang.Error;
import sample.vehicles.Vehicle;

import java.util.ArrayList;

public class DeleteBusPage {

    Scenes scenes = new Scenes();

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
                }
                else {
                    Error.error("Error", "Bus not deleted", "It looks like the bus is assigned to a trip." +
                            "Delete the trip first.");
                }
            }
        }


    }

    public void btnBack(ActionEvent actionEvent) throws Exception {
        scenes.btnAll(actionEvent, "ManagerPage.fxml", "sample.gui.DeleteBusPage");
    }
}


