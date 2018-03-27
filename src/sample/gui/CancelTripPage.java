package sample.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.peoples.Passenger;


public class CancelTripPage {

    @FXML
    TextField txtID;
    @FXML
    TextField txtTripNum;

    public void btnCancelTrip(ActionEvent actionEvent) {
        Passenger p = new Passenger();
        p.setID(txtID.getText());
        p.deleteTrip(txtID.getText(), p, Integer.parseInt(txtTripNum.getText().trim()));
    }
}
