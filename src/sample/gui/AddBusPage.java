package sample.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import sample.Main;
import sample.Scenes;
import sample.files.FileClass;
import sample.lang.Error;
import sample.peoples.Manager;
import sample.vehicles.*;

import java.util.ArrayList;

public class AddBusPage extends VehicleFactory {

    private Scenes scenes = new Scenes();

    @FXML
    TextField txtBusNumber;
    @FXML
    RadioButton rdioBtnBus;
    @FXML
    RadioButton rdioBtnMinibus;
    @FXML
    RadioButton rdioBtnLimo;
    @FXML
    TextField txtLimoColor;
    @FXML
    TextField txtLimoType;

    private ToggleGroup toggleGroup = new ToggleGroup();

    @FXML
    public void initialize() {
        rdioBtnBus.setToggleGroup(toggleGroup);
        rdioBtnMinibus.setToggleGroup(toggleGroup);
        rdioBtnLimo.setToggleGroup(toggleGroup);

        txtLimoType.setVisible(false);
        txtLimoColor.setVisible(false);

    }



    public void btnAddBus(ActionEvent actionEvent) {
        Manager manager = new Manager();
        VehicleFactory vehicleFactory = new VehicleFactory();
        String type = null;
        ArrayList<Vehicle> vehicles = null;
        if (rdioBtnBus.isSelected()) {
            type = "bus";
            vehicles = Main.busList;
        } else if (rdioBtnMinibus.isSelected()) {
            type = "minibus";
            vehicles = Main.miniList;
        } else if (rdioBtnLimo.isSelected()) {
            type = "limo";
            vehicles = Main.limoList;
        }
        Vehicle vehicle = vehicleFactory.createVehicle(type);
        vehicle.setNumber(Integer.parseInt(txtBusNumber.getText()));
        vehicle.setAvailable(true);
        if (manager.searchBus(vehicle.getNumber(), vehicles) != -1) {
            Error.error(Alert.AlertType.ERROR, "Error", "Bus Not Added",
                    "It looks like there is another bus with the same number");
        } else {
            if (vehicle instanceof Limo) {
                ((Limo) vehicle).setType(txtLimoType.getText().trim());
                ((Limo) vehicle).setColor(txtLimoColor.getText().trim());
            }
            assert vehicles != null;
            vehicles.add(vehicle);
            FileClass fc = null;
            if (vehicle instanceof Bus) {
                fc = new FileClass("C:/Users/User/bus.txt");
                Main.busList = vehicles;
            } else if (vehicle instanceof MiniBus) {
                fc = new FileClass("C:/Users/User/minibus.txt");
                Main.miniList = vehicles;
            } else if (vehicle instanceof Limo) {
                fc = new FileClass("C:/Users/User/limo.txt");
                ((Limo) vehicle).setType(txtLimoType.getText().trim());
                ((Limo) vehicle).setColor(txtLimoColor.getText().trim());
                Main.limoList = vehicles;
            }
            assert fc != null;
            fc.writeToFile(vehicles, 0);
            Error.error(Alert.AlertType.INFORMATION, "Information", "Bus Added", "Congratulations, " +
                    "the bus has been added.");
        }
    }

    public void btnBack(ActionEvent actionEvent) throws Exception {
        scenes.btnAll(actionEvent, "ManagerPage.fxml", "sample.gui.AddBusPage");
    }

    public void rdioBtnBusClicked(MouseEvent mouseEvent) {
        txtLimoColor.setVisible(false);
        txtLimoType.setVisible(false);
    }

    public void rdioBtnMiniClicked(MouseEvent mouseEvent) {
        txtLimoColor.setVisible(false);
        txtLimoType.setVisible(false);
    }

    public void rdioBtnLimoClicked(MouseEvent mouseEvent) {
        txtLimoColor.setVisible(true);
        txtLimoType.setVisible(true);
    }
}
