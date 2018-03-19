package sample.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.Main;
import sample.files.FileClass;
import sample.lang.Error;
import sample.vehicles.Bus;

public class AddBusPage {
    @FXML
    TextField txtBusNumber;
    public void btnAddBus(ActionEvent actionEvent) {
        Bus bus = new Bus();
        bus.setNumber(Integer.parseInt(txtBusNumber.getText()));
        bus.setAvailable(true);
        if(bus.search(bus.getNumber(), Main.busList)!=-1){
            Error.error("Error", "Bus Not Added",
                    "It looks like there is another bus with the same number");
        }else{
            Main.busList.add(bus);
            FileClass fc = new FileClass("C:/Users/User/bus.txt");
            fc.writeToFile(Main.busList,0);
        }
    }
}
