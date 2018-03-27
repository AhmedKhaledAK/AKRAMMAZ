package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {

    public static boolean pageType;

    public void goToManagerPage(ActionEvent actionEvent) throws Exception{
        pageType = false;
        Parent root = FXMLLoader.load(getClass().getResource("gui/ManagerPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void goToPassengerPage(ActionEvent actionEvent) throws Exception{
        pageType = true;
        Parent root = FXMLLoader.load(getClass().getResource("gui/PassengerPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


}
