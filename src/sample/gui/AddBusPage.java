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
import sample.vehicles.Bus;
import sample.vehicles.MiniBus;
import sample.vehicles.Vehicle;
import sample.vehicles.VehicleFactory;

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

    public void btnAddBus(ActionEvent actionEvent) {
        Manager manager = new Manager();
        VehicleFactory vehicleFactory = new VehicleFactory();
        String type=null;
        ArrayList<Vehicle> vehicles=null;
        int flag1=0,flag2=0,flag3=0;
        if(chkBxBus.isSelected()){
            type = "bus";
            vehicles=Main.busList;
            flag1=1;
        }else if(chkBxMini.isSelected()){
            type = "minibus";
            vehicles=Main.miniList;
            flag2=1;
        }else if(chkBxLimo.isSelected()){
            type="limo";
            vehicles = Main.limoList;
            flag3=1;
        }
        Vehicle vehicle = vehicleFactory.createVehicle(type);
        vehicle.setNumber(Integer.parseInt(txtBusNumber.getText()));
        vehicle.setAvailable(true);
        if(manager.searchBus(vehicle.getNumber(), vehicles)!=-1){
            Error.error("Error", "Bus Not Added",
                    "It looks like there is another bus with the same number");
        }else{
            vehicles.add(vehicle);
            FileClass fc= null;
            if (vehicle instanceof Bus) {
                fc = new FileClass("C:/Users/User/bus.txt");
            } else if (vehicle instanceof MiniBus){
                fc = new FileClass("C:/Users/User/minibus.txt");
            }else {
                fc = new FileClass("C:/Users/User/limo.txt");
            }
            fc.writeToFile(vehicles,0);
            for (int i = 0; i < vehicles.size(); i++){
                System.out.println(vehicles.get(i));
            }
        }
        if(flag1==1)Main.busList=vehicles;
        else if(flag2==1)Main.miniList=vehicles;
        else if(flag3==1)Main.limoList=vehicles;
    }

    public void btnBack(ActionEvent actionEvent) throws Exception{
        scenes.btnAll(actionEvent, "ManagerPage.fxml", "sample.gui.AddBusPage");
    }
}
