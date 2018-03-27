package sample.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Scenes;

public class PassengerPage {

    Scenes scenes = new Scenes();

    public void btnBookingTripPage(ActionEvent actionEvent) throws Exception{
        scenes.btnAll(actionEvent, "BookTripPage.fxml", "sample.gui.PassengerPage");
    }

    public void btnBookingLimoPage(ActionEvent actionEvent) throws Exception {
        scenes.btnAll(actionEvent, "BookLimoPage.fxml", "sample.gui.PassengerPage");
    }

    public void btnCancelPage(ActionEvent actionEvent) throws Exception {
        scenes.btnAll(actionEvent, "CancelTripPage.fxml", "sample.gui.PassengerPage");
    }
}
