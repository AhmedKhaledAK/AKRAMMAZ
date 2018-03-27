package sample.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import sample.Scenes;
import sample.lang.Error;
import sample.peoples.Passenger;


public class CancelTripPage {

    @FXML
    TextField txtID;
    @FXML
    TextField txtTripNum;

    private Scenes scenes = new Scenes();

    public void btnCancelTrip(ActionEvent actionEvent) {
        Passenger p = new Passenger();
        p.setID(txtID.getText());
        if(p.deleteTrip(txtID.getText(), p, Integer.parseInt(txtTripNum.getText().trim()))){
            Error.error(Alert.AlertType.INFORMATION, "Information","Trip Cancelled", "Your trip has been " +
                    "cancelled.");
        }else {
            Error.error(Alert.AlertType.ERROR, "Error", "Trip not cancelled", "It looks like " +
                    "there is no trip with this number.");
        }
    }

    public void btnBack(ActionEvent actionEvent) throws Exception {
        scenes.btnAll(actionEvent, "PassengerPage.fxml", "sample.gui.CancelTripPage");
    }
}
