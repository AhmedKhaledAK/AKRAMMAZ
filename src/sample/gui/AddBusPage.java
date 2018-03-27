package sample.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import sample.Main;
import sample.Scenes;
import sample.files.FileClass;
import sample.lang.Error;
import sample.peoples.Manager;
import sample.vehicles.*;

import java.util.ArrayList;

public class AddBusPage extends VehicleFactory{

    Scenes scenes = new Scenes();

    @FXML
    TextField txtBusNumber;
    @FXML
    CheckBox chkBxBus;
    @FXML
    CheckBox chkBxMini;
    @FXML
    CheckBox chkBxLimo;
    @FXML
    TextField txtLimoColor;
    @FXML
    TextField txtLimoType;

    public void btnAddBus(ActionEvent actionEvent) {
        Manager manager = new Manager();
        VehicleFactory vehicleFactory = new VehicleFactory();
        String type=null;
        ArrayList<Vehicle> vehicles=null;
        if(chkBxBus.isSelected()){
            type = "bus";
            vehicles=Main.busList;
        }else if(chkBxMini.isSelected()){
            type = "minibus";
            vehicles=Main.miniList;
        }else if(chkBxLimo.isSelected()){
            type="limo";
            vehicles = Main.limoList;
        }
        Vehicle vehicle = vehicleFactory.createVehicle(type);
        vehicle.setNumber(Integer.parseInt(txtBusNumber.getText()));
        vehicle.setAvailable(true);
        if(manager.searchBus(vehicle.getNumber(), vehicles)!=-1){
            Error.error("Error", "Bus Not Added",
                    "It looks like there is another bus with the same number");
        }else{
            if(vehicle instanceof Limo) {
                ((Limo) vehicle).setType(txtLimoType.getText().trim());
                ((Limo) vehicle).setColor(txtLimoColor.getText().trim());
            }
            vehicles.add(vehicle);
            FileClass fc=null;
            if (vehicle instanceof Bus) {
                fc = new FileClass("C:/Users/User/bus.txt");
                Main.busList=vehicles;
            } else if (vehicle instanceof MiniBus){
                fc = new FileClass("C:/Users/User/minibus.txt");
                Main.miniList=vehicles;
            }else if(vehicle instanceof Limo){
                fc = new FileClass("C:/Users/User/limo.txt");
                ((Limo) vehicle).setType(txtLimoType.getText().trim());
                ((Limo) vehicle).setColor(txtLimoColor.getText().trim());
                Main.limoList=vehicles;
            }
            fc.writeToFile(vehicles,0);
        }
    }

    public void btnBack(ActionEvent actionEvent) throws Exception{
        scenes.btnAll(actionEvent, "ManagerPage.fxml", "sample.gui.AddBusPage");
    }
}
