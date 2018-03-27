package sample.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Scenes;

public class ManagerPage {

    Scenes scenes = new Scenes();

    public void btnCreateTripPage(ActionEvent actionEvent) throws Exception{
        scenes.btnAll(actionEvent, "TripCreation.fxml", "sample.gui.ManagerPage");
    }

    public void btnDeleteTripPage(ActionEvent actionEvent) throws Exception{
        scenes.btnAll(actionEvent, "TripDeletion.fxml", "sample.gui.ManagerPage");
}

    public void btnAddBusPage(ActionEvent actionEvent)  throws Exception{
        scenes.btnAll(actionEvent, "AddBusPage.fxml", "sample.gui.ManagerPage");
    }

    public void btnDeleteBusPage(ActionEvent actionEvent) throws Exception{
        scenes.btnAll(actionEvent, "DeleteBusPage.fxml", "sample.gui.ManagerPage");
    }

    public void btnAddDriver(ActionEvent actionEvent) throws Exception {
        scenes.btnAll(actionEvent, "AddDriverPage.fxml", "sample.gui.ManagerPage");
    }

    public void btnDeleteDriverPage(ActionEvent actionEvent) throws Exception {
        scenes.btnAll(actionEvent, "DeleteDriverPage.fxml", "sample.gui.ManagerPage");
    }
}
